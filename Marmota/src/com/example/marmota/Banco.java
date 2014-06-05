package com.example.marmota;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.database.sqlite.SQLiteDatabase;


public class Banco extends Activity{

		String NomeBanco = "bdprincipal";
		SQLiteDatabase banco = null;
		
		public String desc, data;
		public double valor;
		
	private void Criabanco(){
	try{
		banco = openOrCreateDatabase(NomeBanco, MODE_WORLD_READABLE, null)	;		
		banco.execSQL("CREATE TABLE IF NOT EXISTS dados_conta (idConta integer PRIMARY KEY, _" +
				"descricao VARCHAR(50), data VARCHAR(20), valor REAL)");
	}catch (Exception e){
		
	}
	finally
	{banco.close ();}
}
	
	private void InserirDados(){
		try{
			banco = openOrCreateDatabase(NomeBanco, MODE_WORLD_READABLE, null);
			banco.execSQL("INSERT INTO dados_conta (descricao, data, valor)VALUES ('"+desc+"', '"+data+"', '"+valor+"')");
		}catch(Exception e){
		
		}
	}
}
