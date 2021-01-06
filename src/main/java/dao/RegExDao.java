package dao;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDao {
    private static final String LOGIN_AND_PASS_CHECK = "^[a-zA-Z0-9_-]+$";
    private static final String DOUBLE_CHECK = "^\\d+(\\.\\d+)?";
    private static final String NAME_AND_LASTNAME_CHECK = "^[a-zA-Z-]+$";
    private static final String EMAIL_CHECK = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-._]+\\.[a-zA-Z0-9-.]+$";
    private static final String STRING_CHECK = "^[a-zA-Z0-9_-]+$";
    private static final String IS_NUMERIC = "^\\d+$";
    private static final String DIGIT_NOT_ZERO_CHECK = "^[1-9]+$";

    public static boolean isLoginValid (String login) {
        Pattern pattern = Pattern.compile(LOGIN_AND_PASS_CHECK);
        Matcher matcher = pattern.matcher(login);
        return matcher.matches();
    }

    public static boolean isPasswordValid (String pass) {
        Pattern pattern = Pattern.compile(LOGIN_AND_PASS_CHECK);
        Matcher matcher = pattern.matcher(pass);
        return matcher.matches();
    }

    public static boolean isNameValid (String name) {
        Pattern pattern = Pattern.compile(NAME_AND_LASTNAME_CHECK);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean isLastNameValid (String lastName) {
        Pattern pattern = Pattern.compile(NAME_AND_LASTNAME_CHECK);
        Matcher matcher = pattern.matcher(lastName);
        return matcher.matches();
    }

    public static boolean isEmailValid (String eMail) {
        Pattern pattern = Pattern.compile(EMAIL_CHECK);
        Matcher matcher = pattern.matcher(eMail);
        return matcher.matches();
    }

//    public static boolean isInputStringValid (String field) {
//        Pattern pattern = Pattern.compile(STRING_CHECK);
//        Matcher matcher = pattern.matcher(field);
//        return matcher.matches();
//    }

    public static boolean validationPassword (String passwordString) {
        return passwordString.matches(LOGIN_AND_PASS_CHECK);
    }


    public static String validationOnRegistration (List<String> fieldsForValidation) {
        for (String field : fieldsForValidation
             ) {
            Pattern pattern = Pattern.compile(STRING_CHECK);
            Matcher matcher = pattern.matcher(field);
            if (!matcher.matches()) {
                return field;
            }
        }
        return "1";
    }

    public static boolean validationNameAndLastName (String string) {
            Pattern pattern = Pattern.compile(NAME_AND_LASTNAME_CHECK);
            Matcher matcher = pattern.matcher(string);
            return matcher.matches();
    }


    public static boolean isNumeric(String string) {
        return string.matches(IS_NUMERIC);
    }

    public static boolean isDouble (String string) {
        return string.matches(DOUBLE_CHECK);
    }

//    public static boolean isDigitsInString (String string) {
//        boolean result = string.matches("\\d*\\.\\*");
//
//        return false;
//    }

    public static String checkInputDouble(List<String> fieldsForValidation) {
        for (String field : fieldsForValidation
             ) {
            if (!RegExDao.isNumeric(field))
            return field;
        }
        return "1";
    }

    public static boolean isDoubleNotZero (String string) {
            return (isDouble(string) && string.matches(DIGIT_NOT_ZERO_CHECK));
    }
}