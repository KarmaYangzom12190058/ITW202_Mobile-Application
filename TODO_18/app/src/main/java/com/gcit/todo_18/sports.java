package com.gcit.todo_18;

public class sports {
    private String title;
    private String info;
    private final int imageResources;

    sports(String title, String info, int imageResources){
        this.title = title;
        this.info = info;
        this.imageResources = imageResources;
    }

    String getTitle(){
        return title;
    }
    String getInfo(){
        return info;
    }

    public int getImageResources(){
        return imageResources;
    }
}
