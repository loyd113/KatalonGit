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

WebUI.callTestCase(findTestCase('Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Home - FIKA/a_Issue Report'))

WebUI.click(findTestObject('Object Repository/Page_Issue Report - FIKA/button_'))

WebUI.click(findTestObject('Object Repository/Page_Issue Report - FIKA/div_Select Departments'))

WebUI.click(findTestObject('Object Repository/Page_Issue Report - FIKA/li_Office'))

WebUI.click(findTestObject('Object Repository/Page_Issue Report - FIKA/div_Select Questioner'))

WebUI.click(findTestObject('Object Repository/Page_Issue Report - FIKA/li_Maintain Building'))

WebUI.click(findTestObject('Object Repository/Page_Issue Report - FIKA/div_Select Auditors'))

WebUI.click(findTestObject('Object Repository/Page_Issue Report - FIKA/li_Admin'))

WebUI.click(findTestObject('Object Repository/Page_Issue Report - FIKA/div_Select Location'))

WebUI.click(findTestObject('Object Repository/Page_Issue Report - FIKA/li_Infonet'))

WebUI.click(findTestObject('Object Repository/Page_Issue Report - FIKA/li_Infonet Lt2'))

WebUI.click(findTestObject('Object Repository/Page_Issue Report - FIKA/button_Schedule Period_p-datepicker-dropdown'))

WebUI.click(findTestObject('Object Repository/Page_Issue Report - FIKA/button__1'))

WebUI.click(findTestObject('Object Repository/Page_Issue Report - FIKA/span_1'))

WebUI.click(findTestObject('Object Repository/Page_Issue Report - FIKA/span_31'))

WebUI.click(findTestObject('Object Repository/Page_Issue Report - FIKA/button_Apply'))

// === WAIT TABLE ===
WebUI.waitForElementVisible(findTestObject('table_Rows'), 10)

// === GET ROW COUNT ===
int rowCount = WebUI.findWebElements(findTestObject('table_Rows'), 10).size()

WebUI.verifyGreaterThan(rowCount, 0)

// === VERIFY EACH ROW ===
for (int i = 1; i <= rowCount; i++) {
	String department = WebUI.getText(findTestObject('td_Dynamic', [('row') : i, ('col') : 1]))

	String questioner = WebUI.getText(findTestObject('td_Dynamic', [('row') : i, ('col') : 2]))
	
	String location = WebUI.getText(findTestObject('td_Dynamic', [('row') : i, ('col') : 3]))
	

	WebUI.verifyEqual(department, 'Office')

	WebUI.verifyEqual(questioner, 'Maintain Building')

	WebUI.verifyMatch(location, '.*Infonet.*', true)
	
}

