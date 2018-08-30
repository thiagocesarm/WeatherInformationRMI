package weatherinfoserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.core.OWM.Language;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;

@SuppressWarnings("serial")
public class WeatherCentral extends UnicastRemoteObject implements IWeatherCentral {

	final private String apiKey = "785d7d7d943ffc783b0e903610246440";
	private OWM openWeatherMap;
	
	protected WeatherCentral() throws RemoteException {
		openWeatherMap = new OWM(apiKey);
	}

	@Override
	public WeatherInfo getCurrentWeatherInfo(String cityName) throws RemoteException, APIException {
		CurrentWeather cwData = openWeatherMap.currentWeatherByCityName(cityName);
		return new WeatherInfo(cwData);
	}

	@Override
	public WeatherInfo getFutureWeatherInfo(String cityName, int numHours) throws RemoteException, APIException, IllegalArgumentException {
		if (numHours < 0) {
			throw new IllegalArgumentException();
		}
		
		int threeHourIntervalIndex = numHours / 3;
		if (threeHourIntervalIndex == 0) {
			return getCurrentWeatherInfo(cityName);
		}
		
		threeHourIntervalIndex -= 1; // first 3 hour interval is index 0
		HourlyWeatherForecast hwData = openWeatherMap.hourlyWeatherForecastByCityName(cityName);
		if (threeHourIntervalIndex >= hwData.getDataCount()) {
			throw new IllegalArgumentException("Mumber of hour interval exceeds maximum from array");
		}
		return new WeatherInfo(hwData, threeHourIntervalIndex);
	}
    
}
