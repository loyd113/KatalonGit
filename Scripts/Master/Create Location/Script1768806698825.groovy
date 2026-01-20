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

WebUI.click(findTestObject('Page_Home - FIKA/span_Location'))

WebUI.waitForElementVisible(findTestObject('table_Rows'), 10)

WebUI.click(findTestObject('Page_Location - FIKA/button_Location'))

WebUI.click(findTestObject('Page_Location - FIKA/div_Department_p-select-dropdown'))

WebUI.click(findTestObject('Page_Location - FIKA/li_Office'))

WebUI.setText(findTestObject('Page_Location - FIKA/input_Code_p-inputtext p-component w-full'), 'CodeKatalon')

//WebUI.setText(findTestObject('Page_Location - FIKA/input_Name_p-inputtext p-component w-full (1)'), 'NameKatalon')

String uniqueName = 'Katalon_' + LocalDateTime.now().format(DateTimeFormatter.ofPattern('yyyyMMdd_HHmmss'))

println(uniqueName)

WebUI.setText(findTestObject('Page_Location - FIKA/input_Name_p-inputtext p-component w-full (1)'),
	uniqueName)

WebUI.click(findTestObject('Page_Location - FIKA/div_Time Zone_p-select-dropdown'))

WebUI.click(findTestObject('Page_Location - FIKA/li_AsiaJakartaWIB 7'))

WebUI.setText(findTestObject('Page_Location - FIKA/input_Description_p-inputtext p-component w-full'), 'DescKatalon')

/*WebUI.setText(findTestObject('Page_Location - FIKA/input_altitude (meter)s_p-inputtext p-component p-inputnumber-input'), 
    '698.90')*/

WebUI.executeJavaScript("""
    // 1. Cari label altitude
    let labels = [...document.querySelectorAll('label')];
    let label = labels.find(l =>
        l.innerText.trim().toLowerCase().startsWith('altitude')
    );
    if (!label) throw 'Label altitude not found';

    // 2. Ambil container input (md:w-2/3)
    let inputDiv = label.closest('div').nextElementSibling;
    if (!inputDiv) throw 'Input container not found';

    // 3. Ambil input
    let input = inputDiv.querySelector('input');
    if (!input) throw 'Altitude input not found';

    // === RESET TOTAL INTERNAL STATE ===
    input.focus();

    // select all + delete (hapus value lama 0,00)
    input.setSelectionRange(0, input.value.length);
    input.dispatchEvent(new KeyboardEvent('keydown', { key: 'Backspace' }));
    input.value = '';

    // === SET VALUE LOCALE INDONESIA ===
    let nativeSetter = Object.getOwnPropertyDescriptor(
        window.HTMLInputElement.prototype, 'value'
    ).set;

    // pakai koma untuk desimal (Indonesia)
    nativeSetter.call(input, '698,90');

    // trigger event agar PrimeFaces update model
    input.dispatchEvent(new Event('input', { bubbles: true }));
    input.dispatchEvent(new Event('change', { bubbles: true }));
    input.dispatchEvent(new Event('blur', { bubbles: true }));
""", null)

