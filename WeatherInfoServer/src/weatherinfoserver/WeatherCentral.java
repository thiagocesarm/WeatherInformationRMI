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
		openWeatherMap.setLanguage(Language.PORTUGUESE);
		CurrentWeather cwData = openWeatherMap.currentWeatherByCityName(cityName);
		return new WeatherInfo(cwData);
	}

	@Override
	public WeatherInfo getFutureWeatherInfo(String cityName, int numHours) throws RemoteException, APIException {
		int threeHourInterval = numHours / 3;
		if (threeHourInterval > 0) {
			threeHourInterval -= 1; 
		}
		HourlyWeatherForecast hwData = openWeatherMap.hourlyWeatherForecastByCityName(cityName);
		return new WeatherInfo(hwData, threeHourInterval);
	}
    
}
