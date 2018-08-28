package weatherinfoserver;

import java.rmi.RemoteException;

public class WeatherCentral implements IWeatherCentral {
    final private String apiKey = "785d7d7d943ffc783b0e903610246440";
    
    @Override
    public String getWeatherInfoByCity(String cityName) throws RemoteException {
        return "";
    }
    
}
