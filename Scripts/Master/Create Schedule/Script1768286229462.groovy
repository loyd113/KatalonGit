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

WebUI.click(findTestObject('Object Repository/Page_Home - FIKA/span_Schedule'))

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/button_Schedule'))

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/span_'))

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/li_Office'))

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/span__1'))

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/li_Katalon_20260113_132810'))

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/span__1_2'))

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/li_Infonet Lt1'))

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/span__1_2_3'))

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/li_PIC Solver'))

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/span__1_2_3_4'))

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/li_PIC Close'))

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/span__1_2_3_4_5'))

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/li_Admin'))

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/button_No'))

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/button_No_1'))

WebUI.setText(findTestObject('Object Repository/Page_Schedule - FIKA/textarea_Description_p-textarea p-component_cec952'), 
    'TestKatalon')

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/span__1_2_3_4_5_6'))

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/li_Daily'))

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/input_Check-In time required_p-checkbox-input'))

WebUI.setText(findTestObject('Page_Schedule - FIKA/input_Checkin (start)_p-inputtext p-component p-inputmask p-filled w-full'), 
    '0700')

WebUI.setText(findTestObject('Page_Schedule - FIKA/input_Checkin (end)_p-inputtext p-component p-inputmask p-filled w-full'), 
    '1700')

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/button_No_1_2'))

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/button_No_1_2_3'))

WebUI.click(findTestObject('Object Repository/Page_Schedule - FIKA/button_No_1_2_3_4'))

