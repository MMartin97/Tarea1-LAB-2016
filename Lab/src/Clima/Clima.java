/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clima;

/**
 *
 * @author Martin
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.*;

public class Clima {
	public static String getHTML(String urlToRead) throws Exception {
		StringBuilder result = new StringBuilder();
		URL url = new URL(urlToRead);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
		   result.append(line);
		}
		rd.close();
		return result.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
                String name;
                Scanner rd = new Scanner(System.in);
                name = rd.next();
		try {
			String respuesta = getHTML("http://api.openweathermap.org/data/2.5/weather?q="+name+"&appid=4c33edcbb527fe74604973a3efd4a458");
			//System.out.println(respuesta);
			JSONObject obj = new JSONObject(respuesta);
			double temp = obj.getJSONObject("main").getDouble("temp") - 273.15;
			System.out.println("La temperatura en : "+name+" "+temp+" Celsius");
                        
                        double lon = obj.getJSONObject("coord").getDouble("lon");
                        System.out.println("Longitud " + lon);
                        
                        double lat = obj.getJSONObject("coord").getDouble("lat");
                        System.out.println("Latitud " + lat);
                        
                        double hum = obj.getJSONObject("main").getDouble("humidity");
                        System.out.println("Humedad " + hum);
                        
                        double pres = obj.getJSONObject("main").getDouble("pressure");
                        System.out.println("Presion del aire " + pres);
                        
                        double tempmax = obj.getJSONObject("main").getDouble("temp_max");
                        System.out.println("Temperatura Maxima " + tempmax);
                        
                        double speed = obj.getJSONObject("wind").getDouble("speed");
                        System.out.println("Velocidad del viento " + speed);
                      
                          
                        
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
