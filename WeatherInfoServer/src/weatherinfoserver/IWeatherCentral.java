package weatherinfoserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

import net.aksingh.owmjapis.api.APIException;

public interface IWeatherCentral extends Remote {
    
    public WeatherInfo getCurrentWeatherInfo(String cityName) throws RemoteException, APIException;
    
    public WeatherInfo getFutureWeatherInfo(String cityName, int numHours) throws RemoteException, APIException;
}
