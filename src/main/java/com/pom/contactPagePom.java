package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.baseClass;

public class contactPagePom extends baseClass{
	
	public contactPagePom() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[contains(text(),'online')]")
	WebElement onlineForm;
	
	
	public feedbackPagePom clickOnlineForm() {
		onlineForm.click();
		return new feedbackPagePom();
	}

}
