package dao;

import java.text.ParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDao {
    private static final String LOGIN_AND_PASS_CHECK = "^[a-zA-Z0-9_-]+$";
    private static final String NAME_AND_LASTNAME_CHECK = "^[a-zA-Z-]+$";
    private static final String EMAIL_CHECK = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-._]+\\.[a-zA-Z0-9-.]+$";
    private static final String STRING_CHECK = "^[a-zA-Z0-9_-]+$";

    public static boolean checkLoginString (String login) {
        Pattern pattern = Pattern.compile(LOGIN_AND_PASS_CHECK);
        Matcher matcher = pattern.matcher(login);
        return matcher.matches();
    }

    public static boolean checkNameString (String name) {
        Pattern pattern = Pattern.compile(NAME_AND_LASTNAME_CHECK);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean checkLastNameString (String lastName) {
        Pattern pattern = Pattern.compile(NAME_AND_LASTNAME_CHECK);
        Matcher matcher = pattern.matcher(lastName);
        return matcher.matches();
    }

    public static boolean checkEmailString (String eMail) {
        Pattern pattern = Pattern.compile(EMAIL_CHECK);
        Matcher matcher = pattern.matcher(eMail);
        return matcher.matches();
    }

    public static boolean checkPasswordString (String eMail) {
        Pattern pattern = Pattern.compile(LOGIN_AND_PASS_CHECK);
        Matcher matcher = pattern.matcher(eMail);
        return matcher.matches();
    }

    public static boolean checkInputString(String field) {
        Pattern pattern = Pattern.compile(STRING_CHECK);
        Matcher matcher = pattern.matcher(field);
        return matcher.matches();
    }

    public static String validationOnRegistration (List<String> fieldsForValidation) {
        String invalidField;
        for (String field : fieldsForValidation
             ) {
            Pattern pattern = Pattern.compile(STRING_CHECK);
            Matcher matcher = pattern.matcher(field);
            if (!matcher.matches()) {
                invalidField = field;
                return invalidField;
            }
        }
        return "1";
    }
}