

package com.example.marmota;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class Tela_Principal extends Activity {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela__principal);
		
		
		btNovaClick(); //Chama a função btNovaclick
		TIntroClick();
		btNtfClick();
		
		}
	
		
		public void btNovaClick(){
		Button btNova = (Button)findViewById(R.id.btNova);
			
		btNova.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View args0) {
			Intent cd = new Intent();
			cd.setClass(Tela_Principal.this, Cadastro.class);
			startActivity(cd);
			finish();
				
			}
		});
		
	}
		
	
		
		//Easter Egg
		public void TIntroClick(){
			TextView TNome = (TextView)findViewById(R.id.tViewIntro);
			TNome.setOnClickListener(new View.OnClickListener() {
				int cont = 0;
				
				@Override
				public void onClick(View arg0) {
					
					cont = cont + 1;
					
					if (cont == 10) {
						Intent oc = new Intent();
						oc.setClass(Tela_Principal.this, TemaOculto.class);
						startActivity(oc);
						finish();
					}
					
				}
			});
		}
		
		public void btNtfClick(){
			Button btNotf = (Button)findViewById(R.id.btntf);
			
			btNotf.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent notf = new Intent();
					notf.setClass(Tela_Principal.this, Notf.class);
					startActivity(notf);
					finish();
					
				}
			});
			
		}
		
		

		
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela__principal, menu);
		return true;
	}

}