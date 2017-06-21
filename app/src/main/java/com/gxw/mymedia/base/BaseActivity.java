package com.gxw.mymedia.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gxw.mymedia.R;


public abstract class BaseActivity extends FragmentActivity {
	private String TAG ="BaseActivity";
	protected boolean isDestroy;
	private LoadingView mLoadingView;
	protected Fragment mFragment;
	private Toast mToast;
	public Activity context = this;
	
	@Override
	protected void onDestroy() {
		isDestroy = true;
//		ActUtil.removeAct(this);
		super.onDestroy();
	}

	@Override
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		addLoadingLayout();
	}


	/**
	 * 显示toast
	 */
	protected void showToast(String msg) {
		if (null == mToast)
			mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
		mToast.setText(msg);
		mToast.show();
	}

	/**
	 * 显示toast
	 */
	protected void showToast(int msg) {
		showToast(getString(msg));
	}
	
	public int getResCoclor(int id) {
		return getResources().getColor(id);
	}
	
	public Float getDimens(int id){
		return getResources().getDimension(id);
	}
	
	@SuppressLint("Override") public Drawable getDra(int id) {
		return getResources().getDrawable(id);
	}
	@Override
	public void setContentView(View view) {
		super.setContentView(view);
		addLoadingLayout();
	}

	@Override
	public void setContentView(View view, ViewGroup.LayoutParams params) {
		super.setContentView(view, params);
		addLoadingLayout();
	}

	private void addLoadingLayout() {
		mLoadingView = new LoadingView(getBaseContext());

		mLoadingView.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return true;
			}
		});
		hideLoadingView();
		addContentView(mLoadingView, new ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT));
	}

	public void showLoadingView() {
		showLoadingView(null);
	}

	public void showLoadingView(int res) {
		showLoadingView(getString(res));
	}

	public void showLoadingView(String msg) {
		mLoadingView.setVisibility(View.VISIBLE);
		mLoadingView.setMsg(msg);
	}

	public void hideLoadingView() {
		mLoadingView.setVisibility(View.GONE);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 无标�?
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // 竖屏显示
		super.onCreate(savedInstanceState);
		setContentView(getContentViewResId());
		gethideKey();
	}

	protected abstract int getContentViewResId();

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}
	

	protected void initNavigationBar() {
		this.initNavigationBar(null);
	}

	protected void initNavigationBar(int res) {
		this.initNavigationBar(getString(res));
	}


	protected void initNavigationTitle(int titleRes) {
		TextView titleView = (TextView) findViewById(R.id.nav_title);
		if (titleView != null) {
			titleView.setText(titleRes);
		}
	}

	protected void initNavigationBar(String title) {
			TextView titleView = (TextView) findViewById(R.id.nav_title);
			if (titleView != null) {
				if (title != null) {
					titleView.setText(title);
				}
			}
			RelativeLayout backButton = (RelativeLayout)
					findViewById(R.id.nav_back);
			if (backButton != null) {
				backButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						finish();
					}
				});
				backButton
						.setOnLongClickListener(new View.OnLongClickListener() {
							@Override
							public boolean onLongClick(View v) {
								return false;
							}
						});
			}
		}
	protected void gethideKey(){
		//判断隐藏软键盘是否弹出

		if (getWindow().getAttributes().softInputMode == WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED)
		{
			//隐藏软键盘
			getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

		}
	}


}
