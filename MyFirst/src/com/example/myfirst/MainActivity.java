package com.example.myfirst;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE="com.example.myFirst.MESSAGE"; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void sendMessage(View view) {
		Intent intent= new Intent(this,DisplayMessageActivity.class);
		EditText inch = (EditText) findViewById(R.id.inches);
		EditText cent = (EditText) findViewById(R.id.centis);
		Float inches  = 0f;
		Float centis = 0f;
		
		if (!this.isEmpty(cent))
				centis= Float.parseFloat(cent.getText().toString());
		if (!this.isEmpty(inch))
			    inches= Float.parseFloat(inch.getText().toString());	
				
		String message="Please enter valid numbers"; double result;
		if ((inches==0)&&(centis!=0)){
			result = centis/2.54;
			message = String.valueOf(centis)+" centimeters is equal to "+String.valueOf(result)+" inches!";
		}
		else if ((inches!=0)&&(centis==0))
		{
			result = inches*2.54;
			message = String.valueOf(inches)+" inches is equal to "+String.valueOf(result)+" Centimeters!";
		}
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}
	
	private boolean isEmpty(EditText etext){
		return etext.getText().toString().trim().length() == 0;
	}
}
