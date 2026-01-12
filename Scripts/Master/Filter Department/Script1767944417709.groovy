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
import org.openqa.selenium.WebElement as WebElement

WebUI.openBrowser('')

WebUI.navigateToUrl('https://fika.infonetglobal.tech/en/login')

WebUI.setText(findTestObject('Object Repository/Page_Login - FIKA/input_Email_p-inputtext p-component block px-4 py-3.5 w-full'), 
    'admin@fika.app')

WebUI.setText(findTestObject('Object Repository/Page_Login - FIKA/input_Password_p-inputtext p-component block px-4 py-3.5 w-full (1)'), 
    'welcome123')

WebUI.click(findTestObject('Object Repository/Page_Login - FIKA/button_Login'))

WebUI.click(findTestObject('Object Repository/Page_Home - FIKA/span_Department'))

WebUI.click(findTestObject('Page_Department - FIKA/svg_Filter_p-icon p-button-icon'))

WebUI.setText(findTestObject('Page_Department - FIKA/Page_Department - FIKA/input_Filter_p-inputtext p-component w-full'), 
    'WH')

WebUI.setText(findTestObject('Page_Department - FIKA/Page_Department - FIKA/input_Search Code_p-inputtext p-component w-full'), 
    'Warehouse')

WebUI.click(findTestObject('Page_Department - FIKA/svg_Search Name_p-icon p-select-dropdown-icon'))

WebUI.click(findTestObject('Page_Department - FIKA/span_Active'))

WebUI.click(findTestObject('Page_Department - FIKA/button_Apply'))

WebUI.verifyElementPresent(findTestObject('Page_Department - FIKA/td_Active'), 0)

WebUI.verifyElementPresent(findTestObject('Page_Department - FIKA/td_Warehouse'), 0)

WebUI.verifyElementPresent(findTestObject('Page_Department - FIKA/td_WH'), 0)

