package com.site.catdog;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class activity_read_person extends AppCompatActivity {
    private ListView lst1;
    private ArrayList<String> arreglo = new ArrayList<String>();
    private ArrayAdapter arrayAdapter;
    Button siguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        siguiente=(Button)findViewById(R.id.button);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent( activity_read_person.this, activity_process.class);
                startActivity(i);
            }
        });

        try{
            SQLiteDatabase db = openOrCreateDatabase("BD_EJEMPLO",Context.MODE_PRIVATE,null);
            lst1 = findViewById(R.id.lst1);
            final Cursor c = db.rawQuery("select * from persona",null);
            int id = c.getColumnIndex("id");
            int nombre = c.getColumnIndex("nombre");
            int apellido = c.getColumnIndex("apellido");
            int edad = c.getColumnIndex("edad");
            arreglo.clear();

            arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arreglo);

            lst1.setAdapter(arrayAdapter);

            final  ArrayList<class_activity_person> lista = new ArrayList<class_activity_person>();


            if(c.moveToFirst())
            {
                do{
                    class_activity_person persona = new class_activity_person();
                    persona.id = c.getString(id);
                    persona.nombre = c.getString(nombre);
                    persona.apellido = c.getString(apellido);
                    persona.edad = c.getString(edad);
                    lista.add(persona);

                    arreglo.add(c.getString(id) + " \t " + c.getString(nombre) + " \t "  + c.getString(apellido) + " \t "  + c.getString(edad) );

                } while(c.moveToNext());
                arrayAdapter.notifyDataSetChanged();
                lst1.invalidateViews();
            }

            lst1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, android.view.View view, int position, long l) {
                    class_activity_person persona = lista.get(position);
                    Intent i = new Intent(getApplicationContext(), class_activity_edit_person.class);
                    i.putExtra("id",persona.id);
                    i.putExtra("nombre",persona.nombre);
                    i.putExtra("apellido",persona.apellido);
                    i.putExtra("edad",persona.edad);
                    startActivity(i);
                }
            });
        }
        catch (Exception e){
            Toast.makeText(this, "Ha ocurrido un error, intentalo nuevamente.", Toast.LENGTH_SHORT).show();
        }

    }
}