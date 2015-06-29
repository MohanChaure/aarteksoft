package com.aartek.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
	public static boolean validateEmail(String emailId) {
		final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(emailId != null ? emailId : "");
		boolean b = m.matches();
		if (!b) {
			return false;
		}
		return true;
	}

	public static boolean validateingAlphabetsFiled(String input) {
		final String NAME_PATTERN = "^[a-zA-Z]*$";
		Pattern p = Pattern.compile(NAME_PATTERN);
		Matcher m = p.matcher(input != null ? input : "");
		boolean b = m.matches();
		if (!b) {
			return false;
		}
		return true;
	}

	public static boolean validatingNumberFiled(String input) {
		final String Number_PATTERN = "^[0-9]*$";
		Pattern p = Pattern.compile(Number_PATTERN);
		Matcher m = p.matcher(input != null ? input : "");
		boolean b = m.matches();
		if (!b) {
			return false;
		}
		return true;

	}

	public static boolean validatingFileUpload(String input) {
		final String FILE_PATTERN = "[^(txt|doc|Pdf)]$";
		Pattern p = Pattern.compile(FILE_PATTERN);
		Matcher m = p.matcher(input != null ? input : "");
		boolean b = m.matches();
		if (!b) {
			return false;
		}
		return true;

	}
}
