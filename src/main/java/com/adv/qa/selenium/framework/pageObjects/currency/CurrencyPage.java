package com.adv.qa.selenium.framework.pageObjects.currency;

import java.sql.SQLException;
import java.util.List;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import com.adv.qa.selenium.framework.BaseTest;
import com.adv.qa.selenium.framework.pageObjects.Page;
import com.adv.qa.selenium.framework.pageObjects.PageObjects;
import com.adv.qa.selenium.helpers.DatabaseQuery;
import com.adv.qa.selenium.helpers.DatabaseQuery_Oracle;
import com.adv.qa.selenium.helpers.SeleniumDaoException;
import com.adv.qa.selenium.helpers.WaitHelper;


public class CurrencyPage extends Page{
	
	private PageObjects pObject = new PageObjects();
	private DatabaseQuery dbQuery = new DatabaseQuery();
	private DatabaseQuery_Oracle OdbQuery = new DatabaseQuery_Oracle();
	
	private String message = "The specified key already exists";
	
	public CurrencyPage(EventFiringWebDriver driver) {
		super(driver);
		log.info("In currency page");
	}
	
	private WebElement msgNode()
	{
//		return getDriver().findElement(By.id(pObject.MESSAGE_NODE_LABEL));
		return getDriver().findElement(By.xpath(pObject.AllPG_MSG_BUTTON_LABEL));
	
	}
	/**
	 * Get tool content message
	 * @return tool content
	 */
	public String getToolContentText(){
		log.info("Inside getToolContext method");
		
		WaitHelper.waitAdditional(2);
		String toolTipValue = "";
		try{
			if(!getDriver().findElement(By.xpath(pObject.AllPG_MSG_TOOLBAR)).isDisplayed()){			
					msgNode().click();
					WaitHelper.waitAdditional(2);
			}
			toolTipValue = getDriver().findElement(By.xpath(pObject.AllPG_MSG_TOOLBAR)).getText();
		}
		catch(NoSuchElementException e){
			toolTipValue = "";
		}
		WaitHelper.waitAdditional(2);
		return toolTipValue;
	}
	
	/**
	 * New Method Added by Chetna, Dt: 17-01-2017 for "VerifyToolContentMessage"
	 * Get toolBar content message
	 * @return tool content
	 * 
	 */
	
		public boolean VerifyToolContentMessage(String value)
		{
		WaitHelper.waitAdditional(2);
		log.info("Verify presence of Message in the ToolBar Message list");
		boolean MessageValue = false;
		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.AllPG_MSG_TOOLBAR));
		for(WebElement wb : wbs)
		{
			if(wb.getText().contains(value))
			{
				MessageValue = true;
				break;
			}
		}
		return MessageValue;
	}
	
		/**
		 * New Method Added by Chetna, Dt: 23-01-2017 for "VerifySeachToolContentMessage"
		 * Get search Page toolBar content message
		 * @return tool content
		 * 
		 */
		
			public boolean VerifySeachToolContentMessage(String value)
			{
			WaitHelper.waitAdditional(2);
			log.info("Verify presence of Message in the Search ToolBar Message list");
			boolean MessageValue = false;
			List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.All_SEARCH_MSG_TOOLBAR));
			for(WebElement wb : wbs)
			{
				if(wb.getText().contains(value))
				{
					MessageValue = true;
					break;
				}
			}
			return MessageValue;
		}
	
	public boolean isToolTipDisplayed(){
		boolean toolTip = false;
		try{
		if(getDriver().findElement(By.id(pObject.MESSAGE_NODE_LABEL)).isDisplayed()){

			toolTip = true;
		}

		}
		catch(NoSuchElementException e){
			toolTip = false;
		}
		return toolTip;
	}
	/**
	 * Verify command box
	 * @return true/false
	 */
	public boolean isCommandDisplayed(){
		log.info("Inside isCommandDisplayed method");
		boolean command = false;
		try{
			
			if(getDriver().findElement(By.xpath(pObject.CMD_COMMAND)).isDisplayed()){
				command = true;
			}
		}
		catch (NoSuchElementException e){
			clickOnCancel();
			
			if(getDriver().findElement(By.xpath(pObject.CMD_COMMAND)).isDisplayed()){	
				command = true;
			}
			WaitHelper.waitAdditional(2);
		}
		return command;
	}
	
	/**
	 * Verify presence of Change Company/Role pop up
	 * @return
	 */
	 
	 	private boolean isChangeCMPYPopUpDisplayed(){
		WaitHelper.waitAdditional(2);
		return getDriver().findElement(By.xpath(pObject.A039_LKP_OK)).isDisplayed();
		
	}
	
	
	/**
	 * Change company from default company
	 * @param company
	 */
	public void clickOnChangeCompany(String company){
		log.info("Inside change Company method");
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A039_CHANGE_CMPY)).click();//ChangeCompany/Role button
		WaitHelper.waitAdditional(2);
		
		if(!isChangeCMPYPopUpDisplayed()){
			WaitHelper.waitAdditional(3);
		}
		
		getDriver().findElement(By.xpath(pObject.A039_LKP_CMPY)).clear(); //Company
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A039_LKP_CMPY)).sendKeys(company);//Company
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A039_LKP_OK)).click(); //Ok Button
		WaitHelper.waitAdditional(4);

	}
	
	/**
	 * Modified by Chetna, Dt: 17-01-2017
	 * Enter currency code in the command line
	 * @param code
	 * @throws InterruptedException
	 */
	public void fillCurrenceyCode(String code) throws InterruptedException{
		WaitHelper.waitAdditional(3);
		log.info("Fill currency code");
		
		getDriver().findElement(By.xpath(pObject.CMD_COMMAND)).sendKeys(code);
		getDriver().findElement(By.xpath(pObject.CMD_COMMAND)).sendKeys(Keys.ENTER);
		
		WaitHelper.waitAdditional(4);
	}
	
	/**
	 * Click on OK button
	 * @throws InterruptedException
	 */
	public void clickOnButton(int i) throws InterruptedException{
		log.info("Clicing button");
		WaitHelper.waitAdditional(3);
		getDriver().findElement(By.id(pObject.ZERO_+i+pObject.LABEL)).click();
		WaitHelper.waitAdditional(4);
	}
	
	private WebElement getSecondHeader()
	{
//		return getDriver().findElement(By.xpath("//html//body//div[2]/div/div[2]/div/div/div[2]/div/div"));
		return getDriver().findElement(By.xpath(pObject.A001A_NAV_BAR));
	}
	
	/**
	 * Verify title of table displayed with currency code
	 * @return page header
	 */
	public String getTableHeader(){
		log.info("Inside getTab header method");
		WaitHelper.waitAdditional(2);
		String header = "";
		if(getSecondHeader() != null)
		
		{
			header = getSecondHeader().getText();
		}
		WaitHelper.waitAdditional(2);
		return header;
	}
	
	/**
	 * Verify Currency list
	 * @return
	 * @throws InterruptedException
	 */
	public boolean isCurrencyListDisplayed() throws InterruptedException{
		log.info("Inside isCurrencyDisplayed method");
		WaitHelper.waitAdditional(2);
		return getDriver().findElement(By.className(pObject.CURRENCY_PANE)).isDisplayed();
	}
	
	/**
	 * Click on Insert button
	 */
	

	public void clickOnInsert(){
		WaitHelper.waitAdditional(2);
		boolean isclicked = false;
		log.info("Clicking on Insert button");
		int count = 0;
		do{
			count=count+1;
			List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
			for(WebElement wb : wbs){
				if(wb.getText().equals("Insert"))
				{
					wb.click();
					isclicked = true;
					break;
				}
			}
		}
		while(isclicked = false);//(!(getTableHeader().contains("Edit")) && count !=3);
		WaitHelper.waitAdditional(2);
	}

	
	/**
	 * Click on Insert1 button for A028 and A0029
	 */
	

	public void clickOnInsert1() {
		log.info("Clicking on Insert button for A028 & A029");
		getDriver().findElement(By.xpath(pObject.AllPG_INSERT1)).click();
		WaitHelper.waitAdditional(2);
	}
	

	public void clickOnCancel1() {
		log.info("Clicking on cancel button for A028 & A029");
		getDriver().findElement(By.xpath(pObject.AllPG_CANCEL1)).click();
		WaitHelper.waitAdditional(2);
	}
	
	
	public void clickOnAmed1() {
		log.info("Clicking on Amend button for A028 & A029");
		getDriver().findElement(By.xpath(pObject.AllPG_AMEND1)).click();
		WaitHelper.waitAdditional(2);
	}
	
	 /**
	 * Modified by Chetna, Dt: 17-01-2017
     *Add new currency
	 * @throws InterruptedException 
     */
	public boolean addNewCurrency(List<String> currencyList) throws InterruptedException
	{
		log.info("Adding new currency");
		boolean update = false;
		
		getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).sendKeys(currencyList.get(0));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_CURRENCY)).sendKeys(Keys.ENTER); //Currency Test

		WaitHelper.waitAdditional(2);
				
	
		if(!VerifyToolContentMessage("The specified key already exists"))
//			if(!getToolContentText().contains(message))
					
		{
			WaitHelper.waitAdditional(1);
			
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();//(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(currencyList.get(1));//Description
			
			getDriver().findElement(By.xpath(pObject.A002_DECIMAL_P)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DECIMAL_P)).sendKeys(currencyList.get(2));//Decimal places
			
			getDriver().findElement(By.xpath(pObject.A002_UNIT)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_UNIT)).sendKeys(currencyList.get(3));//Unit
			
			getDriver().findElement(By.xpath(pObject.A002_UNITS)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_UNITS)).sendKeys(currencyList.get(4));//Units
			
			getDriver().findElement(By.xpath(pObject.A002_SUN_UNIT)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_SUN_UNIT)).sendKeys(currencyList.get(5));//Sub-Unit
			
			getDriver().findElement(By.xpath(pObject.A002_SUN_UNITS)).clear();
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A002_SUN_UNITS)).sendKeys(currencyList.get(6));//Sub-Units
			WaitHelper.waitAdditional(2);
			
//			getDriver().findElement(By.cssSelector("[name^='EMU-IND_']")).sendKeys(currencyList.get(7));//Emu Indicator dropdown
//			WaitHelper.waitAdditional(2);			
			
			getDriver().findElement(By.xpath(pObject.A002_EMU_IND)).sendKeys(currencyList.get(7));//Emu Indicator dropdown
			WaitHelper.waitAdditional(2);
				
			getDriver().findElement(By.xpath(pObject.A002_FIXED_RATE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_FIXED_RATE)).sendKeys(currencyList.get(8));//Fixed rate
			WaitHelper.waitAdditional(2);
			
			getDriver().findElement(By.xpath(pObject.A002_DATE_OF_ENTRY)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A002_DATE_OF_ENTRY)).sendKeys(currencyList.get(9));//Date
			WaitHelper.waitAdditional(3);
			
//			getDriver().findElement(By.cssSelector("[name^='RNDG-IND_']")).sendKeys(currencyList.get(10));//Rounding Ind
//			WaitHelper.waitAdditional(2);
			
			getDriver().findElement(By.xpath(pObject.A002_ROUNDING_IND)).sendKeys(currencyList.get(10));//Rounding Ind
			WaitHelper.waitAdditional(1);

			update = true;
		}
		return update;
	}
	
	/**
     *Click on update button
	 * @throws InterruptedException 
     */
	public void clickOnUpdateCurrency() throws InterruptedException{
		log.info("Clicking on Update btton");
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.ONE+pObject.LABEL)).click();
		try{
			isRefreshDisplayed();
		}
		catch(NoSuchElementException e){
			clickOnCancel();
		}
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Verify Entity present in Currency table by iterating in to each column
	 * @param value
	 * @return true
	 */
	public boolean verifyValues(String value)
	
	{
		WaitHelper.waitAdditional(2);
		log.info("Verify presence of value in the list");
		boolean currencyValue = false;
		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.A001A_CURRENCY_TABLE_CELL));
		for(WebElement wb : wbs){
			if(wb.getText().contains(value))
			
			{
				currencyValue = true;
				break;
			}
		}
		return currencyValue;
	}
	
	/**
	 * Get cancel button
	 */
	
	public List<WebElement> getAlllButton(){
		log.info("Verify presence of Cancel button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		return wbs;
	}
	
	
	
	public List<WebElement> getAllFooterButton(){
		log.info("Verify presence of button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.AllPG_FOOT_SEC));
		return wbs;
	}	
	
	//button[starts-with(@class,'button roundedbutton')]
	
	
	/**
	 * Click on Cancel button
	 */
	
	public void clickOnCancel(){
		log.info("Clicking on cancel button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAlllButton();
		for(WebElement wb : wbs){
			if(wb.getText().equals("Cancel")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	
	/**
	 * Verify presence of confirmation window
	 * @return true/false
	 */
	public void isConfirmPopUpDisplayed()
	
	{
		log.info("Verify confirmation pop up");
		WaitHelper.waitAdditional(3);
		try{
			if(getDriver().findElement(By.xpath(pObject.CONF_BUT_YES)).isDisplayed())
			
			{
				getDriver().findElement(By.xpath(pObject.CONF_BUT_YES)).click();
			}
		}
		catch (NoSuchElementException e){
			
		}
		WaitHelper.waitAdditional(5);
	}
	
	/**
	 * Verify presence of Cancel button
	 * @return
	 */
	public boolean isCancelDisplayed(){
		log.info("Verify cancel button");
		WaitHelper.waitAdditional(2);
		boolean cancel = false;
		List<WebElement> wbs = getAlllButton();
		for(WebElement wb : wbs){
			if(wb.getText().equals("Cancel")){
				cancel = true;
				break;
			}
		}
		return cancel;
	}

	
	private List<WebElement> getButton()
	{
		return getDriver().findElements(By.className("button"));
	}
	
	
	public boolean ClickOnAnyButton(String buttonName,int action)
	
	 
	 {
		log.info("Click on Any Buttomn Method");
	WaitHelper.waitAdditional(1);
		
	boolean isDisplayed = false;
	  List<WebElement> listOfButtons = getButton();
	  for(WebElement button : listOfButtons)
	  {
	   if(button.getAttribute("value").equals(buttonName))
	   {
	    if(button.isDisplayed())
	    {
	     if(action == 0)
	     {
	      isDisplayed = true;
	     }
	     else
	     { 
	      button.click();
	     }
	     
	     break;
	    }    
	   }   
	  } 
	  return isDisplayed;
	 }	
	
	
	/**
	 * Click on Yes button
	 */
	public void clickOnYesButton(){
		log.info("Verify Yes button");
		WaitHelper.waitAdditional(2);
		ClickOnAnyButton("Yes", 1);
		
	}
	
	/**
	 * Logout from the application
	 * @throws InterruptedException
	 */
	public void logOut(int i) throws InterruptedException{
		log.info("Logging out from the application");
		if(i==2){
			clickOnCancel();
		}
		clickOnCancel();	
		clickOnYesButton();

		WaitHelper.waitAdditional(5);
	}
	
	/**
	 * Click on Exit form top header
	 */
	public void clickOnExit(){
		log.info("Clicking on Exit button");

		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for(WebElement wb : wbs){
			if(wb.getText().equals("Exit")){
				wb.click();
				List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
				for(WebElement wb2 : wbs1){
					if(wb2.getText().equals("Exit")){
						wb2.click();
						break;
					}
				}
				break;
			}
		}
	}
	
	/**
	 * Click on Exit form top header
	 */
	public void exitFromSupplierElement(){
		log.info("Clicking on Exit button");
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.HEADER_TAB_BTN));
		for(WebElement wb : wbs){
			if(wb.getText().equals("Exit")){
				wb.click();
				break;
			}
		}
	}
	
	/**
	 * Delete currency from the currency ist
	 */
	public void clickOnPurge(){
		log.info("Clicking on Purge button");
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb : wbs){
			if(wb.getText().equals("Edit")){
				wb.click();
				List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
				for(WebElement wb2 : wbs1){
					if(wb2.getText().equals("Purge")){
						wb2.click();
						break;
					}
				}
				break;
			}
		}
	}
	
	/**
	 * Click on view button
	 */
	public void clickOnView(){
		log.info("Clicking on View button");
		WaitHelper.waitAdditional(2);

		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for(WebElement wb2 : wbs1){
			if(wb2.getText().equals("View")){
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	/**
	 * Refresh after deleting currency
	 * @throws InterruptedException
	 */
	public void clickOnRefresh(){
		log.info("Clicking on Refresh button");
		WaitHelper.waitAdditional(5);

		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for(WebElement wb : wbs){
			if(wb.getText().equals("Refresh")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}
	
	/**
	 * Verify Refresh button
	 * @throws InterruptedException
	 */
	public boolean isRefreshDisplayed() throws InterruptedException{
		log.info("Verify refresh button");
		boolean refreshButton = false;
		WaitHelper.waitAdditional(5);
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.HEADER_TAB_BTN));
		for(WebElement wb : wbs){
			if(wb.getText().equals("Refresh")){
				refreshButton = true;
				break;
			}
		}
		WaitHelper.waitAdditional(2);
		return refreshButton;
	}
	/**
	 * Get sections
	 * @return
	 */
	private List<WebElement> getSections(){
		return getDriver().findElements(By.className(pObject.SECTION_LAYOUT));		 

		
	}
	
	/**
	 * Click on sections of Search page
	 * @param i
	 */
	public void clickOnSections(int i){
		log.info("Expanding Search Section");
		getSections().get(i).click();
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Click on the entity
	 * @param entity
	 * @return
	 * Modified by Chetna Dt: 16-01-2017
	 */
	
	public void selectEntity(String entity){
		log.info("Select Entity method");
		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.A001A_CURRENCY_TABLE_CELL));
		for(WebElement wb : wbs){
			if(wb.getText().contains(entity)){
				wb.click();
				break;
			}
		}
	}
	
	/**
	 * Click on the entity
	 * @param entity
	 * @return
	 * Modified by Chetna Dt: 16-01-2017
	 */
public boolean selectEntityValue(List<String> entity) throws InterruptedException
	
	{
		log.info("Select Entity method");
		
		boolean update = false;
		
		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.A001A_CURRENCY_TABLE_CELL));
		for(WebElement wb : wbs){
			if(wb.getText().contains(entity.get(0)))
					{
				wb.click();
				break;
			
				
					}
			update = true;
		}
		
		return update;
	}

	
	/**
	 * Edit currency from the currency list
	 * Modified by Chetna Dt: 16-01-2017
	 */
	public boolean isEditDisplayed(){
		log.info("Verify edit button");
		boolean edit = false;

		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for(WebElement wb : wbs){
			if(wb.getText().equals("Edit")){
				wb.click();
				edit = true;
				break;
			}
		}
		return edit;
	}
	
	/**
	 * Click on Amend button
	 * Modified by Chetna Dt: 16-01-2017
	 */
	public void clickOnAmend(){
		WaitHelper.waitAdditional(1);
		boolean isClicked = false;
		log.info("Click on Amend button");
		int count = 0;
		do{
			count=count+1;
			List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
			for(WebElement wb2 : wbs1){
				if(wb2.getText().equals("Amend")){
					wb2.click();
					break;
				}
			}
			WaitHelper.waitAdditional(2);
		}
		
		while(isClicked = false); //(!(getTableHeader().contains("Edit")) && count !=3);
		
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Click on prompt button
	 * Modified by Chetna Dt: 16-01-2017
	 */
	public void clickOnPrompt(){
		log.info("Click on prompt button");

		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for(WebElement wb2 : wbs1){
			if(wb2.getText().equals("Prompt")){
						wb2.click();
						break;
			}
		}
		WaitHelper.waitAdditional(3);
	}
	/**
	 * Click on Update currency
	 * Modified by Chetna Dt: 16-01-2017
	 */
	public void clickOnUpdate(){
		log.info("Clicking on update button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for(WebElement wb2 : wbs1){
			if(wb2.getText().equals("Update")){
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	/**
	 * Click on BackWard Button
	 * 
	 */
	public void clickOnBKWD(){
		log.info("Clicking on Backward button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for(WebElement wb2 : wbs1){
			if(wb2.getText().equals("Bkwd")){
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}
	
	/**
	 * Click on Forward Button
	 * 
	 */
	public void clickOnFwd(){
		log.info("Clicking on Forward button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for(WebElement wb2 : wbs1){
			if(wb2.getText().equals("Fwd")){
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}	
	
	
	/**
	 * Click on Update currency
	 * Modified by Chetna Dt: 16-01-2017
	 */
	public void clickOnUpdateCompany(){
		log.info("Clicking on update button");
		WaitHelper.waitAdditional(2);

		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		int i = 0;
		for(WebElement wb2 : wbs1){
			if(wb2.getText().equals("Update")){				
				if(i==1){
					wb2.click();
					break;
				}
				i = i+1;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	/**
	 * Click on Update warnings
	 */
	public void clickOnUpdateWarnings(){
		log.info("Clicking on update warnings");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb2 : wbs1){
			if(wb2.getText().equals("Update Warnings")){
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	/**
	 * Click on UpdatWarnings (Not In Use)
	 */
	public void clickOnUpdatWarnings(){
		log.info("Clicking on update warnings");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb2 : wbs1){
			if(wb2.getText().equals("Updat Warnings")){
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	/**
	 * Click on UpdatWarnings
	 */
	public void clickOnUpdtWarn(){
		log.info("Clicking on updt warn");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb2 : wbs1){
			if(wb2.getText().equals("Updt Warn")){
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	/**
	 * Click on Updt warnings
	 */
	public void clickOnUpdtWarnings(){
		log.info("Clicking on Updt warnings method");
		WaitHelper.waitAdditional(2);
		
		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for(WebElement wb2 : wbs1)
		{
			if(wb2.getText().equals("Updt Warnings"))
			
			{
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	/**
	 * Click on accept warnings
	 */
	public void clickOnAcceptWarnings(){
		log.info("Clicking on Accept warnings");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for(WebElement wb2 : wbs1){
			if(wb2.getText().equals("Accept Warnings")){
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(2);
	}
	
	 /* Click on accept warnings
	 */
	public void clickOnAcceptWarn(){
		log.info("Clicking on Accept warn");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.xpath(pObject.AllPG_HeaderSection));
		for(WebElement wb2 : wbs1){
			if(wb2.getText().equals("Accept Warn")){
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Verify Column Definition tab displayed
	 * 
	 * @return true
	 * Modified by Chetna Dt: 16-01-2017
	 */

	public boolean isColumnDefinitionTabSelected(){
		return ColumnDefinitionTab().isSelected();
	}
	
	
	private WebElement ColumnDefinitionTab(){
		return getDriver().findElement(By.xpath(pObject.A001A_COLUMN_DEFINATION_TAB));
	}	
	
	
public boolean isColumnDefinitionDispayed(){
log.info("Inside isColumnDefinitionDispayed Method");
	return columnDefinition().isDisplayed();
}





private WebElement columnDefinition(){
	log.info("Inside columnDefinition Method");
	return getDriver().findElement(By.xpath(pObject.A001A_COLUMN_DEFINATION_TAB));
	


}
	
	/**
	 * Click on clickOnColumnDefinition Tab
	 * Modified by Chetna Dt: 16-01-2017
	 */ 
	public void clickOnColumnDefinition()
	{
		
	getDriver().findElement(By.xpath(pObject.A001A_COLUMN_DEFINATION_TAB)).click();
	
	}
	

	/**
 * Verify Definition defn tab displayed
 * Modified by Chetna Dt: 16-01-2017
 * @return true
 */
public boolean isDefinitionDefnDispayed()
{
	log.info("Verify Definition Def method");
	
	WebElement clickOnDefinitionDef = getDriver().findElement(By.xpath(pObject.A001A_DEFINATION_DEF_TAB));

	WaitHelper.waitUntilWebElementDisplayed(getDriver(), clickOnDefinitionDef);
	return clickOnDefinitionDef.isDisplayed();
}
	
	
	/**
	 * Click on Definition defn tab
	 */
	public void clickOnDefinitionDef(){
		log.info("click On Definition Def Tab");

		getDriver().findElement(By.xpath(pObject.A001A_DEFINATION_DEF_TAB)).click();
	}
	

	/**
	 * Verify Primary Details Tab displayed
	 * @return true
	 */
	public boolean isPrimaryDetailsTabSelected(){
		return getPrimaryDetailsTab().isSelected();
	}
	
		
	public boolean isPrimaryDetailsTabDisplayed(){
		return getPrimaryDetailsTab().isDisplayed();
	}
	
	/**
	 *Get primary details tab id 
	 */
	private WebElement getPrimaryDetailsTab(){
		return getDriver().findElement(By.xpath(pObject.A006_PRIMARY_TAB));
	}
	
	/**
	 * Click on Primary Details Tab
	 * Modified by Chetna Dt: 16-01-2017
	 */ 
	public void clickOnPrimaryDetailsTab(){

		getDriver().findElement(By.xpath(pObject.A006_PRIMARY_TAB)).click();
	}
	
	/**
	 * Click on Currency Intrastat Tab
	 */
	public void clickOnSecondTab(){
	
		getDriver().findElement(By.xpath(pObject.A006_CURRENCY_EC_TAB)).click();

	}
	
	/**
	 * Verify Currency Intrastat Tab displayed
	 * @return true
	 */
	public boolean isSecondTabDisplayed(){
		return getSecondTab().isDisplayed();
	}
	

	
	/**
	 * Get second tab
	 * @return
	 */
	private WebElement getSecondTab()
	{

		return getDriver().findElement(By.xpath(pObject.A006_CURRENCY_EC_TAB));
	}
	
	/**
	 * Verify ColumnDefinition Tab for A001A
	 * 
	 */	
	public void verifyColumnDefinitionTab(List<String> entityname)
	
	{
		
		if(!getDriver().findElement(By.xpath("//div[4]/table/tbody/tr/td[2]/input")).isSelected())
			
		{
			getDriver().findElement(By.xpath("//div[4]/table/tbody/tr/td[2]/input")).click();//Short Name chk
			WaitHelper.waitAdditional(1);
		}
		
		if(!getDriver().findElement(By.xpath("//div[5]/table/tbody/tr/td[2]/input")).isSelected())
			
		{
			getDriver().findElement(By.xpath("//div[5]/table/tbody/tr/td[2]/input")).click();//Account Type chk
			WaitHelper.waitAdditional(1);
		}
		
		if(!getDriver().findElement(By.xpath("//div[6]/table/tbody/tr/td[2]/input")).isSelected())
			
		{
			getDriver().findElement(By.xpath("//div[6]/table/tbody/tr/td[2]/input")).click();//Purchaging Flag chk
			WaitHelper.waitAdditional(1);
		}
		
		if(!getDriver().findElement(By.xpath("//div[7]/table/tbody/tr/td[2]/input")).isSelected())
			
		{
			getDriver().findElement(By.xpath("//div[7]/table/tbody/tr/td[2]/input")).click();//PL Flag chk
			WaitHelper.waitAdditional(1);
		}
		
		if(!getDriver().findElement(By.xpath("//div[8]/table/tbody/tr/td[2]/input")).isSelected())
			
		{
			getDriver().findElement(By.xpath("//div[8]/table/tbody/tr/td[2]/input")).click();//POP Flag chk
			WaitHelper.waitAdditional(1);
		}
		 
		if(!getDriver().findElement(By.xpath("//div[9]/table/tbody/tr/td[2]/input")).isSelected())
			
		{
			getDriver().findElement(By.xpath("//div[9]/table/tbody/tr/td[2]/input")).click();//IM Flag chk
			WaitHelper.waitAdditional(1);
		}
		
	
	if(entityname.get(0).equals("TPBSUPP"))
	
	{
		
		if(!getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).isSelected())
			
		{
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).click();//Company chk
			WaitHelper.waitAdditional(1);
		}
		

		if(!getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[2]/input")).isSelected())
			
		{
			getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[2]/input")).click();//Supplier chk
			WaitHelper.waitAdditional(1);
		}
		

		if(!getDriver().findElement(By.xpath("//div[3]/table/tbody/tr/td[2]/input")).isSelected())
			
		{
			getDriver().findElement(By.xpath("//div[3]/table/tbody/tr/td[2]/input")).click();//Name chk
			WaitHelper.waitAdditional(1);
		}
		
		if(!getDriver().findElement(By.xpath("//div[10]/table/tbody/tr/td[2]/input")).isSelected())
			
		{
			getDriver().findElement(By.xpath("//div[10]/table/tbody/tr/td[2]/input")).click();//currency chk
			WaitHelper.waitAdditional(1);
		}
		
		if(!getDriver().findElement(By.xpath("//div[11]/table/tbody/tr/td[2]/input")).isSelected())
			
		{
			getDriver().findElement(By.xpath("//div[11]/table/tbody/tr/td[2]/input")).click();//category chk
			WaitHelper.waitAdditional(1);
		}
		
		if(!getDriver().findElement(By.xpath("//div[12]/table/tbody/tr/td[2]/input")).isSelected())
			
		{
			getDriver().findElement(By.xpath("//div[12]/table/tbody/tr/td[2]/input")).click();//Settlment code chk
			WaitHelper.waitAdditional(1);
		}
				
		}
	
		}
	/**
	 * Verify DefinitionDef Tab for A001A
	 * 
	 */	

public void verifyDefinitionDefTab(List<String> entityname)

{	
	{
if(entityname.get(1).equals("1"))
	
	{
	
	if(!getDriver().findElement(By.xpath(pObject.A001A_AUDIT)).isSelected())
		
	{
		getDriver().findElement(By.xpath(pObject.A001A_AUDIT)).click();//Audit
		WaitHelper.waitAdditional(1);
	}
	
	
	}


	if(entityname.get(2).equals("1"))
	{
	
	if(!getDriver().findElement(By.xpath(pObject.A001A_SUPP_AUDIT)).isSelected())
		
	{
		getDriver().findElement(By.xpath(pObject.A001A_SUPP_AUDIT)).click();//Support Audit
		WaitHelper.waitAdditional(1);
	}

	
}
	}
	getDriver().findElement(By.xpath(pObject.A001A_AUD_KEPT)).clear();
	getDriver().findElement(By.xpath(pObject.A001A_AUD_KEPT)).sendKeys(entityname.get(3));
	WaitHelper.waitAdditional(1);
	
	getDriver().findElement(By.xpath(pObject.A001A_PROC_LVL)).clear();
	getDriver().findElement(By.xpath(pObject.A001A_PROC_LVL)).sendKeys(entityname.get(4));
	WaitHelper.waitAdditional(1);
	
	clickOnUpdate();

}
	
	
	
	
	
	/**
	 * Enter primary details of company
	 * @param companydetails
	 */
	public void enterPrimaryDetails(String companyName,List<String> companydetails){
		log.info("Enter preimary details");
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).sendKeys(companyName);//Company
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(companydetails.get(0));//Description
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A006_NAME)).sendKeys(companydetails.get(1));//Name
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_ADDR1)).sendKeys(companydetails.get(2));//Address line1
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_ADDR2)).sendKeys(companydetails.get(3));//Address line2
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_ADDR3)).sendKeys(companydetails.get(4));//Address line3
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_ADDR4)).sendKeys(companydetails.get(5));//Address line4
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_ADDR5)).sendKeys(companydetails.get(6));//Address line5
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_ADDR6)).sendKeys(companydetails.get(7));//Address line6
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_PSOT_CODE)).sendKeys(companydetails.get(8));//Post code
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_TEL)).sendKeys(companydetails.get(9));//Telephone
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_FAX)).sendKeys(companydetails.get(10));//Fax
	
	}
	
	/**
	 * Enter Currency/EC Intrastat details of company
	 * @param companydetails
	 */
	public void enterCurrencyIntrastatDetails(List<String> companydetails){
		log.info("Enter currency intrastat details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A006_COUNTRY)).sendKeys(companydetails.get(11));//Country
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A003_BASE_CURR_IN)).sendKeys(companydetails.get(12));//Currency
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_EMU_FLAG)).click();//Emu flag
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_CURR_FLAG)).click();//Currency flag
	}

		
	/**
	 * Enter device details
	 * @param deviceDetails
	 */
	public void enterDeviceDetails(List<String> deviceDetails){
		log.info("Enter device details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A007_DEVICE)).clear();//Device name
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A007_DEVICE)).sendKeys(deviceDetails.get(0));
		
		getDriver().findElement(By.xpath(pObject.A006_UPPR_CASE)).click();//Upper case check box
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(deviceDetails.get(1));//Description
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A007_DEFINATION1)).sendKeys(deviceDetails.get(2));//Definition1
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A007_DEFINATION2)).sendKeys(deviceDetails.get(3));//Definition2
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A007_DEFINATION3)).sendKeys(deviceDetails.get(4));//Definition3
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A007_DEFINATION4)).sendKeys(deviceDetails.get(5));//Definition4
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A007_DEFINATION5)).sendKeys(deviceDetails.get(6));//Definition5
	}
	
	/**
	 * Enter Distribution profile details 
	 * @param profileDetails
	 */
	public boolean enterDistributionProfileDetails(List<String> profileDetails){
		log.info("Enter distribution profiles details");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A009_PROFILE)).sendKeys(profileDetails.get(0));//D Profile
		getDriver().findElement(By.xpath(pObject.A009_PROFILE)).sendKeys(Keys.ENTER);//D Profile
		WaitHelper.waitAdditional(2);
		if(!getToolContentText().contains(message)){
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(profileDetails.get(1));//Description
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A007_DEST)).sendKeys(profileDetails.get(2));//Destination
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A009_NO_COPIES)).sendKeys(profileDetails.get(3));//No.of copies
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A009_SUPPR_BANN)).click();//Suppress Banner
			update = true;
		}
		return update;
	}
	
	/**
	 * Search currency
	 * @param currencyList
	 * Modified by Chetna Dt: 16-01-2017
	 */
	public void searchCurrency(String currencyValue){
		log.info("search currency method");
		WaitHelper.waitAdditional(2);
	
		getDriver().findElement(By.xpath(pObject.A001A_TABLE)).clear();
		getDriver().findElement(By.xpath(pObject.A001A_TABLE)).sendKeys(currencyValue);
		getDriver().findElement(By.xpath(pObject.A001A_OK)).click();
		WaitHelper.waitAdditional(2);
	}
	
	
	
	/**
	 * Search currency
	 * @param currencyList
	 * Modified by Chetna Dt: 16-01-2017
	 */
	public void searchEntityValue(List<String> valueList)
	{
		log.info("Search value");
		WaitHelper.waitAdditional(2);
		if(!ClickOnAnyButton("OK", 0))
		{
			clickOnSections(0);
		}
				
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(valueList.get(0));
		getDriver().findElement(By.xpath(pObject.A001A_OK)).click();
		WaitHelper.waitAdditional(2);
		
}		
	
	
	/**
	 * 
	 * @param user
	 * @param i = OK button ID
	 * @param j = Search testbox ID
	 */
	public void search(String user,int i,int j){
		
		if(!isOkButtonDisplayed(i)){
			clickOnSections(0);
		}
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_SEARCH_USER)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_SEARCH_USER)).sendKeys(user);
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A001A_OK)).click();
		WaitHelper.waitAdditional(3);
	}
	
	public void searchOrder(String companyId,String user,int i){
		if(!isOkButtonDisplayed(i)){
			clickOnSections(0);
		}
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(companyId);
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(user);
		
		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(3);
		
		
	}
	
	/*Search document */
	public void searchDocument(String companyId,String user,int i){
		if(!isOkButtonDisplayed(i)){
			clickOnSections(0);
		}
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(companyId);
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(user);
		getDriver().findElement(By.id(pObject.ZERO_+i+pObject.LABEL)).click();
		WaitHelper.waitAdditional(3);
	}
	
	/**
	 * Enter calender activities
	 * @param calenderActivity
	 * @param day
	 */
	public void createDayCalendar(List<String> calenderActivity,int day){
		log.info("Create day calendar");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A012_ACTIVITY)).sendKeys(calenderActivity.get(0));//Activity
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(calenderActivity.get(1));//Desc
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A012_TYPE)).sendKeys(calenderActivity.get(2));//Type
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A012_TYPE)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(2);
		
		if(calenderActivity.get(5).equals("day"))
			
		{

		getDriver().findElement(By.xpath(pObject.A012_MON)).sendKeys(calenderActivity.get(3));
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A012_TUE)).sendKeys(calenderActivity.get(4));

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A012_WED)).sendKeys(calenderActivity.get(6));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A012_THU)).sendKeys(calenderActivity.get(7));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A012_FRI)).sendKeys(calenderActivity.get(8));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A012_SAT)).sendKeys(calenderActivity.get(9));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A012_SUN)).sendKeys(calenderActivity.get(10));
		WaitHelper.waitAdditional(1);
		}
		
		else{
			getDriver().findElement(By.xpath(pObject.A012_O_FREQ)).sendKeys(calenderActivity.get(3));//Occurence Freq
			WaitHelper.waitAdditional(1);			
			
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(Keys.ENTER);//Desc
			
			WaitHelper.waitAdditional(2);

			getDriver().findElement(By.xpath(pObject.A012_DAY_OF_WEEK)).sendKeys(calenderActivity.get(4));//Days of the Week
			
			WaitHelper.waitAdditional(2);
		
		}
	
	}
	
	/*
	 * Enter Account Defindation
	 * i = 
	 * 
	 */
	
	public void enterAccountDefinitionDetails(String companyName,String accountDefinition ,List<String> accountCodeList,List<String> costList,List<String> location,List<String> product){
		log.info("Enter account definition details");
		
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).clear();//Company
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).sendKeys(companyName);//Company
				
		getDriver().findElement(By.xpath(pObject.A014_NOMINAL_CODE)).clear();//Nomina code
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A014_NOMINAL_CODE)).sendKeys(accountDefinition);//Nomina code
		WaitHelper.waitAdditional(2);
		
		

		enterAccountCodeDefinitionDetails(accountCodeList,1);
		enterAccountCodeDefinitionDetails(costList,2);
		enterAccountCodeDefinitionDetails(location,3);
		enterAccountCodeDefinitionDetails(product,4);
		WaitHelper.waitAdditional(4);
	}
	
	/*
	 * Enter Account Code Defindation Details
	 * i = Div ID
	 * 
	 */
	
	private void enterAccountCodeDefinitionDetails(List<String> elements,int i){
		log.info("Enter account code definition details");
		WaitHelper.waitAdditional(2);
		
		if(BaseTest.browser.contains("internetexplorer"))
        {
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[2]")).click();//id
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[2]")).click();//id
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(0));//id input
			WaitHelper.waitAdditional(1.5);
			
			
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[3]")).click();//Size
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[3]")).click();//Size
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(1));//Size input
			WaitHelper.waitAdditional(1.5);

			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[4]")).click();//Description
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[4]")).click();//Description
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(2));//Description input
			WaitHelper.waitAdditional(1.5);
			
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]")).click();//Rel
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]")).click();//Rel
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]/input")).sendKeys(elements.get(3));//Rel input
			WaitHelper.waitAdditional(1.5);
			
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[6]")).click();//Ind
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[6]")).click();//Ind
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[6]/input")).sendKeys(elements.get(4));//Ind input
			WaitHelper.waitAdditional(1.5);
			
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[7]")).click();//Chk
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[7]")).click();//Chk
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[7]/input")).sendKeys(elements.get(5));//Chk input
			WaitHelper.waitAdditional(1.5);
			
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[8]")).click();//Heading
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[8]")).click();//Heading
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[8]/input")).sendKeys(elements.get(6));//Heading input
			WaitHelper.waitAdditional(1.5);
			
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[9]")).click();//Hd size
			WaitHelper.waitAdditional(1.5);
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[9]")).click();//Hd size
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[9]/input")).sendKeys(elements.get(7));//Hd size input
			WaitHelper.waitAdditional(1.5);
			
        }
		else
		{
		
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[2]")).click();//id
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[2]/input")).sendKeys(elements.get(0));//id input
		WaitHelper.waitAdditional(1.5);
		
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[3]")).click();//Size
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[3]/input")).sendKeys(elements.get(1));//Size input
		WaitHelper.waitAdditional(1.5);

		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[4]")).click();//Description
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[4]/input")).sendKeys(elements.get(2));//Description input
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]")).click();//Rel
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]/input")).sendKeys(elements.get(3));//Rel input
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[6]")).click();//Ind
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[6]/input")).sendKeys(elements.get(4));//Ind input
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[7]")).click();//Chk
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[7]/input")).sendKeys(elements.get(5));//Chk input
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[8]")).click();//Heading
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[8]/input")).sendKeys(elements.get(6));//Heading input
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[9]")).click();//Hd size
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[9]/input")).sendKeys(elements.get(7));//Hd size input
		WaitHelper.waitAdditional(1.5);
		}
	}
	
	/**
	 * Enter balance sheet control details
	 * @param balanceSheetList
	 */
	public void enterBalanceSheetControls(List<String> balanceSheetList){
		log.info("Enter balance sheet control details");
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A015_VERSION)).sendKeys(balanceSheetList.get(0));//VERSION
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A015_DESC)).sendKeys(balanceSheetList.get(1));//DESC
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A015_NOM_MAN)).click();//NOM_MAN
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A015_NOM_BAL_SHEET)).click();//NOM_BAL_SHEET
		
	
	}
	
	/**
	 * Enter balance sheet group details
	 * @param balancegroupList
	 */
	public boolean enterBalanceSheetGroup(List<String> balancegroupList){
		log.info("Enter Normal balance sheet group details");
		boolean update = false;
		WaitHelper.waitAdditional(3);
		getDriver().findElement(By.xpath(pObject.A016_GRP)).clear();//Group A016_GRP
		getDriver().findElement(By.xpath(pObject.A016_GRP)).sendKeys(balancegroupList.get(0));//Group A016_GRP
		getDriver().findElement(By.xpath(pObject.A016_GRP)).sendKeys(Keys.ENTER);//Group A016_GRP
		WaitHelper.waitAdditional(2);
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(balancegroupList.get(1));//Desc A004A_DESCR
			WaitHelper.waitAdditional(2);
			
			if(balancegroupList.get(2).equals("1"))
			
			{
	
				getDriver().findElement(By.xpath(pObject.A016_PRPT_LS)).click();//Profit and loss chk box A016_PRPT_LS
				
				
			}
			update = true;
		}
		return update;
	}
	
	/**
	 * Search balance value
	 * @param valueList
	 * @param i = button ID Position
	 * @param j = fields ID Position
	 */
	public void searchBalanceClass(List<String> valueList,int i,int j){
		log.info("Search balance class");
		if(!isOkButtonDisplayed(i)){
			clickOnSections(0);
		}
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.id("pObject.ZERO_+pObject.ZERO"))).click()
		.sendKeys(valueList.get(0)).build().perform();
		
		if(j==1){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(valueList.get(1));
		}
		
		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(3);
		
	}
	
	/**
	 * Search elements
	 * @param valueList
	 * @param i = button ID Position
	 * @param j = fields ID Position
	 */
	public void searchValue(String valueList,int i,int j){
		log.info("Search values");
		WaitHelper.waitAdditional(2);
		if(!ClickOnAnyButton("OK", 0))
		{
			clickOnSections(0);
		}
		
		if(j==0){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(valueList);
			WaitHelper.waitAdditional(1);
		}
		if(j==1){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(valueList);
			WaitHelper.waitAdditional(1);
		}
		if(j==2){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(valueList);
			WaitHelper.waitAdditional(1);
		}
		if(j==4){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(valueList);
			WaitHelper.waitAdditional(1);
		}

		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(3);
				
	}
		
	
	/**
	 * Search value
	 * @param valueList
	 * @param i = button ID Position
	 * @param j = fields ID Position
	 */	
	public void searchValue1(String companyName,List<String> valueList,int i,int j){
		log.info("Into Search value method");
		WaitHelper.waitAdditional(2);

		if(!ClickOnAnyButton("OK", 0))

		{
			clickOnSections(0);
		}
				
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(companyName);
		
		if(j==4){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(valueList.get(0));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();		
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR_+pObject.ZERO)).sendKeys(valueList.get(2));
			WaitHelper.waitAdditional(1);
		}

		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(3);
		
	}	
	
	
	/**
	 * Search value
	 * @param valueList
	 * @param i = button ID Position
	 * @param j = fields ID Position
	 */
	
	
	
	
	public void searchValue(String companyName,List<String> valueList,int i,int j){
		log.info("Into Search value method");
		WaitHelper.waitAdditional(2);

		if(!ClickOnAnyButton("OK", 0))

		{
			clickOnSections(0);
		}
				
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(companyName);
		
		if(j==1){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(valueList.get(0));
			WaitHelper.waitAdditional(1);
		}
		
		if(j==2){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(valueList.get(0));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
		}
		if(j==3){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(valueList.get(0));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
			if(!valueList.get(2).equals("NILL")){
				getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(valueList.get(2));
			}
			WaitHelper.waitAdditional(1);
		}
		if(j==4){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(valueList.get(0));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();		
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(valueList.get(2));
			WaitHelper.waitAdditional(1);
		}
		if(j==5){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(valueList.get(0));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(valueList.get(2));
			WaitHelper.waitAdditional(1);
			if(!valueList.get(3).equals("NILL")){
				getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(valueList.get(3));	
			}
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys(valueList.get(4));
			WaitHelper.waitAdditional(1);
		}
		if(j==6){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(valueList.get(0));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
		}
		if(j==7){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(valueList.get(0));
		}
		if(j==8){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(valueList.get(0));
		}
		if(j==9){
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(valueList.get(0));
		}
		if(j==10){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(valueList.get(0));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
		}
		if(j==11){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(valueList.get(0));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(valueList.get(2));
			WaitHelper.waitAdditional(1);
		}
	

		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(3);
		
	}
	
	/**
	 * Search value for A032A
	 * @param valueList
	 * @param i = button ID Position
	 * @param j = fields ID Position
	 */
		

	public void searchValuePathKey(String companyName,List<String> valueList,int i,int j){
		log.info("Into PathKey Search value method");
		WaitHelper.waitAdditional(2);

		if(!ClickOnAnyButton("OK", 0))

		{
			clickOnSections(0);
		}
		{
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(companyName);
		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(valueList.get(0));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(valueList.get(1));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(1);
		clickOnSections(0);
		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR_+pObject.ZERO)).sendKeys(valueList.get(2));
		WaitHelper.waitAdditional(1);
		}

		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(3);
		
	}
	
	
	public void searchAuthorisor(String companyName,List<String> elements,String orderNumber,int i){
		log.info("Search value");
		WaitHelper.waitAdditional(2);
		if(!isOkButtonDisplayed(i)){
			clickOnSections(0);
		}
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(companyName);//Company
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(0));//USer
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(1));//Structure
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys(orderNumber);//Doc ref
		WaitHelper.waitAdditional(1);
		

		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(2);
		
	}
	/**
	 * Search value -Common
	 * @param valueList
	 * @param i = button ID Position
	 * @param j = fields ID Position
	 */
	public void searchValue(List<String> valueList,int i,int j)
	{
		log.info("Search value");
		WaitHelper.waitAdditional(2);
		if(!ClickOnAnyButton("OK", 0))
		{
			clickOnSections(0);
		}
				
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(valueList.get(0));
		
		if(j==1){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
		}
		
		if(j==2){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(valueList.get(1));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(valueList.get(2));
			WaitHelper.waitAdditional(1);
		}

			ClickOnAnyButton("OK", 1);
			WaitHelper.waitAdditional(3);
	}
	
	
	/**
	 * Search structure
	 * @param companyName
	 * @param valueList
	 * @param i
	 */
	public void searchStructure(String companyName,List<String> valueList,int i){
		log.info("Search structure");
		WaitHelper.waitAdditional(2);
		if(!isOkButtonDisplayed(i)){
			clickOnSections(0);
		}
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(companyName);
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(valueList.get(0));
		WaitHelper.waitAdditional(1);


		ClickOnAnyButton("OK", 1);
		
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Search element
	 * @param companyName
	 * @param ledgerControl
	 * @param i
	 */
	public void searchElement(String companyName,List<String> ledgerControl,int i){
		log.info("Inside search element");
		WaitHelper.waitAdditional(2);
		if(!isOkButtonDisplayed(i)){
			clickOnSections(0);
		}
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();	
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(companyName);
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(ledgerControl.get(0));
		WaitHelper.waitAdditional(1);
		

		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(2);
		
	}
	
	/**
	 * Search nominal balance
	 * @param ledgerControl
	 * @param i
	 */
	public void searchElement(List<String> ledgerControl,int i){
		log.info("Inside search element");
		WaitHelper.waitAdditional(2);
		if(!isOkButtonDisplayed(i)){
			clickOnSections(0);
		}
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();	
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(ledgerControl.get(0));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(ledgerControl.get(1));
		WaitHelper.waitAdditional(1);

		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Search calendar
	 * @param element
	 * @param i
	 */
	public void searchCalendar(List<String> element,int i){
		log.info("Inside search calendar");
		WaitHelper.waitAdditional(3);
		if(!isOkButtonDisplayed(i)){
			clickOnSections(0);
		}
			
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(element.get(0));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject._FIRST)).click();
			
		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(3);
				
	}
	
	/**
	 * Is ok button displayed
	 * @param i
	 * @return
	 */
	public boolean isOkButtonDisplayed(int i){
		log.info("Is ok button displayed");
		boolean displayed = false;
		WebElement wb = getDriver().findElement(By.xpath(pObject.A001A_OK));
		
		if(wb.isDisplayed()){
			displayed = true;
		}
		WaitHelper.waitAdditional(2);
		return displayed;
		
	}
	/**
	 * Enter balance sheet category details - A017
	 * @param balanceCategoryList
	 */
	public boolean enterBalanceSheetCategory(List<String> balanceCategoryList){
		log.info("Inside balance sheet category method");
		boolean update = false;
		
		WaitHelper.waitAdditional(5);
		getDriver().findElement(By.xpath(pObject.A015_VERSION)).clear();//A015_VERSION
		getDriver().findElement(By.xpath(pObject.A015_VERSION)).sendKeys(balanceCategoryList.get(0));//Version A015_VERSION
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A016_GRP)).clear();//Group A016_GRP
		getDriver().findElement(By.xpath(pObject.A016_GRP)).sendKeys(balanceCategoryList.get(1));//Group A016_GRP
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A017_CATEG)).clear();//A017_CATEG
		getDriver().findElement(By.xpath(pObject.A017_CATEG)).sendKeys(balanceCategoryList.get(2));//Category A017_CATEG
		getDriver().findElement(By.xpath(pObject.A017_CATEG)).sendKeys(Keys.ENTER);//Category A017_CATEG
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();//A004A_DESCR
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(balanceCategoryList.get(3));//Desc A004A_DESCR
			WaitHelper.waitAdditional(4);
			getDriver().findElement(By.xpath(pObject.A017_CATEG_TYPE)).sendKeys(balanceCategoryList.get(4));//Category type A017_CATEG_TYPE
			WaitHelper.waitAdditional(1);
			
			update = true;
		}
		return update;
	}
	
	/**
	 * Double click on row
	 * @param i
	 */
	public void doubleClick(int i){
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.id("0_"+i))).doubleClick().build().perform();
	}
	
	/**
	 * Click on delete and refresh
	 * @throws InterruptedException
	 */
	public void deleteAndRefresh() throws InterruptedException{
		clickOnPurge();
		clickOnUpdate();
		clickOnRefresh();
		WaitHelper.waitAdditional(2);
	}
	
	
	/**
	 * Create Nominal controls
	 */
	public boolean enterNominalControl(List<String> nominalList){
		log.info("Inside nominal control method");
		boolean update = false;
		if(!isPrimaryDetailsTabSelected())
		{
			ClickOnAnyTab("Primary Details", 1);
		}

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A018_NOMINAL)).clear();//A018_NOMINAL
		getDriver().findElement(By.xpath(pObject.A018_NOMINAL)).sendKeys(nominalList.get(0));//Nominal A018_NOMINAL
		getDriver().findElement(By.xpath(pObject.A018_NOMINAL)).sendKeys(Keys.ENTER);//Nominal A018_NOMINAL
		WaitHelper.waitAdditional(1);		
		
		if(!getToolContentText().contains(message)){
			
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();//A004A_DESCR
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(nominalList.get(1));//Description A004A_DESCR 
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A016_GRP)).clear();//A016_GRP
			getDriver().findElement(By.xpath(pObject.A016_GRP)).sendKeys(nominalList.get(2));//Group A016_GRP
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A017_CATEG)).clear();
			getDriver().findElement(By.xpath(pObject.A017_CATEG)).sendKeys(nominalList.get(3));//Category
	
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A018_NOML_TYPE)).sendKeys(nominalList.get(4));//Nominal type A018_NOML_TYPE
			WaitHelper.waitAdditional(3);
			getDriver().findElement(By.xpath(pObject.A018_NOML_PST_TYPE)).sendKeys(nominalList.get(5));//Nominal posting type  A018_NOML_PST_TYPE
			WaitHelper.waitAdditional(1);

			getDriver().findElement(By.xpath(pObject.A018_MNGT_CODE_REL1)).clear();//A018_MNGT_CODE_REL1
			getDriver().findElement(By.xpath(pObject.A018_MNGT_CODE_REL1)).sendKeys(nominalList.get(6));//Management Code Relationships1 
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A018_MNGT_CODE_REL2)).clear();//Management Code Relationships
			WaitHelper.waitAdditional(1);
			
			
			if(!getDriver().findElement(By.xpath(pObject.A018_FIN_ALLW)).isSelected())
				
			{
				getDriver().findElement(By.xpath(pObject.A018_FIN_ALLW)).click();//Financial Allowed
			}
			if(getDriver().findElement(By.xpath(pObject.A018_PLN_ALLW)).isSelected())
			{
				getDriver().findElement(By.xpath(pObject.A018_PLN_ALLW)).click();//Planning Allowed
			}
			if(getDriver().findElement(By.xpath(pObject.A018_CST_ALLW)).isSelected())
			
			{
				getDriver().findElement(By.xpath(pObject.A018_CST_ALLW)).click();//Cost allocation
			}
			
			WaitHelper.waitAdditional(2);
	
			ClickOnAnyTab("Currency / Group Category", 1);
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A018_CURR_CODE)).clear();
			WaitHelper.waitAdditional(1);
 			getDriver().findElement(By.xpath(pObject.A018_CURR_CODE)).sendKeys(nominalList.get(7));//Currency code
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A018_CURR_PROCESS)).sendKeys(nominalList.get(8));//Currency processing A018_CURR_PROCESS
			WaitHelper.waitAdditional(2);
		
			update  = true;
		}
		return update;
	}
	
	
	/**
	 * Create Management/Analysis code
	 */
	public boolean enterManagementDetails(List<String> managementList)
	
	{
		log.info("Inside management details");
		boolean update = false;
		
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A019_MNGT_KEY)).clear();//A019_MNGT_KEY
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A019_MNGT_KEY)).sendKeys(managementList.get(0));//Management code A019_MNGT_KEY
		getDriver().findElement(By.xpath(pObject.A019_MNGT_KEY)).sendKeys(Keys.ENTER);//Management code A019_MNGT_KEY
		WaitHelper.waitAdditional(2);
		
		
		if(!getToolContentText().contains(message))
		
		{
			
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();//A004A_DESCR
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(managementList.get(1));//Description A004A_DESCR
			
			getDriver().findElement(By.xpath(pObject.A019_SHRT_NAME)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A019_SHRT_NAME)).sendKeys(managementList.get(2));//Short Description A019_SHRT_NAME
			WaitHelper.waitAdditional(1);
			
			if(!getDriver().findElement(By.xpath(pObject.A019_FINC)).isSelected())
				
			{
				getDriver().findElement(By.xpath(pObject.A019_FINC)).click();//Financial A019_FINC
			}
			
			if(!getDriver().findElement(By.xpath(pObject.A019_PLNG)).isSelected())
			{
				getDriver().findElement(By.xpath(pObject.A019_PLNG)).click();//Planning A019_PLNG
			}
			
			if(!getDriver().findElement(By.xpath(pObject.A019_CST_ALC)).isSelected())
			
			{
				getDriver().findElement(By.xpath(pObject.A019_CST_ALC)).click();//Cost allocation A019_CST_ALC
			}
			
			if(getDriver().findElement(By.xpath(pObject.A019_SUMM_TRANC)).isSelected())
			
			{
				getDriver().findElement(By.xpath(pObject.A019_SUMM_TRANC)).click();//Sum A019_SUMM_TRANC
			}
			
			if(getDriver().findElement(By.xpath(pObject.A019_AVG_BLNC)).isSelected())
				
			{
				getDriver().findElement(By.xpath(pObject.A019_AVG_BLNC)).click();//AVG Bal A019_AVG_BLNC
			}
			
		update = true;
		}
		return update;
	}
	

	/**
	 * Create Analysis code
	 */
	public boolean enterAnalysisDetails(List<String> managementList)
	
	{
		log.info("Inside management details");
		boolean update = false;
		
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A019_MNGT_KEY)).clear();//A019_MNGT_KEY
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A019_MNGT_KEY)).sendKeys(managementList.get(0));//Management code A019_MNGT_KEY
		getDriver().findElement(By.xpath(pObject.A019_MNGT_KEY)).sendKeys(Keys.ENTER);//Management code A019_MNGT_KEY
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message))
		
		{
			
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();//A004A_DESCR
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(managementList.get(1));//Description A004A_DESCR
			
			getDriver().findElement(By.xpath(pObject.A019_SHRT_NAME)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A019_SHRT_NAME)).sendKeys(managementList.get(2));//Short Description A019_SHRT_NAME
			WaitHelper.waitAdditional(1);
			
			if(!getDriver().findElement(By.xpath(pObject.A019_FINC)).isSelected())
				
			{
				getDriver().findElement(By.xpath(pObject.A019_FINC)).click();//Financial A019_FINC
			}
			
			if(!getDriver().findElement(By.xpath(pObject.A019_PLNG)).isSelected())
			{
				getDriver().findElement(By.xpath(pObject.A019_PLNG)).click();//Planning A019_PLNG
			}
			
			if(!getDriver().findElement(By.xpath(pObject.A019_CST_ALC)).isSelected())
			
			{
				getDriver().findElement(By.xpath(pObject.A019_CST_ALC)).click();//Cost allocation A019_CST_ALC
			}
			
			if(getDriver().findElement(By.xpath(pObject.A019_SUMM_TRANC)).isSelected())
			
			{
				getDriver().findElement(By.xpath(pObject.A019_SUMM_TRANC)).click();//Sum A019_SUMM_TRANC
			}
			
						
			getDriver().findElement(By.xpath(pObject.A033_PST_LIMIT_CHECKS)).click();//Post Limit Checks A033_PST_LIMIT_CHECKS
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A033_PST_LIMIT_CHECKS)).sendKeys(managementList.get(5));//Limit Checks A033_PST_LIMIT_CHECKS
			WaitHelper.waitAdditional(1);
			
			getDriver().findElement(By.xpath(pObject.A033_BAL_LIMIT_CHECKS)).click();//BAL Limit Checks A033_BAL_LIMIT_CHECKS
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A033_BAL_LIMIT_CHECKS)).sendKeys(managementList.get(5));//A033_BAL_LIMIT_CHECKS
			WaitHelper.waitAdditional(1);

		update = true;
		}
		return update;
	}	
	
	
	/**
	 * Create Formula
	 */
	
	public boolean enterFormulaDetails(List<String> fomulaList){
		log.info("Inside Formula details method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A025_FORM)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A025_FORM)).sendKeys(fomulaList.get(0));//Formula A025_FORM
		getDriver().findElement(By.xpath(pObject.A025_FORM)).sendKeys(Keys.ENTER);//Formula A025_FORM
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(fomulaList.get(1));//Description A004A_DESCR
			
			getDriver().findElement(By.xpath(pObject.A025_HEADN)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A025_HEADN)).sendKeys(fomulaList.get(2));//Heading A025_HEADN
			
			if(fomulaList.get(3).equals("1")){
				getDriver().findElement(By.xpath(pObject.A025_CHK_APPY_CURR)).click();//Apply currency A025_CHK_APPY_CURR
			}
			
			if(!fomulaList.get(4).equals("Sum Columns"))
			{
			
				getDriver().findElement(By.xpath(pObject.A025_TOTL_CNTRL)).sendKeys(fomulaList.get(4));//Totalling Control A025_TOTL_CNTRL
			}
						
			getDriver().findElement(By.xpath(pObject.A025_FOR_EXP_LNONE)).clear();
			WaitHelper.waitAdditional(3);
			getDriver().findElement(By.xpath(pObject.A025_FOR_EXP_LNONE)).sendKeys(fomulaList.get(5));//Formula expression A025_FOR_EXP_LNONE
			update = true;
		}
		return update;
	}	
	
	
	/**
	 * Create Layout
	 */
	public void enterLayoutDetails(List<String> layoutList){
		log.info("Enter layout details");
		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A026_LAYT)).clear();
		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A026_LAYT)).sendKeys(layoutList.get(0));//Layout A026_LAYT
		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(layoutList.get(1));//Description A004A_DESCR
		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A025_TOTL_CNTRL)).sendKeys(layoutList.get(2));//Total display A025_TOTL_CNTRL
		WaitHelper.waitAdditional(2);
		
		enterFormulasForLayout(layoutList.get(3),layoutList.get(7),layoutList.get(8),1);
		enterFormulasForLayout(layoutList.get(4),layoutList.get(7),layoutList.get(8),2);
		enterFormulasForLayout(layoutList.get(5),layoutList.get(7),layoutList.get(8),3);
		enterFormulasForLayout(layoutList.get(6),layoutList.get(7),layoutList.get(8),4);
		
	}
	
	/**
	 * Enter fourmula for layout
	 * @param formula
	 * @param i
	 */
	private void enterFormulasForLayout(String formula, String formula1,String formula2,int i)
	
	{
		log.info("Enter formula layout details");
		WaitHelper.waitAdditional(2);
	
		if(BaseTest.browser.contains("internetexplorer"))
        {
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[2]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[2]")).click();
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[2]/input")).sendKeys(formula);//Formula
			WaitHelper.waitAdditional(1);
			
		
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[4]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[4]")).click();
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[4]/select[@class='dojoxGridSelect']")).sendKeys(formula1);//Highlight Rule
			WaitHelper.waitAdditional(1);
			
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]/input")).sendKeys(formula2);//Highlight Value
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]/input")).sendKeys(Keys.ENTER);//Highlight Rule
			WaitHelper.waitAdditional(2);
	    }
		else {
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[2]")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[2]/input")).sendKeys(formula);//Formula
		WaitHelper.waitAdditional(1);
		
	
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[4]")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[4]/select[@class='dojoxGridSelect']")).sendKeys(formula1);//Highlight Rule
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]")).click();
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]/input")).sendKeys(formula2);//Highlight Rule
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]/input")).sendKeys(Keys.ENTER);//Highlight Rule
		WaitHelper.waitAdditional(2);
		}
	
	
	}

	
	/**
	 * Enter Destination details
	 * @param destinatioList
	 * @param i
	 */
	public void enterDestinationDetails(List<String> destinatioList){
		log.info("Enter destination details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A007_DEST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A007_DEST)).sendKeys(destinatioList.get(0));//Destination
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(destinatioList.get(1));//Description
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A007_SPOOL_ONLY)).click();//Device type - Spool only
	}
	
	/**
	 * Enter environment details - AFA
	 * @param destinatioList
	 * @param i
	 */
	public boolean enterEnvironmentDetails(List<String> destinatioList){
		log.info("Enter environment details page");
		boolean update = false;
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A010_ENV_GRP)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A010_ENV_GRP)).sendKeys(destinatioList.get(0));//Environment group
		getDriver().findElement(By.xpath(pObject.A010_ENV_GRP)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(1);
		
		if(!getToolContentText().contains(message)){
			WaitHelper.waitAdditional(1);
			
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();//Description
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(destinatioList.get(1));
			
			getDriver().findElement(By.xpath(pObject.A010_SESS_TIME)).clear();//Session time
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A010_SESS_TIME)).sendKeys(destinatioList.get(2));
			
			getDriver().findElement(By.xpath(pObject.A010_PASS_EXP)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A010_PASS_EXP)).sendKeys(destinatioList.get(3));//Password expiry
			
			getDriver().findElement(By.xpath(pObject.A010_MAX_SESS)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A010_MAX_SESS)).sendKeys(destinatioList.get(4));//Maximum sessions
			
			getDriver().findElement(By.xpath(pObject.A010_PROFILE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A010_PROFILE)).sendKeys(destinatioList.get(6));//Profile
			WaitHelper.waitAdditional(2);
			
			getDriver().findElement(By.xpath(pObject.A010_RAD_NORMAL)).click();//Indicator - Normal
			update = true;
		}
		return update;
	}
	
	/**
	 * Modified by Chetna, Dt: 18-Jan-2017
	 * Create Currency Relationship -AGC
	 * @param currencyList
	 * 
	 */
	public boolean enterCurrencyRelationshipDetails(List<String> currencyList){
		log.info("Enter currency relationship details");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A003_BASE_CURR_IN)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A003_BASE_CURR_IN)).sendKeys(currencyList.get(0));//Base currency
		
		getDriver().findElement(By.xpath(pObject.A003_NONBASE_CURR_IN)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A003_NONBASE_CURR_IN)).sendKeys(currencyList.get(1));//Non-base currency
		getDriver().findElement(By.xpath(pObject.A003_NONBASE_CURR_IN)).sendKeys(Keys.ENTER);//Non-base currency
		WaitHelper.waitAdditional(2);
		
		if(!VerifyToolContentMessage("The specified key already exists"))

		{
			
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A003_DIRECTION)).sendKeys(currencyList.get(2));//Direction
			WaitHelper.waitAdditional(1);
			
			getDriver().findElement(By.xpath(pObject.A003_CONVERSION_UNIT)).clear();//Conversion Units
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A003_CONVERSION_UNIT)).sendKeys(currencyList.get(3));
			
			getDriver().findElement(By.xpath(pObject.A003_TOLERANCE_PERC)).clear();//Tolerance %
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A003_TOLERANCE_PERC)).sendKeys(currencyList.get(4));
			
			getDriver().findElement(By.xpath(pObject.A003_TOLERANCE_AMT)).clear();//Tolerance amount
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A003_TOLERANCE_AMT)).sendKeys(currencyList.get(5));
			update = true;
		}
		return update;
	}
	
	
	/**
	 * New Method Added By Chetna Mishra, dt: 18-01-2017
	 * Enter Rate Types 
	 * @param RateTypeList
	 */
	public boolean enterRateTypeDetails(List<String> RateTypeList){
		log.info("Enter Rate Type details");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A004_RATE_TYPE)).clear();//Rate Type
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004_RATE_TYPE)).sendKeys(RateTypeList.get(0));
		getDriver().findElement(By.xpath(pObject.A004_RATE_TYPE)).sendKeys(Keys.ENTER);
				
		if(!VerifyToolContentMessage("The specified key already exists"))
		{

			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(RateTypeList.get(1));
			
			update = true;
		}
		return update;
	}
		
	
	
	
	/**
	 * Enter currency exchange details
	 * @param currencyExchangeList
	 */
	public boolean enterCurrencyExchangeDetails(List<String> currencyExchangeList)
	{
		log.info("Enter currency exchange details");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A003_BASE_CURR_IN)).clear();//Base currency
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A003_BASE_CURR_IN)).sendKeys(currencyExchangeList.get(0));
		
		getDriver().findElement(By.xpath(pObject.A003_NONBASE_CURR_IN)).clear();//Non base currency
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A003_NONBASE_CURR_IN)).sendKeys(currencyExchangeList.get(1));
		
		getDriver().findElement(By.xpath(pObject.A004_RATE_TYPE)).clear();//Rate type
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004_RATE_TYPE)).sendKeys(currencyExchangeList.get(2));
		
		getDriver().findElement(By.xpath(pObject.A004_RATE_TYPE)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(1);
		
		
	 	if (IsMessageToolBarDisplayed())
			
		{
		if(!getToolContentText().contains(message))
				update = true;
		}
		else{
				update = true;
		}			
		return update;
	}
	
		
	/**
	 * Enter currency exchange rate details
	 * @param currencyExchangeList
	 */
	public boolean enterCurrencyExchangeRateDetails(List<String> currencyExchangeList){
		log.info("Enter currency exchange rate details");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A003_BASE_CURR_IN)).clear();//BC
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A003_BASE_CURR_IN)).sendKeys(currencyExchangeList.get(0));
		
		getDriver().findElement(By.xpath(pObject.A003_NONBASE_CURR_IN)).clear();//NBC
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A003_NONBASE_CURR_IN)).sendKeys(currencyExchangeList.get(1));
		
		getDriver().findElement(By.xpath(pObject.A004_RATE_TYPE)).clear();//Rate type
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004_RATE_TYPE)).sendKeys(currencyExchangeList.get(2));
		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DATE_OF_ENTRY)).clear();//Effective Date
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DATE_OF_ENTRY)).sendKeys(currencyExchangeList.get(3));
		getDriver().findElement(By.xpath(pObject.A002_DATE_OF_ENTRY)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(1);
		
			if(!getToolContentText().contains(message))

			
			{
						
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A005_EXCHANGE_RATE)).clear();//Exchange rate
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A005_EXCHANGE_RATE)).sendKeys(currencyExchangeList.get(4));
			WaitHelper.waitAdditional(1);

			if(getDriver().findElement(By.xpath(pObject.A005_TOLERANCE_PER)).getText().equals("1.00"))
			
			{
				getDriver().findElement(By.xpath(pObject.A005_TOLERANCE_PER)).clear();//Tolerance %
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A005_TOLERANCE_PER)).sendKeys(currencyExchangeList.get(5));
			}
			if(getDriver().findElement(By.xpath(pObject.A005_TOLERANCE_AMT)).getText().equals("1.00"))
			{
				getDriver().findElement(By.xpath(pObject.A005_TOLERANCE_AMT)).clear();//Tolerance Amount
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A005_TOLERANCE_AMT)).sendKeys(currencyExchangeList.get(6));
			}
			update = true;			
			}
			
			return update;
	}
	
	/**
	 * Create Structure details
	 * @param structureList
	 */
	public void enterStructureDetails(List<String> structureList){
		log.info("Enter structure details");
		WaitHelper.waitAdditional(2);
					
		getDriver().findElement(By.xpath(pObject.A027_STRUC)).clear();
		getDriver().findElement(By.xpath(pObject.A027_STRUC)).sendKeys(structureList.get(0));//structure
		
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(structureList.get(1));//Description
		
		getDriver().findElement(By.xpath(pObject.A027_UNI_ELE_REQ)).click();//Unique elements
				
		ClickOnAnyTab("Balance Class Update", 1);
		WaitHelper.waitAdditional(2);

		if(BaseTest.browser.contains("internetexplorer"))
        {
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));
			
			getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[3]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));
			
			getDriver().findElement(By.xpath("//div[3]/table/tbody/tr/td[3]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[3]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[3]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));
			
			getDriver().findElement(By.xpath("//div[4]/table/tbody/tr/td[3]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[4]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[4]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));
			
			getDriver().findElement(By.xpath("//div[5]/table/tbody/tr/td[3]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[5]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[5]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));
			
			getDriver().findElement(By.xpath("//div[6]/table/tbody/tr/td[3]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[6]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[6]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));
			
        }
		else{
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));
			
			getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));
			
			getDriver().findElement(By.xpath("//div[3]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[3]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));
			
			getDriver().findElement(By.xpath("//div[4]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[4]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));
			
			getDriver().findElement(By.xpath("//div[5]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[5]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));
			
			getDriver().findElement(By.xpath("//div[6]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[6]/table/tbody/tr/td[3]/input")).sendKeys(structureList.get(2));
			
		}

	
	}
	
	/**
	 * Enter default structure control details - A028
	 * @param controlList
	 */
	
	public void enterControlDetails(List<String> controlList){
		log.info("Enter control details");
		WaitHelper.waitAdditional(2);	
		getDriver().findElement(By.xpath(pObject.A027_STRUC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A027_STRUC)).sendKeys(controlList.get(0));//structure A027_STRUC
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A028_PATH_CODE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A028_PATH_CODE)).sendKeys(controlList.get(1));//Path code A028_PATH_CODE
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A028_SUSP_ELEMNT)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A028_SUSP_ELEMNT)).sendKeys(controlList.get(2));//Suspense element A028_SUSP_ELEMNT
				
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A028_UPDT_CNTRL)).click();//Update control A028_UPDT_CNTRL
		getDriver().findElement(By.xpath(pObject.A028_UPDT_CNTRL)).sendKeys(controlList.get(3));//Update control A028_UPDT_CNTRL
		
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A028_NET_BAL_IND)).sendKeys(controlList.get(4));//Net balance indicator A028_NET_BAL_IND
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A028_NET_BAL_LYT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A028_NET_BAL_LYT)).sendKeys(controlList.get(5));//Net balance layout A028_NET_BAL_LYT
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A028_NOML_BAL_LYT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A028_NOML_BAL_LYT)).sendKeys(controlList.get(6));//Nominal balance layout A028_NOML_BAL_LYT
		WaitHelper.waitAdditional(1);
		
		ClickOnAnyTab("Balance Sheet",1);
		WaitHelper.waitAdditional(2);
		
		
		if(BaseTest.browser.contains("internetexplorer"))
        {
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).clear();
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).sendKeys(controlList.get(7));
			
        }
		else{
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).click();
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).clear();
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).sendKeys(controlList.get(7));
			
		}
		
		
	}	
	

	/**
	 * Enter ledger control list details
	 * @param ledgerControlList
	 */
	public void enterLedgerControlDetails(List<String> ledgerControlList){
		log.info("Enter ledger control details");
		WaitHelper.waitAdditional(2);
		
		
		getDriver().findElement(By.xpath(pObject.A020_LEDGR_COD)).clear();
		getDriver().findElement(By.xpath(pObject.A020_LEDGR_COD)).sendKeys(ledgerControlList.get(0));//Ledger code A020_LEDGR_COD
		
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(ledgerControlList.get(1));//Description A004A_DESCR
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A020_CURR_RND_ACC)).clear();
		getDriver().findElement(By.xpath(pObject.A020_CURR_RND_ACC)).sendKeys(ledgerControlList.get(2));//Account A020_CURR_RND_ACC
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A020_CURR_RND_CST)).clear();
		getDriver().findElement(By.xpath(pObject.A020_CURR_RND_CST)).sendKeys(ledgerControlList.get(3));//Cost A020_CURR_RND_CST
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A020_CLOS_OUT_ACC)).clear();
		getDriver().findElement(By.xpath(pObject.A020_CLOS_OUT_ACC)).sendKeys(ledgerControlList.get(4));//Account A020_CLOS_OUT_ACC
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A020_CLOS_OUT_CST)).clear();
		getDriver().findElement(By.xpath(pObject.A020_CLOS_OUT_CST)).sendKeys(ledgerControlList.get(5));//Cost A020_CLOS_OUT_CST
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A020_JRN_SUSP_ACC)).clear();
		getDriver().findElement(By.xpath(pObject.A020_JRN_SUSP_ACC)).sendKeys(ledgerControlList.get(6));//Account A020_JRN_SUSP_ACC 
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A020_JRN_SUSP_CST)).clear();
		getDriver().findElement(By.xpath(pObject.A020_JRN_SUSP_CST)).sendKeys(ledgerControlList.get(7));//Cost A020_JRN_SUSP_CST

		
	}
	
	/**
	 * 
	 * @param command
	 * @param i = OK button id eg: 0_4_label and here i==4
	 * @param j
	 */
	public void enterCommandParameters(List<String> command,int i,int j){
		log.info("Entering command parameters");
		WaitHelper.waitAdditional(3);
		Actions builder = new Actions(driver);
		if(j==01){
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div/table/tbody/tr/td[2]"))).click().sendKeys(command.get(0)).build().perform();
		}
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+i+pObject.LABEL)).click();	
		getDriver().findElement(By.id(pObject.ZERO_+i+pObject.LABEL)).click();
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Click on financial module
	 */
	private void clickOnFinancialModule(){
		log.info("Click On Financial Tab");
		getDriver().findElement(By.xpath(pObject.A001_FINANCIAL_MODULE_TAB)).click();
		WaitHelper.waitAdditional(2);

	}
	
	/**
	 * Click on purchasing module
	 */
	private void clickOnPurchasingModule(){
		log.info("Click On purchasing Tab");
		getDriver().findElement(By.xpath(pObject.A001_PURCHASING_MODULE_TAB)).click();


		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Verify financial module
	 * @return
	 */
	private boolean verifyFinancialModule(){
		log.info("Verifying Financial module");
		WaitHelper.waitAdditional(2);
		boolean value = false;

		boolean generalLedger = getDriver().findElement(By.xpath(pObject.A001_GENERAL_LEDGER)).isSelected();
		boolean projectTracking = getDriver().findElement(By.xpath(pObject.A001_PROJECT_TRACKING)).isSelected();
		boolean intraCompanyAccounting = getDriver().findElement(By.xpath(pObject.A001_INTRA_COMPANY_ACCOUNTING)).isSelected();
		boolean averageDaysBalance = getDriver().findElement(By.xpath(pObject.A001_AVERAGE_DAY_BALANCE)).isSelected();
		boolean valueDatedAccounting = getDriver().findElement(By.xpath(pObject.A001_VALUE_DATED_ACCOUNTING)).isSelected();
		
		if(generalLedger==true && projectTracking==true)
		{
			value = true;
		}
		if(intraCompanyAccounting==true && averageDaysBalance==true && valueDatedAccounting==true){
			value = true;
		}
		
		return value;
	}
	
	/**
	 * Verify purchasing module
	 * @return
	 */
	private boolean verifyPurchasingModule(){
		log.info("Verifying purchasing module");
		WaitHelper.waitAdditional(2);
		boolean value = false;

		boolean accountsPayable = getDriver().findElement(By.xpath(pObject.A001_ACCOUNTS_PAYABLE)).isSelected();
		boolean cISEDI = getDriver().findElement(By.xpath(pObject.A001_cISEDI)).isSelected();
		boolean purchasingManagement = getDriver().findElement(By.xpath(pObject.A001_PURCHASING_MANAGEMENT)).isSelected();
		boolean inventoryManagement = getDriver().findElement(By.xpath(pObject.A001_INVENTORY_MANAGEMENT)).isSelected();
		

		if(accountsPayable==true && cISEDI==true)
		{
			value = true;
		}
		if(purchasingManagement==true && inventoryManagement==true)
		{
			value = true;
		}
		return value;
	}
	
	/**
	 * Verify finance module
	 * @return
	 */
	public boolean verifyFinancialModules(){
		log.info("Verify Financial module");
		boolean value = false;
		clickOnFinancialModule();
		if(verifyFinancialModule() == true){
			value = true;
		}
		return value;
	}
	
	/**
	 * Verify purchasing module
	 * @return
	 */
	public boolean verifyPurchasingModules(){
		log.info("Verify purchasing module");
		boolean value = false;
		clickOnPurchasingModule();
		if(verifyPurchasingModule() == true){
			value = true;
		}
		return value;
	}
	
	
	
	
	
	
	/**
	 * Enter structure build details A035
	 * @param structureList
	 */
	
	public void enterStructureReBuildDetails(List<String> structureList,String companyName){
		log.info("Enter structure rebuild details");
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_REQ)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_REQ)).sendKeys(structureList.get(1));//Request
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_CMPY)).sendKeys(companyName);//Company
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_CMPY)).sendKeys(Keys.ENTER);//Press Enter to view years
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A035_YEAR1)).click();//Select years 2017
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_YEAR2)).click();//Select years 2016
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_YEAR3)).click();//Select years 2015
		WaitHelper.waitAdditional(1);
		
		if(BaseTest.browser.contains("internetexplorer"))
        {
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).click();//Add structure
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).click();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).click();
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(structureList.get(2));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(Keys.ENTER);
			
			WaitHelper.waitAdditional(1);
			
			ClickOnSubmitFooter();//Submit button
			WaitHelper.waitAdditional(1);
			
        }
		else{
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).click();//Add structure
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]")).click();
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(structureList.get(2));
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[2]/input")).sendKeys(Keys.ENTER);
			
			WaitHelper.waitAdditional(1);
			
			ClickOnSubmitFooter();//Submit button
			WaitHelper.waitAdditional(1);	
			
		}
		
	}
	
	
	public void ClickOnSubmitFooter(){
		log.info("Click on Submit Button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for(WebElement wb : wbs){
			if(wb.getText().equals("Submit")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	
	
	public void doubleClick(WebElement structure) {
		WebElement structure1 = driver.findElement(By.xpath("//div[1]/table/tbody/tr/td[2]"));
		
		try {
			Actions action = new Actions(driver).doubleClick(structure1);
			action.build().perform();

		} catch(NoSuchElementException e) {
			
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Verify presence of About to Submit pop up
	 * @return
	 */
	private boolean isAboutSubmitPopUpDisplayed(){
		WaitHelper.waitAdditional(2);
		return getDriver().findElement(By.xpath(pObject.A035_CONFM_SUBMIT)).isDisplayed();
		
	}
	
	/**
	 * 
	 * @param Submit details
	 */
	public void enterAboutsubmitDetails(){
		WaitHelper.waitAdditional(4);
		if(!isAboutSubmitPopUpDisplayed()){
			WaitHelper.waitAdditional(3);
		}
		getDriver().findElement(By.xpath(pObject.A035_HOLD)).click();//Hold
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A035_CONFM_SUBMIT)).click();//Submit
		
		WaitHelper.waitAdditional(5);
	}
	
	public void submitDetails(int i){
		WaitHelper.waitAdditional(4);
		if(!isAboutSubmitPopUpDisplayed()){
			WaitHelper.waitAdditional(3);
		}
		if(i==1){
			getDriver().findElement(By.xpath(pObject.A035_HOLD)).click();//Hold
		}
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A035_CONFM_SUBMIT)).click();//Submit
		
		WaitHelper.waitAdditional(5);
	}
	
	/**
	 * Enter security group structure details
	 * @param securityList
	 */
	public void enterSecurityGroupStructureDetails(List<String> securityList){
		log.info("Enter security structure details");
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).sendKeys(securityList.get(1));
		getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE)).sendKeys(securityList.get(2));
	}
	
	/**
	 * Enter action commands
	 * @param parameters
	 */
	public void enterCommands(String parameters){
		log.info("Enter commands");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.LABEL)).sendKeys(parameters);//Enter currency code
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.LABEL)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(5);
	}
	
	/**
	 * Verify security group has access to e5h5 application
	 * @param parameters
	 * @return
	 */
	public void enterUserDetails(List<String> parameters){
		log.info("Enter user details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys(parameters.get(3));//security element
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).sendKeys(parameters.get(3));//security element
		WaitHelper.waitAdditional(2);		
	}
	
	public boolean getUserDetails(List<String> parameters){
		log.info("Get user details method");
		WaitHelper.waitAdditional(2);
		boolean userDetails = false;
		String securityGroup=" ";
		String reportSecurity=" ";

		securityGroup = getDriver().findElement(By.id("0_4")).getText();
		
		reportSecurity= getDriver().findElement(By.id("0_6")).getText();
		
		if(securityGroup.equals(parameters.get(4)) && reportSecurity.equals(parameters.get(4)))
		{
			userDetails = true;
		}
		WaitHelper.waitAdditional(2);
		return userDetails;
		
	}
	
	/**
	 * Create Batch type
	 */
	public boolean enterBatchTypeDetails(List<String> batachTypeList)
	
	{
		log.info("Inside batch type details method");
		boolean update = false;
		
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A021_BATCH_TYPE)).clear(); //Batch type A021_BATCH_TYPE
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A021_BATCH_TYPE)).sendKeys(batachTypeList.get(0));//Batch type A021_BATCH_TYPE
		getDriver().findElement(By.xpath(pObject.A021_BATCH_TYPE)).sendKeys(Keys.ENTER);//Batch type A021_BATCH_TYPE
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message))
		
		{
			
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();//A004A_DESCR 
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(batachTypeList.get(1));//Description A004A_DESCR
			
			getDriver().findElement(By.xpath(pObject.A021_LEDR_CTRL_CD)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A021_LEDR_CTRL_CD)).sendKeys(batachTypeList.get(2));//Ledger Control Code: A021_LEDR_CTRL_CD
			
			getDriver().findElement(By.xpath(pObject.A021_UPDT_IND)).sendKeys(batachTypeList.get(3));//Update Indicator A021_UPDT_IND
			
			getDriver().findElement(By.xpath(pObject.A021_BS_VALUE)).click();//Base A021_BS_VALUE
			WaitHelper.waitAdditional(1);
			
			
			if(batachTypeList.get(4).equals("1"))
			{
				getDriver().findElement(By.xpath(pObject.A021_FRN_VALUE)).click();//Foreign A021_FRN_VALUE
				WaitHelper.waitAdditional(1);
				
			}
			if(batachTypeList.get(5).equals("1")){
				
				getDriver().findElement(By.xpath(pObject.A021_BSN_FRN)).click();//Base and Foreign A021_BSN_FRN
				WaitHelper.waitAdditional(1);
			}
			update = true;
		}
		return update;
	}
		
	
	
	/**
	 * Enter ledger batch details
	 * @param batchList
	 * @return
	 */
	
	public boolean enterLedgerBatchTypeDetails(List<String> batchList) 
	{
		log.info("Inside ledger batch type details method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A021_BATCH_TYPE)).clear(); //A021_BATCH_TYPE
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A021_BATCH_TYPE)).sendKeys(batchList.get(0));//Batch type A021_BATCH_TYPE
		getDriver().findElement(By.xpath(pObject.A021_BATCH_TYPE)).sendKeys(Keys.ENTER);//Batch type A021_BATCH_TYPE
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();//A004A_DESCR
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(batchList.get(1));//Batch description A004A_DESCR
			
			getDriver().findElement(By.xpath(pObject.A021_LEDR_CTRL_CD)).clear();//A021_LEDR_CTRL_CD
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A021_LEDR_CTRL_CD)).sendKeys(batchList.get(2));//Ledger code A021_LEDR_CTRL_CD
			
			if(!batchList.get(3).equals("NILL")){
				getDriver().findElement(By.xpath(pObject.A021_UPDT_IND)).sendKeys(batchList.get(3));//Update indicator A021_UPDT_IND
			}
			if(batchList.get(4).equals("1"))
			{
				if(!getDriver().findElement(By.xpath(pObject.A024_SECDRY_IND)).isSelected())
				{
					getDriver().findElement(By.xpath(pObject.A024_SECDRY_IND)).click();//Secondary index A024_SECDRY_IND
				}
			}
			if(batchList.get(5).equals("1")){
				if(!getDriver().findElement(By.xpath(pObject.A021_BS_VALUE)).isSelected())
				{
					getDriver().findElement(By.xpath(pObject.A021_BS_VALUE)).click();//Base values A021_BS_VALUE
				}
			}
			if(batchList.get(6).equals("1")){
				if(!getDriver().findElement(By.xpath(pObject.A021_FRN_VALUE)).isSelected()){
					getDriver().findElement(By.xpath(pObject.A021_FRN_VALUE)).click();//Foreign Values A021_FRN_VALUE
				}
			}
			if(batchList.get(7).equals("1")){
				if(!getDriver().findElement(By.xpath(pObject.A021_BSN_FRN)).isSelected()){
					getDriver().findElement(By.xpath(pObject.A021_BSN_FRN)).click();//Base and Foreign values A021_BSN_FRN
				}
			}
			WaitHelper.waitAdditional(2);
			if(!batchList.get(8).equals("NILL")){
				getDriver().findElement(By.xpath(pObject.A024_ACCRL)).sendKeys(batchList.get(8));//Accruals A024_ACCRL
			}
			WaitHelper.waitAdditional(2);
			if(!batchList.get(9).equals("NILL")){
				getDriver().findElement(By.xpath(pObject.A024_RCCRL)).sendKeys(batchList.get(9));//Recurrals A024_RCCRL
			}
			WaitHelper.waitAdditional(1);
			update = true;
		}
		return update;
	}
	

	
	/**
	 * Enter default structure element details
	 * @param elementList
	 * @return
	 */
	
	public boolean enterElementDetails(List<String> elementList)
	
	{
		log.info("Inside default structure elements method");
		boolean update = false;
		
		if(elementList.get(1).equals("SUSP")){
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(elementList.get(2));//Description A004A_DESCR
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A029_NEW_PARENT)).clear();
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A029_NEW_PARENT)).sendKeys(elementList.get(3));//New Parent A029_NEW_PARENT
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A029_CHK_NOM_BAL)).click();//Nominal balance A029_CHK_NOM_BAL
			WaitHelper.waitAdditional(2);
			update = true;
		}
		
		else{
			getDriver().findElement(By.xpath(pObject.A027_STRUC)).clear();//A027_STRUC
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A027_STRUC)).sendKeys(elementList.get(0));//Structure A027_STRUC
			WaitHelper.waitAdditional(1);
			
			getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).clear(); //A028_ELEMENT
			WaitHelper.waitAdditional(2);		
			getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).sendKeys(elementList.get(1));//Element A029_ELEMENT
			
			getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).sendKeys(Keys.ENTER);//Element A029_ELEMENT
			WaitHelper.waitAdditional(2);
				
			if(!getToolContentText().contains(message)){
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear(); //Description A004A_DESCR
				WaitHelper.waitAdditional(2);
				getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(elementList.get(2));//Description A004A_DESCR
				WaitHelper.waitAdditional(1);
				
				getDriver().findElement(By.xpath(pObject.A029_NEW_PARENT)).clear();//A028_NEW_PARENT
				WaitHelper.waitAdditional(2);
				getDriver().findElement(By.xpath(pObject.A029_NEW_PARENT)).sendKeys(elementList.get(3));//New Parent A028_NEW_PARENT
				WaitHelper.waitAdditional(1);
				
				getDriver().findElement(By.xpath(pObject.A029_CHK_NOM_BAL)).click();//Nominal balance A028_CHK_NOM_BAL
				WaitHelper.waitAdditional(2);
				update = true;
			}
		}
		return update;
	}
	
	

	
	/**
	 * Click on path key
	 * @param i
	 */
	public void clickOnPathKey(){
		log.info("Click on path key");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for(WebElement wb : wbs){
			if(wb.getText().equals("Path")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	/**
	 * Search path key
	 * @param pathList
	 * @param i
	 */
	public void searchPathKey(List<String> pathList,int i){
		log.info("Search path key details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(pathList.get(0));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(pathList.get(1));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(pathList.get(2));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject._ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject._ZERO)).sendKeys(pathList.get(3));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+i+pObject.LABEL));
		WaitHelper.waitAdditional(2);		
	}
	
	
	
	public void createPathKey(List<String> pathList){
		log.info("Enter path key details");
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A029_PATH_KEY_IN)).clear();//A029_PATH_KEY_IN
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A029_PATH_KEY_IN)).sendKeys(pathList.get(2));///Path key A029_PATH_KEY_IN
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear(); //A004A_DESCR
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(pathList.get(3));//Description A004A_DESCR
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A029_NEW_PARENT_IN)).clear();//A029_NEW_PARENT_IN
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A029_NEW_PARENT_IN)).sendKeys(pathList.get(4));//New Parent A029_NEW_PARENT_IN
		WaitHelper.waitAdditional(2);
	}
	

	
	/**
	 * Click on Return button
	 * @param i
	 */
	public void clickOnReturnButton(int i){
		log.info("Click on return button");
		getDriver().findElement(By.id(pObject.ZERO_+i+pObject.LABEL)).click();
		WaitHelper.waitAdditional(5);
	}	
	
	/**
	 * Click on Return button
	 */
	public void clickOnReturnButton(){
		WaitHelper.waitAdditional(2);
		log.info("Clicking on Return button");
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.HEADER_TAB_BTN));
		for(WebElement wb : wbs){
			if(wb.getText().equals("Return")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(4);
	}

	/**
	 * Verify company control check list
	 * @param companyControl
	 * @return
	 */
	public boolean verifyCompanyControl(List<String> companyControl){
		log.info("Verify company control details");
		boolean control = false;
		boolean accLayout = false;
		boolean bSPLLayout = false;
		boolean icaStructure = false;
		boolean transfer = false;
		boolean reversal = false;
		WaitHelper.waitAdditional(3);
		
		if(!isPrimaryDetailsTabSelected()){
			ClickOnAnyTab("Primary Details", 1);
		}

		String acc = getDriver().findElement(By.xpath(pObject.A031_ACC_LAY1)).getText();//A031_ACC_LAY1
		String bspl = getDriver().findElement(By.xpath(pObject.A031_BSPL_LAY1)).getText(); //A031_BSPL_LAY1
		String structure = getDriver().findElement(By.xpath(pObject.A031_IC_STRUCT)).getText();//A031_IC_STRUCT
		
		if(acc.equals(companyControl.get(6))){
			accLayout = true;
		}
		if(bspl.equals(companyControl.get(7))){
			bSPLLayout = true;
		}
		if(structure.equals(companyControl.get(8))){
			icaStructure = true;
		}
		
		ClickOnAnyTab("Batch Types", 1);
		
	

		WaitHelper.waitAdditional(3);

		String TRANS = getDriver().findElement(By.xpath(pObject.A031_TRANS1)).getText(); //A031_TRANS1
		String REVRSL = getDriver().findElement(By.xpath(pObject.A031_REVRS1)).getText();//A031_REVRS1
		
				
		if(TRANS.equals(companyControl.get(9))){
			transfer = true;
		}
		if(REVRSL.equals(companyControl.get(10))){
			reversal = true;
		}
		
		if(accLayout == true && bSPLLayout == true && icaStructure == true && transfer==true && reversal==true){
			control = true;
		}
		
		WaitHelper.waitAdditional(3);
		return control;	
	}
	

	/*
	 * Enter user details
	 * @param companyID
	 */
	
	public void amendUsersDetails(String companyID)
	
	{
		log.info("Inside Amending/User Edit Page");
		WaitHelper.waitAdditional(1);
		WaitHelper.waitUntilWebElementDisplayed(getDriver(), getDriver().findElement(By.xpath(pObject.A006_PRIMARY_TAB)));
	
		if(!isPrimaryDetailsTabSelected())
			
		
		{

		ClickOnAnyTab("Primary Details", 1);
			
		}
		
		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_DEFAULT_CMPNY)).clear();//Default company
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_DEFAULT_CMPNY)).sendKeys(companyID);
		WaitHelper.waitAdditional(1);
	}
	
	
	/*
	 * Enter user details
	 * @param userDetails
	 */
	public void enterUsersDetails(String companyName,List<String> userDetails){
		log.info("Inside Insert user detail page");
		WaitHelper.waitUntilWebElementDisplayed(getDriver(), getDriver().findElement(By.xpath(pObject.A006_PRIMARY_TAB)));
//		if(!isPrimaryDetailsTabDisplayed())
		
		if(!isPrimaryDetailsTabSelected())
		{
			ClickOnAnyTab("Primary Details", 1);
		}
		
		getDriver().findElement(By.xpath(pObject.LOGIN_USER_NAME)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.LOGIN_USER_NAME)).sendKeys(userDetails.get(0));//User
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A002_DESCRIPTION)).sendKeys(userDetails.get(1));//Description
		
		getDriver().findElement(By.xpath(pObject.A011_MENU)).clear();//Menu
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_MENU)).sendKeys(userDetails.get(2));
		
		getDriver().findElement(By.xpath(pObject.A011_DEFAULT_CMPNY)).clear();//Default company
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_DEFAULT_CMPNY)).sendKeys(companyName);
		
		getDriver().findElement(By.xpath(pObject.LOGIN_PASSWORD)).clear();//Password
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.LOGIN_PASSWORD)).sendKeys(userDetails.get(3));
		
		
		getDriver().findElement(By.xpath(pObject.A011_NON_CMPNY)).clear();//Non-Company
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_NON_CMPNY)).sendKeys(userDetails.get(4));
		
		getDriver().findElement(By.xpath(pObject.A011_CMPNY)).clear();//Company
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_CMPNY)).sendKeys(userDetails.get(5));
		
		getDriver().findElement(By.xpath(pObject.A011_REPORT)).clear();//Report
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_REPORT)).sendKeys(userDetails.get(6));
		
		getDriver().findElement(By.xpath(pObject.A011_REPORT_CMPNY)).clear();//Report Company
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_REPORT_CMPNY)).sendKeys(userDetails.get(7));
		
		WaitHelper.waitAdditional(1);
		ClickOnAnyTab("Job/ Location Details", 1);
		
		WaitHelper.waitAdditional(2);
		
		
		getDriver().findElement(By.xpath(pObject.A010_ENV_GRP)).clear();//Environment Group
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A010_ENV_GRP)).sendKeys(userDetails.get(8));
		
		getDriver().findElement(By.xpath(pObject.A011_EWS_PRTN)).clear();//EWS Partition
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_EWS_PRTN)).sendKeys(userDetails.get(9));
		
		getDriver().findElement(By.xpath(pObject.A011_LANG)).clear();//Language
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A011_LANG)).sendKeys(userDetails.get(10));
		WaitHelper.waitAdditional(1);
	}
	
	/**
	 * Enter balance class details - A022
	 * @param balanceList
	 */
	
	public boolean enterBalanceClass(List<String> balanceList){
		log.info("Inside balance class method");
		boolean update = false;
		WaitHelper.waitAdditional(3);
		
				
		if(!isPrimaryDetailsTabSelected())
		{
			clickOnPrimaryDetailsTab();
		}
		
		String[] element  = balanceList.get(0).split(",");
		
		getDriver().findElement(By.xpath(pObject.A022_BAL_CLS)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A022_BAL_CLS)).sendKeys(element[0]);//Balance class A022_BAL_CLS
		getDriver().findElement(By.xpath(pObject.A022_BAL_CLS)).sendKeys(element[1]);//Balance class A022_BAL_CLS
		
		getDriver().findElement(By.xpath(pObject.A022_BAL_CLS)).sendKeys(Keys.ENTER);//Balance class A022_BAL_CLS
		WaitHelper.waitAdditional(2);
		if(!getToolContentText().contains(message))
		{
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(balanceList.get(1));//Description A004A_DESCR
			
			if(balanceList.get(2).equals("1")){
				getDriver().findElement(By.xpath(pObject.A022_STASTICAL)).click();//Statistical A022_STASTICAL
			}
			if(balanceList.get(3).equals("1")){
				getDriver().findElement(By.xpath(pObject.A022_TRANSATION)).click();//Transaction A022_TRANSATION
			}
			
			if(getDriver().findElement(By.xpath(pObject.A022_ROLL_FLAG)).isSelected())
			
			{
				getDriver().findElement(By.xpath(pObject.A022_ROLL_FLAG)).click();//Roll Flag A022_ROLL_FLAG
			}
			
			getDriver().findElement(By.xpath(pObject.A022_CALN_TYPE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A022_CALN_TYPE)).sendKeys(balanceList.get(5));//Calendar Type A022_CALN_TYPE
			
			getDriver().findElement(By.xpath(pObject.A022_PATH)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A022_PATH)).sendKeys(balanceList.get(6));//Path Code A022_PATH
			
			WaitHelper.waitAdditional(3);
			
			
			if(!isSecondaryDetailsTabSelected())
			{
				clickOnSecondaryDetailsTab();
			}
			
			WaitHelper.waitAdditional(1);
			if(balanceList.get(7).equals("1")){
				getDriver().findElement(By.xpath(pObject.A022_FRN_CURR)).click();// Foreign Currency A022_FRN_CURR
			}
			WaitHelper.waitAdditional(1);
			if(balanceList.get(8).equals("1"))
			{
				getDriver().findElement(By.xpath(pObject.A022_VAT)).click();//VAT//chk_0_11 A022_VAT
			}
			WaitHelper.waitAdditional(1);
			if(balanceList.get(9).equals("1"))
			{
				getDriver().findElement(By.xpath(pObject.A022_ALW_BTCH_BAL)).click();//Allow Batches Out Of Balance A022_ALW_BTCH_BAL
			}
			WaitHelper.waitAdditional(2);
			
			
			if(!balanceList.get(10).equals("Not Active"))
			{
			
			getDriver().findElement(By.xpath(pObject.A022_AVG_DLY_BAL)).sendKeys(balanceList.get(10));//Average Daily Balances A022_AVG_DLY_BAL
			}
			
			WaitHelper.waitAdditional(2);
			update = true;
		}
		return update;
	}	
	
	
	/**
	 *Enter company controls - A023 
	 * @param companyControl
	 */
	public void enterCompanyControlDetails(String companyName,List<String> companyControl)
	
	{
		log.info("Enter company control details");
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).sendKeys(companyName);//Company A006_COMPANY
		
		getDriver().findElement(By.xpath(pObject.A023_CURNT_PER)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A023_CURNT_PER)).sendKeys(companyControl.get(0));//Period A023_CURNT_PER
		
		getDriver().findElement(By.xpath(pObject.A023_CURNT_YR)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A023_CURNT_YR)).sendKeys(companyControl.get(1));//Year A023_CURNT_YR
		
		getDriver().findElement(By.xpath(pObject.A023_CNTL_AC_CD)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A023_CNTL_AC_CD)).sendKeys(companyControl.get(2));//Control account code A023_CNTL_AC_CD
		
		getDriver().findElement(By.xpath(pObject.A023_CALDR)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A023_CALDR)).sendKeys(companyControl.get(3));//Calender A023_CALDR
		
		getDriver().findElement(By.xpath(pObject.A023_YR_RNGE_FUTR)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A023_YR_RNGE_FUTR)).sendKeys(companyControl.get(4));//Future A023_YR_RNGE_FUTR
		
		getDriver().findElement(By.xpath(pObject.A023_YR_RNGE_HIST)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A023_YR_RNGE_HIST)).sendKeys(companyControl.get(5));//History A023_YR_RNGE_HIST
		
		ClickOnAnyTab("Batch Types", 1);
		

		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A023_SUMMAR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_SUMMAR)).sendKeys(companyControl.get(6));//Summ A023_SUMMAR
		WaitHelper.waitAdditional(1);
		
		
		ClickOnAnyTab("Account Controls", 1);
		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_TRANSAC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_TRANSAC)).sendKeys(companyControl.get(7)); //Transac A023_TRANSAC
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A023_STSCL_BAL)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_STSCL_BAL)).sendKeys(companyControl.get(8));//Stat balance Class A023_STSCL_BAL
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A023_CHK_FINC)).click();//Financial A023_CHK_FINC
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_CST_ALOC)).click();//Cost allocation A023_CHK_CST_ALOC
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_AVG_BAL)).click();//Average balances A023_CHK_AVG_BAL
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A023_CHK_PLANG)).click();//Planning A023_CHK_PLANG
		WaitHelper.waitAdditional(1);

		
		ClickOnAnyTab("Data Entry Controls",1);
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A023_SUSPN_ACC)).sendKeys(companyControl.get(9));//Suspense account A023_SUSPN_ACC
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A023_CHK_TOTL_ON_QTY)).click();//Totaling on quantity A023_CHK_TOTL_ON_QTY
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_GNE_BATCH_BAL_RCRD)).click();//Generate batch balancing records A023_CHK_GNE_BATCH_BAL_RCRD
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_CLS_ACC_LST_YR)).click();//Close account for last year A023_CHK_CLS_ACC_LST_YR
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_REV_WRIT_FLG)).click();//Revolution write off flag A023_CHK_REV_WRIT_FLG
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_DTA_ENTRY_IMD_UPD)).click();//Data entry immidiate update  A023_CHK_DTA_ENTRY_IMD_UPD
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_REC_MSG)).click();//Reconcilation message A023_CHK_REC_MSG
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_DEL_CHK)).click();//Delete check A023_CHK_DEL_CHK
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_ACCEPT_WAR_OFF)).click();//Accept warnings off line A023_CHK_ACCEPT_WAR_OFF
		WaitHelper.waitAdditional(1);
		
		
		
		ClickOnAnyTab("Currency Controls/PEV",1);
		

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A023_CURR_R_TYPE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CURR_R_TYPE)).sendKeys(companyControl.get(11));//Currency rate type A023_CURR_R_TYPE
		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_RNDG_TOLRN_AMT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_RNDG_TOLRN_AMT)).sendKeys(companyControl.get(12));//Rounding currency A023_RNDG_TOLRN_AMT
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A023_RNDG_TOLRN_PERC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_RNDG_TOLRN_PERC)).sendKeys(companyControl.get(13));//Rounding tolerance % A023_RNDG_TOLRN_PERC
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A023_CHK_CURR_REV_ALLW)).click();//Currency revaluation allowed A023_CHK_CURR_REV_ALLW
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A023_CURR_TOL_PROC)).sendKeys(companyControl.get(14));//Currency tolerence processing A023_CURR_TOL_PROC
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A023_BTCH_TYPE)).sendKeys(companyControl.get(15));//Batch type A023_BTCH_TYPE
		WaitHelper.waitAdditional(1);
		
		
		ClickOnAnyTab("Reconciliation/Archive",1);
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A023_CHK_ACCT_PAYBL)).click();//Archive A023_CHK_ACCT_PAYBL
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_ACCT_RECIBL)).click();//Archive A023_CHK_ACCT_RECIBL
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_PURC_MNGT)).click(); //A023_CHK_PURC_MNGT
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_INV_MNGT)).click();//A023_CHK_INV_MNGT
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_FIX_ASST)).click();//A023_CHK_FIX_ASST
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A023_CHK_FIX_ASST_LEA)).click();//A023_CHK_FIX_ASST_LEA
		
		getDriver().findElement(By.xpath(pObject.A023_CHK_ARC_TRAN_INDI)).click();//A023_CHK_ARC_TRAN_INDI
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A023_CHK_ARC_UNREC_TRANS)).click();//A023_CHK_ARC_UNREC_TRANS
		WaitHelper.waitAdditional(1);
		
	}
	
	
	
	
	/**
	 * Update company controls A031
	 * @param companyControl
	 */
	public void updateCompanyControlDetails(List<String> companyControl){
		log.info("Update company controls");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A031_ACC_LAY)).clear();//A031_ACC_LAY
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A031_ACC_LAY)).sendKeys(companyControl.get(0));//Account Layout A031_ACC_LAY
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A031_BSPL_LAY)).clear();//A031_BSPL_LAY
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A031_BSPL_LAY)).sendKeys(companyControl.get(1));//BPSL Layout A031_BSPL_LAY
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A031_STRUCT)).clear();//A031_STRUCT
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A031_STRUCT)).sendKeys(companyControl.get(2));//Structure A031_STRUCT
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A031_CODE_ID)).clear();//A031_CODE_xpath
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A031_CODE_ID)).sendKeys(companyControl.get(3));//Code id A031_CODE_ID
		WaitHelper.waitAdditional(1);
		
		ClickOnAnyTab("Batch Types", 1);
		
		
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A031_TRANS)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A031_TRANS)).sendKeys(companyControl.get(4));//Transfer A031_TRANS
		
		getDriver().findElement(By.xpath(pObject.A031_REVRS)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A031_REVRS)).sendKeys(companyControl.get(5));//Reversal A031_REVRS
		WaitHelper.waitAdditional(2);
		clickOnUpdate();
		WaitHelper.waitAdditional(2);
	}	
	
	

	/**
	 * Enter BTZ ICA elements details - A036
	 * @param elements
	 */
	
	public boolean enterICAElements(List<String> elements){
		log.info("Inside ICA elements method");
		boolean update = false;
		getDriver().findElement(By.xpath(pObject.A036_EELE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A036_EELE)).sendKeys(elements.get(0));//Element
		getDriver().findElement(By.xpath(pObject.A036_EELE)).sendKeys(Keys.ENTER);//Element
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			WaitHelper.waitAdditional(1);		
			getDriver().findElement(By.xpath(pObject.A036_ICA_MNGT_CODE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A036_ICA_MNGT_CODE)).sendKeys(elements.get(1));//ICA management code
			getDriver().findElement(By.xpath(pObject.A036_GEN_LEDGR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath(pObject.A036_GEN_LEDGR)).sendKeys(elements.get(2));//General ledger
			WaitHelper.waitAdditional(1);
			update = true;
		}
		return update;
	}
	

	/**
	 * Enter ICA relationship details - A037
	 * @param elments
	 */
	public void enterICARelationShip(List<String> elments){
		log.info("Enter ICA relationship");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A037_FRM_BTZ)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A037_FRM_BTZ)).sendKeys(elments.get(0));//From BTZ entity
		
		getDriver().findElement(By.xpath(pObject.A037_TO_BTZ)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A037_TO_BTZ)).sendKeys(elments.get(1));//To BTZ entity
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A037_GEN_ACC)).clear();
		getDriver().findElement(By.xpath(pObject.A037_GEN_ACC)).sendKeys(elments.get(2));//General Ledger Account
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A037_GEN_COST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A037_GEN_COST)).sendKeys(elments.get(3));//Cost
		WaitHelper.waitAdditional(1);
		
	}
	
	/**
	 * Enter Process EP2 details A038
	 * @param processDetails
	 */
	public void enterEP2ProcessDetails(List<String> processDetails,String companyName){
		log.info("Enter EP2 process details");
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A035_REQ)).clear();//Request
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_REQ)).sendKeys(processDetails.get(1));//Request
		
		getDriver().findElement(By.xpath(pObject.A035_CMPY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_CMPY)).sendKeys(companyName);//Company ID
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A035_CMPY)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(3);
		
		getDriver().findElement(By.xpath(pObject.A038_CHK_UPDT_All)).click();//Update all
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A038_CHK_NET_BAL)).click();//Net balances
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A038_CHK_NET_BAL)).sendKeys(Keys.TAB);
		getDriver().findElement(By.xpath(pObject.A038_CHK_NET_BAL)).sendKeys(Keys.ENTER);
		
		WaitHelper.waitAdditional(3);
		ClickOnSubmitFooter();//Submit button
				
		WaitHelper.waitAdditional(5);
		
			
	}
	
	/**
	 * Enter Process EP4 details - A041
	 * @param processDetails
	 */
	
	public void enterEP4ProcessDetails(List<String> processDetails,String companyName){
		
		getDriver().findElement(By.xpath(pObject.A035_REQ)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_REQ)).sendKeys(processDetails.get(3));//Request
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_CMPY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_CMPY)).sendKeys(companyName);//Company ID
		WaitHelper.waitAdditional(1);
		
		ClickOnSubmitFooter();	
		
	}

	
	/**
	 * Click on submit button
	 */
	public void clickOnSubmit(){
		log.info("Clicking on Submit button");
		WaitHelper.waitAdditional(2);		
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.HEADER_TAB_BTN));
		for(WebElement wb : wbs){
			if(wb.getText().equals("Submit")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	/**
	 * Enter Process EP5 details - A041
	 * @param processDetails
	 */
	public void enterEP5ProcessDetails(List<String> processDetails,String companyName){
		log.info("Enter EP5 process details");
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A035_REQ)).clear();//Request
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_REQ)).sendKeys(processDetails.get(3));//Request
		
		getDriver().findElement(By.xpath(pObject.A035_CMPY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A035_CMPY)).sendKeys(companyName);//Company ID
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A035_CMPY)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(3);
		
		getDriver().findElement(By.xpath(pObject.A038_CHK_UPDT_All)).click();//Update all
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.xpath(pObject.A038_CHK_INCLD)).click();//Include
		WaitHelper.waitAdditional(2);
		
		ClickOnAnyButton("Submit", 1);
		ClickOnAnyButton("Submit", 1);
		WaitHelper.waitAdditional(2);

	}
	
	/**
	 * Enter balance sheet details - A039
	 * @param group
	 */
	public void balanceSheetDetails(List<String> group){
		log.info("Enter balance sheet details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A026_LAYT)).clear();
		getDriver().findElement(By.xpath(pObject.A026_LAYT)).sendKeys(group.get(0));//Enter Layout
		
		getDriver().findElement(By.xpath(pObject.A039_EXT_SEL)).click();
		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A016_GRP)).clear();
		getDriver().findElement(By.xpath(pObject.A016_GRP)).sendKeys(group.get(1));//Enter Group
		WaitHelper.waitAdditional(1);

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A039_EXT_OK)).click();//Ok button
		WaitHelper.waitAdditional(2);
	}

	/**
	 * Verify balance sheet - A039
	 * @param group
	 */
	public void verifyBalanceSheetDetails(List<String> group){
		log.info("Verify balance sheet details");
		 List<WebElement> wbs = driver.findElements(By.xpath("//div[2]/div[2]/div/div/div/div/table/tbody/tr/td[1]"));
		 for(WebElement wb : wbs){
			 wb.getText().contains(group.get(1));
		 }
				
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[1]")).getText();//gets Group
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath("//div[2]/div[2]/div/div/div/div[2]/table/tbody/tr/td[2]")).getText();//gets Cat
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath("//div[2]/div[2]/div/div/div/div[2]/table/tbody/tr/td[3]")).getText();//gets Description
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath("//div[2]/div[2]/div/div/div/div[2]/table/tbody/tr/td[4]")).getText();//gets CP actl Balance
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath("//div[2]/div[2]/div/div/div/div[2]/table/tbody/tr/td[5]")).getText();//gets YTD actl Balance
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Enter fiscal calendar details
	 * @param calender
	 * @param year1
	 * @param year2
	 * @param year3
	 * @param year4
	 * @param year5
	 */
	public void enterFiscalCalendarDetails(List<String> calender,List<String> year1,List<String> year2,List<String> year3,List<String> year4,List<String> year5,List<String> year6,List<String> year7,List<String> year8
			,List<String> year9,List<String> year10,List<String> year11,List<String> year12,List<String> year13,List<String> year14,List<String> year15,List<String> year16,List<String> year17,List<String> year18,List<String> year19
			,List<String> year20, List<String> year21, List<String> year22, List<String> year23, List<String> year24){
		log.info("Enter fiscal calender details");
		
				WaitHelper.waitAdditional(3);
		getDriver().findElement(By.xpath(pObject.A013_CALENDER)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A013_CALENDER)).sendKeys(calender.get(0));//Calender A013_CALENDER
				
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A004A_DESCR)).sendKeys(calender.get(1));//Description A004A_DESCR
		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A006_COMPANY)).sendKeys(calender.get(2));//Company Code A006_COMPANY
				
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A013_WEEKENDDAY)).sendKeys(calender.get(3));//Weekend Day
	
	    WaitHelper.waitAdditional(2);
	   			
	    getDriver().findElement(By.xpath(pObject.A013_LVL_NAME)).click();//Level Name
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A013_LVL_NAME1)).sendKeys(calender.get(4));//Level Name Input
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A013_LVL_DESC)).click();//Level description
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A013_LVL_DESC1)).sendKeys(calender.get(5));//Level description input
		WaitHelper.waitAdditional(1);

		WebElement years = driver.findElement(By.xpath(pObject.A013_YEARS));
		driver.executeScript("arguments[0].scrollIntoView(true);", years);
		
		ClickOnAnyButton("Years",1);
		ClickOnAnyButton("Years",1);
		
		WaitHelper.waitAdditional(5);
		
		/*Enter fiscal years*/
		enterFiscalYears(year1,1);
		enterFiscalYears(year2,2);
		enterFiscalYears(year3,3);
		enterFiscalYears(year4,4);
		enterFiscalYears(year5,5);

		enterFiscalYears(year6,6);
		enterFiscalYears(year7,7);
		enterFiscalYears(year8,8);
		enterFiscalYears(year9,9);
		enterFiscalYears(year10,10);
		
		enterFiscalYears(year11,11);
		enterFiscalYears(year12,12);
		enterFiscalYears(year13,13);
		enterFiscalYears(year14,14);
		enterFiscalYears(year15,15);
		enterFiscalYears(year16,16);	
		
		
		clickOnFwd();

		WaitHelper.waitAdditional(2);
		
		enterFiscalYears(year17,2);
		enterFiscalYears(year18,3);
		enterFiscalYears(year19,4);
		enterFiscalYears(year20,5);
		enterFiscalYears(year21,6);
		enterFiscalYears(year22,7);
		enterFiscalYears(year23,8);
		enterFiscalYears(year24,9);
		
		WaitHelper.waitAdditional(2);
		
		
		getDriver().findElement(By.xpath("//div[9]/table/tbody/tr/td[5]/input")).sendKeys(Keys.ENTER);//Press Enter to get days

		WaitHelper.waitAdditional(3);
		
		clickOnEventsH();
		
		getCalendarEvents("01 Dec 1999",calender.get(6));
		WaitHelper.waitAdditional(2);

		
		
	}
	
	

	/**
	 * Click on Years H button
	 */
	public void clickOnYearsH(){
		WaitHelper.waitAdditional(2);
		log.info("Clicking on Years button");
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.HEADER_TAB_BTN));
		for(WebElement wb : wbs){
			if(wb.getText().equals("Years (H)")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	/**
	 * Click on Run activity
	 */
	public void clickOnRunActivity(){
		WaitHelper.waitAdditional(2);
		log.info("Clicking on Run activity button");
		List<WebElement> wbs = getDriver().findElements(By.className(pObject.HEADER_TAB_BTN));
		for(WebElement wb : wbs){
			if(wb.getText().equals("Run Activity")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	/**
	 * Click on years
	 */
	public void clickOnYears(){
		WaitHelper.waitAdditional(2);
		log.info("Clicking on Years button");

		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.A013_BTM_BUT_SECTION));
		for(WebElement wb : wbs){
			if(wb.getText().equals("Years")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}
	

	
	/**
	 * Click on Events H
	 */
	public void clickOnEventsH(){
		WaitHelper.waitAdditional(2);
		log.info("Clicking on Years button");
		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.A013_BTM_BUT_SECTION));
		for(WebElement wb : wbs){
			if(wb.getText().equals("Events (H)")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}
	
	/**
	 * Click on Activity
	 */
	public void clickOnActivity(){
		WaitHelper.waitAdditional(2);
		log.info("Clicking on Years button");

		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.A013_BTM_BUT_SECTION));
		for(WebElement wb : wbs){
			if(wb.getText().equals("Activity")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}
	/**
	 * Enter fiscal years in the grid
	 * @param years
	 * @param i
	 */
	private void enterFiscalYears(List<String> years,int i){
		log.info("Enter fiscal years");
		
		WaitHelper.waitAdditional(2);
		
		if(BaseTest.browser.contains("internetexplorer"))
		{
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[2]")).click();//Year 1996
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[2]")).click();//Year 1996
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[2]/input")).sendKeys(years.get(0));//Year 1996 input
			WaitHelper.waitAdditional(1);
			
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[3]")).click();//Name
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[3]")).click();//Name
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[3]/input")).sendKeys(years.get(1));//Name input
			WaitHelper.waitAdditional(1);
			
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[4]")).click();//Start
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[4]")).click();//Start
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[4]/input")).sendKeys(years.get(2));//Start input
			WaitHelper.waitAdditional(1);
			
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]")).click();//End
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]")).click();//End
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]/input")).sendKeys(years.get(3));//End input
			WaitHelper.waitAdditional(1);
			
					
			if(i==16){
				
				getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]/input")).sendKeys(Keys.ENTER);
				WaitHelper.waitAdditional(1);
					}
				}
		else{
			
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[2]")).click();//Year 1996
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[2]/input")).sendKeys(years.get(0));//Year 1996 input
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[3]")).click();//Name
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[3]/input")).sendKeys(years.get(1));//Name input
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[4]")).click();//Start
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[4]/input")).sendKeys(years.get(2));//Start input
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]")).click();//End
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]/input")).sendKeys(years.get(3));//End input
		WaitHelper.waitAdditional(1);
		
				
		if(i==16){
			
			getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[5]/input")).sendKeys(Keys.ENTER);
			WaitHelper.waitAdditional(1);

		}
		}
	}
	
	/**
	 * Get calendar events
	 * @param date
	 * @param calender
	 */
	public void getCalendarEvents(String date,String calender){
		log.info("Get calendar");
		
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A013_START_DATE)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A013_START_DATE)).sendKeys(date);//Enter date
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A013_START_DATE)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(2);
		
		clickOnActivity();

		getDriver().findElement(By.xpath(pObject.A013_ACTIVITY)).sendKeys(calender);
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A013_ACTIVITY)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(1);
		
		
		clickOnActivity();
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Enter Lock in fiscal years in the grid
	 * @param years
	 * @param i =div number
	 */	
	
	
	public void enterLockCalendarDetails(List<String> year1,List<String> year2,List<String> year3,List<String> year4,List<String> year5,List<String> year6,List<String> year7,List<String> year8,List<String> year9,List<String> year10,List<String> year11,List<String> year12,List<String> year13,List<String> year14,List<String> year15,List<String> year16,List<String> year17,List<String> year18,List<String> year19,List<String> year20, List<String> year21, List<String> year22, List<String> year23, List<String> year24){
		log.info("Enter fiscal calender Lock details");
			
				clickOnBKWD();
				WaitHelper.waitAdditional(2);
				lockCalendar(year1,1);
				lockCalendar(year2,2);
				lockCalendar(year3,3);
				lockCalendar(year4,4);
				lockCalendar(year5,5);

				lockCalendar(year6,6);
				lockCalendar(year7,7);
				lockCalendar(year8,8);
				lockCalendar(year9,9);
				lockCalendar(year10,10);
				
				lockCalendar(year11,11);
				lockCalendar(year12,12);
				lockCalendar(year13,13);
				lockCalendar(year14,14);
				lockCalendar(year15,15);
				lockCalendar(year16,16);

				clickOnFwd();	

				WaitHelper.waitAdditional(2);
				
				lockCalendar(year17,2);
				lockCalendar(year18,3);
				lockCalendar(year19,4);
				lockCalendar(year20,5);
				lockCalendar(year21,6);
				lockCalendar(year22,7);
				lockCalendar(year23,8);
				lockCalendar(year24,9);
		}
	
	
	
	/**
	 * Click on lock calendar
	 * Created By Chetna
	 */
			
	private void lockCalendar(List<String> years,int i)
	{
		log.info("In the lockCalendar method");
		
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[7]")).click();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath("//div["+i+"]/table/tbody/tr/td[7]/input")).sendKeys(years.get(4));//Year 1996 input onwards
		WaitHelper.waitAdditional(1);
		
		}

		
	public void searchPeriodAndYearDetails(String element){
		if(!isOkButtonDisplayed(5)){
			clickOnSections(0);
		}
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A042_CMPY)).clear();
		getDriver().findElement(By.xpath(pObject.A042_CMPY)).sendKeys(element);//Company
		WaitHelper.waitAdditional(1);
		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Click on GL period
	 */
	
	public void clickOnCloseGLPeriod(){
		log.info("Click on GL period");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getAllFooterButton();
		for(WebElement wb2 : wbs1){
			if(wb2.getText().equals("Close GL Period")){
						wb2.click();
						break;
			}
		}
		WaitHelper.waitAdditional(5);
	}
	
	
	/**
	 * Click on period of the year
	 * @return
	 */
	public String periodOfTheYear(){
		log.info("Get period of the year");
		String period = null;
		WaitHelper.waitAdditional(2);
		period = driver.findElement(By.xpath("//div[1]/table/tbody/tr/td[5]")).getText();//Period
		return period;
	}
	
	
	
	public int getProcessorCount(){
		log.info("Get process count");
		int dspatcherCnt = 0;
		try {
			dspatcherCnt = dbQuery.getProcessCount();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SeleniumDaoException e) {
			e.printStackTrace();
		}
		log.info("dispatcherCount : " +dspatcherCnt);
		WaitHelper.waitAdditional(2);
		return dspatcherCnt;
	}
	
	public void updateHoldFlag(){
		log.info("Update Hold flag");
		try {
			dbQuery.updateHoldFlag();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SeleniumDaoException e) {
			e.printStackTrace();
		}
		WaitHelper.waitAdditional(2);
		log.info("Preocess is updated.");
	}
	
	public String getProcessDetails(String process,String request){
		log.info("Get process details");
		WaitHelper.waitAdditional(2);
		String stat = null;
		try {
			stat = dbQuery.getStatProcess(process,request);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SeleniumDaoException e) {
			e.printStackTrace();
		}
		log.info("stat value :" +stat);
		WaitHelper.waitAdditional(2);
		return stat;
	}
	
	public void updateProcess(String process,String request){
		log.info("Update process");
		try {
			dbQuery.updateProcess(process,request);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SeleniumDaoException e) {
			e.printStackTrace();
		}
		WaitHelper.waitAdditional(3);
		log.info("Preocess is updated.");
	}
	
	public void testing(){
		log.info("Testing");
		try {
			dbQuery.checkProcess();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SeleniumDaoException e) {
			e.printStackTrace();
		}
		WaitHelper.waitAdditional(3);
		log.info("Preocess is updated.");
		
	}
	
	

	
	/**
	 * Click on Lines button
	 * Modified by Chetna
	 */
	
	
	public void clickOnLines(){
		log.info("Click on lines");
		
		List<WebElement> wbs = getAllFooterButton();
		for(WebElement wb : wbs){
			if(wb.getText().equals("Lines")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}
	

	/**
	 * EDB
	 * Enter Journal details 
	 * @param details
	 */
	public void enterJournalDetails(List<String> details){
		log.info("Enter journal details");
		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_JOUR_TYPE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_JOUR_TYPE)).sendKeys(details.get(0));//J Type
		
		getDriver().findElement(By.xpath(pObject.A040_JOUR_REF)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_JOUR_REF)).sendKeys(details.get(1));//J Reference
		
		getDriver().findElement(By.xpath(pObject.A040_PERI)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_PERI)).sendKeys(details.get(4));//Period
		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_YEAR)).sendKeys(details.get(11));//Year
		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_BTZ_ELE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_BTZ_ELE)).sendKeys(details.get(2));//BTZ Element
		
		getDriver().findElement(By.xpath(pObject.A040_DESC)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_DESC)).sendKeys(details.get(3));//Description
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_DESC)).sendKeys(Keys.ENTER);//Description
		
		WaitHelper.waitAdditional(2);
		clickOnAcceptWarnings();
		WaitHelper.waitAdditional(2);
		clickOnLines();
		WaitHelper.waitAdditional(3);
		enterJournalLines(details);	

		
	}

	/**
	 * Enter journal lines
	 * @param lines
	 */
	private void enterJournalLines(List<String> lines){
		log.info("Enter journal lines");
		
		if(BaseTest.browser.contains("internetexplorer"))
        {
        
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).click();
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).sendKeys(lines.get(5));//Account
		WaitHelper.waitAdditional(1.5);
		
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]")).click();
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).sendKeys(lines.get(6));//Cost
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[8]")).click();
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[8]")).click();
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[8]/input")).sendKeys(lines.get(7));//Base Value
		WaitHelper.waitAdditional(1.5);
		
		
		getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[3]")).click();
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[3]")).click();
		getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[3]/input")).sendKeys(lines.get(8));//Account
		WaitHelper.waitAdditional(1.5);
		
		
		getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[4]")).click();
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[4]")).click();
		getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[4]/input")).sendKeys(lines.get(9));//Cost
		WaitHelper.waitAdditional(1.5);
		
		getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[8]")).click();
		WaitHelper.waitAdditional(1.5);
		getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[8]")).click();
		getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[8]/input")).sendKeys(lines.get(10));//Base Value
		WaitHelper.waitAdditional(1.5);
		clickOnUpdate();
        
        }else{
        	
        	getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]")).click();
    		WaitHelper.waitAdditional(1);
    		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[3]/input")).sendKeys(lines.get(5));//Account
    		WaitHelper.waitAdditional(1.5);
    		
    		
    		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]")).click();
    		WaitHelper.waitAdditional(1);
    		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[4]/input")).sendKeys(lines.get(6));//Cost
    		WaitHelper.waitAdditional(1.5);
    		
    		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[8]")).click();
    		WaitHelper.waitAdditional(1);
    		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[8]/input")).sendKeys(lines.get(7));//Base Value
    		WaitHelper.waitAdditional(1.5);
    		
    		
    		getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[3]")).click();
    		WaitHelper.waitAdditional(1);
    		getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[3]/input")).sendKeys(lines.get(8));//Account
    		WaitHelper.waitAdditional(1.5);
    		
    		getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[4]")).click();
    		WaitHelper.waitAdditional(1);
    		getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[4]/input")).sendKeys(lines.get(9));//Cost
    		WaitHelper.waitAdditional(1.5);
    		
    		getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[8]")).click();
    		WaitHelper.waitAdditional(1);
    		getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[8]/input")).sendKeys(lines.get(10));//Base Value
    		WaitHelper.waitAdditional(1.5);
    		clickOnUpdate();
        	
        }

	}

	
	
	
	/**EJJ
	 * Structure Enquiry
	 * @param group
	 */
	public void structureEnquiry(List<String> group){
		log.info("Inside Structure Enquiry Method");
		
		getDriver().findElement(By.xpath(pObject.A026_LAYT)).clear();
		getDriver().findElement(By.xpath(pObject.A026_LAYT)).sendKeys(group.get(0));//Layout
		
		getDriver().findElement(By.xpath(pObject.A027_STRUC)).clear();
		getDriver().findElement(By.xpath(pObject.A027_STRUC)).sendKeys(group.get(1));//Structure
		
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).clear();
		getDriver().findElement(By.xpath(pObject.A029_ELEMENT)).sendKeys(group.get(2));//Element
		
		getDriver().findElement(By.xpath(pObject.A016_GRP)).clear();
		getDriver().findElement(By.xpath(pObject.A016_GRP)).sendKeys(group.get(4));//Group
		
		getDriver().findElement(By.xpath(pObject.A017_CATEG)).clear();
		getDriver().findElement(By.xpath(pObject.A017_CATEG)).sendKeys(group.get(5));//Enter Category
		
		getDriver().findElement(By.xpath(pObject.A040_SELE1_OK)).click();//Ok button
		WaitHelper.waitAdditional(4);
		
}
	
	/**
	 * Verify balance sheet details
	 * @param group
	 */
	public void verifyBalanceSheetDetail(List<String> group){
		log.info("Verify balance sheet details");
		
		
		getDriver().findElement(By.xpath(pObject.A026_LAYT)).clear();
		getDriver().findElement(By.xpath(pObject.A026_LAYT)).sendKeys(group.get(0));//Layout
		
		clickOnSections(1);	//Click on sections
		
		getDriver().findElement(By.xpath(pObject.A016_GRP)).clear();
		getDriver().findElement(By.xpath(pObject.A016_GRP)).sendKeys(group.get(1));//Group
		
		getDriver().findElement(By.xpath(pObject.A017_CATEG)).clear();
		getDriver().findElement(By.xpath(pObject.A017_CATEG)).sendKeys(group.get(2));//Category
		
		getDriver().findElement(By.xpath(pObject.A039_EXT_OK)).click();//Ok button
		WaitHelper.waitAdditional(4);
	}
	
	
	
	public void clickOnDrillDown(){
		log.info("Click on DrillDown button");
		
		List<WebElement> wbs = getAlllButton();
		for(WebElement wb : wbs){
			if(wb.getText().equals("Drill Down")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}
	
	
	
	
	/**
	 * Navigate to account details page
	 * @param account
	 */
	public void navigateToAccountDetailPage(){
		log.info("Navigate to AccountDetailPage");
		getDriver().findElement(By.xpath("//div[2]/table/tbody/tr/td[2]")).click();
		WaitHelper.waitAdditional(1);
		
		clickOnDrillDown();
		WaitHelper.waitAdditional(3);

	}
	
	public void getAccountDetailValues(String account){
		log.info("Verify account detail values");
		WaitHelper.waitAdditional(3);
			
		WebElement account1 = driver.findElement(By.xpath(pObject.A040_SELE_SEC));
		driver.executeScript("scroll(0,850);", account1);
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A040_SELE_ACCO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_SELE_ACCO)).sendKeys(account);//Account
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_SELE_OK)).click();
		WaitHelper.waitAdditional(2);
		
	}
	
	
	
	/**
	 * Navigate to Cost details page
	 * Created By Chetna dt: 
	 */
	public void navigateToCostDetailPage(){
		
		getDriver().findElement(By.xpath("//div[1]/table/tbody/tr/td[1]")).click();
		WaitHelper.waitAdditional(1);
		
		clickOnDrillDown();
		WaitHelper.waitAdditional(3);

	}
	
	
	public void getCostDetailValues(String account){
		log.info("Verify account detail values");
		
		WebElement account1 = driver.findElement(By.xpath(pObject.A040_SELE_SEC));
		driver.executeScript("scroll(0,950);", account1);
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.xpath(pObject.A040_SELE_COST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_SELE_COST)).sendKeys(account);//Cost
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A040_SELE_OK)).click();
		WaitHelper.waitAdditional(2);		
	}
	
	
	public void searchAccount(String account){
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id("0_1_0")).sendKeys(account);
		getDriver().findElement(By.id("0_1_0")).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Search management code
	 * @param element
	 * @param i
	 */
	public void searchManagementCode(String element,int i){
		log.info("Search management code");
		WaitHelper.waitAdditional(2);
				

		if(!ClickOnAnyButton("OK", 0))
		{

			clickOnSections(0);
		}
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.xpath(pObject.A029_PATH_KEY)).clear();//A029_PATH_KEY
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.xpath(pObject.A029_PATH_KEY)).sendKeys(element);//A029_PATH_KEY
		getDriver().findElement(By.xpath(pObject.A029_PATH_KEY)).sendKeys(Keys.ENTER);//A029_PATH_KEY
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Create management link
	 * @param element
	 */
	public void createManagementLink(String element){
		log.info("Create management link");
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.xpath(pObject.A032A_NEW_PAR)).clear();
			getDriver().findElement(By.xpath(pObject.A032A_NEW_PAR)).sendKeys(element);//New Parent
			WaitHelper.waitAdditional(4);
			getDriver().findElement(By.xpath(pObject.A032A_NEW_PAR)).sendKeys(Keys.ENTER);
			WaitHelper.waitAdditional(4);
	}
	
	/**
	 * Search value
	 * @param ValueList
	 * @param i = button
	 * @param j = fields
	 */
	public void searchEement(String companyName,int i){
		log.info("Search elemnt");
		if(!isOkButtonDisplayed(i)){
			clickOnSections(0);
		}
				
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(companyName.subSequence(0, 1));
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(companyName.subSequence(1, 2));
		
		ClickOnAnyButton("OK", 1);
		WaitHelper.waitAdditional(3);
;

	}
		
	/**
	 * Start and stop dispatcher
	 * @throws InterruptedException
	 */
	public void startAndStopDispatcher(String region) throws InterruptedException {
		log.info("Into startAndStopDispatcher Method");
		
		search(region, 3, 2);
		
//		clickOnStop();
//				
//		isStopConfirmPopUpDisplayed();
//		
//		clickOnRefresh();
		
		clickOnStart();

		isStartConfirmPopUpDisplayed();
								
		clickOnRefresh();
		
	}
	
	/**
	 * Click on Stop button
	 */

	
	
	
	
	/**
	 * Click on clickOnStart button
	 * @param i
	 */
	public void clickOnStart(){
		log.info("Click on Start Button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for(WebElement wb : wbs){
			if(wb.getText().equals("Start")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}	

	
	
	/**
	 * Click on clickOnStop Button
	 * @param i
	 */
	public void clickOnStop(){
		log.info("Click on Stop Button");
		WaitHelper.waitAdditional(3);
		List<WebElement> wbs = getAllFooterButton();
		for(WebElement wb : wbs){
			if(wb.getText().equals("Stop")){
				wb.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}	

	
	
	/**
 * Click on clickOnForce button
 * @param i
 */
public void clickOnForce(){
	log.info("Click on Force Button");
	WaitHelper.waitAdditional(3);
	List<WebElement> wbs = getAllFooterButton();
	for(WebElement wb : wbs){
		if(wb.getText().equals("Force")){
			wb.click();
			break;
		}
	}
	WaitHelper.waitAdditional(5);
}	


/**
* Verify presence of Start confirmation window for Executor and Dispatcher
* @return true/false
*/
public void isStartConfirmPopUpDisplayed()

{
log.info("Verify Start confirmation pop up");
WaitHelper.waitAdditional(3);
try{
	if(getDriver().findElement(By.xpath(pObject.A035_START_CONFIRM)).isDisplayed())
	
	{
		getDriver().findElement(By.xpath(pObject.A035_START_CONFIRM)).click();
	}
}
catch (NoSuchElementException e){
	
}
WaitHelper.waitAdditional(3);
}
	


/**
* Verify presence of Stop confirmation window for Executor and Dispatcher
* @return true/false
*/
public void isStopConfirmPopUpDisplayed()

{
log.info("Verify Stop confirmation pop up");
WaitHelper.waitAdditional(3);
try{
	if(getDriver().findElement(By.xpath(pObject.A035_STOP_CONFIRM)).isDisplayed())
	
	{
		getDriver().findElement(By.xpath(pObject.A035_STOP_CONFIRM)).click();
	}
}
catch (NoSuchElementException e){
	
}
WaitHelper.waitAdditional(3);
}


/**
* Verify presence of Submit confirmation window for Structure Rebuild
* @return true/false
*/
public void isSubmitConfirmPopUpDisplayed()

{
log.info("Verify Submit confirmation window for Structure Rebuild");
WaitHelper.waitAdditional(3);
try{
	if(getDriver().findElement(By.xpath(pObject.A035_CONFM_SUBMIT)).isDisplayed())
	
	{
		getDriver().findElement(By.xpath(pObject.A035_CONFM_SUBMIT)).click();
	}
}
catch (NoSuchElementException e){
	
}
WaitHelper.waitAdditional(3);
}


  



/*--------------------------------PHASE II METHODS----------------------------------------------------------------*/
	
	/**
	 * Create tax type - A043
	 * @param taxList
	 */
	public boolean createTaxType(List<String> taxList){
		log.info("In Tax code type method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(taxList.get(0));//Type
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(Keys.ENTER);//Type
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(taxList.get(1));//Desc
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(taxList.get(2));//Percentage
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(taxList.get(3));//Amount
			if(taxList.get(4).equals("1")){
				getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR)).click();//Tax rate chk
			}
			update = true;
		}
		WaitHelper.waitAdditional(2);
		return update;
	}

	/**
	 * Create Locations for Tax code created - A043
	 * @param elments
	 */
	public boolean createTaxCodeLocation(List<String> elements){
		log.info("In Tax code location method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Code
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(Keys.ENTER);//Code
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Desc
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(2));//Location
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys(elements.get(3));//Type
			WaitHelper.waitAdditional(1);
			update = true;
		}
		return update;
	}
	
	/**
	 * Create Tax Rate - A044
	 * @param elments
	 */
	public boolean createTaxRate(List<String> elements){
		log.info("In Tax rate  method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Date
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(2));//Location
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(3));//Type
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).sendKeys(elements.get(4));//Tax rate
		clickOnUpdate();
		
		if(!getToolContentText().contains(message)){			
			update = true;
		}
		return update;
	}
	
	/**
	 * BACS Calendar - A045
	 * @param elements
	 */
	public void enterBASCCalendarDetails(List<String> elements){
		log.info("In BACS calendar method");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Calendar
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject._ZERO)).click();//Type
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(2));//Week end day
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR)).click();
		WaitHelper.waitAdditional(3);
		clickOnYearsH();
		WaitHelper.waitAdditional(5);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(3));//Year
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * BACS Calendar - A045
	 * @param elements
	 */
	public void runActivityForCalendar(List<String> elements){
		log.info("In BACS calendar method");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Calendar to populate
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(4));//Activity to use
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(5));//From Year
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys(elements.get(6));//To Year
		WaitHelper.waitAdditional(2);
	}
	
	/**Create bank sort code - A046
	 * 
	 * @param elements
	 */
	public boolean bankSortCode(List<String> elements){
		log.info("In Bank sort code  method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Country
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(1));//Sort code
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(Keys.ENTER);//Sort code
		WaitHelper.waitAdditional(2);
		if(!getToolContentText().contains(message)){
			
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(2));//Bank name
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(3));//Ad L1
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys(elements.get(4));//Ad L2
			WaitHelper.waitAdditional(1);
			if(!elements.get(5).equals("NILL")){
				getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).sendKeys(elements.get(5));//Ad L2
				WaitHelper.waitAdditional(1);
			}
			WaitHelper.waitAdditional(1);
			if(!elements.get(6).equals("NILL")){
				getDriver().findElement(By.id(pObject.ZERO_+pObject.TEN)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.id(pObject.ZERO_+pObject.TEN)).sendKeys(elements.get(6));//Postal code
				WaitHelper.waitAdditional(1);
			}
			update = true;
		}
		return update;
	}
	
	/**
	 * Create UOM - A048
	 * @param elements
	 */
	public boolean enterUomDetails(List<String> elements){
		log.info("In Uom Details  method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//UOM Code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(Keys.ENTER);//UOM Code
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//UOM Description
			WaitHelper.waitAdditional(1);
			if(elements.get(2).equals("1")){
				getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.TWO)).click();//Sub-Division
			}
			update = true;
		}
		
		return update;
	}
	
	/**
	 * Create UOM Relationship - A048
	 * @param elements
	 */
	public boolean enterUOMRelationShip(List<String> elements){
		log.info("In Uom Relationship Details  method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Base UOM Code
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(0));//Non Base UOM Code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(Keys.ENTER);//Non Base UOM Code
		WaitHelper.waitAdditional(1);
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();//
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(2));//Non-Base to Base Factor
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).clear();//
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys(elements.get(3));//Non-Base to Base Factor
			update = true;
		}
		return update;
	}
	
	/**
	 * Enter Purchasing company control details - A049
	 * @param elements
	 */
	public void enterPurchasingCompanyControlDetails(String companyName,List<String> elements){
		log.info("Enter purchasing company control details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();//Company
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(companyName);//Company
		
		//GL - Numbering 
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(0));//Foreign exchangerate
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT)).sendKeys(companyName);//GL Holding company
		WaitHelper.waitAdditional(2);
		if(elements.get(1).equals("1")){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN+pObject._ZERO)).click();//GL Relationship indicator
		}
		WaitHelper.waitAdditional(1);
		//Click On Miscellaneous/ERS
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.FIFTH_TAB)).click();
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject.SIX)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject.SIX)).sendKeys(elements.get(2));//Days UOM
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject.EIGHT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject.EIGHT)).sendKeys(elements.get(3));//Working days calender
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.SIX+pObject.SEVEN)).click();//Keyword in use
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.SIX+pObject.NINE)).click();//NSV in use
		WaitHelper.waitAdditional(1);
		//Click on Supplier tab
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.TWO+pObject._ZERO)).click();//Duplicate Postcode Validation - Nor-req
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.SEVEN+pObject._FIRST)).click();//Supplier Postcode Enquiry - All supplier types
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.EIGHT+pObject._ZERO)).click();//PM Multiple Supplier Address notification
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.NINE+pObject._ZERO)).click();//AP Multiple Supplier Address notification
	}
	
	/**
	 * Amend batch details A051A
	 */
	public void editBatchTypes(){
		log.info("Inside batch type edit method");
		WaitHelper.waitAdditional(2);		
		clickOnRefresh();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR+pObject.TWO)).click();//Reconciliation required
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR+pObject.THREE)).click();//Bank account
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR+pObject.FOUR)).click();//Reconciliation required
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR+pObject.FIVE)).click();//Bank account
	}
	
	/**
	 * Enter Account payable control details -AO50
	 * @param elements
	 */
	public void enterAccountPayableControlDetails(List<String> elements){
		log.info("Enter account payable control details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Control account Code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject._ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject._ZERO)).sendKeys(elements.get(2));//Creditors control Account
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject._FIRST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject._FIRST)).sendKeys(elements.get(3));//Creditors control Cost
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject._ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject._ZERO)).sendKeys(elements.get(4));//Discount receivable Account
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject._FIRST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject._FIRST)).sendKeys(elements.get(5));//Discount receivable Cost
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE+pObject._ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE+pObject._ZERO)).sendKeys(elements.get(6));//Bank charges Account
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE+pObject._FIRST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE+pObject._FIRST)).sendKeys(elements.get(7));//Bank charges Cost
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject._ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject._ZERO)).sendKeys(elements.get(8));//Tax suspense Account
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject._FIRST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject._FIRST)).sendKeys(elements.get(9));//Tax suspense Cost
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject._ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject._ZERO)).sendKeys(elements.get(10));//Pre-payments Account
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject._FIRST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject._FIRST)).sendKeys(elements.get(11));//Pre-payments Cost
		getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE+pObject._ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE+pObject._ZERO)).sendKeys(elements.get(12));//Detail variance Account
		getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE+pObject._FIRST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE+pObject._FIRST)).sendKeys(elements.get(13));//Detail variance Cost
		
		//Control accounts tab2
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FOUR+pObject._ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FOUR+pObject._ZERO)).sendKeys(elements.get(14));//Service ledger accurals Account
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FOUR+pObject._FIRST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FOUR+pObject._FIRST)).sendKeys(elements.get(15));//Service ledger accurals Cost
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FIVE+pObject._ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FIVE+pObject._ZERO)).sendKeys(elements.get(16));//Service ledger deferrals Account
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FIVE+pObject._FIRST)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FIVE+pObject._FIRST)).sendKeys(elements.get(17));//Service ledger deferrals Cost
		WaitHelper.waitAdditional(1);
	}
	
	/**
	 * Create BR company - A051A
	 * @param elements
	 */
	public void createBRCompanyControl(String companyName,List<String> elements){
		log.info("Create BR company control");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(companyName);//Company
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(0));//Bank stmt
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(1));//Bank adj
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).sendKeys(elements.get(2));//Bank stmt
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT)).sendKeys(elements.get(3));//Bank adj
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TEN)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TEN)).sendKeys(elements.get(4));//GL adj
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.THREE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.TWO+pObject._FIRST)).click();//Origional date
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.THREE)).sendKeys(elements.get(5));//cheques
	}
	
	/**
	 * Create BR Bank code - A051
	 * @param elements
	 */	
	public boolean enterBRBankCodeList(List<String> elements){
		log.info("Enter BR bank code list");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Bank code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(1);
		if(!getToolContentText().contains(message)){
			
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(2));//Closing Balance
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(3));//Statement Date
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(4));//Bank sort code
			getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).sendKeys(elements.get(5));//Account number
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject._ZERO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject._ZERO)).sendKeys(elements.get(6));//GL - Account Account
			getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject._FIRST)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject._FIRST)).sendKeys(elements.get(7));//GL - Account Cost
			getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE)).sendKeys(elements.get(8));//BTZ Element
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.ONE)).sendKeys(elements.get(9));//Currency
			
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();//Currency tab
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.SIX)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.SIX)).sendKeys(elements.get(10));//User
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.SIX)).sendKeys(Keys.ENTER);//User
			update = true;
		}

		return update;
	}
	
	/**
	 * Enter Tax account details - A052
	 * @param elements
	 * @param elements1
	 * @param elements2
	 * @param elements3
	 */
	public void enterTaxAccountDetails(List<String> elements,List<String> elements1,List<String> elements2,List<String> elements3){
		log.info("Enter tax account details");
		enterTaxAccountByCode(elements,1);
		enterTaxAccountByCode(elements1,2);
		enterTaxAccountByCode(elements2,3);
		enterTaxAccountByCode(elements3,4);
	}
	
	private void enterTaxAccountByCode(List<String> elemnts,int i){
		log.info("Enter tax account details");
		WaitHelper.waitAdditional(3);
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+i+"]/table/tbody/tr/td[2]"))).click().
		sendKeys(elemnts.get(0)).build().perform();//Code
		WaitHelper.waitAdditional(2);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+i+"]/table/tbody/tr/td[3]"))).click().
		sendKeys(elemnts.get(1)).build().perform();//Account
		WaitHelper.waitAdditional(2);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+i+"]/table/tbody/tr/td[4]"))).click().
		sendKeys(elemnts.get(2)).build().perform();//Cost
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Enter Category code details - A053
	 * @param elements
	 */
	public void enterCategoryCodeDetails(List<String> elements){
		log.info("Enter category code details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Category
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(2));//Hold days
		WaitHelper.waitAdditional(2);
		if(elements.get(3).equals("1")){
			getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE)).click();//Auto supplier Cleardown
		}
	}
	
	/**
	 * Enter Discount terms - A054
	 * @param elements
	 */
	public void enterDiscountTerms(List<String> elements){
		log.info("Enter discount terms");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Discount term
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
		WaitHelper.waitAdditional(2);
		if(elements.get(2).equals("1")){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject._ZERO)).click();//Period details
		}
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).sendKeys(elements.get(3));//No.of days
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT)).sendKeys(elements.get(4));//Rate %
		WaitHelper.waitAdditional(2);
		if(elements.get(5).equals("1")){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE+pObject._ZERO)).click();//Invoice date
			
		}
	}
	
	/**
	 * Enter Settlement Terms - A055
	 * @param elements
	 */
	public boolean enterSettlementTerms(List<String> elements){
		log.info("Inside settlement terms method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Settlement terms
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(Keys.ENTER);//Settlement terms
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
			WaitHelper.waitAdditional(1);
			if(elements.get(2).equals("1")){
				getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject._ZERO)).click();//Monthly
			}
			WaitHelper.waitAdditional(1);
			if(elements.get(3).equals("1")){
				getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject._FIRST)).click();//Monthly
			}
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(4));//Daily
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(5));//Monthly
			WaitHelper.waitAdditional(1);
			if(!elements.get(6).equals("NILL")){
				getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys(elements.get(6));//Month
			}
			if(!elements.get(7).equals("NILL")){
				getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).sendKeys(elements.get(7));//Days
			}
			if(!elements.get(8).equals("NILL")){
				getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).sendKeys(elements.get(8));//Date
			}
			WaitHelper.waitAdditional(1);
			if(!elements.get(9).equals("1")){
				getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject._ZERO)).click();//Invoice
			}
			WaitHelper.waitAdditional(1);
			if(!elements.get(10).equals("1")){
				getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject._FIRST)).click();//Period
			}
			update = true;
		}
		return update;
	}
	
	/**
	 * Create bank account
	 * @param elements
	 * @return
	 */
	public boolean createBankAccount(List<String> elements){
		log.info("Create bank account");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Bank code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(Keys.ENTER);//Bank code
		WaitHelper.waitAdditional(1);
		if(!getToolContentText().contains(message)){
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Bank account no
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(2));//Bank account desc
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(3));//Currency
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(4));//Bank sort code
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN+pObject._ZERO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN+pObject._ZERO)).sendKeys(elements.get(5));//Bank sort code
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN+pObject._FIRST)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN+pObject._FIRST)).sendKeys(elements.get(6));//Bank sort code
			update = true;
		}
		return update;
	}
	
	/**
	 * AP Ledger Controls - A056
	 * @param elements
	 */
	public void enterAccountPayableCompanyControl(String companyId,List<String> elements){
		log.info("Enter account payable company control details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.FIRST_TAB)).click();//Currency tab
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(companyId);//Company
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(0));//Foreign currency rate type
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject._ZERO)).click();//Tolerance processing
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR)).click();//Currency turnover mentioned
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.SEVEN)).click();//Turnover to include tax
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.ONE+pObject.ONE)).click();//Transaction enquiry in reverse date sequence
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TEN+pObject._FIRST)).click();//Auto cancel - Await payment
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();//Data Entry tab
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.TWO+pObject._FIRST)).click();//Transaction Duplicate - Warning
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.THREE+pObject._TWO)).click();//Log Transactions - Optional
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FIVE+pObject._FIRST)).click();//Post code entry  - Warning
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.EIGHT+pObject._FIRST)).click();//Credit due date - Transactio date
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.ONE+pObject.FOUR)).click();// Transaction Totals Correction
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.ONE+pObject.SIX)).click();//Tax at Detail Level
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.ONE+pObject.SEVEN)).click();// Tax On Expenses at Detail Level
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.NINE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.NINE)).sendKeys(elements.get(1));//Tax Variance Tax Code
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.THIRD_TAB)).click();//Data Entry batch tab
		
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.TWO+pObject.NINE)).click();//Batch Totals Correction
		
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE+pObject.ZERO)).click();//Batch Totals on Number of Transactions
		
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE+pObject.ONE)).click();//Batch Totals Override
		
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE+pObject.TWO)).click();//Batch on Entry
		
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE+pObject.THREE)).click();// Batch on Logging
		
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE+pObject.FOUR)).click();//Batch on Expense
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE+pObject.FIVE)).click();//Mandatory Transaction Date
		
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.FIFTH_TAB)).click();//Withholding Tab
		
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject.FIVE+pObject._ZERO)).click();//Withholding type - None
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject.SEVEN)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject.SEVEN)).sendKeys(elements.get(2));//Tax Rate
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject.EIGHT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject.EIGHT)).sendKeys(elements.get(3));//Non-compliant Tax Rate
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject.NINE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject.NINE)).sendKeys(elements.get(4));//Number of days to Tax prompt
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SEVENTH_TAB)).click();//Payment processing Tab
		
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE+pObject.NINE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE+pObject.NINE)).sendKeys(elements.get(5));//Schedule Days Advance Warning:
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject.ZERO)).sendKeys(elements.get(6));//Default Bank Code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject.ONE)).sendKeys(elements.get(7));//Minimum Payment Value
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject.TWO)).sendKeys(elements.get(8));//Payment Register Value
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject.THREE)).sendKeys(elements.get(9));//Payment Reconciliation
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE+pObject.EIGHT+pObject._FIRST)).click();//Cheque duplication - Warning
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject.SIX)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject.SIX)).sendKeys(elements.get(10));//Number of Days Before Archiving
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.EIGHTH_TAB)).click();//GL Diary	tab
		
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject.EIGHT+pObject._ZERO)).click();//Relationship		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN+pObject.THREE)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN+pObject.THREE)).sendKeys(elements.get(11));//Control Accounts Code
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.SEVEN+pObject.FOUR)).click();//Default Period
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN+pObject.FIVE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN+pObject.FIVE)).sendKeys(elements.get(12));//Current Period / Ye
		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN+pObject.SIX)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN+pObject.SIX)).sendKeys(elements.get(13));//Current Period / Ye
		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN+pObject.SEVEN)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN+pObject.SEVEN)).sendKeys(elements.get(14));//Days Resident
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.NINTH_TAB)).click();//Batch types tab
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject.ZERO)).sendKeys(elements.get(15));//Default Batch Type
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject.ONE)).sendKeys(elements.get(16));//Logged Transactions
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject.TWO)).sendKeys(elements.get(17));//Entered Transactions
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject.THREE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject.THREE)).sendKeys(elements.get(18));//Cancelled Transactions
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject.FOUR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject.FOUR)).sendKeys(elements.get(19));//Transaction Transfer
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject.EIGHT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject.EIGHT)).sendKeys(elements.get(20));//VAT Analysis by Cost Centre
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject.NINE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject.NINE)).sendKeys(elements.get(21));//Payments	
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id("0_tabbedPanel_1_tablist_rightBtn")).click();
		WaitHelper.waitAdditional(2);
		
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.TAB+pObject.TEN)).click();//Payment analysis/Netting off Tab
		
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE+pObject.FOUR)).sendKeys(elements.get(22));//Netting off allowed
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.TAB+pObject.ONE+pObject.ONE)).click();//Invoce order matching Tab
		WaitHelper.waitAdditional(3);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE+pObject.FIVE)).sendKeys(elements.get(23));//Tolerance type
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE+pObject.EIGHT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE+pObject.EIGHT)).sendKeys(elements.get(24));//Tolerance (+)
		getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE+pObject.NINE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE+pObject.NINE)).sendKeys(elements.get(25));//Tolerance (-)
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TEN+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TEN+pObject.ONE)).sendKeys(elements.get(26));//Tolerance Amount
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TEN+pObject.ZERO+pObject._FIRST)).click();//Transaction Held for Price Difference
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.TEN+pObject.TWO)).click();//Over Invoicing of Auto GRN Orders - Warning
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TEN+pObject.SIX+pObject._FIRST)).click();//Goods Receipt Further Matching Option - Prorata		
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.TAB+pObject.ONE+pObject.FOUR)).click();//Credit/Debit matching Tab
		
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.TWO+pObject.TWO)).sendKeys(elements.get(27));//Tolerance Type
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.TWO+pObject.THREE)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.TWO+pObject.THREE)).sendKeys(elements.get(28));//Tolerance (+) 
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.TWO+pObject.FOUR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.TWO+pObject.FOUR)).sendKeys(elements.get(29));//Tolerance Amount
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.TWO+pObject.FOUR)).sendKeys(Keys.ENTER);//Tolerance Amount
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Set Up Additional Batch Types - A056A
	 * @param elements
	 */
	public void amendBatchTypes(List<String> elements){
		log.info("Amend batch types");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.FIVE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.FIVE)).sendKeys(elements.get(1));//Last Batch Reference 		
	}
	
	/**
	 * Enter Transactional Legend details - A057
	 * @param elements
	 */
	public boolean enterTransactionLegendDetails(List<String> elements){
		log.info("Inside transaction legend details");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Transaction Type
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Transaction Sub-type
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(Keys.ENTER);//Transaction Sub-type
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(2));//Description
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(3));//Legend
			update = true;
		}
		return update;
	}
	
	/**
	 * Enter payment methods - A058
	 * @param elements
	 */
	public boolean enterPaymentMethod(List<String> elements){
		log.info("Inside payment methods");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Payment method
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(Keys.ENTER);//Payment method
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Payment description
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(2));//Currency
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(3));//Payment Medium
			WaitHelper.waitAdditional(1);
			if(!elements.get(4).equals("NILL")){
				getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys(elements.get(4));//Payment Rate	
			}
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).sendKeys(elements.get(5));//Indicator
			WaitHelper.waitAdditional(1);
			if(elements.get(6).equals("1")){
				getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.SEVEN)).click();//Split print
			}
			update = true;
		}
		return update;
	}
	
	/**
	 * Enter Bank payment methods - A059
	 * @param elements
	 */
	public boolean enterBankPayMethods(List<String> elements){
		log.info("Inside bank payment methods");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(0));//Bank code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(1));//Payment method
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(Keys.ENTER);//Payment method
		WaitHelper.waitAdditional(2);
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys(elements.get(2));//Payment Sub-Type
			update = true;
		}
		return update;
	}
	
	/**
	 * Enter payment code - A060
	 * @param elements
	 */
	public boolean enterPaymentCode(List<String> elements){
		log.info("Inside payment code method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Payment code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(Keys.ENTER);//Payment code
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Payment description
			if(elements.get(2).equals("1")){
				getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject._ZERO)).click();//Settlement Due Date
			}
			
			WaitHelper.waitAdditional(3);
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(By.xpath("//div[1]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[2]"))).click().
			sendKeys(elements.get(3)).build().perform();//Currency
			WaitHelper.waitAdditional(2);
			builder.moveToElement(driver.findElement(By.xpath("//div[1]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[3]"))).click().
			sendKeys(elements.get(4)).build().perform();//Payment method
			WaitHelper.waitAdditional(2);
			builder.moveToElement(driver.findElement(By.xpath("//div[1]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[4]"))).click().
			sendKeys(elements.get(5)).build().perform();//Bank
			WaitHelper.waitAdditional(2);
			if(elements.get(6).equals("Y")){
			builder.moveToElement(driver.findElement(By.xpath("//div[1]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[4]"))).click().
			sendKeys(elements.get(6)).build().perform();//Auto-Payment
			}
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();
			WaitHelper.waitAdditional(2);
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[1]"))).click().
			sendKeys(elements.get(7)).build().perform();//Schedule Destination
			WaitHelper.waitAdditional(2);
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[2]"))).click().
			sendKeys(elements.get(8)).build().perform();//Payment Destination
			update = true;
		}
		return update;
	}
	
	/**
	 * Create Location Code - A061
	 * @param elements
	 */
	public boolean enterLocationCodeDetails(List<String> elements){
		log.info("Inside location code details method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Location
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(Keys.ENTER);//Location
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(2));//Address line 1
			WaitHelper.waitAdditional(1);
			
			if(!elements.get(3).equals("NILL")){
				getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT)).sendKeys(elements.get(3));//Post code
			}
			
			getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();//Details tab
			WaitHelper.waitAdditional(1);
			if(!elements.get(4).equals("NILL")){
				getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FIVE)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FIVE)).sendKeys(elements.get(4));//Management code
			}
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.NINE)).sendKeys(elements.get(5));//Accept user
			update = true;
		}
		return update;
	}
	
	/**
	 * Create Tax handlers - A062
	 * @param elements
	 */
	public boolean enterTaxHandlingDetails(List<String> elements){
		log.info("Inside tax handling details method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Handling
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(Keys.ENTER);//Handling
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
			WaitHelper.waitAdditional(1);
			if(elements.get(2).equals("1")){
				getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.TWO)).click();//Inclusive
			}
			WaitHelper.waitAdditional(1);
			if(elements.get(3).equals("1")){
				if(!getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE)).isSelected()){
					getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE)).click();//Recoverable
				}
			}
			WaitHelper.waitAdditional(1);
			if(elements.get(3).equals("0")){
				if(getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE)).isSelected()){
					getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE)).click();//Recoverable
				}
			}
			WaitHelper.waitAdditional(1);
			if(elements.get(4).equals("1")){
				getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR)).click();//Pro-data
			}
			update = true;
		}
		return update;
	}
	
	/**
	 * Create Standard Reference details - A063
	 * @param elements
	 * @param lines
	 */
	public boolean enterStandardTextReferenceDetails(List<String> elements,List<String> lines){
		log.info("Enter standard text reference details");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		if(elements.get(1).equals("1")){
			getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.ZERO)).click();//Disabled check box
		}
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(0));//Text ref
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(Keys.ENTER);//Text ref
		WaitHelper.waitAdditional(1);
		
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(2));//Description
			WaitHelper.waitAdditional(1);
			for(int i=1;i<=lines.size();i++){
				Actions builder = new Actions(driver);
				builder.moveToElement(driver.findElement(By.xpath("//div[5]/div/div/div[2]/div[2]/div/div/div/div["+i+"]/table/tbody/tr/td"))).click().
				sendKeys(lines.get(i-1)).build().perform();//Line
				WaitHelper.waitAdditional(1);
		}
		update = true;
		}
		
		return update;
	}
	
	/**
	 * Create PPV Control Account - A064
	 * @param elements
	 */
	public void enterPPVControlAccount(List<String> elements){
		log.info("Enter PPV control account details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//PPV Control code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject._ZERO)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject._ZERO)).sendKeys(elements.get(2));//PPV Account
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject._FIRST)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject._FIRST)).sendKeys(elements.get(3));//PPV Account
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject._ZERO)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject._ZERO)).sendKeys(elements.get(4));//PPV Reserve
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject._FIRST)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject._FIRST)).sendKeys(elements.get(5));//PPV Reserve
	}
	
	/**
	 * Edit purchasing company control - A065
	 * @param elements
	 */
	public void editCommonPurchasingComany(List<String> elements){
		log.info("Edit company purchasing company");
		WaitHelper.waitAdditional(2);
		if(!getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE)).isSelected()){
			getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE)).click();//Purchasing price
		}
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys(elements.get(0));//PPV account code
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();//Supplier tab
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.FOUR)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.FOUR)).sendKeys(elements.get(1));//Price expiry
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.THIRD_TAB)).click();//Goods tab
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR+pObject.ONE)).click();//At point of receipt
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE+pObject.FIVE)).click();//Print receipt/Return Note
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.SIX)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.SIX)).sendKeys(elements.get(2));//No.of copies
	}
	
	/**
	 * Create Accrual control account - A066
	 * @param elements
	 */
	public void enterAccrualControlAccount(List<String> elements){
		log.info("Enter accrual control account details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Accrual Control code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject._ZERO)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject._ZERO)).sendKeys(elements.get(2));//Accrual Account
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject._FIRST)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject._FIRST)).sendKeys(elements.get(3));//Accrual Account
	}
	
	
	/**
	 * Create Inspection code  - A067
	 * @param elements
	 */
	public void enterPOPCompanyControls(String companyName,List<String> elements){
		log.info("Enter POP company controls");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.FIRST_TAB)).click();//Numbering / GL /Supplier
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(companyName);//Company
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).sendKeys(elements.get(0));//Company no length		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT)).sendKeys(elements.get(1));//Next doc no
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.THREE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.THREE)).sendKeys(elements.get(2));//Control Account
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FOUR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FOUR)).sendKeys(elements.get(3));//Batch Type
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FIVE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FIVE)).sendKeys(elements.get(4));//Current GL Period/Year
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.SIX)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.SIX)).sendKeys(elements.get(5));//Current GL Period/Year
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.ONE)).click();//Maintain Turnover
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.TWO)).click();//Turnover to Include Tax
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE)).click();//Maintain Currency Turnover
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(6));//Turn-over period definition
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.SEVEN)).sendKeys(elements.get(7));//Prompts Active	
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.EIGHT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.EIGHT)).sendKeys(elements.get(8));//Number of Prices to Return
		WaitHelper.waitAdditional(1);
		
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();//Data entry
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.FOUR+pObject._ZERO)).click();//Amend or revise
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.SIX)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.SIX)).sendKeys(elements.get(9));//Supplier address
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.SEVEN)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.SEVEN)).sendKeys(elements.get(10));//Invoice point
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.EIGHT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.EIGHT)).sendKeys(elements.get(11));//Delivery point
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.ONE+pObject._FIRST)).click();//Print cancelled lines- suppressed
		WaitHelper.waitAdditional(1);
		if(!getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE+pObject.SEVEN)).isSelected()){
			getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE+pObject.SEVEN)).click();//tem Short Description Amendable
		}
		WaitHelper.waitAdditional(1);
		if(!getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE+pObject.EIGHT)).isSelected()){
			getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE+pObject.EIGHT)).click();//Use EDI Processing
		}
		WaitHelper.waitAdditional(1);
		if(!getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE+pObject.NINE)).isSelected()){
			getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE+pObject.NINE)).click();//Location Codes Mandatory
		}
		WaitHelper.waitAdditional(1);
		if(!getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR+pObject.ZERO)).isSelected()){
			getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR+pObject.ZERO)).click();// Order Line Accept User
		}
		WaitHelper.waitAdditional(1);
		if(!getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR+pObject.ONE)).isSelected()){
			getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR+pObject.ONE)).click();//Allow Auto Order creation from Requisitions
		}
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.THREE)).sendKeys(elements.get(12));//Numbering
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.TWO)).sendKeys(elements.get(13));//Quotation Request
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.FIVE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.FIVE)).sendKeys(elements.get(14));//Quotation Acceptance
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.SIX)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.SIX)).sendKeys(elements.get(15));//Quotation Rejection
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.FIVE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.FIVE)).sendKeys(elements.get(16));//Document Retention Period
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.ZERO)).sendKeys(elements.get(17));//Foreign Currency Rate Type
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.ZERO)).sendKeys(Keys.ENTER);//Foreign Currency Rate Type
		WaitHelper.waitAdditional(2);
	}
	
	
	
	/**
	 * Create Inspection code  - A068
	 * @param elements
	 */
	public void enterInspectionCode(List<String> elements){
		log.info("Enter inspection code details");
		WaitHelper.waitAdditional(3);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Inspection code
		WaitHelper.waitAdditional(1);		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject._+elements.get(1))).click();//Inspection type
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(3));//Description
	}
	
	/**
	 * Create Disposal code - A0069
	 * @param elements
	 */
	public boolean enterDisposalCode(List<String> elements){
		log.info("Enter disposal code details");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Disposal code
		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(Keys.ENTER);//Disposal code
		WaitHelper.waitAdditional(1);
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
			update = true;
		}
		return update ;
	}
	
	/**
	 * Create Disposal code - A0070
	 * @param elements
	 */
	public void enterReasonCode(List<String> elements){
		log.info("Enter reason code details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Reason code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
	}
	
	/**
	 * Document prefix code - A071
	 * @param elements
	 */
	public boolean enterDocumentPrefixCode(List<String> elements){
		log.info("Inside document prefix code method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Document type
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Prefix
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(Keys.ENTER);//Prefix
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(2));//Description
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(3));//Suffix type
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(4));//Length
			update = true;
		}
		return update;
	}
	
	/**
	 * Search CP user
	 * @param elements
	 */
	public void searchCPUser(List<String> elements){
		log.info("Search CP User");
		WaitHelper.waitAdditional(2);
		if(!isOkButtonDisplayed(6)){
			clickOnSections(0);
		}
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(0));
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys(elements.get(1));
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject.LABEL)).click();
		
	}
	
	/**
	 * Create CP User - A072
	 * @param elements
	 */
	public void enterCPUserDetails(List<String> elements){
		log.info("Inside CP User details page");
		
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//CP User
		
		WaitHelper.waitAdditional(2);
		
		if(elements.get(1).equals("1")){
			getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE)).click();//Buyer
		}
		WaitHelper.waitAdditional(1);
		if(elements.get(2).equals("1")){
			getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR)).click();//Expediter
		}
		WaitHelper.waitAdditional(1);
		if(elements.get(3).equals("1")){
			getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FIVE)).click();//Acceptor
		}
		WaitHelper.waitAdditional(1);
		if(elements.get(4).equals("1")){
			getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.SIX)).click();//Goods Receiver
		}

		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();//Default Details
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.FIVE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.FIVE)).sendKeys(elements.get(5));//Buyer
		WaitHelper.waitAdditional(2);

	}
	
	/**
	 * Create Receipt Control details - A073
	 * @param elements
	 */
	public void enterReceiptControlsDetails(List<String> elements){
		log.info("Enter receipt control details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Receipt Control
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(2));//Tolerance Processing
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject._FIRST)).click();//Under Check Warning
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(3));//Under Check %
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys("1.00");//Under Check value
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject._FIRST)).click();//Over Check Warning
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).sendKeys(elements.get(4));//Over Check %
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT)).sendKeys("1.00");//Under Check value
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TEN+pObject._FIRST)).click();//Early check Warning
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.ONE)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.ONE)).sendKeys(elements.get(5));//Early check
	}
	
	/**
	 * CreatebAutomatic bank code - A074
	 * @param elements
	 */
	public void enterAutomaticBankCode(List<String> elements,String protocolId){
		log.info("Enter automatic bank code details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Automatic Banking Code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//User Number	
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(2));//User Name
		WaitHelper.waitAdditional(1);
		if(!elements.get(3).equals("NILL")){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(3));//Bureau Number
		}
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(protocolId);//Protocol Id
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys(elements.get(4));//Calendar
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).sendKeys(elements.get(5));//Processing Cycle/Days
	}
	
	/**
	 * Create Circulation code - A075
	 * @param elements
	 */
	public boolean enterCirculationCode(List<String> elements){
		log.info("Inside circulation code method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Circulation
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(Keys.ENTER);//Circulation
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Descrption
			WaitHelper.waitAdditional(3);
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[2]"))).click().
			sendKeys("01").build().perform();//Company
			WaitHelper.waitAdditional(3);
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[3]"))).click().
			sendKeys(elements.get(2)).build().perform();//Mapping
			WaitHelper.waitAdditional(3);
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[4]"))).click().
			sendKeys(elements.get(3)).build().perform();//Profile
			WaitHelper.waitAdditional(3);
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[5]"))).click().
			sendKeys(elements.get(4)).build().perform();//Description
			WaitHelper.waitAdditional(2);
			update = true;
		}
		return update;
	}
	
	/*Company control QSA*/
	public void createCompanyControl(String companyName,List<String> elements){
		log.info("Create company control");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(companyName);//Company
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).sendKeys(elements.get(0));//User
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.TWO)).sendKeys(elements.get(1));//Default Report Prefix
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.THREE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.THREE)).sendKeys(elements.get(2));//Default Report Prefix No
	}
	
	/*Create Mappings QMA*/
	public void createMappings(List<String> elements){
		log.info("Inside create maappings method");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Mapping
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
	}
	
	
	/**
	 * Document Codes - A076
	 * @param elements
	 */
	public void enterDocumentCodeDetails(List<String> elements){
		log.info("Enter document code details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Document code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(2));//Document type
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.FIRST_TAB)).click();//Miscellaneous
		
		if(!elements.get(3).equals("NILL")){
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT)).sendKeys(elements.get(3));//Header Entry
		}
		if(!elements.get(4).equals("NILL")){
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE)).sendKeys(elements.get(4));//Detail Entry
		}
		if(!elements.get(5).equals("NILL")){
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TEN)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TEN)).sendKeys(elements.get(5));//Fast Entry
		}
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();//Print options
		WaitHelper.waitAdditional(2);
		if(elements.get(6).equals("1")){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FOUR+pObject._FIRST)).click();//Amendments - Print All
			WaitHelper.waitAdditional(1);
		}
		if(elements.get(7).equals("1")){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FIVE+pObject._FIRST)).click();//Revisions - Print All
			WaitHelper.waitAdditional(1);
		}
		if(elements.get(8).equals("1")){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.SIX+pObject._FIRST)).click();//Printing of Cancelled Lines -  Suppressed
			WaitHelper.waitAdditional(1);
		}
		if(elements.get(8).equals("2")){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.SIX+pObject._TWO)).click();//Printing of Cancelled Lines -  Annotated
			WaitHelper.waitAdditional(1);
		}
		if(elements.get(9).equals("1")){
			getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.ONE+pObject.SEVEN)).click();//Immediate Print Required
			WaitHelper.waitAdditional(1);
		}
		if(!elements.get(10).equals("NILL")){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.EIGHT)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.EIGHT)).sendKeys(elements.get(10));//Circulation
		}
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.THIRD_TAB)).click();//Data entry tab
		WaitHelper.waitAdditional(1);
		if(!elements.get(11).equals("NILL")){
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.THREE)).sendKeys(elements.get(11));//Price Mandatory
		}
		if(!elements.get(12).equals("NILL")){
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.SIX)).sendKeys(elements.get(12));//Auto-Numbering Required
		}
		if(!elements.get(13).equals("NILL")){
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.NINE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.NINE)).sendKeys(elements.get(13));//Value Ceiling For Document
		}
		if(elements.get(14).equals("1")){
			getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.THREE+pObject.ONE)).click();// Returns
		}
		if(!elements.get(15).equals("NILL")){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.FOUR)).sendKeys(elements.get(15));//Material Request
		}
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.FOURTH_TAB)).click();//Invoice tab
		WaitHelper.waitAdditional(2);
		if(elements.get(16).equals("1")){
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR+pObject.ONE)).click();//Miscellaneous Charges Accepted
		}
		WaitHelper.waitAdditional(1);
		if(elements.get(17).equals("1")){
			getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR+pObject.TWO)).click();//Invoice Price Tolerance Check
		}
		WaitHelper.waitAdditional(1);
		if(!elements.get(18).equals("NILL")){
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject.THREE)).sendKeys(elements.get(18));//Order Line Selection Default
		}
		WaitHelper.waitAdditional(1);
		if(!elements.get(19).equals("NILL")){
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE+pObject.ZERO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE+pObject.ZERO)).sendKeys(elements.get(19));//Accruals Batch type
		}	


	}
	
	/**
	 * Edit CP company controls - A077
	 * @param elements
	 */
	public void editCPCompanyControls(List<String> elements){
		log.info("Edit CP company controls");
		WaitHelper.waitAdditional(5);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.THIRD_TAB)).click();//Goods receipting/IM tab
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.NINE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.NINE)).sendKeys(elements.get(1));//Purchase Requisition Code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.ZERO)).sendKeys(elements.get(2));//Replenishment Requisition Code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.ONE)).sendKeys(elements.get(3));//Buyer Code
	}
	
	/**
	 * Authorisation Controls - A078
	 * @param elements
	 */
	public boolean enterAuthorisationControlDetails(List<String> elements){
		log.info("Inside authorisation control details method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Authorisation Control Code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(Keys.ENTER);//Authorisation Control Code
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(2));//Method
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(3));//Type
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO_+elements.get(4))).click();// Level
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).clear();
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys(elements.get(5));//Minimum Value
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).clear();
			getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).sendKeys(elements.get(6));//Query Authoriser
			WaitHelper.waitAdditional(1);
			if(elements.get(7).equals("1")){
				getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.EIGHT)).click();//Auth Order Related Transaction
			}
			update = true;
		}
		return update;
	}
	
	/**
	 * Authorisation Group for Purchase management - A079
	 * @param elements
	 */
	public void enterAuthorisationGroupForPM(List<String> elements){
		log.info("Enter authorisation group for PM");
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Authorisation Group
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
	}
	
	
	/**
	 * Authorisation Group for Accounts Payable - A079
	 * @param elements
	 */
	public void enterAuthorisationGroupForAP(List<String> elements){
		log.info("Enter authorisation group for AP");
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Authorisation Group
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
	}
	
	/**
	 * Authorisation Control Details For PM - A080
	 * @param elements
	 */
	public boolean enterAuthorisationControlDetailsForPM(List<String> elements){
		log.info("Inside authorisation control details method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Authorisation Control Code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(Keys.ENTER);//Authorisation Control Code
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(2));//Method
			WaitHelper.waitAdditional(2);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(3));//Type
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO_+elements.get(4))).click();// Level
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).clear();
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys(elements.get(5));//Minimum Value
			WaitHelper.waitAdditional(1);
			if(!elements.get(6).equals("NILL")){
				getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).clear();
				getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).sendKeys(elements.get(6));//Query Authoriser
			}
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TEN+pObject._+elements.get(7))).click();//Authorisation on Amendments
			if(elements.get(8).equals("1")){
				getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.ONE+pObject.ONE)).click();// Site
			}
			WaitHelper.waitAdditional(1);
			if(elements.get(9).equals("1")){
				getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.ONE+pObject.TWO)).click();//Document Type
			}
			WaitHelper.waitAdditional(1);
			if(elements.get(10).equals("1")){
				getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.ONE+pObject.THREE)).click();//Document Code
			}
			WaitHelper.waitAdditional(1);
			if(elements.get(11).equals("1")){
				getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.ONE+pObject.FOUR)).click();// Buyer
			}
			update = true;
		}
		return update;
	}
	
	/**
	 * Authorisation Groupings Details FOR PM - A081
	 * @param elements
	 */
	public boolean enterAuthorisationGroupingsDetails(List<String> elements){
		log.info("Inside authorisation grouping details method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(5));//Authorisation Control Code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(0));//Location
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(1));//Document Type
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).sendKeys(elements.get(2));//Document Code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).sendKeys(Keys.ENTER);//Document Code
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			if(!elements.get(3).equals("NILL")){
				getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT)).clear();
				WaitHelper.waitAdditional(1);
				getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT)).sendKeys(elements.get(3));//Buyer
			}
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TEN)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TEN)).sendKeys(elements.get(4));//Authorisation Group
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.TWO)).sendKeys(elements.get(6));//Grouping Description
			update = true;
		}
		return update;
	}
	
	/**
	 * Authorisation Structure For AP - A082
	 * @param elements
	 */
	public void enterAuthorisationStructureForAP(List<String> elements){
		log.info("Enter authorisation structure for AP");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Authorisation Structure
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
	}
	
	/**
	 * Authorisation Structure For PM - A082
	 * @param elements
	 */
	public void enterAuthorisationStructureForPM(List<String> elements){
		log.info("Enter authorisation structure for AP");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Authorisation Structure
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Description
	}
	
	/**
	 * Structure Authorisor For AP - A083
	 * @param elements
	 */
	public void enterStructureAuthorisorForAP(List<String> elements){
		log.info("Inside authorisor for AP method");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(0));//Authorisation Structure
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(1));//User
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(Keys.ENTER);//User
		WaitHelper.waitAdditional(2);
		
		if(!elements.get(2).equals("NILL")){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).clear();
			WaitHelper.waitAdditional(1);			
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FIVE)).sendKeys(elements.get(2));//Parent User
		}
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).sendKeys(elements.get(3));//Rating
	}
	
	/**
	 * Structure Authorisor For PM - A083
	 * @param elements
	 */
	public void enterStructureAuthorisorForPM(List<String> elements){
		log.info("Inside authorisation for PM method");

		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Authorisation Structure
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(1));//User	
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(Keys.ENTER);//User
		WaitHelper.waitAdditional(2);
		
		if(!elements.get(2).equals("NILL")){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(2));//Parent User
		}
		if(!elements.get(3).equals("NILL")){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX)).sendKeys(elements.get(3));//Rating
		}
	}
	
	/**
	 * Authorisation Value PM - A084
	 * @param elements
	 */
	public boolean enterAuthorisationValuePM(List<String> elements){
		log.info("Inside Authorisation Value for PM");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Value Level
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(Keys.ENTER);//Value Level
		WaitHelper.waitAdditional(2);
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Value
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(2));//Description
			update = true;
		}
		return update;
	}
	
	/**
	 * Authorisation Value AP - A084
	 * @param elements
	 */
	public boolean enterAuthorisationValueAP(List<String> elements){
		log.info("Inside Authorisation Value for AP method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Value Level
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(Keys.ENTER);//Value Level
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Value
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(2));//Description
			update = true;
		}
		return update;
	}
	
	/**
	 * Value Level Auth For AP - A085
	 * @param elements
	 */
	public boolean enterValueLevelAuthForAP(List<String> elements){
		log.info("Inside authorisation by value method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(0));//Authorisation Group
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(1));//Value
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(Keys.ENTER);//Value
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(2));//Minimum Authorisers
			Actions builder = new Actions(driver);
			WaitHelper.waitAdditional(2);
			int users = Integer.parseInt(elements.get(2));
			int j = 3;
			for(int i=1;i<=users;i++){
				WaitHelper.waitAdditional(5);
				builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+i+"]/table/tbody/tr/td[2]"))).click().
				sendKeys(elements.get(j)).build().perform();//User
				WaitHelper.waitAdditional(5);
				builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+i+"]/table/tbody/tr/td[2]"))).click().
				sendKeys(Keys.ENTER).build().perform();//User
				WaitHelper.waitAdditional(6);
				j++;
			}
			update = true;
		}
		return update;
	}
	
	public void searcValueLevel(List<String> elements){
		log.info("Search value level");
		WaitHelper.waitAdditional(3);
		if(!isOkButtonDisplayed(2)){
			clickOnSections(0);
		}
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Company
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Auth group
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(2));//Value level
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.LABEL)).click();
	}
	
	/**
	 * Value Level Auth For PM - A085
	 * @param elements
	 */
	public boolean enterValueLevelAuthForPM(List<String> elements){
		log.info("Inside authorisation by value method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Authorisation Group
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(1));//Value
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(Keys.ENTER);//Value
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(2));//Minimum Authorisers
			Actions builder = new Actions(driver);	
			WaitHelper.waitAdditional(2);
			
			int users = Integer.parseInt(elements.get(2));
			int j = 3;
			for(int i=1;i<=users;i++){
				WaitHelper.waitAdditional(5);
				builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+i+"]/table/tbody/tr/td[2]"))).click().
				sendKeys(elements.get(j)).build().perform();//User
				WaitHelper.waitAdditional(5);
				builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+i+"]/table/tbody/tr/td[2]"))).click().
				sendKeys(Keys.ENTER).build().perform();//User
				WaitHelper.waitAdditional(5);
				j++;
			}	
			update = true;
		}
		return update;
	}
	
	/**
	 * GL Responsibility Auth For AP - A086
	 * @param elements
	 */
	public boolean enterGLResponsibilityAuthForAP(List<String> elements){
		log.info("Inside GL responsibility method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Authorisation Group
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(1));//Element
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(Keys.ENTER);//Element
		WaitHelper.waitAdditional(2);
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).sendKeys(elements.get(2));//Minimum Authorisers
	
			int j = 3;
			int users = Integer.parseInt(elements.get(2));
			Actions builder = new Actions(driver);
			WaitHelper.waitAdditional(2);
			for(int i=1;i<=users;i++){
				WaitHelper.waitAdditional(5);
				builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+i+"]/table/tbody/tr/td[2]"))).click().
				sendKeys(elements.get(j)).build().perform();//User
				WaitHelper.waitAdditional(5);
				builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+i+"]/table/tbody/tr/td[2]"))).click().
				sendKeys(Keys.ENTER).build().perform();//User
				WaitHelper.waitAdditional(5);
				j++;
			}
			update = true;
		}
		return update;
	}
	
	/**
	 * Authorisation by Level/GL Responsibility for Accounts Payable - A087
	 * @param elements
	 * @param l1Users
	 * @param l2Users
	 * @param l3Users
	 * @param l4Users
	 */
	public void enterAuthorisationByLevelOrGLResponsibilityForAP(List<String> elements,List<String> l1Users,List<String> l2Users,List<String> l3Users,List<String> l4Users){
		log.info("In authorisation by Level Or GL responsibility for AP method");
	
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Authorisation Group
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(elements.get(1));//Element
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE)).sendKeys(Keys.ENTER);//Element
		WaitHelper.waitAdditional(5);
	
			Actions builder = new Actions(driver);
			WaitHelper.waitAdditional(2);	
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[2]"))).click().
			sendKeys(elements.get(2)).build().perform();//LEVEL1
			WaitHelper.waitAdditional(5);
	
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[2]/table/tbody/tr/td[2]"))).click().
			sendKeys(elements.get(3)).build().perform();//LEVEL2
			WaitHelper.waitAdditional(5);
	
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[3]/table/tbody/tr/td[2]"))).click().
			sendKeys(elements.get(4)).build().perform();//LEVEL3
			WaitHelper.waitAdditional(5);
		
			builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[4]/table/tbody/tr/td[2]"))).click().
			sendKeys(elements.get(5)).build().perform();//LEVEL4
			WaitHelper.waitAdditional(5);
			
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(Keys.ENTER);//To enable 'Authorisors' fields
			WaitHelper.waitAdditional(3);
			addUsers(l1Users,1);
			addUsers(l2Users,2);
			addUsers(l3Users,3);
			addUsers(l4Users,4);	
	}
	
	private void addUsers(List<String> users,int i){
		log.info("Adding users");
		WaitHelper.waitAdditional(5);
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+i+"]/table/tbody/tr/td[2]"))).click().build().perform();
		WaitHelper.waitAdditional(5);
		clickOnAuthorisors();
		if(isAuthorisorsButtonVisible() == true){
			clickOnAuthorisors();
		}
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE)).sendKeys(users.get(0));//Min Authorisers
		getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE)).sendKeys(Keys.ENTER);
		WaitHelper.waitAdditional(2);
		int userCount = Integer.parseInt(users.get(0));
		Actions builderNew = new Actions(driver);
		for(int j=1;j<=userCount; j++){
			WaitHelper.waitAdditional(5);
			builderNew.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+j+"]/table/tbody/tr/td[2]"))).click().
			sendKeys(users.get(j)).build().perform();//User
			WaitHelper.waitAdditional(5);
			builderNew.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+j+"]/table/tbody/tr/td[2]"))).click().
			sendKeys(Keys.ENTER).release().perform();//User
			WaitHelper.waitAdditional(7);
		}		
		clickOnUpdate();
		WaitHelper.waitAdditional(5);
	}
	 
	/**
	 * Click on authorisors
	 */
	public void clickOnAuthorisors(){
		log.info("Click on Authorisors button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb2 : wbs1){
			if(wb2.getText().equals("Authorisors")){
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(2);
	}
	
	/**
	 * Verify authorisors button
	 * @return
	 */
	public boolean isAuthorisorsButtonVisible(){
		log.info("Verify presence of Authorisors button");
		boolean visible = false;
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb2 : wbs1){
			if(wb2.getText().equals("Authorisors")){
				visible = true;
				break;
			}
		}
		WaitHelper.waitAdditional(2);
		return visible;
	}
				
	/**
	 * Value/GL Responsibility For AP - A088
	 * @param elements
	 */
	public boolean enterValueORGLResponsibilityForAP(List<String> elements){
		log.info("Inside GL responsibility of AP method");
		boolean update = false;
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Authorisation Group
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(1));//Element
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(Keys.ENTER);//Element
		WaitHelper.waitAdditional(2);
		
		if(!getToolContentText().contains(message)){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).clear();
			WaitHelper.waitAdditional(1);
			getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).sendKeys(elements.get(2));//Minimum Authorisers
			getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).sendKeys(Keys.ENTER);
			WaitHelper.waitAdditional(3);
			int userCount = Integer.parseInt(elements.get(3));			
			Actions builder = new Actions(driver);
			int j = 4;
			for(int i=1;i<=userCount;i++){				
				WaitHelper.waitAdditional(5);
				builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+i+"]/table/tbody/tr/td[2]"))).click().
				sendKeys(elements.get(j)).build().perform();//User
				WaitHelper.waitAdditional(5);
				j = j+1;
				builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+i+"]/table/tbody/tr/td[3]"))).click().
				sendKeys(elements.get(j)).build().perform();//Value
				WaitHelper.waitAdditional(5);
				builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div["+i+"]/table/tbody/tr/td[3]"))).click().
				sendKeys(Keys.ENTER).build().perform();//Value
				WaitHelper.waitAdditional(5);
				j++;
				WaitHelper.waitAdditional(4);
			}	
			update = true;
		}
		return update;
	}
	
	/**
	 * AP Company Control - A089
	 * @param elements
	 */
	public void editAPCompanyControl(List<String> elements){
		log.info("Edit AP company control details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.FOURTH_TAB)).click();//Authorisation tab
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.SIX)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.SIX)).sendKeys(elements.get(0));//Code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.EIGHT)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.EIGHT)).sendKeys(elements.get(1));//Structure
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.NINE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.NINE)).sendKeys(elements.get(2));//Company Structure:
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject.ZERO)).sendKeys(elements.get(3));//Structure Path
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.CHECK+pObject.ZERO_+pObject.FOUR+pObject.ONE)).click();//Use Analysis
		WaitHelper.waitAdditional(1);		
	
		if(!elements.get(4).equals("NILL")){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject.TWO)).clear();
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject.TWO)).sendKeys(elements.get(4));//Code Identifier
		}
		WaitHelper.waitAdditional(3);
		if(!elements.get(5).equals("NILL")){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject.FOUR)).sendKeys(elements.get(5));//Posting Type
		}
	}
	
	/**
	 * Amend PM Company Control - A090
	 * @param elements
	 */
	public void editPMCompanyControl(List<String> elements){
		log.info("Edit PM company control detais");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();//Data entry tab
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.NINE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.NINE)).sendKeys(elements.get(0));//Control Code
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.ZERO)).sendKeys(elements.get(1));//Company structure
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.ONE)).sendKeys(elements.get(2));//Default structure
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.TWO)).sendKeys(elements.get(3));//Code id
	}
	
	/**
	 * Edit document code
	 * @param elements
	 */
	public void editDocumentCodes(String elements){
		log.info("Edit document code details");
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.FIRST_TAB)).click();//Miscellaneous tab
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.TWO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.TWO)).sendKeys(elements);//Control Code
	}
			
	/**
	 * Set Up Suppliers - A091
	 * @param elements
	 */
	public void enterSupplierListDetail(List<String> elements){
		log.info("Enter supplier details");
		WaitHelper.waitAdditional(2);		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ZERO)).sendKeys(elements.get(0));//Supplier
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE)).sendKeys(elements.get(1));//Name
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO)).sendKeys(elements.get(2));//Short name
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject._ZERO)).click();//Supplier
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(3));//Currency
		WaitHelper.waitAdditional(2);
		
		enterSupplierAddress(elements);
		enterSupplierPurchasingControl(elements);
		enterSupplierTaxDetails(elements);
		enterSupplierLedgerControlDetails(elements);
		enterPOPControlDetails();
	}
	
	/**
	 * Enter supplier address
	 * @param elements
	 */
	public void enterSupplierAddress(List<String> elements){
		log.info("Enter suppler address details");
		WaitHelper.waitAdditional(4);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject.LABEL)).click();//Address
		WaitHelper.waitAdditional(5);
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[2]"))).click().
		sendKeys(elements.get(4)).build().perform();//Address number
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[4]"))).click().
		sendKeys(elements.get(5)).build().perform();//Address line 1
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[5]"))).click().
		sendKeys(elements.get(6)).build().perform();//Address line 2 
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[6]"))).click().
		sendKeys(elements.get(7)).build().perform();//Address line 3
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[7]"))).click().
		sendKeys(elements.get(8)).build().perform();//Address line 4
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[10]"))).click().
		sendKeys(elements.get(9)).build().perform();//Post Code 
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[11]"))).click().
		sendKeys(elements.get(10)).build().perform();//Phone Number
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[12]"))).click().
		sendKeys(elements.get(11)).build().perform();//Telex Number
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[13]"))).click().
		sendKeys(elements.get(12)).build().perform();//Fax Number
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[14]"))).click().
		sendKeys(elements.get(13)).build().perform();//Contact Name
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[14]"))).click().
		sendKeys(Keys.ENTER).build().perform();//Contact Name
		WaitHelper.waitAdditional(6);
	}
	
	/**
	 * Enter supplier purchasing control
	 * @param elements
	 */
	private void enterSupplierPurchasingControl(List<String> elements){

		log.info("Enter PM control details");
		WaitHelper.waitAdditional(8);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TEN+pObject.LABEL)).click();//Pur control
		if(getDriver().findElement(By.id(pObject.ZERO_+pObject.TEN+pObject.LABEL)).getText().equals("Pur Cntrl")){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.TEN+pObject.LABEL)).click();//Pur control
		}
		
		WaitHelper.waitAdditional(8);
		
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.FIRST_TAB)).click();//Processing tab
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR)).sendKeys(elements.get(14));//Category code
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();//Discounts defaults tab
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FOUR)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.FOUR)).sendKeys(elements.get(15));//Discount terms
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.EIGHT)).clear();
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.EIGHT)).sendKeys(elements.get(16));//Settlement terms
		if(!getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.THREE+pObject._ZERO)).isSelected()){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.THREE+pObject._ZERO)).click();//Supplier discount
		}
		if(!getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.SEVEN+pObject._ZERO)).isSelected()){
			getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.SEVEN+pObject._ZERO)).click();//Always take
		}
		WaitHelper.waitAdditional(3);
	}
	
	/**
	 * Enter supplier tax details
	 * @param elements
	 */
	private void enterSupplierTaxDetails(List<String> elements){
		log.info("Enter supplier tax details");
		WaitHelper.waitAdditional(4);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject.ONE+pObject.LABEL)).click();//TAX
		
		WaitHelper.waitAdditional(5);
		
		Actions builder = new Actions(driver);	
		WaitHelper.waitAdditional(4);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[2]"))).click().
		sendKeys(elements.get(17)).build().perform();//Location
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[3]"))).click().
		sendKeys(elements.get(18)).build().perform();//Registration
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[4]"))).click().
		sendKeys(elements.get(19)).build().perform();//Tax type
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[5]"))).click().
		sendKeys(elements.get(20)).build().perform();//Tax code
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[6]"))).click().
		sendKeys(elements.get(21)).build().perform();//Handling code
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[8]"))).click().
		sendKeys(elements.get(22)).build().perform();//Default
		WaitHelper.waitAdditional(3);
		builder.moveToElement(driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[8]"))).click().
		sendKeys(Keys.ENTER).build().perform();//Default
		WaitHelper.waitAdditional(6);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.EIGHT+pObject.LABEL)).click();//Pur cntrl button
		WaitHelper.waitAdditional(5);
	}
	
	/**
	 * Enter suppler ledger control details
	 * @param elements
	 */
	private void enterSupplierLedgerControlDetails(List<String> elements){
		log.info("Enter AP control details");
		WaitHelper.waitAdditional(5);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SIX+pObject.TWO+pObject.LABEL)).click();//AP Control
		
		WaitHelper.waitAdditional(5);		
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.FIRST_TAB)).click();//Supplier tab
		WaitHelper.waitAdditional(5);		
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.TWO)).clear();
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.TWO)).sendKeys(elements.get(23));//Authorisation Code
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.SEVEN)).sendKeys(elements.get(24));//Self Assessed Tax
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.NINE)).sendKeys(elements.get(25));//Turnover
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.ONE)).sendKeys(elements.get(26));//Invoice Payment
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();//Payment tab
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.ZERO)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject	.TWO+pObject.ZERO)).sendKeys(elements.get(27));//Method
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.ONE)).sendKeys(elements.get(28));//Code
		
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.THIRD_TAB)).click();//Payment tab
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.THREE+pObject.FOUR+pObject._FIRST)).click();//Retain net
		WaitHelper.waitAdditional(3);
	}
	
	/**
	 * Enter POP control details
	 */
	private void enterPOPControlDetails(){
		log.info("Enter POP control details");
		WaitHelper.waitAdditional(4);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.FOUR+pObject.SEVEN+pObject.LABEL)).click();//PM Control		
		WaitHelper.waitAdditional(5);
		
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.FIRST_TAB)).click();//Order details tab
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.SIX+pObject._FIRST)).click();//EDI Orders
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.ONE+pObject.ONE+pObject._ZERO)).click();// Not Maintaine
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.TAB_STRIP+pObject.SECOND_TAB)).click();//Tolerance tab
		WaitHelper.waitAdditional(2);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.ONE)).clear();
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.ONE)).click();///Tolerance amount
		WaitHelper.waitAdditional(1);
		getDriver().findElement(By.id(pObject.ZERO_+pObject.TWO+pObject.TWO+pObject._ZERO)).click();//Miscellaneous Invoice Charges
		WaitHelper.waitAdditional(3);
	}
	
	/**
	 * Click on Address
	 */
	public void clickOnAddress(){
		log.info("Click on address button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb2 : wbs1){
			if(wb2.getText().equals("Address")){
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}
	
	/**
	 * Click on PUR control
	 */
	public void clickOnPurControl(){
		log.info("Click on Pur Cntrl button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb2 : wbs1){
			if(wb2.getText().equals("Pur Cntrl")){
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}
	
	/**
	 * Click on PM control
	 */
	public void clickOnPMControl(){
		log.info("Click on PM Cntrl button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb2 : wbs1){
			if(wb2.getText().equals("PM Cntrl")){
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}
	
	/**
	 * Click on AP control
	 */
	public void clickOnAPControl(){
		log.info("Click on AP Cntrl button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb2 : wbs1){
			if(wb2.getText().equals("AP Cntrl")){
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}
	
	/**
	 * Click on Tax
	 */
	public void clickOnTax(){
		log.info("Click on Tax button");
		WaitHelper.waitAdditional(2);
		List<WebElement> wbs1 = getDriver().findElements(By.className(pObject.TOP_HEADER_TAB_BTN));
		for(WebElement wb2 : wbs1){
			if(wb2.getText().equals("Tax")){
				wb2.click();
				break;
			}
		}
		WaitHelper.waitAdditional(3);
	}
	
	public void getUserNameTextBox(){
		log.info("Inside get username text box method");
		WaitHelper.waitAdditional(2);
//		WebElement wb = getDriver().findElement(By.cssSelector("input[name='USR_field_0'][type='text']"));
		WebElement wb = getDriver().findElement(By.cssSelector("input[name[contains(text(),'USR_field_0')]][type='text']"));
		
		wb.sendKeys("T66");
		
	}
	
	public void createLearner(String uName,String pwd) throws InterruptedException{
		getDriver().findElement(By.id("UserName")).sendKeys(uName);//"PaChand1");
		getDriver().findElement(By.id("Password")).sendKeys(pwd);//("299@CaP010458");
		getDriver().findElement(By.id("loginbtn")).click();
		Thread.sleep(3000);
	}
	
	public void createLearner12() throws InterruptedException{
	
		getDriver().get("https://perf.progresso.net/LearnerRecord/LearnerList");
		getDriver().findElement(By.linkText("Add")).click();
		Thread.sleep(1000);
		
		for(int i=70;i<=100;i++){
			

//			driver.get("https://perf.progresso.net/LearnerRecord/LearnerList");
//			driver.findElement(By.linkText("Add")).click();
		
			getDriver().findElement(By.id("ETS2001")).sendKeys("abc");
			getDriver().findElement(By.id("ETS2004")).sendKeys("efg");
			getDriver().findElement(By.id("ETS2007")).sendKeys("14512"+i);
			getDriver().findElement(By.id("ETS2003")).sendKeys("13/08/2000");
			
			getDriver().findElement(By.xpath(".//*[@id='dvActionbtnArea']/div[3]/div[2]")).click();
			Thread.sleep(2000);
			
			getDriver().findElement(By.id("okatag")).click();
			Thread.sleep(2000);
			
			getDriver().findElement(By.xpath(".//*[@id='fourthNavItemPersonal']/div[2]/a")).click();
			Thread.sleep(2000);
			
			WebElement gender=getDriver().findElement(By.id("ETS3017"));
			Select selectgender=new Select(gender);
			selectgender.selectByVisibleText("Female");
			
			getDriver().findElement(By.id("SectionHeader3")).click();
			
			getDriver().findElement(By.id("ETS3025")).sendKeys("05/09/2011");
			
			WebElement course=getDriver().findElement(By.id("ETS3028"));
			Select selectcourse=new Select(course);
			selectcourse.selectByVisibleText("Key Stage 4");
			Thread.sleep(2000);
			
			WebElement year=getDriver().findElement(By.id("ETS3030"));
			Select selectyear=new Select(year);
			selectyear.selectByVisibleText("Year 10");
			Thread.sleep(2000);
			
			WebElement ncyear=getDriver().findElement(By.id("ETS3026"));
			Select selectNCyear=new Select(ncyear);
			selectNCyear.selectByVisibleText("Year 10");
			Thread.sleep(2000);
			
			getDriver().findElement(By.xpath(".//*[@id='dvActionbtnArea']/div[3]/div[2]")).click();
			Thread.sleep(2000);
			
			getDriver().findElement(By.id("okatag")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id='modalcontent']/div/div[2]/div/div[1]/div[2]/a")).click();
		    Thread.sleep(2000);
			
			getDriver().findElement(By.id("okatag")).click();
			
			Thread.sleep(2000);
			getDriver().findElement(By.linkText("Add")).click();
		}
	}
	
	
	
	
	
	public void createLearner45() throws InterruptedException{
		
		getDriver().get("https://perf.progresso.net/LearnerRecord/LearnerList");
		getDriver().findElement(By.linkText("Add")).click();
		Thread.sleep(1000);
		
		for(int i=70;i<=100;i++){
			

//			driver.get("https://perf.progresso.net/LearnerRecord/LearnerList");
//			driver.findElement(By.linkText("Add")).click();
		
			getDriver().findElement(By.id("ETS2001")).sendKeys("xcbc");
			getDriver().findElement(By.id("ETS2004")).sendKeys("efg");
			getDriver().findElement(By.id("ETS2007")).sendKeys("14542"+i);
			getDriver().findElement(By.id("ETS2003")).sendKeys("13/08/2000");
			
			getDriver().findElement(By.xpath(".//*[@id='dvActionbtnArea']/div[3]/div[2]")).click();
			Thread.sleep(2000);
			
			getDriver().findElement(By.id("okatag")).click();
			Thread.sleep(2000);
			
			getDriver().findElement(By.xpath(".//*[@id='fourthNavItemPersonal']/div[2]/a")).click();
			Thread.sleep(2000);
									
//			getDriver().findElement(By.id("ETS3001")).sendKeys("xcbcz");
//			Thread.sleep(2000);
			
			WebElement gender=getDriver().findElement(By.id("ETS3017"));
			Select selectgender=new Select(gender);
			selectgender.selectByVisibleText("Female");
			
			Thread.sleep(1000);
			
			getDriver().findElement(By.id("SectionHeader3")).click();
			Thread.sleep(1000);			
			
			getDriver().findElement(By.id("ETS3025")).sendKeys("05/09/2011");
			Thread.sleep(1000);
			
			WebElement course=getDriver().findElement(By.id("ETS3028"));
			Select selectcourse=new Select(course);
			selectcourse.selectByVisibleText("Key Stage 4");
			Thread.sleep(2000);
			
			WebElement year=getDriver().findElement(By.id("ETS3030"));
			Select selectyear=new Select(year);
			selectyear.selectByVisibleText("Year 10");
			Thread.sleep(2000);
			
			WebElement ncyear=getDriver().findElement(By.id("ETS3026"));
			Select selectNCyear=new Select(ncyear);
			selectNCyear.selectByVisibleText("Year 10");
			Thread.sleep(2000);
			
			getDriver().findElement(By.xpath(".//*[@id='dvActionbtnArea']/div[3]/div[2]")).click();
			Thread.sleep(2000);
			
			getDriver().findElement(By.id("okatag")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id='modalcontent']/div/div[2]/div/div[1]/div[2]/a")).click();
		    Thread.sleep(2000);
			
			getDriver().findElement(By.id("okatag")).click();
			
			Thread.sleep(2000);
			getDriver().findElement(By.linkText("Add")).click();
		}
	}
	
	
/*--------------------------------PHASE I ADDITIONAL METHODS BY CHETNA----------------------------------------------------------------*/
	
	/**
	 * List of Tabs based on ClassName
	 */
	
	
private List<WebElement> getTab()
	{
		return getDriver().findElements(By.className("ui-tabs-anchor"));
	}


/**
 * Click on Any Tab Based on Tabname and action
 */
	
public boolean ClickOnAnyTab(String TabName, int action)
{
 	boolean isDisplayed = false;
	List<WebElement> listOfTabs = getTab();
	for(WebElement tab : listOfTabs)
 {
	if(tab.getText().equals(TabName))
  {
   if(tab.isDisplayed())
   {
    if(action == 0)
    {
     isDisplayed = true;
    }
    else
    { 
     tab.click();
    }
    
    break;
   }    
  }   
 } 
 return isDisplayed;
}	

/**
 * Verify Secondary Details Tab Selected
 * @return true
 */
public boolean isSecondaryDetailsTabSelected(){
	return GetSecondaryDetailsTab().isSelected();
}	

	private WebElement GetSecondaryDetailsTab(){
	return getDriver().findElement(By.xpath(pObject.A022_SECND_TAB));
}

public void clickOnSecondaryDetailsTab(){

	getDriver().findElement(By.xpath(pObject.A022_SECND_TAB)).click();
}




/**
 * Verify Message Toolbar displayed or not
 */

public boolean IsMessageToolBarDisplayed(){
	boolean messageToolBar = false;
	try{
	if(getDriver().findElement(By.xpath(pObject.AllPG_MSG_TOOLBAR)).isDisplayed())
	{
		messageToolBar = true;
	}

	}
	catch(NoSuchElementException e){
		messageToolBar = false;
	}
	return messageToolBar;
}

/**
 * Amend Fiscal Calender
 * 
 */




public boolean verifyEventsForLevel(String value)
	
	{
		WaitHelper.waitAdditional(2);
		log.info("Verify presence of Event value in the Row");
		boolean EventValue = false;
		List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.A013_EVENT_LVL));
		for(WebElement wb : wbs){
			if(wb.getText().contains(value))
			
			{
				EventValue = true;
				break;
			}
		}
		return EventValue;
	}

public void zoomIn(){
	  //To zoom In page 2 tim = 80% using CTRL and + keys.
	  for(int i=0; i<2; i++)
	  {   
	  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.ADD);
	  }
	 }
	 
	 public void zoomOut(){
	  //To zoom out page 2 time using CTRL and - keys.
	  for(int i=0; i<2; i++){
		 driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.SUBTRACT);
//	   driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  }
	 }

	 
//For A035 Oracle Database Related Process
	 
		public int getProcessorCountOracle(){
			log.info("Get process count");
			int dspatcherCnt = 0;
			try {
				dspatcherCnt = OdbQuery.getProcessCountOracle();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (SeleniumDaoException e) {
				e.printStackTrace();
			}
			log.info("dispatcherCount : " +dspatcherCnt);
			WaitHelper.waitAdditional(2);
			return dspatcherCnt;
		}
		
		public void updateHoldFlagOracle(){
			log.info("Update Hold flag");
			try {
				OdbQuery.updateHoldFlagOracle();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (SeleniumDaoException e) {
				e.printStackTrace();
			}
			WaitHelper.waitAdditional(2);
			log.info("Preocess is updated.");
		}
		
		public String getProcessDetailsOracle(String process,String request){
			log.info("Get process details");
			WaitHelper.waitAdditional(2);
			String stat = null;
			try {
				stat = OdbQuery.getStatProcessOracle(process,request);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (SeleniumDaoException e) {
				e.printStackTrace();
			}
			log.info("stat value :" +stat);
			WaitHelper.waitAdditional(2);
			return stat;
		}
		
		public void updateProcessOracle(String process,String request){
			log.info("Update process");
			try {
				OdbQuery.updateProcessOracle(process,request);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (SeleniumDaoException e) {
				e.printStackTrace();
			}
			WaitHelper.waitAdditional(3);
			log.info("Preocess is updated.");
		}
		
		public void testingOracle(){
			log.info("Testing");
			try {
				OdbQuery.checkProcessOracle();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (SeleniumDaoException e) {
				e.printStackTrace();
			}
			WaitHelper.waitAdditional(3);
			log.info("Preocess is updated.");
			
		}
		

		public boolean selectStruValue(String value) 
		
		{
			log.info("Select Structure method");
			
			boolean update = false;
			
			List<WebElement> wbs = getDriver().findElements(By.xpath(pObject.A035_GLSTRUCT));
			for(WebElement wb : wbs){
				if(wb.getText().contains(value))
						{
					wb.click();
					break;
				
					
						}
				update = true;
			}
			
			return update;
		}
		
/*--------------------------------PHASE II ADDITIONAL METHODS BY CHETNA----------------------------------------------------------------*/		
		
		
		
	 
}

