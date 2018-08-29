package weatherinfoserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IWeatherCentral extends Remote {
    
    public WeatherInfo getCurrentWeatherInfo(String cityName) throws RemoteException;
}
