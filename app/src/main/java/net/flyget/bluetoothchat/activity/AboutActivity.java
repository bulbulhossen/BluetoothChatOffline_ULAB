package net.flyget.bluetoothchat.activity;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.TextView;

import net.flyget.bluetoothchat.R;

public class AboutActivity extends Activity {
	private TextView mVersionTv;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_download);
		mVersionTv = (TextView) findViewById(R.id.versionTv);
		mVersionTv.setText("current version：" + getVersionName());
	}
	
	private String getVersionName(){

		PackageManager packageManager = this.getPackageManager();

		PackageInfo packInfo = null;
		try {
			packInfo = packageManager.getPackageInfo(
					this.getPackageName(), 0);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return packInfo.versionName;
	}
}
