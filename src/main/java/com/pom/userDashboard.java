package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.baseClass;
import com.utility.utility;

public class userDashboard extends baseClass{
	
	public userDashboard() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//div[@class='fl']/h1")
	WebElement helloUser;
	
	@FindBy(id ="MenuHyperLink1")
	WebElement accountSummary;
	
	@FindBy(id ="listAccounts")
	WebElement selectAccount;
	
	@FindBy(id ="btnGetAccount")
	WebElement goButton;
	
	
	
	
	
	public boolean validateLogin() {
		String loginMessage = helloUser.getText();
		if(loginMessage.equals("Hello Admin User ")) {
			return true;
		}
		else {
		return false;
		}
	}
	
	public void acSummaryClick() {
		accountSummary.click();
	}
	
	public accountHistoryPom checkAccountDetails(String value) {
		utility.dropDown(selectAccount, value);
		goButton.click();
		
		return new accountHistoryPom();
	}
	
	
	
	
	
	

}
