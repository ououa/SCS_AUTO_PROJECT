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

WebUI.openBrowser(null)

WebUI.navigateToUrl('https://newscs-sit.sunwoda.com/')

WebUI.setText(findTestObject('Common_公共通用元素/GlobalHeader_顶部导航栏/CHN_IND/Page_/input_'), 'G250723109')

WebUI.setEncryptedText(findTestObject('Common_公共通用元素/GlobalHeader_顶部导航栏/CHN_IND/Page_/input__1'), 'vRPQRzfLAVz/2uHe6SEpgg==')

WebUI.click(findTestObject('Common_公共通用元素/GlobalHeader_顶部导航栏/CHN_IND/Page_/button_'))

WebUI.click(findTestObject('Common_公共通用元素/GlobalHeader_顶部导航栏/CHN_IND/Page_/button__r2e'))

WebUI.click(findTestObject('Common_公共通用元素/GlobalHeader_顶部导航栏/CHN_IND/Page_/span_CHN'))

WebUI.click(findTestObject('Common_公共通用元素/GlobalHeader_顶部导航栏/CHN_IND/Page_/div_IND'))

WebUI.click(findTestObject('Common_公共通用元素/GlobalHeader_顶部导航栏/CHN_IND/Page_/button__r2c'))

WebUI.click(findTestObject('Common_公共通用元素/GlobalHeader_顶部导航栏/CHN_IND/Page_/span_IND'))

WebUI.click(findTestObject('Common_公共通用元素/GlobalHeader_顶部导航栏/CHN_IND/Page_/div_CHN'))

WebUI.click(findTestObject('Common_公共通用元素/GlobalHeader_顶部导航栏/CHN_IND/Page_/button__r2c'))

WebUI.click(findTestObject('Common_公共通用元素/GlobalHeader_顶部导航栏/CHN_IND/Page_/span_CHN'))

WebUI.click(findTestObject('Common_公共通用元素/GlobalHeader_顶部导航栏/CHN_IND/Page_/div_IND'))

WebUI.click(findTestObject('Common_公共通用元素/GlobalHeader_顶部导航栏/CHN_IND/Page_/span_G250723109'))

WebUI.mouseOver(findTestObject('Common_公共通用元素/GlobalHeader_顶部导航栏/CHN_IND/Page_/li__r2o'))

WebUI.click(findTestObject('Common_公共通用元素/GlobalHeader_顶部导航栏/CHN_IND/Page_/li__r2o'))

