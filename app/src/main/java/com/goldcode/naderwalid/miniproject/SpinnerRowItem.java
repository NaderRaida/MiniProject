package com.goldcode.naderwalid.miniproject;

import android.widget.ArrayAdapter;

public class SpinnerRowItem  {

    private int ImageId;
    private String Title;

    public SpinnerRowItem(String Title,int ImageId){

        this.Title = Title;
        this.ImageId = ImageId;
    }

    public String getTitle(){

        return Title;
    }

    public void setTitle(String Title){

        this.Title = Title;
    }

    public int getImageId(){

        return ImageId;
    }

    public void setImageId(int ImageId){

        this.ImageId = ImageId;
    }

    @Override
    public String toString() {
        return Title ;
    }
}
