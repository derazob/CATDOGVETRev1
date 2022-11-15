package com.site.catdog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_process extends AppCompatActivity {
    Button siguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procesos);

        siguiente=(Button)findViewById(R.id.button);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent( activity_process.this, class_activity_maps.class);
                startActivity(i);
            }
        });
        siguiente=(Button)findViewById(R.id.button3);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent( activity_process.this, class_activity_gyroscope_sensor.class);
                startActivity(i);
            }
        });
    }
}