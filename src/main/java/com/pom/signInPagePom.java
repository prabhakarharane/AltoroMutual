package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.baseClass;

public class signInPagePom extends baseClass{
	
	public signInPagePom() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="uid")
	WebElement userName;
	
	@FindBy(id ="passw")
	WebElement password;
	
	@FindBy(xpath = "//input[@name='btnSubmit']")
	WebElement submitLogin;
	
	
	public userDashboard logiForm(String user, String pass) {
		userName.sendKeys(user);
		password.sendKeys(pass);
		submitLogin.click();
		return new userDashboard();
	}

}
