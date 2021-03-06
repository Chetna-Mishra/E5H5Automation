package com.adv.qa.selenium.framework.pageObjects;

public class PageObjects {
	public final String ZERO = "0";
	public final String ONE = "1";
	public final String TWO = "2";
	public final String THREE = "3";
	public final String FOUR = "4";
	public final String FIVE = "5";
	public final String SIX = "6";
	public final String EIGHT = "8";
	public final String SEVEN = "7";
	public final String NINE = "9";
	public final String TEN = "10";
	public final String _ = "_";	
	public final String LABEL = "_label";	
	public final String CURRENCY_PANE = "dijitContentPane";
//	public final String SECTION_LAYOUT = "dijitTitlePaneTextNode";
	public final String SECTION_LAYOUT = "html_TitlePaneTitle";
//	public final String CURRENCY_TABLE_CELL = "dojoxGridCell";
//	Use A001A_CURRENCY_TABLE_CELL for CURRENCY_TABLE_CELL
//	public final String XDJ_COLUMN_DEF = "0_tabPaneId_2";
	public final String XDJ_COLUMN_DEF = "ui-id-12";
	public final String XDJ_DEFINITION_DEF = "0_tabPaneId_5";
	public final String HEADER_TAB_BTN = "roundedbutton";
	public final String TOP_HEADER_TAB_BTN = "dijitReset";
//	public final String COLUMN_DEFINITION_LABEL = "0_tabbedPanel_1_tablist_0_tabPaneId_2";
//	public final String DEFINITION_DEF_LABEL = "0_tabbedPanel_1_tablist_0_tabPaneId_5";
	public final String COMPANY_EDIT_TABLE = "0_tabbedPanel_1";
	public final String FIRST_TAB = "0_tabPaneId_1";
//  Use  for A006_PRIMARY_TAB FOR FIRST_TAB
	public final String SECOND_TAB = "0_tabPaneId_2";
	public final String THIRD_TAB = "0_tabPaneId_3";
	public final String FOURTH_TAB = "0_tabPaneId_4";
	public final String FIFTH_TAB = "0_tabPaneId_5";
	public final String SIXTH_TAB = "0_tabPaneId_6";
	public final String SEVENTH_TAB = "0_tabPaneId_7";
	public final String EIGHTH_TAB = "0_tabPaneId_8";
	public final String NINTH_TAB = "0_tabPaneId_9";
	public final String TAB = "0_tabPaneId_";
	public final String TAB_STRIP= "0_tabbedPanel_1_tablist_";
	public final String CHECK = "chk_";
	public final String SIX_ = "6_";
	public final String TWO_= "2_";
	public final String ZERO_ = "0_";
	public final String _ZERO = "_0";
	public final String _FIRST = "_1";
	public final String _TWO = "_2";
	public final String FOUR_ = "4_";
	public final String ABOUT_TO_SUBMIT = "dojoxFloatingPaneTitle";
	public final String MESSAGE_NODE_LABEL = "msgnode_label";
//	Use AllPG_MSG_BUTTON_LABEL for MESSAGE_NODE_LABEL
	public final String TOOL_TIP_CONTENT = "msgtooltip";
//	Use AllPG_MSG_TOOLBAR for TOOL_TIP_CONTENT
	public final String PAGE_NAME = "action_0";
	public final String NEW_TOP_HEADER_TAB_BTN = "roundedbutton";
//	Use AllPG_HeaderSection for NEW_TOP_HEADER_TAB_BTN
	
	
//	Top Most Section common Application Menus
	public final String TPMN_EXIT = "//div/span[starts-with(@id,'dijit_PopupMenuBarItem')][text()='Exit']";
	public final String TPMN_SELECTION = "//div/span[starts-with(@id,'dijit_PopupMenuBarItem')][text()='Selection']";
	public final String TPMN_CHANGE = "//div/span[starts-with(@id,'dijit_PopupMenuBarItem')][text()='Change']";
	public final String TPMN_DIARY = "//div/span[starts-with(@id,'dijit_PopupMenuBarItem')][text()='Diary']";
	public final String TPMN_FUNCTIONS = "//div/span[starts-with(@id,'dijit_PopupMenuBarItem')][text()='Functions']";
	public final String TPMN_SESSION = "//div/span[starts-with(@id,'dijit_PopupMenuBarItem')][text()='Session']";
	
		
//	Common Buttons on All pages
	
	public final String AllPG_HeaderSection = "//button[contains(@class,'roundedbutton')]/span";
	public final String AllPG_MSG_TOOLBAR= "//span[contains(@class,'toolbarMessages')]";
	public final String AllPG_MSG_BUTTON_LABEL=	"//button[@name='msgnode']/span[contains(@class,'ButtonLabel')]";
	public final String All_SEARCH_MSG_TOOLBAR=	"//div[contains(@class,'errorLine')]";
	
	public final String AllPG_CANCEL = "//button[starts-with(@class,'roundedbutton')][@value='Cancel']";
	public final String AllPG_EXIT = "//button[starts-with(@class,'roundedbutton')][@value='Exit']";
	public final String AllPG_BKWD = "//button[starts-with(@class,'roundedbutton')][@value='Bkwd']";
	public final String AllPG_REFRESH = "//button[starts-with(@class,'roundedbutton')][@value='Refresh']";
	public final String AllPG_MORE = "//button[starts-with(@class,'roundedbutton')][@value='More']";
	public final String AllPG_AMEND = "//button[starts-with(@class,'roundedbutton')][@value='Amend']";
	public final String AllPG_VIEW = "//button[starts-with(@class,'roundedbutton')][@value='View']";
	public final String AllPG_INSERT = "//button[starts-with(@class,'roundedbutton')][@value='Insert']";
	public final String AllPG_COPY = "//button[starts-with(@class,'roundedbutton')][@value='Copy']";
	public final String AllPG_PAPERCLIP = "//button[starts-with(@class,'roundedbutton')][@value='Paperclip']";
	public final String AllPG_FUNCTION_HISTORY = "//button[starts-with(@class,'roundedbutton')][@value='Functions History']";
	public final String AllPG_FUNCTION_SEARCH = "//button[starts-with(@class,'roundedbutton')][@value='Functions Search']";
	public final String AllPG_FAVOURITE_ENQUIRIES = "//button[starts-with(@class,'roundedbutton')][@value='Favourite Enquiries']";
	public final String AllPG_CODE_SWITCH = "//button[starts-with(@class,'roundedbutton')][@value='Code Switch']";
	public final String AllPG_PROMPT = "//button[starts-with(@class,'roundedbutton')][@value='Prompt']";
	public final String AllPG_HELP = "//button[starts-with(@class,'roundedbutton')][@value='Help']";
	
	public final String AllPG_INSERT1 = "//button[starts-with(@class,'roundedbutton')][@name='action_503']";
	public final String AllPG_CANCEL1 = "//button[starts-with(@class,'roundedbutton')][@name='action_998']";
	public final String AllPG_AMEND1 = "//button[starts-with(@class,'roundedbutton')][@name='action_502']";
	
//	public final String AllPG_EXIT = "//button[starts-with(@class,'roundedbutton')][@name='action_942']";
//	
//	public final String AllPG_FWD = "//button[starts-with(@class,'roundedbutton')][@name='action_960']";
//	public final String AllPG_BKWD = "//button[starts-with(@class,'roundedbutton')][@name='action_961']";
//	public final String AllPG_REFRESH = "//button[starts-with(@class,'roundedbutton')][@name='action_943']";
//	public final String AllPG_MORE = "//button[starts-with(@class,'roundedbutton')][@name='action_947']";
//	public final String AllPG_AMEND = "//button[starts-with(@class,'roundedbutton')][@name='action_502']";
//	public final String AllPG_VIEW = "//button[starts-with(@class,'roundedbutton')][@name='action_501']";
//	public final String AllPG_COPY = "//button[starts-with(@class,'roundedbutton')][@name='action_504']";
//	public final String AllPG_HIREACHI = "//button[starts-with(@class,'roundedbutton')][@name='action_56']";
//	public final String AllPG_PAPERCLIP = "//button[starts-with(@class,'roundedbutton')][@name='action_0']";
//	public final String AllPG_PER_QUERY = "//button[starts-with(@class,'roundedbutton')][@name='action_949']";
//	public final String AllPG_FAVOURITE_ENQUIRIES = "//button[starts-with(@class,'roundedbutton')][@name='action_924']";
//	public final String AllPG_DISABLD_SWI = "//button[starts-with(@class,'roundedbutton')][@name='action_959']";
//	public final String AllPG_CODE_SWITCH = "//button[starts-with(@class,'roundedbutton')][@name='action_958']";
//	public final String AllPG_PROMPT = "//button[starts-with(@class,'roundedbutton')][@name='action_950']";
//	public final String AllPG_HELP = "//button[starts-with(@class,'roundedbutton')][@name='action_980']";
//	
//	public final String AllPG_FUNCTION_HISTORY = "//button[starts-with(@class,'roundedbutton')][@value='Functions History']";
//	public final String AllPG_FUNCTION_SEARCH = "//button[starts-with(@class,'roundedbutton')][@value='Functions Search']";
	

	
//	Common Footer Buttons on All pages
	
	public final String AllPG_FOOT_SEC = "//button[starts-with(@class,'button roundedbutton')]";
	
//Exit Confirmation Message Page Objects
	
	public final String CONF_BUT_YES = "//div[contains(@class,'roundedCorners')]/button[@value='Yes']";
	
		
//	Login Page Objects
	public final String LOGIN_USER_NAME = "//input[starts-with(@name,'USR_')]";
	public final String LOGIN_PASSWORD = "//input[starts-with(@name,'PSWD_')]";
	public final String LOGIN_NWPASSWORD = "//input[starts-with(@name,'NEW-PSWD_')]";
	public final String LOGIN_SIGNIN = "//button[@value='Sign in']";
			
		
//	Command prompt Page objects
	public final String CMD_COMMAND = "//fieldset/legend[text()='Command']/..//input[contains(@name,'COMMAND')]";
	public final String CMD_OK = "//div/button[contains(@class,'button roundedbutton')][@value='OK']";
	public final String CMD_PROMPT = "//div/button[contains(@class,'button roundedbutton')][@value='Prompt']";
	public final String CMD_CHANGE_COMPANY_ROLE = "//div/button[contains(@class,'button roundedbutton')][@value='Change Company / Role']";
	public final String CMD_CANCEL = "//div/button[contains(@class,'button roundedbutton')][@value='Cancel']";
		
	
//	Page Objects for "A001_Switch_Intra_Company_Accounting_OnTest"
	
	public final String A001_FINANCIAL_MODULE_TAB ="//a[contains(@class,'ui-tabs-anchor')]/following::a[text()='Financial Modules']";
	
	public final String A001_GENERAL_LEDGER="//fieldset/legend[text()='E5 Modules Available']/..//label[text()='General Ledger']/../input[1]";
	public final String A001_INTRA_COMPANY_ACCOUNTING="//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Intra Company Accounting']/../input[1]";
	public final String A001_AVERAGE_DAY_BALANCE="//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Average Days Balance']/../input[1]";
	public final String A001_VALUE_DATED_ACCOUNTING="//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Value Dated Accounting']/../input[1]";
	public final String A001_COMM_ACCOUNTING="//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Commitment Accounting']/../input[1]";
	public final String A001_TIME_RECO="//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Timesheet Recording']/../input[1]";
	public final String A001_JOB_BIL="//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Job Billing']/../input[1]";
	
	public final String A001_PROJECT_TRACKING="//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Project Tracking']/../input[1]";
	public final String A001_BANK_REC="//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Bank Reconciliation']/../input[1]";
	public final String A001_DRIECT="//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Direct Debit Mandates']/../input[1]";
	public final String A001_PROPS_MNGT="//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Proposed Project Management']/../input[1]";
	public final String A001_FIXD_ASS="//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Fixed Assets']/../input[1]";
	public final String A001_LEAS="//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Leasing']/../input[1]";
	
	public final String A001_PURCHASING_MODULE_TAB ="//a[contains(@class,'ui-tabs-anchor')]/following::a[text()='Purchasing Modules']";
	public final String A001_ACCOUNTS_PAYABLE="//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Accounts Payable']/../input[1]";
	public final String A001_cISEDI="//fieldset/legend[text()='E5 Modules Available']/..//label[text()='CIS EDI']/../input[1]";
	public final String A001_SER_LDGR="//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Service Ledger']/../input[1]";
	public final String A001_PURCHASING_MANAGEMENT="//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Purchasing Management']/../input[1]";
	public final String A001_INVENTORY_MANAGEMENT="//fieldset/legend[text()='E5 Modules Available']/..//label[text()='Inventory Management']/../input[1]";
	public final String A001_IN_FLIGHT="//fieldset/legend[text()='E5 Modules Available']/..//label[text()='In Flight Direct Operating Costs']/../input[1]";
	
//	Page Objects for "A001A_On_line_AuditingTest"
	public final String A001A_NAV_BAR = "//div[contains(@class,'navbar')]/..//div[contains(@class,'variantHeader')]";
	public final String A001A_TABLE = "//div/input[starts-with(@name,'PARAM-ENTY_')]";
	
	public final String A001A_CURRENCY_TABLE_CELL = "//td[starts-with(@class,'dojoxGridCell')]";
	public final String A001A_COLUMN_DEFINATION_TAB = "//a[@class='ui-tabs-anchor'][text()='Column Definition']";
	public final String A001A_DEFINATION_DEF_TAB = "//a[@class='ui-tabs-anchor'][text()='Definition Defn.']";
	public final String A001A_OK = "//button[contains(@class,'roundedbutton')][@value='OK']";
	
	public final String A001A_AUDIT = "//label[text()='Audit']/../input[1]";
	public final String A001A_SUPP_AUDIT = "//label[text()='Support Auditing']/../input[1]";
	
	public final String A001A_AUD_KEPT="//input[starts-with(@name,'AUDT-KEEP-NUM_')]";
	public final String A001A_PROC_LVL = "//input[starts-with(@name,'PROC-LVL_')]";
		
//Page Objects for "A002_Currency_DescriptionTest"
	public final String A002_CURRENCY = "//input[contains(@name,'CURR_')]";
	public final String A002_OK ="//button[contains(@class,'roundedbutton')][@value='OK']";
	public final String A002_DESCRIPTION = "//input[contains(@name,'DESCR_')]";
	public final String A002_DECIMAL_P = "//input[contains(@name,'DECMLP_')]";
	public final String A002_UNIT = "//input[contains(@name,'UNIT_')]";
	public final String A002_UNITS = "//input[contains(@name,'UNITS_')]";
	public final String A002_SUN_UNIT = "//input[contains(@name,'SUB-UNIT_')]";
	public final String A002_SUN_UNITS = "//input[contains(@name,'SUB-UNITS_')]";
	public final String A002_EMU_IND ="//select[contains(@name, 'EMU-IND_')]";
	
	
	
	public final String A002_FIXED_RATE ="//input[contains(@name,'FIXED-XRATE_')]";
	public final String A002_DATE_OF_ENTRY ="//input[contains(@name,'datefield_')]";
	public final String A002_ROUNDING_IND ="//select[contains(@name,'RNDG-IND_')]";
	
	
	//Page Objects for "A003_Currency_Base_NonBase_RelationshipsTest"

	
	public final String A003_BASE_CURR = "//input[starts-with(@name,'PARAM-BASE-CURR')]";
	public final String A003_NONBASE_CURR= "//input[starts-with(@name,'PARAM-NBASE-CURR')]";
	public final String A003_DIRECTION = "//select[starts-with(@name,'CONV-DRCTN_')]";	
	public final String A003_CONVERSION_UNIT = "//input[starts-with(@name,'CONV-UNITS_')]";
	public final String A003_TOLERANCE_PERC = "//input[starts-with(@name,'TOL-PERC_')]";
	public final String A003_TOLERANCE_AMT = "//input[starts-with(@name,'TOL-AMOUNT_')]";
	public final String A003_BASE_CURR_IN = "//input[starts-with(@name,'BASE-CURR_')]";
	public final String A003_NONBASE_CURR_IN= "//input[starts-with(@name,'NON-BASE-CURR_')]";
	
	
	//Page Objects for "A004_Currency_Exchange_Rate_TypesTest"
	
	public final String A004_RATE_TYPE = "//input[starts-with(@name,'RATE-TYPE')]";
	
	
	//Page Objects for "A004A_Rate_Type_Currency_ExchangeTest"
	public final String A004A_DESCR ="//input[starts-with(@name,'DESCR')]";
	
	
	//Page Objects for "A005_Currency_Exchange_RatesTest"
	public final String A005_RATE_TYPE ="//input[starts-with(@name,'PARAM-RATE-TYPE')]";
	public final String A005_EXCHANGE_RATE="//input[starts-with(@name,'EXCH-RATE')]";
	public final String A005_TOLERANCE_PER="//input[starts-with(@name,'TOL-PERC')]";
	public final String A005_TOLERANCE_AMT="//input[starts-with(@name,'TOL-AMOUNT')]";
	
	//Page Objects for "A006_Company_DefinitionTest"
	
//	public final String A006_PRIMARY_TAB = "//a[@class='ui-tabs-anchor'][text()='Primary Details']";
	public final String A006_PRIMARY_TAB = "//ul/li/a[@class='ui-tabs-anchor'][text()='Primary Details']";
	public final String A006_COMPANY = "//input[starts-with(@name,'CMPY_')]";
	public final String A006_NAME = "//input[starts-with(@name,'ADDR-NAME_')]";
	public final String A006_ADDR1 ="//input[starts-with(@name,'ADDR1_')]";
	public final String A006_ADDR2 ="//input[starts-with(@name,'ADDR2_')]";
	public final String A006_ADDR3 ="//input[starts-with(@name,'ADDR3_')]";
	public final String A006_ADDR4 ="//input[starts-with(@name,'ADDR4_')]";
	public final String A006_ADDR5 ="//input[starts-with(@name,'ADDR5_')]";
	public final String A006_ADDR6 ="//input[starts-with(@name,'ADDR6_')]";
	public final String A006_PSOT_CODE=	"//input[starts-with(@name,'POST-CODE_')]";
	public final String A006_TEL =	"//input[starts-with(@name,'TEL_')]";
	public final String A006_FAX ="//input[starts-with(@name,'FAX_')]";
	public final String A006_TELEX = "//input[starts-with(@name,'TELEX_')]";
	public final String A006_REG_NUM = "//input[starts-with(@name,'REG-NUM_')]";
	
	public final String A006_CURRENCY_EC_TAB = "//a[@class='ui-tabs-anchor'][text()='Currency/EC Intrastat']";
									
	public final String A006_EMU_FLAG = "//label[text()='EMU Flag']/../input[1]";
	public final String A006_CURR_FLAG = "//label[text()='Currency Flag']/../input[1]";
	public final String A006_COUNTRY ="//input[starts-with(@name,'CNTRY_')]";
	

	//Page Objects for "A007_DevicesTest"
	
	public final String A007_DEVICE="//input[starts-with(@name,'DEVICE_')]";
	public final String A007_DEFINATION1="//input[starts-with(@name,'DATA-DESCR-01_')]";
	public final String A007_DEFINATION2="//input[starts-with(@name,'DATA-DESCR-02_')]";
	public final String A007_DEFINATION3="//input[starts-with(@name,'DATA-DESCR-03_')]";
	public final String A007_DEFINATION4="//input[starts-with(@name,'DATA-DESCR-04_')]";
	public final String A007_DEFINATION5="//input[starts-with(@name,'DATA-DESCR-05_')]";
	public final String A006_UPPR_CASE ="//label[text()='Upper Case']/../input[1]";
	
	
	//Page Objects for "A008_DestinationsTest"
	public final String A007_DEST= "//input[starts-with(@name,'DEST_')]";
	public final String A007_SPOOL_ONLY = "//div/input[@name='TYPE']/..//label[contains(text(), 'Spool Only')]";
	
	
	//Page Objects for "A009_Distribution_ProfileTest"
	public final String A009_PROFILE ="//input[starts-with(@name,'DSTRP_')]";
	public final String A009_NO_COPIES = "//input[starts-with(@name,'COPIES_')]";
	public final String A009_SUPPR_BANN= "//div/input[@type='checkbox']/..//label[text()='Suppress Banner']/../input[1]";
	
	//Page Objects for "A010_Environment_Groups_Test"
	
	public final String A010_ENV_GRP="//input[starts-with(@name,'ENVR-GRP_')]";
	public final String A010_SESS_TIME="//input[starts-with(@name,'TIME-LIMIT_')]";
	public final String A010_PASS_EXP="//input[starts-with(@name,'PSWD-LIMIT_')]";
	public final String A010_MAX_SESS="//input[starts-with(@name,'SESS-LIMIT_')]";
	public final String A010_PROFILE="//input[starts-with(@name,'DFLT-DSTRP_')]";
	public final String A010_RAD_NORMAL="//div/input[@name='CONV-IND_1'][@value='Normal']";
	
	//Page Objects for "A011_UsersTest"	
	
	public final String A011_SEARCH_USER= "//input[starts-with(@name,'PARAM-USR_')]";
	public final String A011_DEFAULT_CMPNY = "//input[starts-with(@name,'DFLT-CMPY_')]";
	public final String A011_USER1 = "//input[starts-with(@name,'USR_')]";
	public final String A011_MENU	="//input[starts-with(@name,'MENU_')]";
	public final String A011_NON_CMPNY = "//input[starts-with(@name,'SCTY-GRP_')]";
	public final String A011_CMPNY = "//input[starts-with(@name,'SCTY-GRP-CMPY_')]";
	
	public final String A011_REPORT	= "//input[starts-with(@name,'RPRT-SCTY-GRP_')]";
	public final String A011_REPORT_CMPNY = "//input[starts-with(@name,'RPRT-SCTY-CMPY_')]";
	public final String A011_EWS_PRTN = "//input[starts-with(@name,'EWS-PRTN_')]";
	public final String A011_LANG = "//input[starts-with(@name,'LANG_')]";
	
	//Page Objects for "A012_CalendarsTest"
	public final String A012_ACTIVITY= "//input[starts-with(@name,'ACTVT')]";
	public final String A012_TYPE = "//select[starts-with(@name,'ACTVT-TYPE_')]";
	public final String A012_MON = "//fieldset/div[contains(@class,'fieldsetadjustment')]/input[1]";
	public final String A012_TUE = "//fieldset/div[contains(@class,'fieldsetadjustment')]/input[2]";
	public final String A012_WED = "//fieldset/div[contains(@class,'fieldsetadjustment')]/input[3]";
	public final String A012_THU = "//fieldset/div[contains(@class,'fieldsetadjustment')]/input[4]";
	public final String A012_FRI = "//fieldset/div[contains(@class,'fieldsetadjustment')]/input[5]";
	public final String A012_SAT = "//fieldset/div[contains(@class,'fieldsetadjustment')]/input[6]";
	public final String A012_SUN = "//fieldset/div[contains(@class,'fieldsetadjustment')]/input[7]";
	
	public final String A012_O_FREQ = "//input[starts-with(@name,'FREQ')]";
	public final String A012_DAY_OF_WEEK = "//fieldset/div/select[contains(@name,'DD_')]";
//	public final String A012_DAY_OF_WEEK = "//fieldset/div[contains(@class,'fieldsetadjustment')]/select[contains(@name,'DD_')]/option[2]";
//	public final String A012_DAY_OF_WEEK = "//select[@class='textBoxFocused']";
	public final String A012_EVENT_SPECIFIED = "//INPUT[starts-with(@name,'CHILD-ACTVT-W_')]";
	
	
//Page Objects for "A013_Fiscal_CalendarTest", EnterFiscalCalendarDetails

	
	public final String A013_BTM_BUT_SECTION = "//div/button[contains(@class,'button roundedbutton')]";
	public final String A013_CALENDER = "//input[starts-with(@name,'CLNDR_')]";
	public final String A013_YEARS = "//button[starts-with(@class,'button roundedbutton')][@value='Years']";
	public final String A013_EVENTH = "//div/button[contains(@class,'button roundedbutton')][@value='Events (H)']";
	

	public final String A013_WEEKENDDAY = "//div/select[starts-with(@name,'WK-END-DATE_')]";
//	public final String A013_WEEKENDDAY = "//div/select[starts-with(@name,'WK-END-DATE_')]/option";	
//	public final String A013_WEEKENDDAY = "//div/select[starts-with(@name,'WK-END-DATE_')]/option[7]";
//	public final String A013_WEEKENDDAY = "//div[contains(@class,'roundedCorners')]/select[contains(@name,'WK-END-DATE_')]";
	
	public final String A013_LVL_NAME= "//div[1]/table/tbody/tr/td[3]";
	public final String A013_LVL_NAME1= "//div[1]/table/tbody/tr/td[3]/input";
	
	public final String A013_LVL_DESC= "//div[1]/table/tbody/tr/td[4]";	
	public final String A013_LVL_DESC1= "//div[1]/table/tbody/tr/td[4]/input";

	public final String A013_YR_YEAR= "//div[1]/table/tbody/tr/td[2]";	
	public final String A013_YR_YEAR1= "//div[1]/table/tbody/tr/td[2]/input";

	public final String A013_YR_NAME= "//div[1]/table/tbody/tr/td[3]";	
	public final String A013_YR_NAME1= "//div[1]/table/tbody/tr/td[3]/input";
	
	public final String A013_YR_START= "//div[1]/table/tbody/tr/td[4]";	
	public final String A013_YR_START1= "//div[1]/table/tbody/tr/td[4]/input";

	public final String A013_YR_END= "//div[1]/table/tbody/tr/td[5]";	
	public final String A013_YR_END1= "//div[1]/table/tbody/tr/td[5]/input";
	public final String A013_START_DATE ="//div/Input[starts-with(@name,'datefield_')]";
	
	public final String A013_ACTIVITY= "//Input[starts-with(@name,'ACTVT-NAME_')]";
	public final String A013_EVENT_LVL="//div[1]/table/tbody/tr/td[2]";
	
	
	

//Page Objects for "A014_Account_Code_DefinitionTest1", enterAccountDefinitionDetails
	
	public final String A014_NOMINAL_CODE="//input[starts-with(@name,'NOML-CODE_')]";

	
//	Page Objects for "A015_BalanceSheetTest"
	public final String A015_VERSION=	"//input[starts-with(@name,'FRMAT_')]";
	public final String A015_DESC= "//input[starts-with(@name,'FRMAT-DESC_')]";
	public final String A015_NOM_MAN= "//label[text()='Nominal Mandatory']/../input[1]";
	public final String A015_NOM_BAL_SHEET= "//label[text()='Normal Balance Sheet']/../input[1]";
	
//	Page Objects for "A016_Normal_Balance_Sheet_GroupsTest"
	public final String A016_GRP="//input[starts-with(@name,'GRP_')]";
	public final String A016_PRPT_LS= "//label[text()='Profit and Loss']/../input[1]";
	
	
//	Page Objects for "A016_Normal_Balance_Sheet_GroupsTest"
	
	public final String A017_CATEG="//input[starts-with(@name,'CATEG_')]";
	public final String A017_CATEG_TYPE= "//div/select[starts-with(@name,'CATEG-TYPE_')]";
	

//	Page Objects for "A018_Ledger_Control_Nominals"
	
	public final String A018_CATEG_TYPE= "//input[starts-with(@name,'NOML_')]";
	public final String A018_NOMINAL= "//input[starts-with(@name,'NOML_')]";
	
	public final String A018_NOML_TYPE= "//div/select[starts-with(@name,'TYPE_')]";
	public final String A018_NOML_PST_TYPE= "//div/select[starts-with(@name,'POST-IND_')]";
	public final String A018_MNGT_CODE_REL1 = "//input[starts-with(@name,'MGMT-RLTN-FLAG_')][1]";
	public final String A018_MNGT_CODE_REL2 = "//input[starts-with(@name,'MGMT-RLTN-FLAG_')][2]";
	public final String A018_CURR_CODE= "//input[starts-with(@name,'CURR_')]";
	public final String A018_CURR_PROCESS="//div/select[starts-with(@name,'CURR-PROCESS-IND_')]";
	
	public final String A018_FIN_ALLW = "//label[text()='Financial Allowed']/../input[1]";
	public final String A018_PLN_ALLW = "//label[text()='Planning Allowed']/../input[1]";
	public final String A018_CST_ALLW = "//label[text()='Cost Allocation Allowed']/../input[1]";
	

//	Page Objects for "A019_Ledger_Control_Management_CodeTest"
	public final String A019_MNGT_KEY="//input[starts-with(@name,'PATH-KEY_')]";
	public final String A019_SHRT_NAME="//input[starts-with(@name,'SHORT-NAME_')]";
	public final String A019_FINC = "//label[text()='Financial']/../input[1]";
	public final String A019_PLNG = "//label[text()='Planning']/../input[1]";
	public final String A019_CST_ALC = "//label[text()='Cost Allocation']/../input[1]";
	public final String A019_SUMM_TRANC = "//label[text()='Summarise Transactions']/../input[1]";
	public final String A019_AVG_BLNC = "//label[text()='Average Balances']/../input[1]";
	
	
//	Page Objects for "A020_Ledger_Control_AccountsTest"
	public final String A020_LEDGR_COD ="//input[starts-with(@name,'LEDGR-CNTRL_')]";
	public final String A020_CURR_RND_ACC = "//div/input[starts-with(@name,'subfield')][1]";
	public final String A020_CURR_RND_CST = "//div/input[starts-with(@name,'subfield')][2]";
	public final String A020_CLOS_OUT_ACC = "//div/input[starts-with(@name,'subfield')][4]";
	public final String A020_CLOS_OUT_CST = "//div/input[starts-with(@name,'subfield')][5]";
	public final String A020_JRN_SUSP_ACC = "//div/input[starts-with(@name,'subfield')][7]";
	public final String A020_JRN_SUSP_CST = "//div/input[starts-with(@name,'subfield')][8]";
	
//	Page Objects for "A021_Batch_TypesTest"
	public final String A021_BATCH_TYPE = "//input[starts-with(@name,'BTCH-TYPE_')]";
	public final String A021_LEDR_CTRL_CD = "//input[starts-with(@name,'LEDGR-CNTRL_')]";
	public final String A021_UPDT_IND = "//select[starts-with(@name,'UPDT-IND_')]";
	public final String A021_BS_VALUE = "//label[text()='Base Values']/../input[1]";
	public final String A021_FRN_VALUE = "//label[text()='Foreign Values']/../input[1]";
	public final String A021_BSN_FRN = "//label[text()='Base and Foreign']/../input[1]";
	
//	Page Objects for "A022_Balance_ClassesTest"
	public final String A022_BAL_CLS= "//input[starts-with(@name,'BAL_')]";
	public final String A022_STASTICAL= "//label[text()='Statistical']/../input[1]";
	public final String A022_TRANSATION= "//label[text()='Transaction']/../input[1]";
	public final String A022_ROLL_FLAG = "//label[text()='Roll Flag']/../input[1]";
	public final String A022_PATH = "//input[starts-with(@name,'PATH_')]";
	public final String A022_CALN_TYPE = "//input[starts-with(@name,'CLNDR-LVL_')]";
	public final String A022_SECND_TAB = "//a[@class='ui-tabs-anchor'] [text()='Secondary Details']";
	public final String A022_FRN_CURR ="//label[text()='Foreign Currency']/../input[1]";
	public final String A022_VAT ="//label[text()='VAT']/../input[1]";
	public final String A022_ALW_BTCH_BAL ="//label[text()='Allow Batches Out Of Balance']/../input[1]";
	public final String A022_AVG_DLY_BAL= "//select[starts-with(@name,'ADB-IND_')]";

//	Page Objects for "A023_Balance_ClassesTest"
	public final String A023_CURNT_PER= "//input[starts-with(@name,'CURNT-PER-NUM_')]"; 	
	public final String A023_CURNT_YR="//input[starts-with(@name,'CURNT-YY_')]";
	public final String A023_CNTL_AC_CD ="//input[starts-with(@name,'LEDGR-CNTRL_')]";
	public final String A023_CALDR ="//input[starts-with(@name,'FSCL-CLNDR_')]";
	public final String A023_YR_RNGE_FUTR ="//input[starts-with(@name,'YY-RNGE-FUTR_')]";
	public final String A023_YR_RNGE_HIST ="//input[starts-with(@name,'YY-RNGE-HIST_')]";
	public final String A023_SUMMAR="//input[starts-with(@name,'SUMM-BTCH-TYPE_')]";
	public final String A023_TRANSAC ="//input[starts-with(@name,'CURNT-DD_')]";
	public final String A023_STSCL_BAL ="//input[starts-with(@name,'STSCL-BAL_')]";
	public final String A023_CHK_FINC ="//label[text()='Financial']/../input[1]";
	public final String A023_CHK_CST_ALOC ="//label[text()='Cost Allocation']/../input[1]";
	public final String A023_CHK_AVG_BAL ="//label[text()='Average Balances']/../input[1]";
	public final String A023_CHK_SUMM ="//label[text()='Summarise']/../input[1]";
	public final String A023_CHK_PLANG ="//label[text()='Planning']/../input[1]";
	public final String A023_SUSPN_ACC = "//select[starts-with(@name,'SUSP-ACCT-IND_')]";
	public final String A023_ACCEPT_WAR_OFF="//label[text()='Accept Warnings Off-line']/../input[1]";
	public final String A023_CHK_ACCEPT_WAR_OFF="//label[text()='Accept Warnings Off-line']/../input[1]";
	public final String A023_CHK_TOTL_ON_QTY="//label[text()='Totalling on Quantity']/../input[1]";
	public final String A023_CHK_GNE_BATCH_BAL_RCRD="//label[text()='Generate Batch Balancing Records']/../input[1]";
	public final String A023_CHK_CLS_ACC_LST_YR="//label[text()='Close Accounts for Last Year']/../input[1]";
	public final String A023_CHK_REV_WRIT_FLG="//label[text()='Revaluation Writeoff Flag']/../input[1]";
	public final String A023_CHK_DTA_ENTRY_IMD_UPD="//label[text()='Data Entry Immediate Update']/../input[1]";
	public final String A023_CHK_REC_MSG ="//label[text()='Reconciliation Messages']/../input[1]";
	public final String A023_CHK_DEL_CHK ="//label[text()='Delete Check']/../input[1]";
	public final String A023_ACC_WAR_OFL ="//label[text()='Accept Warnings Off-line']/../input[1]";
	public final String A023_CURR_R_TYPE ="//input[starts-with(@name,'RATE-TYPE_')]";
	public final String A023_RNDG_TOLRN_AMT = "//input[starts-with(@name,'RNDG-TOLRN-AMT_')]";
	public final String A023_RNDG_TOLRN_PERC = "//input[starts-with(@name,'RNDG-TOLRN-PERC_')]";
	public final String A023_CHK_CURR_REV_ALLW = "//label[text()='Currency Revaluation Allowed']/../input[1]";
	public final String A023_CURR_TOL_PROC = "//select[starts-with(@name,'NBASE-TOLRN-IND_')]";
	public final String A023_BTCH_TYPE = "//input[starts-with(@name,'REVAL-BTCH-TYPE_')]";
	
	public final String A023_CHK_ACCT_PAYBL = "//label[text()='Accounts Payable']/../input[1]";
	public final String A023_CHK_ACCT_RECIBL = "//label[text()='Accounts Receivable']/../input[1]";
	public final String A023_CHK_PURC_MNGT = "//label[text()='Purchasing Management']/../input[1]";
	public final String A023_CHK_INV_MNGT = "//label[text()='Inventory Management']/../input[1]";
	public final String A023_CHK_FIX_ASST = "//label[text()='Fixed Assets']/../input[1]";
	public final String A023_CHK_FIX_ASST_LEA = "//label[text()='Fixed Assets Leasing']/../input[1]";
	public final String A023_CHK_ARC_TRAN_INDI = "//label[text()='Archive Transaction Indices']/../input[1]";
	public final String A023_CHK_ARC_UNREC_TRANS = "//label[text()='Archive Unreconciled Transactions']/../input[1]";
		

//	Page Objects for "A024_Batch_TypesTest"
	public final String A024_SECDRY_IND = "//label[text()='Secondary Index']/../input[1]";
	public final String A024_ACCRL= "//select[starts-with(@name,'ACCRL-IND_')]";
	public final String A024_RCCRL= "//select[starts-with(@name,'RECUR-BTCH-IND_')]";
	
//	Page Objects for "A025_FormulaTest"
	public final String A025_FORM = "//input[starts-with(@name,'CALC_')]";
	public final String A025_HEADN = "//input[starts-with(@name,'HEAD_')]";
	public final String A025_CHK_APPY_CURR = "//label[text()='Apply Currency']/../input[1]";
	public final String A025_TOTL_CNTRL= "//select[starts-with(@name,'TOTAL-IND_')]";
	public final String A025_FOR_EXP_LNONE= "//input[starts-with(@name,'CALC-LINE-1_')]";

//	Page Objects for "A026_Layout_CodesTest"
	public final String A026_LAYT= "//input[starts-with(@name,'LYT_')]";
	public final String A026_HIGH_VAL= "//div[1]/table/tbody/tr/td[4]/select[@class='dojoxGridSelect']";
	
	
//	Page Objects for "A027_Default_StructureTest"
	public final String A027_STRUC = "//input[starts-with(@name,'STRUC_')]";
	public final String A027_UNI_ELE_REQ= "//label[text()='Unique Elements Required']/../input[1]";

//	Page Objects for "A028_Default_Structure_ControlsTest"
	public final String A028_PATH_CODE = "//input[starts-with(@name,'PATH_')]";
	public final String A028_SUSP_ELEMNT = "//input[starts-with(@name,'SUSP-ELEM_')]";
	public final String A028_UPDT_CNTRL= "//select[starts-with(@name,'PRCSS-IND_')]";
	public final String A028_NET_BAL_IND= "//select[starts-with(@name,'NET-BAL-UPDT-IND_')]";
	public final String A028_NET_BAL_LYT = "//input[starts-with(@name,'NET-BAL-LYT_')]";
	public final String A028_NOML_BAL_LYT = "//input[starts-with(@name,'NOML-BAL-LYT_')]";
	
	
//	Page Objects for "A029_Default_Structure_ElementsTest"
	
	public final String A029_ELEMENT ="//input[starts-with(@name,'ELEM_')]";
	public final String A029_NEW_PARENT ="//input[starts-with(@name,'PRNT-ELEM_')]";
	public final String A029_CHK_NOM_BAL ="//label[text()='Nominal Balances']/../input[1]";
	public final String A029_PATH_KEY ="//div/label[starts-with(text(), 'Path Key:')]/../input[4]";
	public final String A029_PATH_KEY_IN ="//div/label[starts-with(text(), 'Path Key:')]/../input[1]";
	public final String A029_NEW_PARENT_IN ="//input[starts-with(@name,'NEW-PRNT-ELEM_')]";
	
//	Page Objects for "A031_Company_ControlsTest"
	public final String A031_ACC_LAY ="//input[starts-with(@name,'DFLT-ACCT-LYT_')]";
	public final String A031_BSPL_LAY ="//input[starts-with(@name,'DFLT-BSPL-LYT_')]";
	public final String A031_STRUCT ="//input[starts-with(@name,'ICA-STRUC_')]";
	public final String A031_CODE_ID ="//input[starts-with(@name,'ICA-CODE-ID_')]";
	public final String A031_TRANS ="//input[starts-with(@name,'TRF-BTCH-TYPE_')]";
	public final String A031_REVRS ="//input[starts-with(@name,'REVSL-BTCH-TYPE_')]";
	public final String A031_ACC_LAY1 ="//input[starts-with(@name,'DFLT-ACCT-LYT_')]/..//label[2]";
	public final String A031_BSPL_LAY1=	"//input[starts-with(@name,'DFLT-ACCT-LYT_')]/..//label[4]";
	public final String A031_IC_STRUCT="//input[starts-with(@name,'ICA-STRUC_')]/..//label[2]";
	public final String A031_TRANS1 ="//input[starts-with(@name,'TRF-BTCH-TYPE_')]/..//label[4]";
	public final String A031_REVRS1 ="//input[starts-with(@name,'REVSL-BTCH-TYPE_')]/..//label[6]";
	
//	Page Objects for "A032A_PathKeyNewParentTest"
	public final String A032A_NEW_PAR= "//input[starts-with(@name,'NEW-PRNT-ELEM_')]";
	public final String A032A_PATH_KEY= "//input[starts-with(@name,'subfield_4_0')]";
	
//	Page Objects for "A033_Analysis_CodeTest"	
	public final String A033_PST_LIMIT_CHECKS= "//select[starts-with(@name,'POST-LIMIT-IND_')]";
	public final String A033_PST_CR_LIMITS= "//input[starts-with(@name,'POST-CR-LIMIT_')]";
	public final String A033_PST_DB_LIMITS= "//input[starts-with(@name,'POST-DR-LIMIT_')]";
	public final String A033_BAL_LIMIT_CHECKS= "//select[starts-with(@name,'BAL-LIMIT-IND_')]";
	public final String A033_BAL_CR_LIMITS= "//input[starts-with(@name,'BAL-CR-LIMIT_')]";
	public final String A033_BAL_DB_LIMITS= "//input[starts-with(@name,'BAL-DR-LIMIT_')]";

	
//	Page Objects for "A035_Structure_RebuildTest"
	public final String A035_REQ= "//input[starts-with(@name,'REQ_')]";
	public final String A035_CMPY= "//input[starts-with(@name,'PARM-CMPY_')]";
	public final String A035_YEAR1="//input[@id='chk_0_14']";
	public final String A035_YEAR2="//input[@id='chk_0_16']";
	public final String A035_YEAR3="//input[@id='chk_0_18']";
	public final String A035_START_CONFIRM="//div[contains(@class,'roundedCorners')]/button[@value='Start']";
	public final String A035_STOP_CONFIRM="//div[contains(@class,'roundedCorners')]/button[@value='Stop']";
	public final String A035_CONFM_SUBMIT= "//div[contains(@class,'roundedCorners')]/button[@id='2_2']";
	public final String A035_HOLD= "//input[@id='chk_2_1']";
	public final String A035_GLSTRUCT= "//div[contains(@class,'licol')]";
	
//	Page Objects for "A036_BTZ_Elements_For_ICA_StructureTest"
	public final String A036_EELE="//input[starts-with(@name,'ELEM_field_')]";
	public final String A036_ICA_MNGT_CODE="//input[starts-with(@name,'ICA-MGMT_')]";
	public final String A036_GEN_LEDGR="//input[starts-with(@name,'GL-CNTRL_')]";
	
//	Page Objects for "A037_ICA_Default_Trading_RelationshipsTest"
	public final String A037_FRM_BTZ="//input[starts-with(@name,'FROM-BTZ-ENTY_')]";
	public final String A037_TO_BTZ= "//input[starts-with(@name,'TO-BTZ-ENTY_')]";
	public final String A037_GEN_ACC= "//input[@id='0_5_0']";
	public final String A037_GEN_COST="//input[@id='0_5_1']";
	
// Page Objects for "A038_Process_EP2Test"
	public final String A038_CHK_UPDT_All="//label[text()='Update All']/../input[1]";
	public final String A038_CHK_NET_BAL="//label[text()='Net Balances']/../input[1]";
	public final String A038_CHK_INCLD="//div[1]/table/tbody/tr/td[5]/input";
	
//	Page Objects for "A039_EnquiryTest"
	public final String A039_EXT_SEL="//a[contains(text(),'Extended Selection')]";
	public final String A039_CHANGE_CMPY="//button[@value='Change Company / Role']";	
	public final String A039_LKP_CMPY= "//input[starts-with(@name,'HDR-CMPY_')]";
	public final String A039_LKP_OK= "//div[contains(@class,'roundedCorners')]/button[@id='1_1']";
	public final String A039_EXT_OK="//button[contains(@class,'roundedbutton')][@id='0_44']";
	
//	Page Objects for "A040_ICA_Data_EntryTest"
	public final String A040_JOUR_TYPE= "//input[starts-with(@name,'BTCH-TYPE_')]";
	public final String A040_JOUR_REF= "//input[starts-with(@name,'BTCH-REF_')]";
	public final String A040_PERI ="//input[starts-with(@name,'BTCH-PER_')]";
	public final String A040_YEAR ="//select[starts-with(@name,'YY-IND_')]";
	public final String A040_BTZ_ELE ="//input[starts-with(@name,'ELEM_')]";
	public final String A040_DESC ="//input[starts-with(@name,'HDR-DESCR_')]";
	public final String A040_NUM_OF_TRANC ="//input[starts-with(@name,'NUM-OF-TRANS-HEAD_')]";
	public final String A040_SELE_OK = "//button[contains(@class,'roundedbutton')][@id='0_21']";
	public final String A040_SELE1_OK = "//button[contains(@class,'roundedbutton')][@id='0_11']";
	public final String A040_SELE_ACCO = "//input[@id='0_1_0']";
	public final String A040_SELE_COST = "//input[@id='0_1_1']";
	public final String A040_SELE_SEC = "//div[@class='html_TitlePaneTitle']/a[contains(text(),'Selection')]";
	
	
//	Page Objects for "A042_Period_End_Test"
	public final String A042_CMPY= "//input[starts-with(@name,'PARAM-CMPY_')]";

/*--------------------------------PHASE II PageObjects----------------------------------------------------------------*/	
	
	
//	Page Objects for "A043_Insert_Tax_CodesTest"
	public final String A043_TX_TYPE= "//input[starts-with(@name,'TAX-TYPE_')]";
	public final String A043_TOLRN_PERC = "//input[starts-with(@name,'TOLRN-PERC_')]";
	public final String A043_TOLRN_AMT = "//input[starts-with(@name,'TOLRN-AMT_')]";
	public final String A043_CHK_TX_RATE_EXP = "//label[text()='Tax Rate Exempt']/../input[1]";
	public final String A043_CODE ="//input[starts-with(@name,'TAX-CODE_')]";
	public final String A043_LOC ="//input[starts-with(@name,'LOCTN_')]";
	public final String A043_CHK_ECSTATE ="//label[text()='EC State']/../input[1]";
	
//	Page Objects for "A044_TAX_Rates_by_Tax_CodesTest"
	public final String A044_EFF_DATE = "//div/input[starts-with(@name,'datefield_')]";
	public final String A044_TOT_RATE = "//input[starts-with(@name,'TOT-RATE_')]";
	
//	Page Objects for "A045_BACS_CalendarTest"
	public final String A045_CAL = "//input[starts-with(@name,'CLNDR_')]";
	public final String A045_RAD_BACS = "//div/input[@name='CLNDR-TYPE_1'][@value='BACS']";
	
	public final String A045_RAD_OTH = "//div/input[@name='CLNDR-TYPE_1'][@value='Other']";
	
	public final String A045_WK_DAY = "//select[starts-with(@name,'WK-END-DAY_')]";
	public final String A045_CHK_SHOW_WK_END = "//label[text()='Show Week Ending']/../input[1]";
	public final String A045_ACT = "//input[starts-with(@name,'ACTVT_')]";
	public final String A045_FRM_YR = "//input[starts-with(@name,'FROM-YR_')]";
	public final String A045_TO_YR = "//input[starts-with(@name,'TO-YR_')]";
	public final String A045_YEAR = "//input[starts-with(@name,'YR_')]";
	
//	Page Objects for "A046_Bank_Account_Names_for_PurchasingTest"
	public final String A046_CNTRY = "//input[starts-with(@name,'CNTRY_')]";
	public final String A046_SRTCODE =	"//input[starts-with(@name,'SRTCODE_')]";
	public final String A046_BANK_NAME =	"//input[starts-with(@name,'BANK-NAME_')]";
	public final String A046_ADDRES1 = "//input[starts-with(@name,'BANK-ADDRES-LINE_')][1]";
	public final String A046_ADDRES2 = "//input[starts-with(@name,'BANK-ADDRES-LINE_')][2]";
	public final String A046_ADDRES3 = "//input[starts-with(@name,'BANK-ADDRES-LINE_')][3]";
	public final String A046_PSTCD  = "//input[starts-with(@name,'POST-CODE_')]"; 

//	Page Objects for "A048_UOMTest"
	public final String A048_UOM_CODE  = "//input[starts-with(@name,'UOM-CODE_')]";
	public final String A048_CHK_SUBD  = "//label[text()='Sub-Division']/../input[1]";
	public final String A048_BASE_UOM  = "//input[starts-with(@name,'UOM_')]";
	public final String A048_UOM_NBASE = "//input[starts-with(@name,'UOM-NBASE_')]";
	public final String A048_NBASE_BASE_FACT = "//input[starts-with(@name,'NBASE-BASE-FACT_')]";
	public final String A048_BASE_NBASE_FACT = "//input[starts-with(@name,'BASE-NBASE-FACT_')]";

//	Page Objects for "A049_Common_Purchasing_Company_ControlsTest"
	public final String A049_EXCH_RATE_TYPE = "//input[starts-with(@name,'EXCH-RATE-TYPE_')]";
	public final String A049_GL_HOld_CMPY = "//input[starts-with(@name,'GL-HOLDING-CMPY_')]";
	public final String A049_GL_RLTN_IND = "//input[starts-with(@name,'GL-RLTN-IND_')]";
	public final String A049_RAD_NOR = "//div/input[@name='GL-RLTN-IND_1'][@value='Normal']";
	
	public final String A049_DD_UOM = "//input[starts-with(@name,'DD-UOM_')]";
	public final String A049_WRK_DAYS_CLNDR = "//input[starts-with(@name,'WRK-DAYS-CLNDR_')]";
	public final String A049_CHK_KEYWD_INUSE = "//label[text()='Keywords In Use']/../input[1]";
	public final String A049_CHK_NSV_INUSE = "//label[text()='NSV In Use ']/../input[1]";
	public final String A049_RAD_DUP_PST_NR = "//div/input[@name='DUP-POSTCODE-IND_1'][@value='Not Required']";
	public final String A049_RAD_SUPP_PST_ALLSUP = "//div/input[@name='SUPP-POSTCODE-IND'][@value='All Supplier Types']";
	public final String A049_RAD_PM_ADDR_NNOT = "//div/input[@name='PM-MULTI-ADDR-IND'][@value='No Notification']";
	public final String A049_RAD_AP_ADDR_NNOT ="//div/input[@name='AP-MULTI-ADDR-IND'][@value='No Notification']";

//	Page Objects for "A050_Accounts_Payable_Control_AccountsTest"

	public final String A050_CNTL_AC_CD = "//input[starts-with(@name,'LEDGR_')]";

	public final String A050_CRE_CONT_ACC = "//div/input[starts-with(@name,'subfield_3_0')]";
	public final String A050_CRE_CONT_CST = "//div/input[starts-with(@name,'subfield_3_1')]";
	public final String A050_DIS_RECE_ACC = "//div/input[starts-with(@name,'subfield_4_0')]";
	public final String A050_DIS_RECE_CST = "//div/input[starts-with(@name,'subfield_4_1')]";
	public final String A050_BNK_CHG_ACC = "//div/input[starts-with(@name,'subfield_5_0')]";
	public final String A050_BNK_CHG_CST = "//div/input[starts-with(@name,'subfield_5_1')]";
	public final String A050_PREPAY_ACC = "//div/input[starts-with(@name,'subfield_6_0')]";
	public final String A050_PREPAY_CST = "//div/input[starts-with(@name,'subfield_6_1')]";
	public final String A050_DET_VAR_ACC = "//div/input[starts-with(@name,'subfield_7_0')]";
	public final String A050_DET_VAR_CST = "//div/input[starts-with(@name,'subfield_7_1')]";
	public final String A050_TRD_CUR_ACC = "//div/input[starts-with(@name,'subfield_8_0')]";
	public final String A050_TRD_CUR_CST = "//div/input[starts-with(@name,'subfield_8_1')]";
	public final String A050_SRV_ACCR_ACC = "//div/input[starts-with(@name,'subfield_9_0')]";
	public final String A050_SRV_ACCR_CST = "//div/input[starts-with(@name,'subfield_9_1')]";
	public final String A050_SRV_DEFE_ACC = "//div/input[starts-with(@name,'subfield_10_0')]";
	public final String A050_SRV_DEFE_CST = "//div/input[starts-with(@name,'subfield_10_1')]";
	public final String A050_AP_AR_ACC = "//div/input[starts-with(@name,'subfield_11_0')]";
	public final String A050_AP_AR_CST = "//div/input[starts-with(@name,'subfield_11_1')]";
	public final String A050_TAX_SUP_ACC = "//div/input[starts-with(@name,'subfield_14_0')]";
	public final String A050_TAX_SUP_CST = "//div/input[starts-with(@name,'subfield_14_1')]";
	public final String A050_TAX_VAR_ACC = "//div/input[starts-with(@name,'subfield_15_0')]";
	public final String A050_TAX_VAR_CST = "//div/input[starts-with(@name,'subfield_15_1')]";
	public final String A050_MUL_GL_ACC = "//div/input[starts-with(@name,'subfield_16_0')]";
	public final String A050_MUL_GL_CST = "//div/input[starts-with(@name,'subfield_16_1')]";
	public final String A050_SLF_ASS_ACC = "//div/input[starts-with(@name,'subfield_17_0')]";
	public final String A050_SLF_ASS_CST = "//div/input[starts-with(@name,'subfield_17_1')]";
	
//	Page Objects for "A051_Purchase_Ledger_Bank_CodesTest"
	
	public final String A051_BNK_CODE = "//input[starts-with(@name,'BANK_')]";
	public final String A051_BNK_ACC_NU = "//input[starts-with(@name,'ACCT-NUM_')]";
	public final String A051_SRT_CODE = "//input[starts-with(@name,'SRT-CODE_')]";
	public final String A050_GL_BNK_ACC = "//div/input[starts-with(@name,'subfield_7_0')]";
	public final String A050_GL_BNK_CST = "//div/input[starts-with(@name,'subfield_7_1')]";

//	Page Objects for "A053_Category_CodeTest"
	public final String A053_HLD_DAY = "//input[starts-with(@name,'HOLD-DD_')]";
	public final String A053_CHK_AUTO_SUPP_CLER = "//label[text()='Auto Supplier Cleardown']/../input[1]";

//	Page Objects for "A054_Discount_TermsTest"
	public final String A054_DSCNT = "//input[starts-with(@name,'DSCNT_')]";
	public final String A054_RAD_PER_D ="//div/input[@name='PER-IND_1'][@value='Daily']";
	public final String A054_NUM_DD = "//input[starts-with(@name,'NUM-DD_')]";
	public final String A054_RATE_PERC = "//input[starts-with(@name,'RATE-PERC_')]";
	public final String A054_RAD_SRTP_INVDT ="//div/input[@name='STRT-POINT-IND_1'][@value='Invoice Date']";
	
//	Page Objects for "A055_Settlement_TermsTest"
	public final String A055_SETT_TERM= "//input[starts-with(@name,'STLMNT_')]";
	public final String A055_RAD_PERD_M= "//div/input[@name='PER-IND_1'][@value='Monthly']";
	public final String A055_FROM_DD= "//input[starts-with(@name,'FROM-DD_')]";
	public final String A055_TO_DD= "//input[starts-with(@name,'TO-DD_')]";
	public final String A055_MONTH= "//input[starts-with(@name,'NUM-MM_')]";
	public final String A055_DATE= "//input[starts-with(@name,'DUE-DD_')]";
	public final String A055_DAYS= "//input[starts-with(@name,'NUM-DD_')]";
	public final String A055_RAD_STRT_PER= "//div/input[@name='STRT-POINT-IND_1'][@value='Period']";
	public final String A055_RAD_STRT_INV= "//div/input[@name='STRT-POINT-IND_1'][@value='Invoice']";
	
//	Page Objects for "A056_AP_Ledger_ControlsTest"
	public final String A056_TOL_PROC= "//select[starts-with(@name,'EXCH-TOLRN-IND_')]";
	public final String A056_CHK_CURR_TURN= "//label[text()='Currency Turnover Maintained']/../input[1]";
	public final String A056_CHK_TURN_IN_TAX= "//label[text()='Turnover To Include Tax']/../input[1]";
	public final String A056_CHK_TRNS_ENQ= "//label[text()='Transaction Enquiry in Reverse Date Sequence']/../input[1]";	
	public final String A056_AUTO_CNCL= "//select[starts-with(@name,'AUTO-CANC-IND_')]";
	public final String A056_TURN_PER_IND= "//select[starts-with(@name,'TNVR-GL-PER-FLAG_')]";
	
	public final String A056_TRANS_DUP= "//select[starts-with(@name,'DUP-REF-ERR-FLAG_')]";
	public final String A056_LOG_TRANS= "//select[starts-with(@name,'LOG-IND_')]";
	public final String A056_POSTCD_ETRY= "//select[starts-with(@name,'POSTCODE-ENT-IND_')]";
	
	public final String A056_CRDT_NT_DUE_DT= "//select[starts-with(@name,'CRED-DUE-DATE-IND_')]";
	public final String A056_CHK_TRNS_TTL_CORR= "//label[text()='Transaction Totals Correction']/../input[1]";
	public final String A056_CHK_TX_DET_LVL= "//label[text()='Tax at Detail Level']/../input[1]";
	public final String A056_CHK_TX_ON_EXP_AT_DL= "//label[text()='Tax On Expenses at Detail Level']/../input[1]";
	public final String A056_TAX_VRNC_CODE= "//input[starts-with(@name,'TAX-VRNC-CODE_')]";
	
	public final String A056_CHK_BTCH_TOT_CORR= "//label[text()='Batch Totals Correction']/../input[1]";
	public final String A056_CHK_BTCH_TOT_NUM_TRAN= "//label[text()='Batch Totals on Number of Transactions']/../input[1]";
	public final String A056_CHK_BTCH_TOT_OVER= "//label[text()='Batch Totals Override']/../input[1]";
	public final String A056_CHK_BTCH_ON_ENT= "//label[text()='Batch on Entry']/../input[1]";
	public final String A056_CHK_BTCH_ON_LOG= "//label[text()='Batch on Logging']/../input[1]";
	public final String A056_CHK_BTCH_ON_EXP= "//label[text()='Batch on Expense']/../input[1]";
	public final String A056_CHK_MNDTY_TRAN_DT= "//label[text()='Mandatory Transaction Date']/../input[1]";
	public final String A056_CHK_USE_VAT_ANLS= "//label[text()='Use VAT Analysis']/../input[1]";
	public final String A056_COD_IDNT= "//input[starts-with(@name,'VAT-MGMT-CODE-ID_')]";
	public final String A056_PSTNG_TYPE = "//select[starts-with(@name,'VAT-ANAL-TYPE_')]";
	public final String A056_WITH_TYPE = "//select[starts-with(@name,'WHOLD-TYPE-IND_')]";
	public final String A056_TX_RATE= "//input[starts-with(@name,'CIT-TAX-RATE_')]";
	public final String A056_NTCOMP_TX_RATE= "//input[starts-with(@name,'NCOMP-TAX-RATE_')]";
	public final String A056_NUM_DAY_TX_PRMPT= "//input[starts-with(@name,'CIT-WARN-DD_')]";
	public final String A056_SCHD_ADV_WARN= "//input[starts-with(@name,'SCHD-WARN-DD_')]";
	public final String A056_MIN_PAY_BAL= "//input[starts-with(@name,'MIN-PAY-VAL_')]";
	public final String A056_PAY_REGST_VAL= "//input[starts-with(@name,'PAY-REGST-VAL_')]";
	public final String A056_PAY_RECON = "//select[starts-with(@name,'PAY-RECON-IND_')]";
	public final String A056_CHQ_DUP = "//select[starts-with(@name,'DUP-CHQ-ERR-FLAG_')]";
	public final String A056_DAYS_BFR_ARCHV= "//input[starts-with(@name,'ARCH-DD_')]";
	public final String A056_REL_IND = "//select[starts-with(@name,'GL-RLTN-IND_')]";
	public final String A056_CNTRL_ACC_CD= "//input[starts-with(@name,'DFLT-LEDGR_')]";
	public final String A056_CHK_DEF_PER = "//label[text()='Default Period']/../input[1]";
	public final String A056_DAYS_RESIT= "//input[starts-with(@name,'DIARY-RESIDENT-DD_')]";
	
	public final String A056_DEF_BATCH_TYP= "//input[starts-with(@name,'DFLT-BTCH-TYPE_')]";
	public final String A056_LOG_TRANC= "//input[starts-with(@name,'LOG-BTCH-TYPE_')]";
	public final String A056_ENTR_TRANC= "//input[starts-with(@name,'ENTRY-BTCH-TYPE_')]";
	public final String A056_CANLD_TRANC= "//input[starts-with(@name,'CANC-BTCH-TYPE_')]";
	public final String A056_TRANC_TRANSF= "//input[starts-with(@name,'TRF-BTCH-TYPE_')]";
	public final String A056_VAT_ANYS_CST_CNTR= "//input[starts-with(@name,'VAT-CC-BTCH-TYPE_')]";
	public final String A056_PAYMNT= "//input[starts-with(@name,'PAY-BTCH-TYPE_')]";
	
	public final String A056_AP_AR_NETT_OFF = "//select[starts-with(@name,'NET-OFF-IND_')]";
	
	
	public final String A056_TOL_TYPE = "//select[starts-with(@name,'TOLRN-TYPE-IND_')]";
	public final String A056_TOLRNC_PSTV ="//input[starts-with(@name,'TOLRN-PERC-PSTV_')]";
	public final String A056_TOLRNC_NEG ="//input[starts-with(@name,'TOLRN-PERC-NEG_')]";
	public final String A056_TOLRNC_AMT ="//input[starts-with(@name,'TOLRN-AMT_')]";
	public final String A056_CHK_TRNC_HD_DIFF = "//label[text()='Transaction Held for Price Difference']/../input[1]";
	public final String A056_OVR_INVO_GRN = "//select[starts-with(@name,'OVER-INVCE-IND_')]";
	public final String A056_GRN_FURT_MAT = "//select[starts-with(@name,'GRN-MTCH-IND_')]";
	
	public final String A056_CR_TOL_TYPE = "//select[starts-with(@name,'CR-TOLRN-TYPE-IND')]";
	public final String A056_CR_TOLRNC_PSTV ="//input[starts-with(@name,'CR-TOLRN-PERC_')]";
	
	public final String A056_CR_TOLRNC_AMT ="//input[starts-with(@name,'CR-TOLRN-AMT_')]";
	
	
	
	
}
