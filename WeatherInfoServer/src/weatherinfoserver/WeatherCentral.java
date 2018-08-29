package weatherinfoserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class WeatherCentral extends UnicastRemoteObject implements IWeatherCentral {
	protected WeatherCentral() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	final private String apiKey = "785d7d7d943ffc783b0e903610246440";

	@Override
	public WeatherInfo getCurrentWeatherInfo(String cityName) throws RemoteException {
		return new WeatherInfo(cityName);
	}
    
}
