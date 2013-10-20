package com.pux0r3.zombiemaster;

import com.pux0r3.zombiemaster.renderer.ZombieGlEs20Renderer;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class ZombieActivity extends Activity {

	private GLSurfaceView mGlView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_zombie);
		
		initializeGl();
	}

	@Override
	protected void onResume() {
		super.onResume();
    	mGlView.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		mGlView.onPause();
	}

	private boolean supportsGlEs20() {
		ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
		ConfigurationInfo info = am.getDeviceConfigurationInfo();
		return info.reqGlEsVersion >= 0x20000;
	}

	private void initializeGl() {
		if (supportsGlEs20())
		{
			mGlView = new GLSurfaceView(this);
			mGlView.setEGLContextClientVersion(2);
			mGlView.setPreserveEGLContextOnPause(true);
			mGlView.setRenderer(new ZombieGlEs20Renderer());
			setContentView(mGlView);
		}
	}
}
