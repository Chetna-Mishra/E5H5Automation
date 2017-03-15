package com.adv.qa.selenium.tests.currency;

import javax.xml.parsers.ParserConfigurationException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.adv.qa.selenium.framework.Assert;
import com.adv.qa.selenium.framework.BaseTest;
import com.adv.qa.selenium.framework.pageObjects.LoginPage;
import com.adv.qa.selenium.framework.pageObjects.currency.CurrencyPage;

/**
 * @author              :   Chetna
 * Test Reference No	: 	Start dispatcher
 * Purpose              :   Switch on online auditing
 * Date					:   
 * ACCESS               :   AQD
 */

public class A035A_StartDispatcher extends BaseTest{	
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	@Test
	public void verify() throws InterruptedException, ParserConfigurationException{
		String userName = "SYSTEM";
		String passWord = "E5";
		String currencyCode = "AQD";
			
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page*/
		CurrencyPage currencyPage = new CurrencyPage(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(currencyCode);
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Region List","Structure Rebuild page","displayed");	
		

		currencyPage.startAndStopDispatcher("QAH5DES0");
		currencyPage.startAndStopDispatcher("QAH5EX01");		
		currencyPage.startAndStopDispatcher("QAH5EX02");
		currencyPage.startAndStopDispatcher("QAH5EX03");
		currencyPage.startAndStopDispatcher("QAH5EX04");
		
				
		/*Logout from the application*/
		currencyPage.logOut(2);
	}
	

	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}

}
