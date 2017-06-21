package com.gxw.mymedia.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gxw.mymedia.R;


public abstract class BaseFragment extends Fragment {

	private Toast mToast;
	public Context context=getActivity();
	protected ViewGroup topContentView;
	/** 标题 */
	private TextView tvTitle;
	private RelativeLayout imgLeft;
	private ImageView imgRight;
	private LinearLayout mLinRight;
	private TextView mRightText;
	//标题栏
	private RelativeLayout mTitleLayout;

	/**
	 * 显示toast
	 */
	protected void showToast(String msg) {
		if (isDetached())
			return;
		if (null == mToast)
			mToast = Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT);
		mToast.setText(msg);
		mToast.show();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		topContentView = (ViewGroup) LayoutInflater.from(getActivity()).inflate(R.layout.hf_base_fragment_title, null);
		tvTitle = (TextView) topContentView.findViewById(R.id.nav_title);
		imgLeft = (RelativeLayout) topContentView.findViewById(R.id.nav_back);
		imgRight = (ImageView) topContentView.findViewById(R.id.hf_base_btn_right);
		mRightText = (TextView) topContentView.findViewById(R.id.hf_base_text_right);
		mLinRight = (LinearLayout) topContentView.findViewById(R.id.hf_base_right_lin);
		mTitleLayout = (RelativeLayout) topContentView.findViewById(R.id.hf_base_title_lin);
	}
	
	public RelativeLayout getTitleLayout(){
		
		return mTitleLayout;
		
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

	/**
	 * 显示toast
	 */
	protected void showToast(int msg) {
		showToast(getString(msg));
	}

	protected void finish() {
		if (getActivity() != null) {
			getActivity().finish();
		}
	}

	public int getResCoclor(int id) {
		return getResources().getColor(id);
	}
	
	public int getDimens(int id){
		return getResources().getDimensionPixelSize(id);
	}

	public void showActivityLoadingView() {
		if (getActivity() != null && getActivity() instanceof BaseActivity) {
			((BaseActivity) getActivity()).showLoadingView();
		}
	}

	public void showActivityLoadingView(int res) {
		if (getActivity() != null && getActivity() instanceof BaseActivity) {
			((BaseActivity) getActivity()).showLoadingView(res);
		}
	}

	public void hideActivityLoadingView() {
		if (getActivity() != null && getActivity() instanceof BaseActivity) {
			((BaseActivity) getActivity()).hideLoadingView();
		}
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		context = getActivity();
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup vg,
							 Bundle bundle) {
		if (null != topContentView) {
			((ViewGroup) topContentView.getParent()).removeView(topContentView);
			return topContentView;
		}
		return topContentView;
	}
	

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
	}
	

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

	protected void initNavigationBar() {
		this.initNavigationBar(null);
	}

	protected void initNavigationBar(int res) {
		this.initNavigationBar(getString(res));
	}

	protected void initNavigationBar(View view, int res) {
		this.initNavigationBar(view, getString(res));
	}

	protected void initNavigationBar(String title) {
		View view = getView();
		initNavigationBar(view, title);
	}

	protected void initNavigationTitle(int titleRes) {
		TextView titleView = (TextView) getView().findViewById(R.id.nav_title);
		if (titleView != null) {
			titleView.setText(titleRes);
		}
	}
	@SuppressLint("WrongViewCast")
	protected void initNavigationBar(View view, String title) {
		if (view != null) {
			TextView titleView = (TextView) view.findViewById(R.id.nav_title);
			if (titleView != null) {
				if (title != null) {
					titleView.setText(title);
				}
			}
			 ImageView backButton = (ImageView) view.findViewById(R.id.nav_back);
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
	}

	/**
	 * 自定义返回view
	 * @param id
	 * @return
	 */
	public View findviewbyMyid(int id) {
		return getView().findViewById(id);
	}
	
	
	protected void gethideKey(){
		//判断隐藏软键盘是否弹出
		if (getActivity().getWindow().getAttributes().softInputMode == WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED)
		{
			//隐藏软键盘
			getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

		}
	}

//	/**
//	 * 是否有网络，是否连击
//	 * @return
//     */
//	public boolean isRutn(){
//		if (Engine.hasInternet(getActivity()))
//		return true;
//
//		return false;
//	}

}
