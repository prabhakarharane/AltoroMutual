package com.testCases;

import java.time.Duration;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.baseClass;
import com.pom.accountHistoryPom;
import com.pom.contactPagePom;
import com.pom.feedbackPagePom;
import com.pom.indexPagePom;
import com.pom.recentTransactions;
import com.pom.signInPagePom;
import com.pom.transferFundPom;
import com.pom.userDashboard;
import com.utility.ExcelSheethandle;



public class testFireHappyPath extends baseClass{
	
	@BeforeMethod
	public void setUp() 
	{
		loadApplication();
		driver.get(prop.getProperty("baseurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
/*	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	} */
	
	@Test
	public void happyPath() throws InterruptedException 
	{
		//Clicks On Signin Buttton
		indexPagePom indexPage = new indexPagePom();
		indexPage.signin();
		
		signInPagePom signInPage = new signInPagePom();
		ExcelSheethandle excel = new ExcelSheethandle();
		
		for(int i=1; i<3; i++) {
			HashMap<String, Object>hm =excel.getExcelSheetData("book1", i);
			
			signInPage.logiForm((String)hm.get("username"), (String)hm.get("password"));
			Thread.sleep(3000);
		}
		
		//User Dashboard Page After Login
		userDashboard dashboard = new userDashboard();
		SoftAssert sft = new SoftAssert();
		sft.equals(dashboard.validateLogin());
		
		//click on account summery link
		dashboard.acSummaryClick();
		dashboard.checkAccountDetails("800001");
		
		//Account History Page
		accountHistoryPom acHistory = new accountHistoryPom();
		String str = acHistory.accountBallance();
		
		//Assert available Balance
		sft.assertEquals(str, str);
		
		acHistory.transferFund();
		
		//Transfer Fund Page
		transferFundPom transferFund = new transferFundPom();
		
		//Account details and amount from excel file
		HashMap<String, Object>data =excel.getExcelSheetData("account", 1);
		
		transferFund.transferFund((String)data.get("From"), (String)data.get("To"), (String)data.get("Amount"));
		
		sft.equals(transferFund.transactionMessage());
		
		transferFund.recentTransaction();
		
		//Recent Transaction page
		
		recentTransactions recent = new recentTransactions();
		HashMap<String, String> hm =recent.checkTransaction();
		sft.assertEquals("$9876.00", hm.get("deposit"));
		sft.assertEquals("-$9876.00", hm.get("withdrawal"));
		
		
		recent.Contact();
		
		//Contact Page
		contactPagePom contact = new contactPagePom();
		contact.clickOnlineForm();
		
		//Feedback Page 
		feedbackPagePom feedback = new feedbackPagePom();
		
		HashMap<String, Object>feed =excel.getExcelSheetData("Feedback", 1);
				
		feedback.submitForm((String)feed.get("email"), (String)feed.get("subject"), (String)feed.get("message"));
		
		//Thank you message validation
		sft.assertEquals(feedback.thankyouMessage(), "Thank You");
		
		//Logoff
		feedback.loginOff();
		
		
		
		sft.assertAll();
		
		
	}
		

}
