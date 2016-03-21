package com.example.pazera.katalogferrari;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class CarList extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);



        final String[] listAut = {"FXX", "LaFerrari", "F430", "Enzo", "F599"};
        ListAdapter theAdapter = new MyAdapter(this, listAut);
        ListView theListeView = (ListView) findViewById(R.id.autoLista);
        theListeView.setAdapter(theAdapter);

        theListeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String imagePath = "@drawable/f" + String.valueOf(position);
                String text1 = "Wybrałeś " + String.valueOf(adapterView.getItemAtPosition(position));
                Toast.makeText(CarList.this, text1, Toast.LENGTH_SHORT).show();

                Intent newIntent = new Intent(getApplicationContext(), Description.class);
                newIntent.putExtra("nazwa_auta", listAut[position]);
                newIntent.putExtra("position", String.valueOf(position));
                newIntent.putExtra("temp", imagePath);
                startActivity(newIntent);

                Intent fragmentIntent = new Intent(getApplicationContext(), LandscapeFragment.class);
                fragmentIntent.putExtra("position", String.valueOf(position));
            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.car_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
