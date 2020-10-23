package service;

public class StringUtils {

    public String firstUpperCase(String stringLine){
        if(stringLine == null || stringLine.isEmpty()) return "";//или return word;
        return stringLine.substring(0, 1).toUpperCase() + stringLine.substring(1);
    }
}
