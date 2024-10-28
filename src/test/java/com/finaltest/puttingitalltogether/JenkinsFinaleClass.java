package com.finaltest.puttingitalltogether;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class JenkinsFinaleClass {

	@Test
	@Parameters({ "username", "password" })
	public void getUsernameForJenkins(String username, String password) {

		System.out.println("Hello, Jenkins! " + username + " " + password);

	}

}
