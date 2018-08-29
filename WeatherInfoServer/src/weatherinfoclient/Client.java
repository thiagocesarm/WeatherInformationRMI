package weatherinfoclient;

import java.net.MalformedURLException;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import weatherinfoserver.IWeatherCentral;
import weatherinfoserver.WeatherInfo;

public class Client {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        IWeatherCentral stub = (IWeatherCentral) Naming.lookup("rmi://localhost/WeatherCentral");
        WeatherInfo w = stub.getCurrentWeatherInfo("Los Angeles");
        System.out.println(w);
    }
}
