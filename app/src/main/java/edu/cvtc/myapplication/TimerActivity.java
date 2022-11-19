package edu.cvtc.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Locale;

public class TimerActivity extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 60000;

    // Variables
    private TextView mCountDownTextV;
    private Button mStartPauseBtn;
    private Button mResetBtn;
    private Button mPickTimeBtn;
    private Button m5MinBtn;
    private Button m2MinBtn;
    private Button m8MinBtn;

    int minute, second;

    private boolean mTimerRunning;
    private CountDownTimer mCountDownTimer;

    // Constants
    private long mEndTime;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    private long mStartTimeInMillis = mTimeLeftInMillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        //Set the Action bar color to red
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.red)));
        // Assign the variables to their corresponding widgets
        mCountDownTextV = findViewById(R.id.count_down_timer);
        mStartPauseBtn = findViewById(R.id.btnStart);
        mResetBtn = findViewById(R.id.btnReset);
        mPickTimeBtn = findViewById(R.id.btn_pick_time);
        m5MinBtn = findViewById(R.id.btn5min);
        m2MinBtn = findViewById(R.id.btn2min);
        m8MinBtn = findViewById(R.id.btn8min);

        // Event listener that Calls the pauseTimer or startTimer methods
        mStartPauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        mResetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        m5MinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStartTimeInMillis = START_TIME_IN_MILLIS * 5;
                mTimeLeftInMillis = mStartTimeInMillis;
                updateCountDownText();
                updateButtons();
            }

        });
        m2MinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStartTimeInMillis = START_TIME_IN_MILLIS * 2;
                mTimeLeftInMillis = mStartTimeInMillis;
                updateCountDownText();
                updateButtons();
            }

        });
        m8MinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStartTimeInMillis = START_TIME_IN_MILLIS * 8;
                mTimeLeftInMillis = mStartTimeInMillis;
                updateCountDownText();
                updateButtons();
            }
        });

        mPickTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStartTimeInMillis = START_TIME_IN_MILLIS / 12;
                mTimeLeftInMillis = mStartTimeInMillis;
                updateCountDownText();
                updateButtons();
            }
        });

        updateCountDownText();
    }

//    public void popTimerPicker(View view) {
//        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker timePicker, int selectedMinute, int selectedSecond) {
//                minute = selectedMinute;
//                second = selectedSecond;
//
//                String timeLeftFormatted;
//                timeLeftFormatted = String.format(Locale.getDefault(),
//                        "%02d:%02d", minute, second);
//
//                mCountDownTextV.setText(timeLeftFormatted);
//                //updateCountDownText();
//                updateButtons();
//            }
//        };
//
//        int style = AlertDialog.THEME_HOLO_DARK;
//        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, minute, second, false);
//        timePickerDialog.show();
//    }

    private void startTimer() {
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;

        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;

                updateCountDownText();
                updateButtons();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                updateButtons();
            }
        }.start();

        mTimerRunning = true;
        updateButtons();
    }

    private void resetTimer() {
        mTimeLeftInMillis = mStartTimeInMillis;
        updateCountDownText();
        updateButtons();
    }

    private void updateButtons() {
        if (mTimerRunning) {
            mResetBtn.setVisibility(View.INVISIBLE);
            m5MinBtn.setVisibility(View.INVISIBLE);
            m2MinBtn.setVisibility(View.INVISIBLE);
            m8MinBtn.setVisibility(View.INVISIBLE);

            mStartPauseBtn.setText(R.string.pause_text);
        } else {
            m5MinBtn.setVisibility(View.VISIBLE);
            m2MinBtn.setVisibility(View.VISIBLE);
            m8MinBtn.setVisibility(View.VISIBLE);
            mResetBtn.setVisibility(View.VISIBLE);

            mStartPauseBtn.setText(R.string.start_text);

            if (mTimeLeftInMillis < 1000) {
                mStartPauseBtn.setVisibility(View.INVISIBLE);
                m5MinBtn.setVisibility(View.VISIBLE);
                m2MinBtn.setVisibility(View.VISIBLE);
                m8MinBtn.setVisibility(View.VISIBLE);
                mResetBtn.setVisibility(View.VISIBLE);

            } else {
                mStartPauseBtn.setVisibility(View.VISIBLE);
            }

            // Updated reset button visibility if the value when reset
            // is equal to start time value
            if (mTimeLeftInMillis < mStartTimeInMillis) {
                mResetBtn.setVisibility(View.VISIBLE);
            } else {
                mResetBtn.setVisibility(View.INVISIBLE);
            }
        }
    }

    private void updateCountDownText() {
        // Local variables
        int hours = (int) (mTimeLeftInMillis / 1000) / 3600;
        int minutes = (int) ((mTimeLeftInMillis / 1000) % 3600) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted;

        if (hours > 0) {
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%d:%02d:%02d", hours, minutes, seconds);
        } else {
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%02d:%02d", minutes, seconds);
        }

        mCountDownTextV.setText(timeLeftFormatted);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        updateButtons();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("millisLeft", mTimeLeftInMillis);
        outState.putBoolean("timerRunning", mTimerRunning);
        outState.putLong("endTime", mEndTime);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mTimeLeftInMillis = savedInstanceState.getLong("millisLeft");
        mTimerRunning = savedInstanceState.getBoolean("timerRunning");
        updateCountDownText();
        updateButtons();

        if (mTimerRunning) {
            mEndTime = savedInstanceState.getLong("endTime");
            mTimeLeftInMillis = mEndTime - System.currentTimeMillis();
            startTimer();
        }
    }




}