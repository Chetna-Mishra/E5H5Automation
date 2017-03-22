package com.adv.qa.selenium.tests.currency;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.adv.qa.selenium.framework.Assert;
import com.adv.qa.selenium.framework.BaseTest;
import com.adv.qa.selenium.framework.pageObjects.LoginPage;
import com.adv.qa.selenium.framework.pageObjects.currency.CurrencyPage;
import com.adv.qa.selenium.helpers.DataResource;
import com.adv.qa.selenium.helpers.DataRow;
import com.adv.qa.selenium.helpers.WaitHelper;

/**
 * @author              :   Chetna
 * Test Reference No	: 	A041_Group_Category_And_Structure_PostingsOracleTest
 * Purpose              :   Run Group Cate15-03-2017
 * ACCESS               :   Submit EP4 and Submit EP5 for Oracle DB
 */

public class A041_Group_Category_And_Structure_PostingsOracleTest extends BaseTest{
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		List<String> ep4ProcessList = dataRow.findNamesReturnValues("ep4ProcessList");
		List<String> ep5ProcessList = dataRow.findNamesReturnValues("ep5ProcessList");
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPage currencyPage = new CurrencyPage(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(ep4ProcessList.get(0));
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+ep4ProcessList.get(1)+" - Company Parameter Edit","Structure Rebuild page","displayed");
		
		/*Create layout code*/	
		
		currencyPage.enterEP4ProcessDetails(ep4ProcessList,companyId);	
		
		currencyPage.enterAboutsubmitDetails();
		
		processVerificationep4(currencyPage,ep4ProcessList.get(2), ep4ProcessList.get(3));
		
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(ep5ProcessList.get(0));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+ep5ProcessList.get(1)+" - Postings Rebuild Parameters","Structure Rebuild page","displayed");
		
		currencyPage.enterEP5ProcessDetails(ep5ProcessList,companyId);

		currencyPage.enterAboutsubmitDetails();
				
		processVerificationep5(currencyPage,ep5ProcessList.get(2), ep5ProcessList.get(3));
		
		currencyPage.logOut(1);
	}

	
	
	public void processVerificationep4(CurrencyPage currencyPage,String process,String Request){
		boolean value = false;
		
		String statBeforeEp4 = currencyPage.getProcessDetailsOracle(process, Request);
		
		Assert.assertEquals(testcases,statBeforeEp4, "2","Process has","entered task list");
		
		if(statBeforeEp4.equals("2")){
			currencyPage.updateProcessOracle(process, Request);
		}
		
		String statAfterEp4 = currencyPage.getProcessDetailsOracle(process, Request);
		
		if(statAfterEp4 == null)
		{
			value = true;			
		}
		Assert.assertTrue(testcases,value,"Process "+process,"performed on "+Request);
		
		currencyPage.clickOnCancel();
		
		currencyPage.isConfirmPopUpDisplayed();
	}
	
	public void processVerificationep5(CurrencyPage currencyPage,String process,String Request){
		boolean value = false;
		
		String statBeforeEp5 = currencyPage.getProcessDetailsOracle(process, Request);
		
		Assert.assertEquals(testcases,statBeforeEp5, "2","Process has","entered task list");
		
		if(statBeforeEp5.equals("2")){
			currencyPage.updateProcessOracle(process, Request);
		}
		
		String statAfterEp5 = currencyPage.getProcessDetailsOracle(process, Request);
		
		if(statAfterEp5 == null || statAfterEp5.equals("3"))
		{
			value = true;			
		}
		Assert.assertTrue(testcases,value,"Process "+process,"performed on "+Request);
		
		currencyPage.clickOnCancel();
		
		currencyPage.isConfirmPopUpDisplayed();
	}

	
	
	
	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	@DataProvider
	public Object[][] dp() 
	{		
		String folder = "src/test/resources/";
		String xmlFilePath = folder  + "E5H5.xml";
		String[] nodeID = { "A041" };
		String [] selectedNames = {"userName","passWord","ep4ProcessList","ep5ProcessList"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
