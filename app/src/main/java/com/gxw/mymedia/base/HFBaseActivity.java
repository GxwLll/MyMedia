package com.gxw.mymedia.base;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gxw.mymedia.R;


public abstract class HFBaseActivity extends BaseActivity{


	@Override
	protected int getContentViewResId() {
		return R.layout.hf_base_activity;
	}
	public abstract int layoutResID();

	public abstract void initView();

	private LayoutParams layoutParams = null;
	public LayoutInflater inflater;
	/** 标题 */
	private TextView tvTitle;
	private RelativeLayout imgLeft;
	private ImageView imgRight;
	private LinearLayout mLinRight;
	private TextView mRightText;
	
	private LinearLayout mLinSub;
	public View mViewTitle;
	private RelativeLayout mRelSliding;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		findView();
		initSubView();
		initView();
	}

	private void initSubView() {
		inflater = LayoutInflater.from(this);
		View view = null;
		if (layoutResID() != 0) {
			view = inflater.inflate(layoutResID(), null);
		}
		mLinSub = (LinearLayout) findViewById(R.id.hf_base_lin_sub);
		layoutParams = new LinearLayout.LayoutParams(
				android.view.ViewGroup.LayoutParams.MATCH_PARENT,
				android.view.ViewGroup.LayoutParams.MATCH_PARENT);
		if (view != null) {
			mLinSub.addView(view, layoutParams);
		}

	}
	

	private void findView() {
		tvTitle = (TextView) findViewById(R.id.nav_title);
		imgLeft = (RelativeLayout) findViewById(R.id.nav_back);
		imgRight = (ImageView) findViewById(R.id.hf_base_btn_right);
		mViewTitle = findViewById(R.id.background_title);
		mRightText = (TextView) findViewById(R.id.hf_base_text_right);
		mLinRight = (LinearLayout) findViewById(R.id.hf_base_right_lin);
		mRelSliding = (RelativeLayout) findViewById(R.id.hf_base_back_rel);
		if(mRelSliding!=null)
		mRelSliding.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mRelSliding.setVisibility(View.GONE);
			}
		});
	}
	/**
	 * 显示黑色背景
	 */
	public void getRelSliding() {
		 mRelSliding.setVisibility(View.VISIBLE);
	}
	
	/**
	 * 获得黑色背景对象
	 * @return
	 */
	public RelativeLayout getRelBackground(){
		return mRelSliding;
	}
	
	public View getTitleLin() {
		return mViewTitle;
	}

	public RelativeLayout getLeftImg() {
		imgLeft.setVisibility(View.VISIBLE);
		return imgLeft;
	}

	public LinearLayout getRightTvLin(String text) {
		mLinRight.setVisibility(View.VISIBLE);
		mRightText.setText(text);
		return mLinRight;
	}

	public ImageView getRightImg() {
		imgRight.setVisibility(View.VISIBLE);
		return imgRight;
	}
	public ImageView getRightImg(int src) {
		imgRight.setImageResource(src);
		imgRight.setVisibility(View.VISIBLE);
		return imgRight;
	}

	public void setTitleText(String title) {
		this.tvTitle.setText(title);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			onBackPressed();
		}
		return false;
	}




}
