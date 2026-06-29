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
 * Data Files/Mat_Review/MAT_Commodity
 */

String caseId = CaseID?.toString()?.trim()
if (!caseId) {
    KeywordUtil.markFailedAndStop('测试用例变量 CaseID 不能为空')
}

TestData tdCommodity = findTestData('Data Files/Mat_Review/MAT_Commodity')

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

int dataRow = findRowByCaseId(tdCommodity, caseId)
if (dataRow == -1) {
    KeywordUtil.markFailedAndStop("Data Files/Mat_Review/MAT_Commodity 中未找到 CaseID='${caseId}' 的数据")
}

String itemcode = getRequiredCell(tdCommodity, 'itemcode', dataRow, 'MAT_Commodity', caseId)
String ciqcode = getRequiredCell(tdCommodity, 'ciqcode', dataRow, 'MAT_Commodity', caseId)
String unit = getRequiredCell(tdCommodity, 'unit', dataRow, 'MAT_Commodity', caseId)

WebUI.comment("开始执行商品信息维护，CaseID=${caseId}")

WebUI.waitForElementVisible(findTestObject('Page_MAT/Page_AddItem/Page_MAT_Commodity/Page_- Sun.pro/textarea_'), 20)
WebUI.setText(findTestObject('Page_MAT/Page_AddItem/Page_MAT_Commodity/Page_- Sun.pro/textarea_'), itemcode)

WebUI.click(findTestObject('Page_MAT/Page_AddItem/Page_MAT_Commodity/Page_/svg_svg'))
WebUI.click(findTestObject('Page_MAT/Page_AddItem/Page_MAT_Commodity/Page_/td_ant-table-cell ant-table-selection-column ant'))
WebUI.click(findTestObject('Page_MAT/Page_AddItem/Page_MAT_Commodity/Page_- Sun.pro/svg_svg'))

WebUI.click(findTestObject('Page_MAT/Page_AddItem/Page_MAT_Commodity/Page_-/span_ant-select-selection-item'))
WebUI.setText(findTestObject('Page_MAT/Page_AddItem/Page_MAT_Commodity/Page_-/input_'), ciqcode)
WebUI.sendKeys(findTestObject('Page_MAT/Page_AddItem/Page_MAT_Commodity/Page_-/input_'), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Page_MAT/Page_AddItem/Page_MAT_Commodity/Page_-/input__1'), unit)
WebUI.sendKeys(findTestObject('Page_MAT/Page_AddItem/Page_MAT_Commodity/Page_-/input__1'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Page_MAT/Page_AddItem/Page_MAT_Commodity/Page_-/span_'))
WebUI.click(findTestObject('Page_MAT/Page_AddItem/Page_MAT_Commodity/Page_-/span__1'))
WebUI.click(findTestObject('Page_MAT/Page_AddItem/Page_MAT_Commodity/Page_-/span__2'))
WebUI.click(findTestObject('Page_MAT/Page_AddItem/Page_MAT_Commodity/Page_/span_'))
WebUI.click(findTestObject('Page_MAT/Page_AddItem/Page_MAT_Commodity/Page_/span__1'))