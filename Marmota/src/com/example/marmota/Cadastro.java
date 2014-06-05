package com.example.marmota;




import java.sql.DatabaseMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class Cadastro extends Activity {
//Variáveis Globais
	String NomeBanco = "dbprincipal";
	SQLiteDatabase banco = null;
	EditText txtData; 
	EditText txtDsc;
	EditText txtValor;
	
	 protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro);
		
		//chamando funções
		btVoltarClick();
		DatadoSistema();
		btvalorClick();
		//experimental
		btInserir();
		//------
		btNotfClick();//faz nada
		
		txtData = (EditText)findViewById(R.id.data);//declara EditText
		txtData.setText(DatadoSistema().toString());//adiciona data a EditText
		ChamaBanco();
	 }
	 
	 //Botão Voltar - Volta para tela Incical
	 public void btVoltarClick(){
		//Variaveis
		 Button btVoltar = (Button)findViewById(R.id.btVoltar);
		 
		 //Associa o evento click ao botao btvoltar
		 btVoltar.setOnClickListener(new View.OnClickListener() {
			
			 //Cria o evento click
			@Override
			public void onClick(View v) {
				// Urrules
			Intent main = new Intent();
			main.setClass(Cadastro.this, Tela_Principal.class);
			startActivity(main);
			finish();
			}
		});	 
	 }

	 
	//Chama a Classe DataSistema
	 public String DatadoSistema(){
		 DataSistema data = new DataSistema();
		 return data.data;
		 }
	
	 
	 //Adiciona valor (negativo ou positivo)
	 public void btvalorClick(){
		//Variáveis
		 Button btvalor = (Button)findViewById(R.id.btvalor);
		 
		 //associa o evento click ao botao btvalor
		 btvalor.setOnClickListener(new View.OnClickListener() {
			
			//Variáveis
			String text = "+" ;
			EditText tValor = (EditText)findViewById(R.id.txtValor);
			Button btvalor = (Button)findViewById(R.id.btvalor);
			String valor;
			String oldTxt;
			
			//Evento click, quando clicar, faz as instruções abaixo
			@Override
			public void onClick(View arg0) {
				
				//Muda o texto do botao btvalor, se estiver '+', muda para '-'
				//ou seja, adicona débito(-) ou crédito(+)
				if (text == "+"){	
				btvalor.setText("-");
				text = "-";
				oldTxt = "" + tValor.getText();//Recupera os dados caso seja cancelada a opção de débito (-)
				valor = "-" + tValor.getText();
				}
				else 
				{
				btvalor.setText("+");
				text = "+";
				valor = oldTxt;
				}
				
				//---
				EditText tvalor = (EditText)findViewById(R.id.txtValor);
				tvalor.setText(valor);
			}
			
		});
	 }
	 
	 //Mostra a tela de notificações
	public void btNotfClick(){
		Button btNotf = (Button)findViewById(R.id.btNotf);
		
		btNotf.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View arg0) {
				Intent ntf = new Intent();
				ntf.setClass(Cadastro.this, Notf.class);
				startActivity(ntf);
				finish();
			}
		});
		
	};

		
	//mensagebox do java
public void mensagem(String titulo, String mens){
	
	AlertDialog.Builder msg = new AlertDialog.Builder(Cadastro.this);
	msg.setTitle(titulo);
	msg.setMessage(mens);
	msg.setNeutralButton("Ok", null);
	msg.show();
}

//Instnaica a classe BANCO
public Object ChamaBanco(){
	try{
		Banco bd = new Banco();
		mensagem("Marmota", "Banco Criado Com Sucesso!");
		return bd;
		
	}
	catch (Exception e){
		mensagem("Marmota", "Não criou banco de dados erro - " + e);
		
	}
	return false;
}
//Exeperimentos ----------------------------------------------	
 public void InsertBanco(){
	txtData = (EditText)findViewById(R.id.data);
	txtDsc = (EditText)findViewById(R.id.desc);
	txtValor = (EditText)findViewById(R.id.txtValor);
	
	try{
	Banco mdb = new Banco();
	mdb.data = txtData.getText().toString();
	mdb.desc = txtDsc.getText().toString();
	mdb.valor = txtValor.getText().getSpanFlags(txtValor);
	
	mensagem("Marmotas", "Dados Inseridos com Sucesso");
	}catch(Exception e){
		mensagem("Marmota", "Erro");
	}
		
}

public void btInserir(){
	Button btIns = (Button)findViewById(R.id.testiculose);
	btIns.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
		InsertBanco();
			
		}
	});
} 
}