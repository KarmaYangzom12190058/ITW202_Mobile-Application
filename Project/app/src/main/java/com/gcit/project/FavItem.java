package com.gcit.project;

public class FavItem {
    private String item_proverb;
    private String key_id;


    public FavItem() {
    }

    public FavItem(String item_proverb, String key_id) {
        this.item_proverb = item_proverb;
        this.key_id = key_id;
    }

    public String getItem_proverb() {
        return item_proverb;
    }

    public void setItem_proverb(String item_proverb) {
        this.item_proverb = item_proverb;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

}
