package com.ersen.util;

import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.ersen.exception.InvalidRequestParametersException;

public class ValidationUtils {

	private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern EMAIL_PATTERN;
    public static final int PASSWORD_MIN_LENGTH = 6;
    public static final int USER_NAME_MIN_LENGTH = 3;

    static {
        EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    }

    public static boolean isValidEmail(final String email) {
        return email == null ? false : EMAIL_PATTERN.matcher(email).matches();
    }

    public static void validateEmail(final String email) {
        if (!isValidEmail(email))
            throw new InvalidRequestParametersException("Invalid e-mail address " + email);
    }
    
    public static void validateUserName(final String username) {
        if (!isValidUsername(username))
            throw new InvalidRequestParametersException("Invalid e-mail address " + username);
    }

    private static boolean isValidUsername(String username) {
		return StringUtils.isNotEmpty(username) && username.length() > USER_NAME_MIN_LENGTH;
	}

	public static boolean isValidPassword(final String password) {
        // TODO this might be strengthened
        return password == null ? false : password.length() >= PASSWORD_MIN_LENGTH;
    }

    public static void validatePassword(final String password) {
        if (!isValidPassword(password))
            throw new InvalidRequestParametersException("Password "
                                                        + password
                                                        + " does not meet requirements.At least "
                                                        + PASSWORD_MIN_LENGTH
                                                        + " character required");
    }
	
	public static void protectFromNull(final Object o, final String name) {
        if (o == null)
            throw new InvalidRequestParametersException(name + " cannot be null");
    }
}
