package com.example.pazera.katalogferrari;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by pazera on 2014-08-07.
 */
public class Description extends Activity {

    TextView nazwa_auta;
    public String[][] dane = new String[][]
            {{"V12 48V", "6,2L", "800KM @ 8,500 obr.", "686 Nm @ 5,750 obr.", "2,5 s", "345 km/h", "1155kg"},
                    {"V12 DOHC", "6,3L", "950KM @ 9,000 obr.", "900 Nm @ 6,750 obr.", "2,9 s", ">350 km/h", "1255kg"},
                    {"V8 40V", "4,3L", "510KM @ 8,500 obr.", "470 Nm @ 5,250 obr.", "3,6 s", "320 km/h", "1350kg"},
                    {"V12 48V", "6,0L", "660KM @ 7,800 obr.", "657 Nm @ 5,550 obr.", "3,3 s", "355 km/h", "1365kg"},
                    {"V12 48V", "6,0L", "620KM @ 7,600 obr.", "608 Nm @ 5,600 obr.", "3,6 s", "333 km/h", "1688kg"}};

    TextView silnikTextView, pojemnoscTextView, mocTextView, smomentTextView,accTextView, vmaxTextView,masaTextView;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokaz__auto);


        Intent nowyIntent = getIntent();
        String nazwa = nowyIntent.getExtras().getString("nazwa_auta");
        TextView nazwaTextView = (TextView) findViewById(R.id.nazwa_text_view);
        nazwaTextView.setText(nazwa);
        position = Integer.parseInt(nowyIntent.getExtras().getString("position"));
        initializeTextViews();

        ImageView opisImageView = (ImageView) findViewById(R.id.opis_image_view);
        Bitmap bmw;
        switch (position) {
            case 0:  bmw = BitmapFactory.decodeResource(getResources(), R.drawable.f1);
                opisImageView.setImageBitmap(bmw);
                break;

            case 1:  bmw = BitmapFactory.decodeResource(getResources(), R.drawable.f2);
                opisImageView.setImageBitmap(bmw);
                break;

            case 2:  bmw = BitmapFactory.decodeResource(getResources(), R.drawable.f3);
                opisImageView.setImageBitmap(bmw);
                break;

            case 3:  bmw = BitmapFactory.decodeResource(getResources(), R.drawable.f4);
                opisImageView.setImageBitmap(bmw);
                break;

            case 4:  bmw = BitmapFactory.decodeResource(getResources(), R.drawable.f5);
                opisImageView.setImageBitmap(bmw);
                break;
        }

        FragmentManager manager = getFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();

        Configuration config = getResources().getConfiguration();

        LandscapeFragment fragment = new LandscapeFragment();

        transaction.hide(fragment);



        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            transaction.replace(android.R.id.content, fragment);
            transaction.show(fragment);

        } else {
            transaction.hide(fragment);
        }

        transaction.commit();

      //  Bitmap bmw = BitmapFactory.decodeResource(getResources(), id);


        silnikTextView.setText(dane[position][0]);
        pojemnoscTextView.setText(dane[position][1]);
        mocTextView.setText(dane[position][2]);
        smomentTextView.setText(dane[position][3]);
        accTextView.setText(dane[position][4]);
        vmaxTextView.setText(dane[position][5]);
        masaTextView.setText(dane[position][6]);


    }

    private void initializeTextViews() {
        silnikTextView = (TextView) findViewById(R.id.silnik_text_view);
        pojemnoscTextView = (TextView) findViewById(R.id.pojemnosc_text_view);
        mocTextView = (TextView) findViewById(R.id.moc_text_view);
        smomentTextView = (TextView) findViewById(R.id.moment_text_view);
        accTextView = (TextView) findViewById(R.id.acc_text_view);
        vmaxTextView = (TextView) findViewById(R.id.vmax_text_view);
        masaTextView = (TextView) findViewById(R.id.masa_text_view);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pokaz_auto_menu, menu);
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