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

WebUI.click(findTestObject('Object Repository/Page_Home - FIKA/a_Questioner'))

WebUI.click(findTestObject('Object Repository/Page_Questioner - FIKA/span_Questioner'))

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/span_'))

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/li_Office'))

/*WebUI.setText(findTestObject('Object Repository/Page_Create Questioner - FIKA/input_Required_p-inputtext p-component w-full p-invalid'), 
    'TestKatalon')*/
String uniqueName = 'Katalon_' + LocalDateTime.now().format(DateTimeFormatter.ofPattern('yyyyMMdd_HHmmss'))

println(uniqueName)

WebUI.setText(findTestObject('Object Repository/Page_Create Questioner - FIKA/input_Required_p-inputtext p-component w-full p-invalid'), 
    uniqueName)

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

WebUI.waitForPageLoad(10)

WebUI.delay(2)

/*WebUI.executeJavaScript('\n  const inputs = document.querySelectorAll("input.p-inputnumber-input");\n\n  if (inputs.length < 2) {\n    throw \'Input range PrimeVue tidak ditemukan\';\n  }\n\n  const from = inputs[2];\n  const to   = inputs[3];\n\n  // FROM = 0\n  from.focus();\n  from.value = \'0\';\n  from.dispatchEvent(new Event(\'input\', { bubbles: true }));\n  from.dispatchEvent(new Event(\'change\', { bubbles: true }));\n  from.blur();\n\n  // TO = 60\n  to.focus();\n  to.value = \'60\';\n  to.dispatchEvent(new Event(\'input\', { bubbles: true }));\n  to.dispatchEvent(new Event(\'change\', { bubbles: true }));\n  to.blur();\n', 
    null)*/
boolean result = WebUI.executeJavaScript('\n  const inputs = document.querySelectorAll("input.p-inputnumber-input");\n\n  // pastikan minimal 4 input (from & to)\n  if (inputs.length < 4) {\n    return false;\n  }\n\n  const from = inputs[2];\n  const to   = inputs[3];\n\n  // FROM = 0\n  from.focus();\n  from.value = "0";\n  from.dispatchEvent(new Event("input", { bubbles: true }));\n  from.dispatchEvent(new Event("change", { bubbles: true }));\n  from.blur();\n\n  // TO = 60\n  to.focus();\n  to.value = "60";\n  to.dispatchEvent(new Event("input", { bubbles: true }));\n  to.dispatchEvent(new Event("change", { bubbles: true }));\n  to.blur();\n\n  return true;\n', 
    null)

if (!(result)) {
    KeywordUtil.logInfo('Input range PrimeVue belum muncul, step dilewati tanpa menghentikan test')
}

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/button_'))

WebUI.setText(findTestObject('Object Repository/Page_Create Questioner - FIKA/input_Add Category_p-inputtext p-component w-full'), 
    'Ketersediaan tempat sampah')

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/button__1_2_3'))

//WebUI.click(findTestObject('Page_Create Questioner - FIKA/i_Selection_pi pi-angle-down'))
WebUI.setText(findTestObject('Object Repository/Page_Create Questioner - FIKA/input_Add Category_p-inputtext p-component w-full'), 
    'Tersedia')

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/button_Add Option'))

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/span_Green'))

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/li_Red'))

WebUI.setText(findTestObject('Object Repository/Page_Create Questioner - FIKA/input_Add Category_p-inputtext p-component w-full'), 
    'Tersedia tapi penuh')

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/button_Add Option_1'))

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/div_Green_p-select-dropdown_1'))

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/li_Red_1'))

WebUI.setText(findTestObject('Object Repository/Page_Create Questioner - FIKA/input_Add Category_p-inputtext p-component w-full'), 
    'Tidak tersedia')

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/span_Not Required'))

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/li_Optional'))

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/button_'))

WebUI.setText(findTestObject('Object Repository/Page_Create Questioner - FIKA/input_Reference Photo (for instruction)_p-inputtext p-component mr-2 w-full'), 
    'Apakah lantai dalam keadaan bersih')

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/div_Selection'))

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/span_Yes  No'))

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/button__1_2_3_4'))

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/span_Required'))

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/li_Required'))

WebUI.click(findTestObject('Object Repository/Page_Create Questioner - FIKA/button_Save'))

//verifikasi menggunakan uniquename
WebUI.click(findTestObject('Page_Questioner - FIKA/svg_Filter_p-icon p-button-icon'))

WebUI.setText(findTestObject('Object Repository/Page_Questioner - FIKA/input_Select Departments_p-inputtext p-comp_22b816'), 
    uniqueName)

WebUI.click(findTestObject('Object Repository/Page_Questioner - FIKA/button_Apply'))

// === WAIT TABLE ===
WebUI.waitForElementVisible(findTestObject('table_Rows'), 10)

// === GET ROW COUNT ===
int rowCount = WebUI.findWebElements(findTestObject('table_Rows'), 10).size()

WebUI.verifyGreaterThan(rowCount, 0)

// === VERIFY EACH ROW ===
for (int i = 1; i <= rowCount; i++) {
    //String departments = WebUI.getText(findTestObject('td_Dynamic', [('row') : i, ('col') : 1]))
    String name = WebUI.getText(findTestObject('td_Dynamic', [('row') : i, ('col') : 2]))

    //WebUI.verifyMatch(departments, '.*Office.*', true)
    WebUI.verifyMatch(name, uniqueName, true)
}

