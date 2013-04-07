package com.fix.emotionbbc;

import com.fix.emotionbbc.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
    public static Activity context;
    private ProgressDialog progress = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		
		
		

	}
	
	public void startApp(View v) {
		Intent intent = new Intent(this, DataCollection.class);
		startService(intent);
		progress = ProgressDialog.show(context, "Scrapping and Classification", "running as a background service...");
		
	}
	
	public void onpause() {
		progress.dismiss();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}

}
