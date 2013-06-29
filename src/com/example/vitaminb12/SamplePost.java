package com.example.vitaminb12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.view.View;

public class SamplePost {

	
	
	public static void backendCall(String args[]){
		HashMap<String, String> testObj = new HashMap<String, String>();
		testObj.put("name", "bogus");
		testObj.put("field_type", "text_en");
		testObj.put("indexed", "true");
		testObj.put("stored", "true");
		testObj.put("search_by_default", "true");
		testObj.put("multi_valued", "true");

		JSONObject jsonObj = new JSONObject(testObj);
		System.out.println(jsonObj.toString());
		try {
			URL                 url;
			URLConnection   urlConn;
			DataInputStream     input;

			//Make the actual connection/
			//item?ration="MRE32&menu=MENU+3
			url = new URL ("http://mitercam.mit.edu:38084/NatickJersey/webapi/menu?type=mre&menu=3&entree=barb");
			urlConn = url.openConnection();
			urlConn.setDoInput (true);
			urlConn.setDoOutput (true);
			urlConn.setUseCaches (false);

// urlConn.setRequestProperty("Content-Type",   //Send the JSON data
	//		       		         printout = new DataOutputStream (urlConn.getOutputStream ());
			String content = jsonObj.toString();
			
			// Do something with content
			
			// Get response 
			input = new DataInputStream (urlConn.getInputStream ());
			String str;
			while (null != ((str = input.readLine())))
			{
				try {
					//Create the JSON object from the returned text
					JSONObject jsonObjOutput = new JSONObject(str);

					//Output the complete object
					System.out.println(jsonObjOutput.toString());

					//Output the "search_by_default" value in the returned JSON object
					System.out.println(jsonObjOutput.get("search_by_default").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			input.close ();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}




