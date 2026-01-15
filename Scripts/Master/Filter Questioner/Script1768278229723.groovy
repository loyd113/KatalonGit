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

WebUI.click(findTestObject('Object Repository/Page_Home - FIKA/a_Questioner'))

WebUI.click(findTestObject('Page_Questioner - FIKA/svg_Filter_p-icon p-button-icon'))

WebUI.click(findTestObject('Page_Questioner - FIKA/svg_empty_p-icon p-multiselect-dropdown-icon'))

WebUI.click(findTestObject('Page_Questioner - FIKA/span_Office'))

WebUI.setText(findTestObject('Object Repository/Page_Questioner - FIKA/input_Select Departments_p-inputtext p-comp_22b816'), 
    'Maintain Building')

WebUI.click(findTestObject('Object Repository/Page_Questioner - FIKA/button_Apply'))

// === WAIT TABLE ===
WebUI.waitForElementVisible(findTestObject('table_Rows'), 10)

// === GET ROW COUNT ===
int rowCount = WebUI.findWebElements(findTestObject('table_Rows'), 10).size()

WebUI.verifyGreaterThan(rowCount, 0)

// === VERIFY EACH ROW ===
for (int i = 1; i <= rowCount; i++) {
	String departments = WebUI.getText(findTestObject('td_Dynamic', [('row') : i, ('col') : 1]))

	String name = WebUI.getText(findTestObject('td_Dynamic', [('row') : i, ('col') : 2]))

	WebUI.verifyMatch(departments, '.*Office.*', true)

	WebUI.verifyMatch(name, '.*Main.*', true)
}

