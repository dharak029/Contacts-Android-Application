package com.example.dharak029.homework2;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DisplayContacts extends AppCompatActivity {

    ArrayList<Contacts> listOfContact;
    ListView lvContacts;
    int operation = 0;
    int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contacts);


        if(getIntent().getSerializableExtra("ListOfContact")!=null){
            listOfContact = (ArrayList<Contacts>)getIntent().getSerializableExtra("ListOfContact");
        }
        else{
            listOfContact = new ArrayList<Contacts>();
        }

        if(getIntent().getExtras().getString("operation")!=null){
            String op = getIntent().getExtras().getString("operation");
            if(op.toString().equals("delete"))
                operation=1;
            else
                operation=2;
        }

        final ListAdapter listAdapter = new ContactListAdapter(listOfContact,this,listOfContact.size());
        lvContacts = (ListView)findViewById(R.id.lvContacts);
        lvContacts.setAdapter(listAdapter);
        lvContacts.setTextFilterEnabled(true);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete")
                .setMessage("Are you sure")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listOfContact.remove(index);
                        Intent intent = new Intent(DisplayContacts.this,MainActivity.class);
                        intent.putExtra("ListOfContact",listOfContact);
                        startActivity(intent);
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        final AlertDialog alert = builder.create();

        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(operation==1){
                    index = position;
                    alert.show();
                }
                else if(operation==2){
                    Intent intent = new Intent(DisplayContacts.this,CreateNewContact.class);
                    intent.putExtra("objContact",listOfContact.get(position));
                    intent.putExtra("index",position);
                    intent.putExtra("ListOfContact",listOfContact);
                    intent.putExtra("operation","edit");
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(DisplayContacts.this,CreateNewContact.class);
                    intent.putExtra("objContact",listOfContact.get(position));
                    startActivity(intent);
                }

            }
        });
    }
}
