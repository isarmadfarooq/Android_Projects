package com.sarmadtechempire.contactbook.activity.model;

public class HomeContactRecyclerModel {

    public int img;
    public String name;
    public String number;

    public HomeContactRecyclerModel(int img, String name, String number)
    {
        this.img = img;
        this.name = name;
        this.number = number;
    }

    public HomeContactRecyclerModel(String name, String number)
    {
        this.name = name;
        this.number = number;
    }
}
