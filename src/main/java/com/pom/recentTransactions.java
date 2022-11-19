package com.pom;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.baseClass;

public class recentTransactions extends baseClass{
	
	public recentTransactions() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//table[@id='_ctl0__ctl0_Content_Main_MyTransactions']//tr[2]/td[5]")
	WebElement deposit;
	
	@FindBy(xpath ="//table[@id='_ctl0__ctl0_Content_Main_MyTransactions']//tr[3]/td[5]")
	WebElement withdrawal;
	
	@FindBy(id="HyperLink3")
	WebElement contactBtn;
	
	
	
	public HashMap<String, String> checkTransaction() {
		HashMap<String, String> hm = new HashMap();
		hm.put("deposit",deposit.getText());
		hm.put("withdrawal",withdrawal.getText());
		
		return hm;
		
	}
	
	public contactPagePom Contact() {
		contactBtn.click();
		return new contactPagePom();
	}

}
