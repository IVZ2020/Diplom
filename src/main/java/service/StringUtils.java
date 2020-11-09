package service;

import dao.RegExDao;

public class StringUtils {

    RegExDao regExDao = new RegExDao();

    public String firstUpperCase(String stringLine){
        if(stringLine == null || stringLine.isEmpty()) return "";//или return word;
        return stringLine.substring(0, 1).toUpperCase() + stringLine.substring(1);
    }

    public boolean checkLoginString (String login) {
        if(regExDao.checkLoginString(login)) return true;
        return false;
    }

    public boolean checkNameString (String name) {
        if(regExDao.checkNameString(name)) return true;
        return false;
    }

    public boolean checkLastNameString (String lastName) {
        if(regExDao.checkLastNameString(lastName)) return true;
        return false;
    }

    public boolean checkEmailString (String eMail) {
        if(regExDao.checkEmailString(eMail)) return true;
        return false;
    }
}