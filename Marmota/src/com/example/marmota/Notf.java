package com.example.marmota;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Notf extends Activity{
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notificacoes);
		
		TextView tvdt = (TextView)findViewById(R.id.tvdata);
		
		tvdt.setText(dataSistema().toString());	
		btpsqClick();
		
	}
	
	
	public void btpsqClick(){
		Button psq = (Button)findViewById(R.id.btpesquisa) ;
	psq.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
		
		
		//pesquisa por data no bd
			
		}
	});
		
	}


private String dataSistema(){
SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
Date data = new Date();
return dtf.format(data);
	
}
}