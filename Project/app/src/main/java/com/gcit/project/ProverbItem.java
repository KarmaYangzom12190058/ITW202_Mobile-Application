package com.gcit.project;

public class ProverbItem {
    private String proverb;
    private String key_id;
    private String favStatus;

    public ProverbItem(){

    }

    public ProverbItem(String proverb, String key_id, String favStatus) {
        this.proverb = proverb;
        this.key_id = key_id;
        this.favStatus = favStatus;
    }

    public String getProverb() {
        return proverb;
    }

    public void setProverb(String proverb) {
        this.proverb = proverb;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getFavStatus() {
        return favStatus;
    }

    public void setFavStatus(String favStatus) {
        this.favStatus = favStatus;
    }
}
