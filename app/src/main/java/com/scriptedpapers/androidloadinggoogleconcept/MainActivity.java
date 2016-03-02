package com.scriptedpapers.androidloadinggoogleconcept;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.googleloading.LoadingView;

public class MainActivity extends AppCompatActivity {

    LoadingView loadingView;

    Button startButton;
    Button stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingView = (LoadingView) findViewById(R.id.loadingView);

        startButton = (Button) findViewById(R.id.startButton);
        stopButton = (Button) findViewById(R.id.stopButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingView.setCurrentMode(LoadingView.START_MODE);
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingView.setCurrentMode(LoadingView.STOP_MODE);
            }
        });
    }
}
