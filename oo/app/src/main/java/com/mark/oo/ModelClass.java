package com.mark.oo;

public class ModelClass {
    int image ;
    String text;
    String text2;
    String code3;
    int image2;
    int type;
  String Name;

    public ModelClass(int image, String text, String text2, String code3, int image2, int type, String name ) {
        this.image = image;
        this.text = text;
        this.text2=text2;
        this.code3=code3;
        this.image2=image2;
        this.type=type;
         this.Name=name;
    }



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
    public String getCode3() {
        return code3;
    }

    public void setCode3(String code3) {
        this.code3 = code3;
    }
    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
