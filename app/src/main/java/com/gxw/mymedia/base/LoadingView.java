package com.gxw.mymedia.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gxw.mymedia.R;

/**
 * loading视图
 * Created by cy-love on 14-1-15.
 */
public class LoadingView extends RelativeLayout {

    TextView mMsg;

    public LoadingView(Context context) {
        super(context);
        this.init();
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context
                .LAYOUT_INFLATER_SERVICE);
     View view= inflater.inflate(R.layout.framework_loading_layout, this);
        mMsg=(TextView) view.findViewById(R.id.framework_loading_message);
    }

    public void setMsg(CharSequence msg) {
        mMsg.setText(msg);
    }

}
