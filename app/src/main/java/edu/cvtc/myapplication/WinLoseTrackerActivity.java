package edu.cvtc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

// import com.bumptech.glide.Glide;


public class WinLoseTrackerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_lose_tracker);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.spinner_fighters, getResources().getStringArray(R.array.fighters_spinner));

        // Create the spinner
        Spinner spinner = findViewById(R.id.fighters_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        // Specify the layout to use when the list of fighters appears
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_fighters);

        // Apply the adapter to the spinner
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

//       Glide.with(this).load(R.drawable.mario_down_b).into(test);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}