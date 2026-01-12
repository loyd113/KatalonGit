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

WebUI.click(findTestObject('Object Repository/Page_Home - FIKA/a_National Holiday'))

WebUI.click(findTestObject('Object Repository/Page_National Holiday - FIKA/button_'))

WebUI.click(findTestObject('Object Repository/Page_National Holiday - FIKA/button_Filter_p-datepicker-dropdown'))

WebUI.click(findTestObject('Object Repository/Page_National Holiday - FIKA/button_2026'))

WebUI.click(findTestObject('Object Repository/Page_National Holiday - FIKA/span_2025'))

WebUI.click(findTestObject('Object Repository/Page_National Holiday - FIKA/span_Jan'))

WebUI.click(findTestObject('Object Repository/Page_National Holiday - FIKA/span_1'))

WebUI.click(findTestObject('Object Repository/Page_National Holiday - FIKA/span_31'))

WebUI.click(findTestObject('Object Repository/Page_National Holiday - FIKA/div_ApplyReset'))

WebUI.setText(findTestObject('Page_National Holiday - FIKA/input_Period_p-inputtext p-component w-full'), 'tahun')

WebUI.click(findTestObject('Object Repository/Page_National Holiday - FIKA/button_Apply'))

// === WAIT TABLE ===
WebUI.waitForElementVisible(findTestObject('table_Rows'), 10)

// === GET ROW COUNT ===
int rowCount = WebUI.findWebElements(findTestObject('table_Rows'), 10).size()

WebUI.verifyGreaterThan(rowCount, 0)

// === VERIFY EACH ROW ===
for (int i = 1; i <= rowCount; i++) {
	String date = WebUI.getText(findTestObject('td_Dynamic', [('row') : i, ('col') : 1]))

	String description = WebUI.getText(findTestObject('td_Dynamic', [('row') : i, ('col') : 2]))

	WebUI.verifyMatch(date, '.*Jan 2025.*', true, FailureHandling.CONTINUE_ON_FAILURE) 

    WebUI.verifyMatch(description, '.*Imlek.*', true, FailureHandling.CONTINUE_ON_FAILURE)

} 
