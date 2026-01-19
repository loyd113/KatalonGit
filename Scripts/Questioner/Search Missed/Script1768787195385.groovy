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
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter

WebUI.callTestCase(findTestCase('Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Home - FIKA/a_Missed'))

WebUI.click(findTestObject('Object Repository/Page_Missed - FIKA/button_'))

WebUI.click(findTestObject('Object Repository/Page_Missed - FIKA/div_empty_p-multiselect-dropdown'))

WebUI.click(findTestObject('Object Repository/Page_Missed - FIKA/li_Maintain Building'))

WebUI.click(findTestObject('Object Repository/Page_Missed - FIKA/div_Select Questioner_p-select-dropdown'))

WebUI.click(findTestObject('Object Repository/Page_Missed - FIKA/li_Daily'))

WebUI.click(findTestObject('Object Repository/Page_Missed - FIKA/div_empty_p-multiselect-dropdown_1'))

WebUI.click(findTestObject('Object Repository/Page_Missed - FIKA/li_Infonet Lt1'))

WebUI.click(findTestObject('Object Repository/Page_Missed - FIKA/div_empty_p-multiselect-dropdown_1_2'))

WebUI.click(findTestObject('Object Repository/Page_Missed - FIKA/li_Admin'))

WebUI.click(findTestObject('Object Repository/Page_Missed - FIKA/button_Select Auditors_p-datepicker-dropdown'))

WebUI.click(findTestObject('Object Repository/Page_Missed - FIKA/button__1'))

WebUI.click(findTestObject('Object Repository/Page_Missed - FIKA/button__1'))

WebUI.click(findTestObject('Object Repository/Page_Missed - FIKA/span_1'))

WebUI.click(findTestObject('Object Repository/Page_Missed - FIKA/button__1_2'))

WebUI.click(findTestObject('Object Repository/Page_Missed - FIKA/span_31'))

WebUI.click(findTestObject('Object Repository/Page_Missed - FIKA/button_Apply'))

// === WAIT TABLE ===
WebUI.waitForElementVisible(findTestObject('Object Repository/table_Rows'), 10)

// === GET ROW COUNT ===
int rowCount = WebUI.findWebElements(findTestObject('Object Repository/table_Rows'), 10).size()

WebUI.verifyGreaterThan(rowCount, 0)

// === VERIFY EACH ROW ===
for (int i = 1; i <= rowCount; i++) {
    String questioner = WebUI.getText(findTestObject('Object Repository/td_Dynamic', [('row') : i, ('col') : 2]))

    String scheduleType = WebUI.getText(findTestObject('Object Repository/td_Dynamic', [('row') : i, ('col') : 3]))

    String location = WebUI.getText(findTestObject('Object Repository/td_Dynamic', [('row') : i, ('col') : 4]))

    String auditor = WebUI.getText(findTestObject('Object Repository/td_Dynamic', [('row') : i, ('col') : 9]))

    String period = WebUI.getText(findTestObject('Object Repository/td_Dynamic', [('row') : i, ('col') : 5]))

    WebUI.verifyEqual(questioner, 'Maintain Building')

    WebUI.verifyEqual(scheduleType, 'Daily')

    WebUI.verifyEqual(location, 'Infonet Lt1')

    WebUI.verifyEqual(auditor, 'Admin')

    WebUI.verifyMatch(period, '.*(Nov|Dec).*2025.*|.*2025.*(Nov|Dec).*', true)
}

WebUI.click(findTestObject('Object Repository/Page_Missed - FIKA/button_Reason'))

String uniqueName = 'KatalonMissed_' + LocalDateTime.now().format(DateTimeFormatter.ofPattern('yyyyMMdd_HHmmss'))

println(uniqueName)

WebUI.setText(findTestObject('Page_Missed - FIKA/input_Reason Missed_p-inputtext p-component p-filled w-full'), uniqueName)

WebUI.click(findTestObject('Page_Missed - FIKA/button_Save'))

for (int i = 1; i <= rowCount; i++) {
	//String departments = WebUI.getText(findTestObject('td_Dynamic', [('row') : i, ('col') : 1]))
	String reason = WebUI.getText(findTestObject('td_Dynamic', [('row') : i, ('col') : 10]))

	//WebUI.verifyMatch(departments, '.*Office.*', true)
	WebUI.verifyMatch(reason, uniqueName, true)
}

