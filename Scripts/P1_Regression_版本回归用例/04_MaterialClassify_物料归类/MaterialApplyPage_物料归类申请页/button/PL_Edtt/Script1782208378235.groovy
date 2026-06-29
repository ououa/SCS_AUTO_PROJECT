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
 * Data Files/Mat_Apply/PL_Edit
 */

String caseId = CaseID?.toString()?.trim()
if (!caseId) {
    KeywordUtil.markFailedAndStop('测试用例变量 CaseID 不能为空')
}

TestData tdEdit = findTestData('Data Files/Mat_Apply/PL_Edit')

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

void setGridValue(TestObject cellObj, TestObject inputObj, String value, boolean pressEnter = true) {
    WebUI.click(cellObj)
    WebUI.doubleClick(cellObj)
    WebUI.setText(inputObj, value)
    if (pressEnter) {
        WebUI.sendKeys(inputObj, Keys.chord(Keys.ENTER))
    }
}

void openPLEditPage() {
    WebUI.waitForPageLoad(20)
    WebUI.waitForElementVisible(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/li__r10'), 20)
    WebUI.mouseOver(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/li__r10'))

    WebUI.waitForElementClickable(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/span_'), 20)
    WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/span_'))

    WebUI.waitForElementClickable(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/a__r1v'), 20)
    WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/a__r1v'))
}

int dataRow = findRowByCaseId(tdEdit, caseId)
if (dataRow == -1) {
    KeywordUtil.markFailedAndStop("Data Files/Mat_Apply/PL_Edit 中未找到 CaseID='${caseId}' 的数据")
}

String search_text_01 = getRequiredCell(tdEdit, 'search_text_01', dataRow, 'PL_Edit', caseId)
String search_text_02 = getRequiredCell(tdEdit, 'search_text_02', dataRow, 'PL_Edit', caseId)
String tariff_code = getRequiredCell(tdEdit, 'tariff_code', dataRow, 'PL_Edit', caseId)
String attr_00 = getRequiredCell(tdEdit, 'attr_00', dataRow, 'PL_Edit', caseId)
String attr_01 = getRequiredCell(tdEdit, 'attr_01', dataRow, 'PL_Edit', caseId)
String attr_02 = getRequiredCell(tdEdit, 'attr_02', dataRow, 'PL_Edit', caseId)
String attr_03 = getRequiredCell(tdEdit, 'attr_03', dataRow, 'PL_Edit', caseId)
String attr_04 = getRequiredCell(tdEdit, 'attr_04', dataRow, 'PL_Edit', caseId)
String attr_05 = getRequiredCell(tdEdit, 'attr_05', dataRow, 'PL_Edit', caseId)
String attr_06 = getRequiredCell(tdEdit, 'attr_06', dataRow, 'PL_Edit', caseId)
String attr_07 = getRequiredCell(tdEdit, 'attr_07', dataRow, 'PL_Edit', caseId)
String attr_08 = getRequiredCell(tdEdit, 'attr_08', dataRow, 'PL_Edit', caseId)
String attr_09 = getRequiredCell(tdEdit, 'attr_09', dataRow, 'PL_Edit', caseId)
String attr_extra_01 = getRequiredCell(tdEdit, 'attr_extra_01', dataRow, 'PL_Edit', caseId)
String attr_extra_02 = getRequiredCell(tdEdit, 'attr_extra_02', dataRow, 'PL_Edit', caseId)

WebUI.comment("开始执行 PL 编辑，CaseID=${caseId}")

// 调用公共登录用例
// WebUI.callTestCase(findTestCase('Test Cases/P1_Regression_版本回归用例/Common_公共/SysManger_Login'), [:], FailureHandling.STOP_ON_FAILURE)

openPLEditPage()

WebUI.setText(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/textarea_'), search_text_01)
WebUI.sendKeys(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/textarea_'), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/textarea_'), search_text_02)
WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/span__1'))
WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/input_Select all'))
WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/button_'))

// 第一列税号
setGridValue(
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/div_gridcell'),
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/input_rc_select_15'),
    tariff_code,
    true
)

// 网格值输入
setGridValue(
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/div_gridcell_1'),
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/input_ag-148-input'),
    attr_00,
    true
)

setGridValue(
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/div_gridcell_2'),
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/input_ag-180-input'),
    attr_01,
    false
)

setGridValue(
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/div_gridcell_3'),
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/input_ag-180-input'),
    attr_02,
    false
)

setGridValue(
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/div_gridcell_4'),
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/input_ag-180-input'),
    attr_03,
    false
)

setGridValue(
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/div_gridcell_5'),
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/input_ag-180-input'),
    attr_04,
    false
)

setGridValue(
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/div_gridcell_6'),
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/input_ag-180-input'),
    attr_05,
    false
)

// 中间额外字段
WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/div_0_1'))
WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/div_0_2'))
WebUI.doubleClick(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/div_0_2'))
WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/input_ag-569-input'))
WebUI.doubleClick(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/input_ag-569-input'))
WebUI.setText(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/input_ag-569-input'), attr_extra_01)
WebUI.sendKeys(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/input_ag-569-input'), Keys.chord(Keys.ENTER))

setGridValue(
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/div_gridcell_7'),
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/input_ag-180-input'),
    attr_06,
    false
)

setGridValue(
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/div_gridcell_8'),
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/input_ag-180-input'),
    attr_07,
    false
)

setGridValue(
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/div_gridcell_9'),
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/input_ag-180-input'),
    attr_08,
    false
)

setGridValue(
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/div_gridcell_10'),
    findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/input_ag-180-input'),
    attr_09,
    false
)

// 如果页面后续确实还有第二个额外字段入口，再补到这里；当前先保留数据字段但不强行写死动作
if (attr_extra_02) {
    WebUI.comment("attr_extra_02 当前已取到数据：${attr_extra_02}，如页面有对应控件可继续补充映射")
}

WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Page_apply/PLedit/Page_- Sun.pro/button__1'))