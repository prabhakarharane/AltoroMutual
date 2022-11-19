package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.baseClass;

public class feedbackPagePom extends baseClass{
	
	public feedbackPagePom() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//input[@name='email_addr']")
	WebElement emailID;
	
	@FindBy(xpath ="//input[@name='subject']")
	WebElement subject;
	
	@FindBy(xpath ="//textarea[@name='comments']")
	WebElement comment;
	
	@FindBy(xpath ="//input[@name='submit']")
	WebElement submitBtn;
	
	@FindBy(xpath ="//div[@class='fl']/h1")
	WebElement thankYou;
	
	@FindBy(id = "LoginLink")
	WebElement logOffBtn;
	
	
	
	public void submitForm(String email, String sbjt, String msg) {
		emailID.sendKeys(email);
		subject.sendKeys(sbjt);
		comment.sendKeys(msg);
		submitBtn.submit();
	}
	
	public String thankyouMessage() {
		String message = thankYou.getText();
		return message;
	}
	
	public void loginOff() {
		logOffBtn.click();
	}

}
