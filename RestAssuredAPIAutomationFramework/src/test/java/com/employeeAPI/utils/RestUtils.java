package com.employeeAPI.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	public static String getEmpName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John" + generatedString);
	}

	public static String getEmpSal() {
		String generatedSalary = RandomStringUtils.randomNumeric(5);
		return (generatedSalary);
	}

	public static String getEmpAge() {
		String generatedString = RandomStringUtils.randomNumeric(2);
		return (generatedString);
	}

}
