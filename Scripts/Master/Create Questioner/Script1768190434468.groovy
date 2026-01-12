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

WebUI.click(findTestObject('Object Repository/Page_Questioner - FIKA/span_Questioner'))

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/span_'))

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/li_Office'))

WebUI.setText(findTestObject('Object Repository/Page_Create Questioner - FIKA/input_Required_p-inputtext p-component w-full p-invalid'), 
    'TestKatalon')

WebUI.setText(findTestObject('Object Repository/Page_Create Questioner - FIKA/input_Description_p-inputtext p-component w-full'), 
    'TestOnly')

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/span_Add Category'))

WebUI.setText(findTestObject('Object Repository/Page_Create Questioner - FIKA/input_Add Category_p-inputtext p-component w-full'), 
    'Ruang Operasional')

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/button_'))

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/button__1'))

WebUI.setText(findTestObject('Object Repository/Page_Create Questioner - FIKA/input_Add Category_p-inputtext p-component w-full'), 
    'Suhu genset')

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/div_Selection_p-select-dropdown'))

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/span_Number'))

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/button__1_2'))

/*TestObject fromInput = findTestObject('Object Repository/Page_Create Questioner - FIKA/input_range_from')
TestObject toInput   = findTestObject('Object Repository/Page_Create Questioner - FIKA/input_range_to')

WebUI.waitForElementVisible(fromInput, 10)

WebUI.click(fromInput)
WebUI.sendKeys(fromInput, Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(fromInput, Keys.BACK_SPACE)
WebUI.sendKeys(fromInput, '0')
WebUI.sendKeys(fromInput, Keys.TAB)

WebUI.click(toInput)
WebUI.sendKeys(toInput, Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(toInput, Keys.BACK_SPACE)
WebUI.sendKeys(toInput, '60')
WebUI.sendKeys(toInput, Keys.TAB)*/

WebUI.waitForPageLoad(10)
WebUI.delay(2)

WebUI.executeJavaScript("""
  const inputs = document.querySelectorAll("input.p-inputnumber-input");

  if (inputs.length < 2) {
    throw 'Input range PrimeVue tidak ditemukan';
  }

  const from = inputs[2];
  const to   = inputs[3];

  // FROM = 0
  from.focus();
  from.value = '0';
  from.dispatchEvent(new Event('input', { bubbles: true }));
  from.dispatchEvent(new Event('change', { bubbles: true }));
  from.blur();

  // TO = 60
  to.focus();
  to.value = '60';
  to.dispatchEvent(new Event('input', { bubbles: true }));
  to.dispatchEvent(new Event('change', { bubbles: true }));
  to.blur();
""", null)

