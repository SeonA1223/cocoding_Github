package com.example.myapplication.Object;

import android.net.Uri;

public class ObjectData {

    private Uri userObjectImage;
    private String objectName;

    public String getobjectName() {
        return objectName;
    }

    public void setobjectName(String objectName) {
        this.objectName = objectName;
    }

    public Uri getuserObjectImage(){return userObjectImage;}

    public void setuserObjectImage(Uri uri) {this.userObjectImage = uri;}
}
