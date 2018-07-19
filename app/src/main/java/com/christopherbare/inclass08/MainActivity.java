package com.christopherbare.inclass08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements ContactListFragment.ContactListInterface, NewContactFragment.NewContactInterface, PickIconFragment.SelectIconInterface {

    Button button;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_view, new ContactListFragment(), "list_fragment")
                .commit();
    }

    @Override
    public void toNewContact() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_view, new NewContactFragment(), "new_contact_fragment")
                .commit();
    }

    @Override
    public void toSelectIcon(Contact contact) {

    }

    @Override
    public void backToNewContact(Contact contact) {

    }
}
