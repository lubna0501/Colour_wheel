package com.example.colour_wheel;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import top.defaults.colorpicker.ColorPickerPopup;

public class MainActivity extends AppCompatActivity {
Button button;
TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textviewcolor);
        button = findViewById(R.id.button);

        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //noinspection unused
                new ColorPickerPopup.Builder(MainActivity.this)
                        .initialColor(Color.RED)
                        .enableBrightness(true)
                        .okTitle("choose")
                        .cancelTitle("cancel")
                        .showIndicator(true)
                        .showValue(true)
                        .build()
                        .show(v, new ColorPickerPopup.ColorPickerObserver() {
                            @Override
                            public void onColorPicked(int color) {

                                textView.setTextColor(color);
                               // textView.setBackgroundColor(color);
                            }
                            @Override
                            public void onColor(int color, boolean fromUser) {
                                textView.setTextColor(color);
                               // textView.setBackgroundColor(color);
                            }

                        });


            }
        });
    }
}