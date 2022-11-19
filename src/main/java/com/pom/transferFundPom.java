package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.baseClass;
import com.utility.utility;

public class transferFundPom extends baseClass{
	
	public transferFundPom() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="fromAccount")
	WebElement fromAccount;
	
	@FindBy(id ="toAccount")
	WebElement toAccount;
	
	@FindBy(id ="transferAmount")
	WebElement transferAmount;
	
	@FindBy(id ="transfer")
	WebElement transferBtn;
	
	@FindBy(xpath ="//span[@id='_ctl0__ctl0_Content_Main_postResp']/span")
	WebElement transferMessage;
	
	@FindBy(id = "MenuHyperLink2")
	WebElement recentTransactionsLink;
	
	
	//Transfer Fund method
	public void transferFund(String fromact, String toact, String amount) {

		utility.dropDown(fromAccount, fromact);
		utility.dropDown(toAccount, toact);
		transferAmount.sendKeys(amount);
		transferBtn.click();
		
	}
	
	public boolean transactionMessage() {
		
		boolean msg = transferMessage.isDisplayed();
		return msg;
	}
	
	public recentTransactions recentTransaction() {
		recentTransactionsLink.click();
		return new recentTransactions();
	}
	
	

}
