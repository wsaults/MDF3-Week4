/*
 * project 	MDF3Week4
 * 
 * package 	com.fullsail.mdf3week4
 * 
 * @author 	William Saults
 * 
 * date 	Aug 28, 2013
 */
package com.fullsail.mdf3week4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	TextView name;
	TextView debt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); 
		
		SharedPreferences preferences;
		preferences = this.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
		String nameString = preferences.getString("name", "John Smith");
		String debtString = preferences.getString("total", "0");
		
		name = (TextView) findViewById(R.id.mainNameTextView);
		name.setText(nameString);
		debt = (TextView) findViewById(R.id.mainDebtTextView);
		debt.setText(debtString);
		
		Button webActivityButton = (Button) findViewById(R.id.webActivityButton);
		webActivityButton.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent a = new Intent(getApplicationContext(),WebViewActivity.class);
				a.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				setResult(RESULT_OK, a);
				startActivityForResult(a,0);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		SharedPreferences preferences;
		preferences = this.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
		String nameString = preferences.getString("name", "John Smith");
		String debtString = preferences.getString("total", "0");
		
		name = (TextView) findViewById(R.id.mainNameTextView);
		name.setText(nameString);
		debt = (TextView) findViewById(R.id.mainDebtTextView);
		debt.setText(debtString);
	}

}
