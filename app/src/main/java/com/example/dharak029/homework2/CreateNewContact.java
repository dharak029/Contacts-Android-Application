package com.example.dharak029.homework2;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CreateNewContact extends AppCompatActivity {

    private final int REQ_CODE = 100;
    EditText editBirthday,editPhone,editFirst,editLast,editCompany,editEmail,editURL,editAddress,editFB,editTwitter,editYoutube,editSkype,editNickName;
    Calendar myCalendar;
    ImageButton imgCam;
    Button btnSave;
    ByteArrayOutputStream photoByteArray;
    Contacts objContacts;
    int index=0;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String phonePattern = "^[\\+\\d]+$";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CODE && resultCode == Activity.RESULT_OK && data!=null) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imgCam.setImageBitmap(Bitmap.createScaledBitmap(photo, 600, 600, false));
            photoByteArray = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG, 50, photoByteArray);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_contact2);

        editBirthday = (EditText) findViewById(R.id.editBirthday);
        imgCam = (ImageButton)findViewById(R.id.imgCam);
        myCalendar = Calendar.getInstance();
        btnSave = (Button)findViewById(R.id.btnSave);
        editFirst = (EditText) findViewById(R.id.editFirst);
        editLast = (EditText) findViewById(R.id.editLast);
        editCompany = (EditText) findViewById(R.id.editCompany);
        editURL = (EditText) findViewById(R.id.editURL);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editAddress = (EditText) findViewById(R.id.editAddress);
        editFB = (EditText) findViewById(R.id.editFB);
        editTwitter = (EditText) findViewById(R.id.editTweet);
        editYoutube = (EditText) findViewById(R.id.editYoutube);
        editSkype = (EditText) findViewById(R.id.editSkype);
        editNickName = (EditText) findViewById(R.id.editNickname);
        editPhone = (EditText) findViewById(R.id.editPhone);
        final ArrayList<Contacts> listOfContacts ;

        if(getIntent().getSerializableExtra("ListOfContact")!=null){
            listOfContacts = (ArrayList<Contacts>)getIntent().getSerializableExtra("ListOfContact");

        }
        else{
            listOfContacts = new ArrayList<Contacts>();
        }

        if(getIntent().getExtras().getSerializable("objContact")!=null){
            index = getIntent().getExtras().getInt("index");
            objContacts = (Contacts) getIntent().getExtras().getSerializable("objContact");
            editFirst.setEnabled(false);
            imgCam.setEnabled(false);
            editLast.setEnabled(false);
            editCompany.setEnabled(false);
//            editURL.setEnabled(false);
            btnSave.setVisibility(View.GONE);
            editEmail.setEnabled(false);
            editAddress.setEnabled(false);
//            editFB.setEnabled(false);
//            editTwitter.setEnabled(false);
//            editYoutube.setEnabled(false);
//            editSkype.setEnabled(false);
            editNickName.setEnabled(false);
            editPhone.setEnabled(false);
            editBirthday.setEnabled(false);

            editFirst.setText(objContacts.getFirst());
            editLast.setText(objContacts.getLast());
            editCompany.setText(objContacts.getCompany());
            editURL.setText(objContacts.getURL());
            editEmail.setText(objContacts.getEmail());
            editAddress.setText(objContacts.getAddress());
            editFB.setText(objContacts.getFacebook());
            editTwitter.setText(objContacts.getTwitter());
            editYoutube.setText(objContacts.getYoutube());
            editSkype.setText(objContacts.getSkype());
            editNickName.setText(objContacts.getNickname());
            editPhone.setText(objContacts.getPhone());
            editBirthday.setText(objContacts.getBirthday());

            editFirst.setHint("");
            editLast.setHint("");
            editCompany.setHint("");
            editURL.setHint("");
            editEmail.setHint("");
            editAddress.setHint("");
            editFB.setHint("");
            editTwitter.setHint("");
            editYoutube.setHint("");
            editSkype.setHint("");
            editNickName.setHint("");
            editPhone.setHint("");
            editBirthday.setHint("");

            if(objContacts.getImage()!=null) {
                Bitmap image = BitmapFactory.decodeByteArray(
                        objContacts.getImage(), 0, objContacts.getImage().length);
                imgCam.setImageBitmap(image);
            }
            else {
                imgCam.setImageResource(R.drawable.default_image);
            }

            editYoutube.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(editYoutube.getText().toString()));
                    startActivity(intent);
                }
            });
            editFB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(editFB.getText().toString()));
                    startActivity(intent);
                }
            });
            editSkype.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(editSkype.getText().toString()));
                    startActivity(intent);
                }
            });
            editTwitter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(editTwitter.getText().toString()));
                    startActivity(intent);
                }
            });
            editURL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(editURL.getText().toString()));
                    startActivity(intent);
                }
            });

        }

        if(getIntent().getExtras().getSerializable("objContact")!=null && getIntent().getStringExtra("operation")!=null){
            editFirst.setEnabled(true);
            imgCam.setEnabled(true);
            editLast.setEnabled(true);
            editCompany.setEnabled(true);
            editURL.setEnabled(true);
            btnSave.setVisibility(View.VISIBLE);
            editEmail.setEnabled(true);
            editAddress.setEnabled(true);
            editFB.setEnabled(true);
            editTwitter.setEnabled(true);
            editYoutube.setEnabled(true);
            editSkype.setEnabled(true);
            editNickName.setEnabled(true);
            editPhone.setEnabled(true);
            editBirthday.setEnabled(true);

        }





        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                editBirthday.setText(sdf.format(myCalendar.getTime()));
            }

        };

        editBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CreateNewContact.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        imgCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent,REQ_CODE);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] photo = null;
                if(photoByteArray!=null) {
                    photo = photoByteArray.toByteArray();
                }
                if(editFirst.getText().toString().length()==0 || editLast.getText().toString().length()==0 || editPhone.getText().toString().length()==0){
                    Toast.makeText(CreateNewContact.this,"Please fill First Name,Last Name,Phone",Toast.LENGTH_LONG).show();
                }
                else if(!editEmail.getText().toString().matches(emailPattern) && editEmail.getText().length()>0){
                    Toast.makeText(CreateNewContact.this,"Please check Email format",Toast.LENGTH_LONG).show();
                }
                else if(!editPhone.getText().toString().matches(phonePattern)){
                    Toast.makeText(CreateNewContact.this,"Please check phone number format",Toast.LENGTH_LONG).show();
                }
                else {
                    if (objContacts != null) {
                        Contacts obj = listOfContacts.get(index);
                        obj.first = editFirst.getText().toString();
                        obj.last = editLast.getText().toString();
                        obj.image = photo;
                        obj.address = editAddress.getText().toString();
                        obj.birthday = editBirthday.getText().toString();
                        obj.email = editEmail.getText().toString();
                        obj.facebook = editFB.getText().toString();
                        obj.skype = editSkype.getText().toString();
                        obj.youtube = editYoutube.getText().toString();
                        obj.twitter = editTwitter.getText().toString();
                        obj.URL = editURL.getText().toString();
                        obj.nickname = editNickName.getText().toString();
                        obj.phone = editPhone.getText().toString();
                        obj.company = editCompany.getText().toString();
                    } else {
                        Contacts objContact = new Contacts(editFirst.getText().toString(), editLast.getText().toString(),
                                editCompany.getText().toString(), editPhone.getText().toString(), editEmail.getText().toString(),
                                editURL.getText().toString(), editAddress.getText().toString(), editBirthday.getText().toString(),
                                editNickName.getText().toString(), editFB.getText().toString(), editTwitter.getText().toString(),
                                editSkype.getText().toString(), editYoutube.getText().toString(), photo);

                        listOfContacts.add(objContact);
                    }
                    Intent intent = new Intent(CreateNewContact.this, MainActivity.class);
                    intent.putExtra("ListOfContact", listOfContacts);
                    startActivity(intent);
                }
            }
        });

    }

}