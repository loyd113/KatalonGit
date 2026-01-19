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

WebUI.click(findTestObject('Object Repository/Page_Home - FIKA/a_Issue'))

WebUI.click(findTestObject('Object Repository/Page_Issue - FIKA/button_'))

WebUI.click(findTestObject('Object Repository/Page_Issue - FIKA/div_empty_p-multiselect-dropdown'))

WebUI.click(findTestObject('Object Repository/Page_Issue - FIKA/li_Maintain Building'))

WebUI.click(findTestObject('Object Repository/Page_Issue - FIKA/div_Select Questioner_p-select-dropdown'))

WebUI.click(findTestObject('Object Repository/Page_Issue - FIKA/li_medium'))

WebUI.click(findTestObject('Object Repository/Page_Issue - FIKA/div_Select Priority_p-select-dropdown'))

WebUI.click(findTestObject('Object Repository/Page_Issue - FIKA/li_Open'))

WebUI.click(findTestObject('Object Repository/Page_Issue - FIKA/button_Apply'))

// === WAIT TABLE ===
WebUI.waitForElementVisible(findTestObject('table_Rows'), 10)

// === GET ROW COUNT ===
int rowCount = WebUI.findWebElements(findTestObject('table_Rows'), 10).size()

WebUI.verifyGreaterThan(rowCount, 0)

// === VERIFY EACH ROW ===
for (int i = 1; i <= rowCount; i++) {
	String questioner = WebUI.getText(findTestObject('td_Dynamic', [('row') : i, ('col') : 1]))

	String priority = WebUI.getText(findTestObject('td_Dynamic', [('row') : i, ('col') : 5]))
	
	String status = WebUI.getText(findTestObject('td_Dynamic', [('row') : i, ('col') : 7]))
	

	WebUI.verifyEqual(questioner, 'Maintain Building')

	WebUI.verifyEqual(priority, 'medium')

	WebUI.verifyEqual(status, 'Open')
	
}