package com.site.catdog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class class_activity_adopta extends AppCompatActivity {
        EditText etEnviar;
        Button Enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopta);

        Enviar=(Button)findViewById(R.id.button4);
        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent( class_activity_adopta.this, activity_process.class);
                startActivity(i);
            }
        });


        etEnviar=findViewById(R.id.editTextTextPersonName);
        Enviar=findViewById(R.id.button2);


        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle enviadatos=new Bundle();
                enviadatos.putString("key",etEnviar.getText().toString());
                Intent i=new Intent( class_activity_adopta.this, class_add_show_person.class);
                i.putExtras(enviadatos);
                startActivity(i);

            }
        });



    }
}