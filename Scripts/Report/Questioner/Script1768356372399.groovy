import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://fika.infonetglobal.tech/en/login')

WebUI.setText(findTestObject('Object Repository/Page_Login - FIKA/input_Email_p-inputtext p-component block px-4 py-3.5 w-full'), 
    'admin@fika.app')

WebUI.setText(findTestObject('Object Repository/Page_Login - FIKA/input_Password_p-inputtext p-component block px-4 py-3.5 w-full (1)'), 
    'welcome123')

WebUI.click(findTestObject('Object Repository/Page_Login - FIKA/button_Login'))

WebUI.click(findTestObject('Object Repository/Page_Home - FIKA/a_Questioner Report'))

WebUI.click(findTestObject('Object Repository/Page_Questioner Report - FIKA/button_'))

WebUI.click(findTestObject('Object Repository/Page_Questioner Report - FIKA/div_Select Departments_p-multiselect-dropdown'))

WebUI.click(findTestObject('Object Repository/Page_Questioner Report - FIKA/li_Office'))

WebUI.click(findTestObject('Object Repository/Page_Questioner Report - FIKA/div_Select Auditors_p-multiselect-dropdown'))

WebUI.click(findTestObject('Object Repository/Page_Questioner Report - FIKA/li_Admin'))

WebUI.click(findTestObject('Object Repository/Page_Questioner Report - FIKA/div_Select Schedule Type_p-select-dropdown'))

WebUI.click(findTestObject('Object Repository/Page_Questioner Report - FIKA/li_Daily'))

WebUI.click(findTestObject('Object Repository/Page_Questioner Report - FIKA/button_Schedule Period_p-datepicker-dropdown'))

WebUI.click(findTestObject('Object Repository/Page_Questioner Report - FIKA/button__1'))

WebUI.click(findTestObject('Object Repository/Page_Questioner Report - FIKA/span_1'))

WebUI.click(findTestObject('Object Repository/Page_Questioner Report - FIKA/span_31'))

WebUI.click(findTestObject('Object Repository/Page_Questioner Report - FIKA/button_Schedule Period_p-datepicker-dropdown'))

WebUI.click(findTestObject('Object Repository/Page_Questioner Report - FIKA/button_Apply'))

WebUI.click(findTestObject('Object Repository/Page_Questioner Report - FIKA/div_Loading 1 to 10 from total 17_p-select-_9a163c'))

WebUI.click(findTestObject('Object Repository/Page_Questioner Report - FIKA/li_50'))

// === WAIT TABLE ===
WebUI.waitForElementVisible(findTestObject('table_Rows'), 10)

// === GET ROW COUNT ===
int rowCount = WebUI.findWebElements(findTestObject('table_Rows'), 10).size()

WebUI.verifyGreaterThan(rowCount, 0)

// === VERIFY EACH ROW ===
for (int i = 1; i <= rowCount; i++) {
	String department = WebUI.getText(findTestObject('td_Dynamic', [('row') : i, ('col') : 2]))

	String scheduleType = WebUI.getText(findTestObject('td_Dynamic', [('row') : i, ('col') : 5]))

	String schedule = WebUI.getText(findTestObject('td_Dynamic', [('row') : i, ('col') : 7]))

	String auditor = WebUI.getText(findTestObject('td_Dynamic', [('row') : i, ('col') : 13]))
	
	WebUI.verifyEqual(department, 'Office')

	WebUI.verifyEqual(scheduleType, 'Daily')

	WebUI.verifyMatch(schedule, '.*Dec.*', true)
	
	WebUI.verifyEqual(auditor, 'Admin')
}

WebUI.click(findTestObject('Page_Questioner Report - FIKA/button_View'))

WebUI.verifyElementAttributeValue(findTestObject('Page_View Report Questioner - FIKA/input_Department_p-inputtext p-component p-filled w-full'), 
    'value', 'Office', 10)

WebUI.verifyElementAttributeValue(findTestObject('Page_View Report Questioner - FIKA/input_Type Schedule_p-inputtext p-component p-filled w-full'), 
    'value', 'DAILY', 10)

WebUI.verifyElementAttributeValue(findTestObject('Page_View Report Questioner - FIKA/input_Auditor_p-inputtext p-component p-filled w-full'), 
    'value', 'Admin', 10)

String schedule = WebUI.getAttribute(
    findTestObject('Page_View Report Questioner - FIKA/input_Schedule_p-inputtext p-component p-filled w-full'),
    'value'
)

WebUI.verifyMatch(schedule, '.*Dec.*', true)

