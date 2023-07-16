package com.priyoshop.assets.counterview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.content.ContextCompat;

import com.priyoshop.assets.R;


public class PSCounterView extends LinearLayout implements View.OnClickListener {

    private final AppCompatImageButton mBtnDecrease;
    private final AppCompatImageButton mBtnIncrease;
    public TextView mTextCounter;
    public String event = "null";
    public int mCounterValue = 0;
    public int minimumCounterValue = 0;
    public int maximumCounterValue = 0;
    private boolean minFixToOne = false;
    private CounterValueChangeListener mCounterValueChangeListener;

    private static final long MIN_CLICK_INTERVAL = 0;
    private long mLastClickTime;
    private final Context mContext;

    public PSCounterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_ps_counterview, this, true);

        mBtnDecrease = (AppCompatImageButton) getChildAt(0);
        mTextCounter = (TextView) getChildAt(1);
        mBtnIncrease = (AppCompatImageButton) getChildAt(2);

        setClickListener();
    }


    @Override
    public void onClick(View v) {

        long currentClickTime = SystemClock.uptimeMillis();
        long elapsedTime = currentClickTime - mLastClickTime;

        mLastClickTime = currentClickTime;

        if (elapsedTime <= MIN_CLICK_INTERVAL)
            return;

        int i = v.getId();
        if (i == R.id.btn_decrease) {
            event = "Decrease";
            if (mCounterValue > minimumCounterValue) {
//            if(minFixToOne && mCounterValue == 1 ){
//               return;
//            }
                //mCounterValue--;
                mTextCounter.setText(String.valueOf(mCounterValue));
                if (mCounterValueChangeListener != null) {
                    mCounterValueChangeListener.onValueDelete(event);
                }
            }

        } else if (i == R.id.btn_increase) {
            event = "Increase";
            mBtnDecrease.setEnabled(true);
            mTextCounter.setText(String.valueOf(mCounterValue));
            if (mCounterValueChangeListener != null) {
                mCounterValueChangeListener.onValueAdd(event);
            }

            checkFabColor();
        }
    }

    private void checkFabColor() {
        if (mCounterValue > minimumCounterValue) {
            mBtnDecrease.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(mContext, R.color.colorPrimary)));
        } else {
            mBtnDecrease.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(mContext, R.color.colorPrimary)));
        }
    }

    private void setClickListener() {
        mBtnDecrease.setOnClickListener(this);
        mBtnIncrease.setOnClickListener(this);
    }

    /**
     * get the counter value
     *
     * @return current value of counter
     */
    public int getCounterValue() {
        return mCounterValue;
    }

    /**
     * set the current value of counter
     *
     * @param mCounterValue
     */
    public void setCounterValue(int mCounterValue) {
        this.mCounterValue = mCounterValue;
        mTextCounter.setText(String.valueOf(this.mCounterValue));
        checkFabColor();
    }

    public void minFixToOne(boolean enable) {
        minFixToOne = enable;
    }

    public void addCounterValueChangeListener(@NonNull CounterValueChangeListener listener) {
        mCounterValueChangeListener = listener;
    }

    public interface CounterValueChangeListener {
        void onValueAdd(String eventType);

        void onValueDelete(String eventType);
    }
}
