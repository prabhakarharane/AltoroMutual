package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.baseClass;

public class indexPagePom extends baseClass{
	
	public indexPagePom() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="LoginLink")
	WebElement signinButton;
	
	
	
	
	//clicks on login button
	public signInPagePom signin() {
		signinButton.click();
		
		return new signInPagePom();
	}

}
