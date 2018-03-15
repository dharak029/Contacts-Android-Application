package com.example.dharak029.homework2;

import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

/**
 * Created by dharak029 on 9/13/2017.
 */

public class Contacts implements Serializable{

    String first;
    String last;
    String company;
    String phone;
    String email;
    String URL;
    String address;
    String birthday;
    String nickname;
    String facebook;
    String twitter;
    String skype;
    String youtube;
    byte[] image;

    public Contacts(String first, String last, String company, String phone, String email, String URL, String address, String birthday, String nickname, String facebook, String twitter, String skype, String youtube,byte[] image) {
        this.first = first;
        this.last = last;
        this.company = company;
        this.phone = phone;
        this.email = email;
        this.URL = URL;
        this.address = address;
        this.birthday = birthday;
        this.nickname = nickname;
        this.facebook = facebook;
        this.twitter = twitter;
        this.skype = skype;
        this.youtube = youtube;
        this.image = image;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getCompany() {
        return company;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getURL() {
        return URL;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getSkype() {
        return skype;
    }

    public String getYoutube() {
        return youtube;
    }

    public byte[] getImage() {
        return image;
    }
}
