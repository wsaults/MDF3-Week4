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

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.JavascriptInterface;

public class WebAppInterface {
	
	Context _context;
	
	WebAppInterface(Context context) {
		_context = context;
	} 
	
	@JavascriptInterface
	public void displayData(String name, String total) {
		// Save parameters into preferences
		SharedPreferences preferences;
		SharedPreferences.Editor editor;
		preferences = _context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
		editor = preferences.edit();
		editor.putString("name", name);
		editor.putString("total", total);
		editor.commit();
			
		((WebViewActivity)_context).goBack();
	}
}
