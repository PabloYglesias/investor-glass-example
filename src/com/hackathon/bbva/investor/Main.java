package com.hackathon.bbva.investor;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class Main extends Activity {
	
	static final String DATA_TITLE = "T";
	static final String DATA_LINK  = "L";
	
	
	
	static LinkedList<HashMap<String, String>> data;
	static LinkedList<HashMap<String, String>>msg;
	
	//static String feedUrl = "http://prensa.bbva.com/view_manager.html?root=9882,22&rss=1";	
	
	
	private ProgressDialog progressDialog;
	
	/*
	
	private final Handler progressHandler = new Handler() {
		@SuppressWarnings("unchecked")
		public void handleMessage() {
			//if (msg.obj != null) {
				//data = (LinkedList<HashMap<String, String>>)msg.obj;
								
			//}
			//progressDialog.dismiss();
	    }
	};
	
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        setTitle("RSS");
        
        Button btn = (Button) findViewById(R.id.btnLoad);
        
        
        btn.setOnClickListener(new OnClickListener() {			
    		@Override
    		public void onClick(View v) {
    			ListView lv = (ListView) findViewById(R.id.lstData);
    			
    			if (lv.getAdapter() != null) {
    				AlertDialog.Builder builder = new AlertDialog.Builder(Main.this);
    				builder.setMessage("ya ha cargado datos, �Est� seguro de hacerlo de nuevo?")
    				       .setCancelable(false)
    				       .setPositiveButton("Si", new DialogInterface.OnClickListener() {
    				           public void onClick(DialogInterface dialog, int id) {
    				        	   //loadData();
    				           }
    				       })
    				       .setNegativeButton("No", new DialogInterface.OnClickListener() {
    				           public void onClick(DialogInterface dialog, int id) {
    				                dialog.cancel();					            
    				           }
    				       })
    				       .create()
    				       .show();
    			  				
    			} else {
    				loadData(2);
    			}
    		}
    	});
        
        ListView lv = (ListView) findViewById(R.id.lstData);
  
        lv.setOnItemClickListener(new OnItemClickListener() {

    		@Override
    		public void onItemClick(AdapterView<?> av, View v, int position,
    				long id) {
		     
    			HashMap<String, String> entry = data.get(position);

    			Intent browserAction = new Intent(Intent.ACTION_VIEW, 
    					Uri.parse(entry.get(DATA_LINK)));
    			startActivity(browserAction);				
    		}
    	});        
    }
    

    private void setData(LinkedList<HashMap<String, String>> data){
    	SimpleAdapter sAdapter = new SimpleAdapter(getApplicationContext(), data, 
    			android.R.layout.two_line_list_item, 
    			new String[] { DATA_TITLE }, 
    			new int[] { android.R.id.text1});
    	ListView lv = (ListView) findViewById(R.id.lstData);
    	lv.setAdapter(sAdapter);
    }   
    

    private void loadData(int i) {
    	/progressDialog = ProgressDialog.show(
    			Main.this,
    			"", 
    			"Por favor espere mientras se cargan los datos...", 
    			true);

    	if(i==1){
    	this.runOnUiThread(new Runnable() {
    		  public void run() {
    			  
    			  AssetManager assetManager = getAssets();
    			  InputStream inputStream = null;
    			  try {
    			      inputStream = assetManager.open("press.xml");
    			  }
    			  catch (IOException e){
    			      Log.e("message: ",e.getMessage());
    			  }
    				XMLParser parser = new XMLParser(inputStream); 
                    msg = parser.parse();
                    setData(msg);	
    		  }
    		});
    	
    	}else if(i==2){
        	this.runOnUiThread(new Runnable() {
      		  public void run() {
      			  
      			  AssetManager assetManager = getAssets();
      			  InputStream inputStream = null;
      			  try {
      			      inputStream = assetManager.open("events.xml");
      			  }
      			  catch (IOException e){
      			      Log.e("message: ",e.getMessage());
      			  }
      				XMLParser parser = new XMLParser(inputStream); 
                      msg = parser.parse();
                      setData(msg);	
      		  }
      		});
      	
      	}
    	if(i==3){
        	this.runOnUiThread(new Runnable() {
        		  public void run() {
        			  
        			  AssetManager assetManager = getAssets();
        			  InputStream inputStream = null;
        			  try {
        			      inputStream = assetManager.open("presentation.xml");
        			  }
        			  catch (IOException e){
        			      Log.e("message: ",e.getMessage());
        			  }
        				XMLParser parser = new XMLParser(inputStream); 
                        msg = parser.parse();
                        setData(msg);	
        		  }
        		});
        	
        	}
    	
    }   
    */
}