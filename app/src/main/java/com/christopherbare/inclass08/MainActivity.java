package com.christopherbare.inclass08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button button;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        button = findViewById(R.id.buttonCreate);
        listView = findViewById(R.id.listView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewContactFragment fragment = (NewContactFragment) getFragmentManager().findFragmentById(R.id.newContactFragment);

            }
        });


    }
}
