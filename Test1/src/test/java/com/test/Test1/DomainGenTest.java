package com.test.Test1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;
import org.powermock.core.classloader.annotations.PrepareForTest;


//@RunWith(PowerMockRunner.class)
@PrepareForTest(MyTest1.class)
public class DomainGenTest {
	
	@InjectMocks
	DomainGen domainGen = new DomainGen();
	
	

	@Test
	public void testDomainGen() {
		String args = "private String userId;private String firstName;private String lastName;private String completeName;private String mailId;private String contractType;private String accessLevel;private String applicationAccessFlag;private String userRole;private List<String> contentCategories;private String logOutUrl;";
		String[] propertiesArrays = args.split(";");
		List<String> listOfProperties = new ArrayList<>();
		for (String property : propertiesArrays) {
			listOfProperties.add(property);
			/*mockStatic(MyTest1.class);
			PowerMockito.when(MyTest1.justTry("testSuccess")).thenReturn("testSuccess");*/
			
			//when(MyTest1.justTry("testSuccess")).thenReturn("testSuccess");
			
			//domainGen.extractListfromString();
		   
	}
		
		 System.out.println("String: " + MyTest1.justTry("testSuccess"));
		    
	
	}
}
