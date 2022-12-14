package edu.cvtc.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class TimerActivity extends AppCompatActivity{

    private static final long START_TIME_IN_MILLIS = 60000;

    // Variables
    private TextView mCountDownTextV;
    private Button mStartPauseBtn;
    private Button mResetBtn;
    private Button mPickTimeBtn;
    private Button m5MinBtn;
    private Button m2MinBtn;
    private Button m1MinBtn;
    private EditText mEditTimeInput;
    private Button mSetTimeBtn;

    int minute, second;
    String isSetTimerOn = "off";

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
        m1MinBtn = findViewById(R.id.btn1min);
        mEditTimeInput = findViewById(R.id.pick_time_et);
        mSetTimeBtn = findViewById(R.id.btn_set_time);

        // Set time
        mSetTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Local variable that stores the number entered by the user
                String numberEntered = mEditTimeInput.getText().toString();

                //Check if box is empty
                if(numberEntered.length() == 0){
                    Toast.makeText(TimerActivity.this, "Please enter your time in minutes",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                long inputInMillis = Long.parseLong(numberEntered) * START_TIME_IN_MILLIS;

                // Check if number entered is Zero
                if(inputInMillis == 0){
                    Toast.makeText(TimerActivity.this, "Please enter a positive number",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check if number entered is more that 86.4M milliseconds (24hrs)
                if(inputInMillis > 1440 * START_TIME_IN_MILLIS){
                    Toast.makeText(TimerActivity.this, "Max time allow is 24 hours",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                // Takes the value entered to set the time
                setTime(inputInMillis);
                // Clear the edit textBox that receives the time entered
                mEditTimeInput.setText("");
            }
        });

        // Event listener that Calls the pauseTimer or startTimer methods
        mStartPauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSetTimerOn = "off";

                if (mTimerRunning) {
                    pauseTimer();
                    mResetBtn.setVisibility(View.VISIBLE);
                } else {
                    startTimer();
                    mSetTimeBtn.setVisibility(View.INVISIBLE);
                    mEditTimeInput.setVisibility(View.INVISIBLE);
                }
            }
        });

        // Event listener that Calls the reset method
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
        m1MinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStartTimeInMillis = START_TIME_IN_MILLIS;
                mTimeLeftInMillis = mStartTimeInMillis;
                updateCountDownText();
                updateButtons();
            }
        });

        mPickTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSetTimerOn == "off") {
                    mSetTimeBtn.setVisibility(View.VISIBLE);
                    mEditTimeInput.setVisibility(View.VISIBLE);
                    isSetTimerOn = "on";
                } else  {
                    mSetTimeBtn.setVisibility(View.INVISIBLE);
                    mEditTimeInput.setVisibility(View.INVISIBLE);
                    isSetTimerOn = "off";
                }
            }
        });

        updateCountDownText();
    }

    // Close the keyboard when number of minutes have been set
    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    // Method that sets the time
    private void setTime(long inputInMillis) {
        mStartTimeInMillis = inputInMillis;
        resetTimer();
        closeKeyboard();
        mSetTimeBtn.setVisibility(View.INVISIBLE);
        mEditTimeInput.setVisibility(View.INVISIBLE);
    }

    // Function that starts the timer
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

    // Function that reset the timer
    private void resetTimer() {
        mTimeLeftInMillis = mStartTimeInMillis;
        Toast.makeText(TimerActivity.this, "Time set to " + mStartTimeInMillis / START_TIME_IN_MILLIS + " minute(s)",
                Toast.LENGTH_SHORT).show();
        updateCountDownText();
        updateButtons();
    }

    // Function that update the buttons
    private void updateButtons() {
        if (mTimerRunning) {
            mResetBtn.setVisibility(View.INVISIBLE);
            m5MinBtn.setVisibility(View.INVISIBLE);
            m2MinBtn.setVisibility(View.INVISIBLE);
            m1MinBtn.setVisibility(View.INVISIBLE);
            mPickTimeBtn.setVisibility(View.INVISIBLE);

            mStartPauseBtn.setText(R.string.pause_text);
        } else {
            m5MinBtn.setVisibility(View.VISIBLE);
            m2MinBtn.setVisibility(View.VISIBLE);
            m1MinBtn.setVisibility(View.VISIBLE);
            mResetBtn.setVisibility(View.VISIBLE);
            mPickTimeBtn.setVisibility(View.VISIBLE);

            if (mTimeLeftInMillis < 1000) {
                mStartPauseBtn.setVisibility(View.INVISIBLE);
                m5MinBtn.setVisibility(View.VISIBLE);
                m2MinBtn.setVisibility(View.VISIBLE);
                m1MinBtn.setVisibility(View.VISIBLE);
                mResetBtn.setVisibility(View.VISIBLE);
                mPickTimeBtn.setVisibility(View.VISIBLE);

            } else {
                mStartPauseBtn.setVisibility(View.VISIBLE);
            }

            // Updated reset button visibility if the value when reset
            // is equal to start time value
            if (mTimeLeftInMillis < mStartTimeInMillis) {
                mResetBtn.setVisibility(View.VISIBLE);
                mStartPauseBtn.setText("Resume");
            } else {
                mResetBtn.setVisibility(View.INVISIBLE);
                mStartPauseBtn.setText(R.string.start_text);
            }
        }
    }

    // Function that update the count down text
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

    // Function that cancel the timer
    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        updateButtons();
        mStartPauseBtn.setText("Resume");
    }

    // Save the instance state for get device rotate to landscape or portrait mode
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("millisLeft", mTimeLeftInMillis);
        outState.putBoolean("timerRunning", mTimerRunning);
        outState.putLong("endTime", mEndTime);
        outState.putLong("startTime", mStartTimeInMillis);
    }

    // Restore the instance state for get device rotate to landscape or portrait mode
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mTimeLeftInMillis = savedInstanceState.getLong("millisLeft");
        mTimerRunning = savedInstanceState.getBoolean("timerRunning");
        mStartTimeInMillis = savedInstanceState.getLong("startTime");
        updateCountDownText();
        updateButtons();

        if (mTimerRunning) {
            mEndTime = savedInstanceState.getLong("endTime");
            mTimeLeftInMillis = mEndTime - System.currentTimeMillis();
            startTimer();
        }
    }
}