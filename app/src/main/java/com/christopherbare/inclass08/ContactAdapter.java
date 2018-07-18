package com.christopherbare.inclass08;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {
    public ContactAdapter (Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contact person = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.contact_item, parent, false);

        TextView textViewName = convertView.findViewById(R.id.textViewName);
        TextView textViewEmail = convertView.findViewById(R.id.textViewEmail);
        TextView textViewPhone = convertView.findViewById(R.id.textViewPhone);
        TextView textViewDept = convertView.findViewById(R.id.textViewDept);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        //set the data from the person object
        textViewName.setText(person.getName());
        textViewEmail.setText(person.getEmail());
        textViewPhone.setText(person.getPhone());
        textViewDept.setText(person.getDept());
        imageView.setImageResource(person.picID);

        return convertView;
    }
}
