package com.example.movies.pojo;

public class Movie {
    private String name ;
    private int id ;
    private String img;
    private String rate ;

   public Movie (String name , int id , String img , String rate){
        this.name = name;
        this.id = id;
        this.img = img;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }



}
