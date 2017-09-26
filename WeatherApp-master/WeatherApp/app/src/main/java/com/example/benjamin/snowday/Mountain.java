package com.example.benjamin.snowday;

/**
 * Created by 박정철 on 2015-09-14.
 */
public class Mountain {

    private String name;
    private String address;
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Mountain(int image) {
        this.image = image;
    }

    public Mountain(String name, String address, int image){
        this.name = name;
        this.address = address;
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
