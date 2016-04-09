package com.hd29.mhmg;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameBeginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.begin);

	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.begin:
			Intent intent = new Intent(GameBeginActivity.this,GameMainActivity.class);
			startActivity(intent);
			break;			
		case R.id.exit:
			 System.exit(0);//
//			 this.finish();
//			 android.os.Process.killProcess(android.os.Process.myPid());  
			break;
		}

	}

}
