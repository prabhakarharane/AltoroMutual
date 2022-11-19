package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.baseClass;

public class accountHistoryPom extends baseClass{
	
	public accountHistoryPom() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//div[@class='fl']/table//table[1]//tr[4]/td[2]")
	WebElement balance;
	
	@FindBy(id ="MenuHyperLink3")
	WebElement transferFundLink;
	
	
	public String accountBallance() {
		String acBalance = balance.getText();
		return acBalance;
	}
	
	public transferFundPom transferFund() {
		transferFundLink.click();
		
		return new transferFundPom();
		
	}
	
	

}
