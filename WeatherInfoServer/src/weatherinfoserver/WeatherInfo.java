package weatherinfoserver;

import java.io.Serializable;

public class WeatherInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public WeatherInfo(String city) {
		this.city = city;
	}
	
	private String city = "Natal";
	private double cityLat = 2.32626;
	private double cityLon = 3.151;
	private double temp = 32;
	private double tempMin = 23;
	private double tempMax = 36;
	private double pressure = 23.26;
	private double humidity = 50;
	private String weatherCondition = "Clouds";
	private String weatherDescription = "broken clouds";
	private double windSpeed = 8;
	private double windDeg = 32;
	private double cloudiness = 60;
	
	@Override
	public String toString() {
		String info = "";
		info += "Weather data from " + city + " (" + cityLat + ", " + cityLon + ")\n";
		info += weatherCondition + " - " + weatherDescription + "\n";
		info += "Temperature: " + temp + " ºC (max: " + tempMax + "ºC, min: " + tempMin + "ºC)\n";
		info += "Pressure: " + pressure + " hPa\n";
		info += "Humidity: " + humidity + "%\n";
		info += "Wind: " + windSpeed + " km/h - " + windDeg + "º\n";
		info += "Cloudiness: " + cloudiness + "%\n\n";
		return info;
	}
	
}
