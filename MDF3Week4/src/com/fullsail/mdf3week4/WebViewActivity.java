package com.fullsail.mdf3week4;

import com.fullsail.mdf3week4.WebAppInterface;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

@SuppressLint("SetJavaScriptEnabled")
public class WebViewActivity extends Activity {
	
	WebView webView;
	EditText msg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		webView = (WebView) findViewById(R.id.webview);
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);

		final WebAppInterface webAppInterface = new WebAppInterface(this);
		webView.addJavascriptInterface(webAppInterface, "AndroidFunction");

		webView.loadUrl("file:///android_asset/webpage.html");

		msg = (EditText)findViewById(R.id.editText);
		Button btnSendMsg = (Button)findViewById(R.id.button);
		btnSendMsg.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String msgToSend = msg.getText().toString();
				webView.loadUrl("javascript:callFromActivity(\""+msgToSend+"\")");

			}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web_view, menu);
		return true;
	}

}
