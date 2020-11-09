package dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDao {
    private static final String LOGIN_CHECK = "^[a-zA-Z0-9_-]$";
    private static final String NAME_CHECK = "^[a-zA-Z]+$";
    private static final String LASTNAME_CHECK = "^[a-zA-Z-]$";
    private static final String EMAIL_CHECK = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

    Pattern pattern;
    Matcher matcher;

    public boolean checkLoginString (String login) {
        pattern = Pattern.compile(LOGIN_CHECK);
        matcher = pattern.matcher(login);
        return matcher.matches();
    }

    public boolean checkNameString (String name) {
        pattern = Pattern.compile(NAME_CHECK);
        matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public boolean checkLastNameString (String lastName) {
        pattern = Pattern.compile(LASTNAME_CHECK);
        matcher = pattern.matcher(lastName);
        return matcher.matches();
    }

    public boolean checkEmailString (String eMail) {
        pattern = Pattern.compile(EMAIL_CHECK);
        matcher = pattern.matcher(eMail);
        return matcher.matches();
    }

}
