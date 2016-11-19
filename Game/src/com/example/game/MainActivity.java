package com.example.game;




import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
	private TextView Rtext,Rdisplay,RTime;
	static int a;
	static long elapsedTime;
	long startTime,stopTime;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Button button = (Button) findViewById(R.id.btnClick1);
        Rtext=(TextView) findViewById(R.id.txtInput1);
        Rdisplay=(TextView) findViewById(R.id.lblDisplay1);
        RTime=(TextView) findViewById(R.id.lblTime1);
        
button.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String s,value=null;
				startTime = System.currentTimeMillis();
				long byt;
				Send sendob=new Send();
				//byt=android.net.TrafficStats.getTotalTxPackets();
				
				s=Rtext.getText().toString();
				try
				{
				 value=sendob.SendValue(s);
				 System.out.println("Rest");
				}
				catch (Exception e)
				{
					
				}
				a++;
				Rdisplay.setText(Rdisplay.getText().toString() + " " + value + "a : " + a);
				stopTime = System.currentTimeMillis();
				elapsedTime = elapsedTime + (stopTime - startTime);				
				//s=Float.toString(byt);
				//view.setText(s);				
				RTime.setText(RTime.getText().toString() + " " +String.valueOf(elapsedTime));
			   
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
