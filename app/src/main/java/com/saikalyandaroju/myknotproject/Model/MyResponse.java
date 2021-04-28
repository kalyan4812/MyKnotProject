package com.saikalyandaroju.myknotproject.Model;

import java.io.Serializable;

public class MyResponse implements Serializable {
    private String title,imageURL,success_url;
    private int status;

    public MyResponse(String title, String imageURL, String success_url, int status) {

        this.title = title;
        this.imageURL = imageURL;
        this.success_url = success_url;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getSuccess_url() {
        return success_url;
    }

    public void setSuccess_url(String success_url) {
        this.success_url = success_url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
