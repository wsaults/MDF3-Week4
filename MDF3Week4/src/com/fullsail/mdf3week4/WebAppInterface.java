package com.fullsail.mdf3week4;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
	
	Context _context;
	
	WebAppInterface(Context context) {
		_context = context;
	} 
	
	/** Show a toast from the web page */
	public void showToast(String toast) {
	    Toast.makeText(_context, toast, Toast.LENGTH_SHORT).show();
	}
	
	
	@JavascriptInterface
	public void uselessMethod(String something){
		Log.i("USELESS",something);
	} 
}
