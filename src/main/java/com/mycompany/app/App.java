package com.mycompany.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

/**
 * Hello world!
 *
 */
@Service
public class App 
{
	private final String USER_AGENT = "Mozilla/5.0";
    public String thisIsTheText()
    {
    	return "Print me";
    }
    public String processText(TextToProcess textToProcess)
    {
    	return new StringBuilder(textToProcess.gettext()).reverse().toString();
    }
    public String googleIt(String text){
		try {
			return sendGet(text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	private String sendGet(String text) throws Exception {

		String url = "http://www.google.com/search?q="+text;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		
		return response.toString();

	}
}
