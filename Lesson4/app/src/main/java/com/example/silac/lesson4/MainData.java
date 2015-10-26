package com.example.silac.lesson4;

public class MainData {
    String zag1;
    String zag2;
    String text;
    public MainData(String zag1, String zag2, String text){
        this.zag1 = zag1;
        this.zag2 = zag2;
        this.text = text;
    }
    public String getZag1(){ return zag1; }
    public String getZag2(){ return zag2; }
    public String getText(){ return text; }
}
