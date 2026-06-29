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
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/*
 * 通用变量：
 * CaseID
 *
 * Test Data:
 * Data Files/Mat_Apply/Apply_Edit
 */

String caseId = CaseID?.toString()?.trim()
if (!caseId) {
	KeywordUtil.markFailedAndStop('测试用例变量 CaseID 不能为空')
}

TestData tdApply = findTestData('Data Files/Mat_Apply/Apply_Edit')

int findRowByCaseId(TestData td, String targetCaseId) {
	int rowCount = td.getRowNumbers()
	for (int i = 1; i <= rowCount; i++) {
		String value = td.getValue('CaseID', i)?.toString()?.trim()
		if (targetCaseId == value) {
			return i
		}
	}
	return -1
}

String getCell(TestData td, String columnName, int row) {
	return td.getValue(columnName, row)?.toString()?.trim()
}

String getRequiredCell(TestData td, String columnName, int row, String dataName, String caseIdValue) {
	String value = getCell(td, columnName, row)
	if (!value) {
		KeywordUtil.markFailedAndStop("${dataName} 中 CaseID='${caseIdValue}' 的字段 '${columnName}' 不能为空")
	}
	return value
}

int dataRow = findRowByCaseId(tdApply, caseId)
if (dataRow == -1) {
	KeywordUtil.markFailedAndStop("Data Files/Mat_Apply/Apply_Edit 中未找到 CaseID='${caseId}' 的数据")
}

String textarea_01 = getRequiredCell(tdApply, 'textarea_01', dataRow, 'Apply_Edit', caseId)
String textarea_02 = getRequiredCell(tdApply, 'textarea_02', dataRow, 'Apply_Edit', caseId)
String mat_name_input = getRequiredCell(tdApply, 'mat_name_input', dataRow, 'Apply_Edit', caseId)
String mat_code_input = getRequiredCell(tdApply, 'mat_code_input', dataRow, 'Apply_Edit', caseId)
String select_30_input = getRequiredCell(tdApply, 'select_30_input', dataRow, 'Apply_Edit', caseId)
String num_3c_input = getRequiredCell(tdApply, 'num_3c_input', dataRow, 'Apply_Edit', caseId)
String weight_kg_input = getRequiredCell(tdApply, 'weight_kg_input', dataRow, 'Apply_Edit', caseId)
String num_input_02 = getRequiredCell(tdApply, 'num_input_02', dataRow, 'Apply_Edit', caseId)
String select_34_input = getRequiredCell(tdApply, 'select_34_input', dataRow, 'Apply_Edit', caseId)
String cell_input_01 = getRequiredCell(tdApply, 'cell_input_01', dataRow, 'Apply_Edit', caseId)
String cell_input_02 = getRequiredCell(tdApply, 'cell_input_02', dataRow, 'Apply_Edit', caseId)
String cell_input_03 = getRequiredCell(tdApply, 'cell_input_03', dataRow, 'Apply_Edit', caseId)
String cell_input_04 = getRequiredCell(tdApply, 'cell_input_04', dataRow, 'Apply_Edit', caseId)
String cell_input_05 = getRequiredCell(tdApply, 'cell_input_05', dataRow, 'Apply_Edit', caseId)
String cell_input_06 = getRequiredCell(tdApply, 'cell_input_06', dataRow, 'Apply_Edit', caseId)
String cell_input_07 = getRequiredCell(tdApply, 'cell_input_07', dataRow, 'Apply_Edit', caseId)
String cell_input_08 = getRequiredCell(tdApply, 'cell_input_08', dataRow, 'Apply_Edit', caseId)
String extra_input_01 = getRequiredCell(tdApply, 'extra_input_01', dataRow, 'Apply_Edit', caseId)
String extra_input_02 = getRequiredCell(tdApply, 'extra_input_02', dataRow, 'Apply_Edit', caseId)
String file_path_input = getRequiredCell(tdApply, 'file_path_input', dataRow, 'Apply_Edit', caseId)

WebUI.comment("开始执行物料归类申请，CaseID=${caseId}")

WebUI.setText(findTestObject('Old_Obj/Page_apply/Page_- Sun.pro/textarea_'), textarea_01)

WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_- Sun.pro/span__1'))
WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_- Sun.pro/svg_svg'))
WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_- Sun.pro/td_ant-table-cell ant-table-selection-column ant'))
WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_tijiaoshangpinweihu/span_tijiaoweihu'))
WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_tijiaoshangpinweihu/span__queren'))
WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_- Sun.pro/a__r1t'))

WebUI.setText(findTestObject('Old_Obj/Page_apply/Page_- Sun.pro/textarea_'), textarea_02)
WebUI.click(findTestObject('Old_Obj/Page_apply/Page_- Sun.pro/span__3'))
WebUI.click(findTestObject('Old_Obj/Page_apply/Page_- Sun.pro/input_ant-checkbox-input'))
WebUI.click(findTestObject('Old_Obj/Page_apply/Page_- Sun.pro/span__4'))

WebUI.setText(findTestObject('Old_Obj/Page_apply/Page_-/input_'), mat_name_input)
WebUI.setText(findTestObject('Old_Obj/Page_apply/Page_-/input__1'), mat_code_input)

WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_-/input_rc_select_30'), select_30_input)
WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_-/div_8507600090 -'))

WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_-/input_3C'), num_3c_input)
WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_-/div_2 3c'))

WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_-/input_KG'), weight_kg_input)
WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_-/input__2'), num_input_02)
WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_-/span_(CHN)'))

WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_-/span_icon iconfont icon-gengduo'))
WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_-/span_ant-select-selection-item'))
WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_-/input_rc_select_34'), select_34_input)
WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_-/div_0'))

WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_-/input_ant-input ant-input-sm css-oiqwb9 ant-inpu'), cell_input_01)
WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_-/input_ant-input ant-input-sm css-oiqwb9 ant-inpu_1'), cell_input_02)
WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_-/input_ant-input ant-input-sm css-oiqwb9 ant-inpu_2'), cell_input_03)
WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_-/input_ant-input ant-input-sm css-oiqwb9 ant-inpu_3'), cell_input_04)
WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_-/input_ant-input ant-input-sm css-oiqwb9 ant-inpu_4'), cell_input_05)
WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_-/input_ant-input ant-input-sm css-oiqwb9 ant-inpu_5'), cell_input_06)
WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_-/input_ant-input ant-input-sm css-oiqwb9 ant-inpu_6'), cell_input_07)
WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_-/input_ant-input ant-input-sm css-oiqwb9 ant-inpu_7'), cell_input_08)

WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_-/input_ant-input ant-input-sm css-oiqwb9 ant-inpu_8'))
WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_-/Page_ELEMSUM/span_qr'))

WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_-/input__3'), extra_input_01)
WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_-/input__4'), extra_input_02)

WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_- Sun.pro/div_ant-select-selection-overflow'))
WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_-/div_businessList_list'))
WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_-/span__1'))

WebUI.setFileUpload(findTestObject('Old_Obj/Page_MAT/Page_-/input_files'), file_path_input)
WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_-/span__2'))