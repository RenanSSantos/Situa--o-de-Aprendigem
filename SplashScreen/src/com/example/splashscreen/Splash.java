package com.example.splashscreen;

import java.util.concurrent.ExecutionException;

import android.net.MailTo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        //Thread for displaying the Splash Screen
        
        Thread splash_screen = new Thread(){
        	public void run (){
        	try{
        		sleep(5000);
        		
        	}catch(Exception e){        		
        		e.printStackTrace();
        	}finally{
        		startActivity(new Intent(getApplicationContext(),Main.class));
        	finish();
         	}	
        	
        		
        	}
        	
        };
        splash_screen.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash, menu);
        return true;
    }
    
}
