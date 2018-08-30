package weatherinfoclient;

import java.net.MalformedURLException;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import net.aksingh.owmjapis.api.APIException;
import weatherinfoserver.IWeatherCentral;
import weatherinfoserver.WeatherInfo;

public class Client {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        IWeatherCentral stub = (IWeatherCentral) Naming.lookup("rmi://localhost/WeatherCentral");
        WeatherInfo wInfo;
		Scanner input = new Scanner(System.in);
		String cityName;
		int option = 0;
		
		try {
			while (true) {
				System.out.println("Please, input the city name to get weather info from (EXIT to leave):");
				cityName = input.nextLine();
				if (cityName.trim().equalsIgnoreCase("EXIT")) {
					System.out.println(">>> Leaving weather central");
					break;
				}
				System.out.println("Please, select the desired data wanted:");
				System.out.println("1 - Current weather information from " + cityName);
				System.out.println("2 - Weather information from " + cityName + " in the next hours");
				option = input.nextInt();
				input.nextLine();
				switch (option) {
					case 1: // Adicao
						wInfo = stub.getCurrentWeatherInfo(cityName);
						System.out.println(wInfo);
						break;
					case 2: // Subtracao
						System.out.println("Input the number of hours in the future you want to know weather data:");
						int hours = input.nextInt();
						input.nextLine();
						wInfo = stub.getFutureWeatherInfo(cityName, hours);
						System.out.println("Weather data from " + hours + " hours in the future");
						System.out.println(wInfo);
						break;
					default:
						System.out.println("Invalid option, please try again.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
}
