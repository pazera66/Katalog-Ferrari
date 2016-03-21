package com.example.pazera.katalogferrari;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pazera on 2014-08-06.
 */
public class MyAdapter extends ArrayAdapter<String> {
    public MyAdapter(Context context, String[] values) {
        super(context, R.layout.layout_lista, values);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theView  = theInflater.inflate(R.layout.layout_lista, parent, false);
        String pozycja = getItem(position);
        TextView theTextView = (TextView) theView.findViewById(R.id.textView1);
        theTextView.setText(pozycja);
        ImageView theImageView = (ImageView) theView.findViewById(R.id.imageView1);
      //  theImageView.setImageResource(R.drawable.f1);
      //  int i = position;

       /* if (position == 2){
            theImageView.setImageResource(R.drawable.f2);
        }*/

        switch  (position){
            case 0:
                theImageView.setImageResource(R.drawable.f1);
                break;

            case 1:
                theImageView.setImageResource(R.drawable.f2);
                break;

            case 2:
                theImageView.setImageResource(R.drawable.f3);
                break;

            case 3:
                theImageView.setImageResource(R.drawable.f4);
                break;

            case 4:
                theImageView.setImageResource(R.drawable.f5);
                break;
        }


        return theView;
    }
}
