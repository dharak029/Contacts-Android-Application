package com.example.dharak029.homework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<Contacts> listOfContacts ;

        if(getIntent().getSerializableExtra("ListOfContact")!=null){
            listOfContacts = (ArrayList<Contacts>)getIntent().getSerializableExtra("ListOfContact");
        }
        else{
            listOfContacts = new ArrayList<Contacts>();
        }

        findViewById(R.id.btnCreate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CreateNewContact.class);
                intent.putExtra("ListOfContact",listOfContacts);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnDisplay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DisplayContacts.class);
                intent.putExtra("ListOfContact",listOfContacts);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnFinish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                MainActivity.this.finish();
            }
        });

        findViewById(R.id.btnEdit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DisplayContacts.class);
                intent.putExtra("ListOfContact",listOfContacts);
                intent.putExtra("operation","edit");
                startActivity(intent);
            }
        });

        findViewById(R.id.btnDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DisplayContacts.class);
                intent.putExtra("ListOfContact",listOfContacts);
                intent.putExtra("operation","delete");
                startActivity(intent);
            }
        });

    }
}
