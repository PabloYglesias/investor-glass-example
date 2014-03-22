package com.hackathon.bbva.investor;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.util.Log;

public class XMLParser {

	InputStream is;
	
	public XMLParser(InputStream is) {
		
		if(is!=null){
		this.is=is;
		}
		else{
			Log.d("prueba","llego aqui");
		}
		
		/*if(value==1){
			
		Log.d("prueba","llego aqui");
		is=getResources().openRawResource(R.raw.press);
		Log.d("prueba2",""+ is);
				//getAssets().open("press.xml");
		}
		else if(value==2){
			try {
				is=getResources().getAssets().open("events.xml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//is = res.openRawResource(R.raw.events);
		}
		else{
			try {
				is=getResources().getAssets().open("presentation.xml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//is = res.openRawResource(R.raw.presentation);
		}*/
	}
	
	public LinkedList<HashMap<String, String>> parse() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		LinkedList<HashMap<String, String>> entries = new LinkedList<HashMap<String, String>>();
		HashMap<String, String> entry;
		
		try {
			
			Log.d("prueba3","llego aqui3");
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document dom = builder.parse(is);
			Element root = dom.getDocumentElement();
			NodeList items = root.getElementsByTagName("item");
			for (int i=0;i<items.getLength();i++){
				entry = new HashMap<String, String>();				
				Node item = items.item(i);
				NodeList properties = item.getChildNodes();
				for (int j=0;j<properties.getLength();j++){
					Node property = properties.item(j);
					String name = property.getNodeName();
					if (name.equalsIgnoreCase("title")){
						entry.put(Main.DATA_TITLE, property.getFirstChild().getNodeValue());
					} else if (name.equalsIgnoreCase("link")){
						entry.put(Main.DATA_LINK, property.getFirstChild().getNodeValue());						
					}
					
				}
				entries.add(entry);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 

		return entries;
	}		
}
