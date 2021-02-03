package io.geektech.myapplicationfragment;

public class MainModel {

    private String title;
    private String subTitle;
    private int image;

    public int getImage() {
        return image;
    }

    public MainModel(String title, String subTitle, int image) {
        this.title = title;
        this.subTitle = subTitle;
        this.image = image;
    }


    public String getTitle() {
        return title;
    }


    public String getSubTitle() {
        return subTitle;
    }

}
