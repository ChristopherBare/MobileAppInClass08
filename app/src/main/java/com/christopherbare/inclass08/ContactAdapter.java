package com.christopherbare.inclass08;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;
import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {
    public ContactAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Get the app at the current position
        Contact contact = getItem(position);

        //Create the ViewHolder to limit the number of times findViewById is used (faster speeds)
        ViewHolder viewHolder;

        //Make sure the convertView is null before inflating the view
        if (convertView == null) {

            //This turns the normal list view items into our custom app_list_item
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.contact_item, parent, false);

            //Initialize the ViewHolder
            viewHolder = new ViewHolder();

            //Get the elements in the app_list_item and assign them to the ViewHolder
            viewHolder.contact_image = convertView.findViewById(R.id.contact_image);
            viewHolder.contact_name = convertView.findViewById(R.id.textView_contact_name);
            viewHolder.contact_id = convertView.findViewById(R.id.textView_contact_id);
            viewHolder.contact_email = convertView.findViewById(R.id.textView_contact_email);
            viewHolder.contact_phone = convertView.findViewById(R.id.textView_contact_phone);
            viewHolder.contact_dept = convertView.findViewById(R.id.textView_contact_dept);

            //Set the tag (not entirely sure what this does)
            convertView.setTag(viewHolder);

        } else {

            //Instead of creating a new ViewHolder and using findViewById, just populate it using the tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //Populate the views with the object
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource("app/src/main/res/drawable/");
//        Log.d("demo", "Path: " + classLoader.getResource("app/src/main/res/drawable"));
        if (contact.getPicID() == 0) viewHolder.contact_image.setImageResource(contact.getPicID());
        viewHolder.contact_name.setText(contact.getName());
        viewHolder.contact_id.setText(contact.getId());
        viewHolder.contact_id.setVisibility(View.GONE);
        viewHolder.contact_email.setText(contact.getEmail());
        viewHolder.contact_phone.setText(contact.getPhone());
        viewHolder.contact_dept.setText(contact.getDept());

        //Return the converted view that contains the desired layout and information
        return convertView;
    }

    private static class ViewHolder {
        ImageView contact_image;
        TextView contact_name;
        TextView contact_id;
        TextView contact_email;
        TextView contact_phone;
        TextView contact_dept;
    }
}
