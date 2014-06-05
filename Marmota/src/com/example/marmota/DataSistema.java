package com.example.marmota;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataSistema {

		String data = DatadoSistema();
		//Pega a data atual do sistema android
		 private String DatadoSistema(){

		SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = new Date();
		return dtf.format(dt);
		
	}
	
}
