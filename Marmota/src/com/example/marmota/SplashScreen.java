package com.example.marmota;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity implements Runnable {

	private final int Pausa = 5000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashscreen);
		
		
		
		Handler handler = new Handler();
		handler.postDelayed(this, Pausa);
		}
	
	public void run() {
		 
		Intent intent = new Intent(getApplicationContext(), Tela_Principal.class);
		startActivity(intent);
		 
		finish();
		 
		}
}
