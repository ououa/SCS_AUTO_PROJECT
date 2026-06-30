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

WebUI.setText(findTestObject('Filter_conditions_筛选条件/MergeRelationManage_归并关系管理/Query_查询/textarea_'), '0428-TEST-OCJ-003')

WebUI.setText(findTestObject('Filter_conditions_筛选条件/MergeRelationManage_归并关系管理/Query_查询/input_'), '1')

WebUI.click(findTestObject('Filter_conditions_筛选条件/MergeRelationManage_归并关系管理/Query_查询/div_1_2'))

WebUI.click(findTestObject('Filter_conditions_筛选条件/MergeRelationManage_归并关系管理/Query_查询/input__1'))

WebUI.click(findTestObject('Filter_conditions_筛选条件/MergeRelationManage_归并关系管理/Query_查询/div_compCode_list'))

WebUI.click(findTestObject('Filter_conditions_筛选条件/MergeRelationManage_归并关系管理/Query_查询/input__2'))

WebUI.click(findTestObject('Filter_conditions_筛选条件/MergeRelationManage_归并关系管理/Query_查询/div_oriCountry_list'))

WebUI.setText(findTestObject('Filter_conditions_筛选条件/MergeRelationManage_归并关系管理/Query_查询/input__3'), '1')

WebUI.click(findTestObject('Filter_conditions_筛选条件/MergeRelationManage_归并关系管理/Query_查询/div_1_3'))

WebUI.click(findTestObject('Filter_conditions_筛选条件/MergeRelationManage_归并关系管理/Query_查询/input__4'))

WebUI.click(findTestObject('Filter_conditions_筛选条件/MergeRelationManage_归并关系管理/Query_查询/div_'))

WebUI.click(findTestObject('Filter_conditions_筛选条件/MergeRelationManage_归并关系管理/Query_查询/input__5'))

WebUI.click(findTestObject('Filter_conditions_筛选条件/MergeRelationManage_归并关系管理/Query_查询/div_1_4'))

WebUI.click(findTestObject('Filter_conditions_筛选条件/MergeRelationManage_归并关系管理/Query_查询/div_1_5'))

WebUI.click(findTestObject('Filter_conditions_筛选条件/MergeRelationManage_归并关系管理/Query_查询/button_'))

