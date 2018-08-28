package weatherinfoserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IWeatherCentral extends Remote {
    
    public String getWeatherInfoByCity(String cityName) throws RemoteException;
}
