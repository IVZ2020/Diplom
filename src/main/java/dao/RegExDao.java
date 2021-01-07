package dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDao {
    private static final String LOGIN_AND_PASS_CHECK = "^[a-zA-Z0-9_-]+$";
    private static final String DOUBLE_CHECK = "^\\d+(\\.\\d+)?";
    private static final String NAME_AND_LASTNAME_CHECK = "^[a-zA-Z-]+$";
    private static final String EMAIL_CHECK = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-._]+\\.[a-zA-Z0-9-.]+$";
    private static final String IS_NUMERIC = "^\\d+$";
    private static final String DIGIT_NOT_ZERO_CHECK = "^[1-9]+$";

    public static boolean isEmailValid (String eMail) {
        Pattern pattern = Pattern.compile(EMAIL_CHECK);
        Matcher matcher = pattern.matcher(eMail);
        return matcher.matches();
    }

    public static boolean validationLogin (String nameString) {
        return nameString.matches(LOGIN_AND_PASS_CHECK);
    }

    public static boolean validationPassword (String passwordString) {
        return passwordString.matches(LOGIN_AND_PASS_CHECK);
    }

    public static boolean validationName (String nameString) {
        return nameString.matches(NAME_AND_LASTNAME_CHECK);
    }

    public static boolean validationLastName (String nameString) {
        return nameString.matches(NAME_AND_LASTNAME_CHECK);
    }

    public static boolean isNumeric(String string) {
        return string.matches(IS_NUMERIC);
    }

    public static boolean isDouble (String string) {
        return string.matches(DOUBLE_CHECK);
    }

    public static boolean isDoubleNotZero (String string) {
            return (isDouble(string) && string.matches(DIGIT_NOT_ZERO_CHECK));
    }
}