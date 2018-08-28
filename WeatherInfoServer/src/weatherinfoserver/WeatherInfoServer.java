package weatherinfoserver;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class WeatherInfoServer {
    public static void main(String[] args) throws RemoteException, MalformedURLException{
        // Execução do modulo de referencia remota (RMI Registry)
        LocateRegistry.createRegistry(1099);

        // Instanciacao do servene
        WeatherCentral weatherCentral = new WeatherCentral();

        // Registro do servente no modulo de referencia remota (RMI Registry)
        Naming.rebind("rmi://localhost/WeatherCentral", weatherCentral);
        System.out.println("Server ready and registered on RMI Registry.");
    }
}
