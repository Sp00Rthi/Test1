package com.test.Test1;

import java.util.ArrayList;
import java.util.List;

public class DomainGen {
	
	public static List<String> extractListfromString() {
		String args = "private String userId;private String firstName;private String lastName;private String completeName;private String mailId;private String contractType;private String accessLevel;private String applicationAccessFlag;private String userRole;private List<String> contentCategories;private String logOutUrl;";
		String[] propertiesArrays = args.split(";");
		List<String> listOfProperties = new ArrayList<>();
		for (String property : propertiesArrays) {
			listOfProperties.add(property);
		}
		
		String s = MyTest1.justTry("testSuccess");
		System.out.println(s);
		return listOfProperties;
	}

	public static String generateDataPerField(String property) {
		
		if (property.indexOf("String") > -1) {			
			return "\"JUNIT_" + property + "\"";
		} else if (property.indexOf("Integer") > -1) {			
			return "12345";
		} else if (property.indexOf("int") > -1) {
			return "12345";
		} else if (property.indexOf("Float") > -1) {
			return "12F";
		} else if (property.indexOf("Double") > -1) {
			return "12d";
		}

		return null;
	}

	public static void main(String[] args) {

		List<String> listOfProperties = extractListfromString();

		String objectName = "UserDetailsBean";
		String referenceName = (objectName.substring(0, 1)).toLowerCase()
				+ (objectName.substring(1, objectName.length()));
			
		List<String> resultOfSetters = new ArrayList<>();
		List<String> resultOfGetters = new ArrayList<>();

		resultOfSetters.add(objectName + " " + referenceName + " = " + "new " + objectName + "();");

		for (String property : listOfProperties) {
			String dataOfField = generateDataPerField(property);
			int beginIndex = property.lastIndexOf(" ");			
			int endIndex = property.length();
			String propertyName = (property.substring(beginIndex + 1, beginIndex + 2)).toUpperCase()
					+ (property.substring(beginIndex + 2, endIndex));			
			resultOfSetters.add(referenceName + ".set" + propertyName + "(" + dataOfField + ");");
			resultOfGetters.add(referenceName + ".get" + propertyName + "();");

		}

		for (String property : resultOfSetters) {
			System.out.println(property);
		}
		for (String property : resultOfGetters) {
			System.out.println(property);
		}

	}



}
