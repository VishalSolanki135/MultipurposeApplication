package com.example.vishal;

import android.content.Context;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SettingAdapter extends ArrayAdapter {

    public SettingAdapter(Context context, ArrayList<IntentClass> list) {
        super(context, 0, list);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null) {
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        IntentClass currentView = (IntentClass)getItem(position);

        ImageView imageView = listItemView.findViewById(R.id.image_view);
        imageView.setImageResource(currentView.getResource());

        TextView name =(TextView)listItemView.findViewById(R.id.nameOfApp);

        name.setText(currentView.getName());

        return listItemView;
    }
}
