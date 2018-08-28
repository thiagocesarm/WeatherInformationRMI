package weatherinfoclient;

import java.net.MalformedURLException;
import weatherinfoserver.IWeatherCentral;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        IWeatherCentral stub = (IWeatherCentral) Naming.lookup("rmi://localhost/WeatherCentral");
        System.out.println(stub.getWeatherInfoByCity("Caicó"));
    }
}
