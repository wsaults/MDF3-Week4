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

import com.fullsail.mdf3week4.WebAppInterface;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("SetJavaScriptEnabled")
public class WebViewActivity extends Activity {
	
	WebView webView;
	EditText nameEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); 
		webView = (WebView) findViewById(R.id.webview); 

		WebAppInterface webAppInterface = new WebAppInterface(this);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.addJavascriptInterface(webAppInterface, "WebAppInterface");

		webView.loadUrl("file:///android_asset/webpage.html");

		SharedPreferences preferences;
		preferences = this.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
		String nameString = preferences.getString("name", "John Smith");
		nameEditText = (EditText)findViewById(R.id.editText);
		nameEditText.setText(nameString);
		Button btnSendMsg = (Button)findViewById(R.id.button);
		btnSendMsg.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String nameString = nameEditText.getText().toString();
				webView.loadUrl("javascript:callFromActivity(\""+nameString+"\")");
			}
		});
	}
	
	public String getValue(String str)
	{
		webView.loadUrl("javascript:function1(colors)");
	    Toast.makeText(this, "Under getValue " + str, Toast.LENGTH_SHORT).show();
	    return str;

	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web_view, menu);
		return true;
	}
	
	public void goBack() {
		// Send the choosen temp format back.
		Intent a = new Intent(getApplicationContext(),MainActivity.class);
		setResult(RESULT_OK, a);
		super.finish();
	}

}
