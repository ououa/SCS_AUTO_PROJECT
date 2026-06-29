import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/*
 * 用例名称：物料主档复制
 * 数据来源：Excel/Test Data
 * 匹配字段：CaseID
 * 输入参数：caseId
 * Excel 字段：
 * - CaseID
 * - itemcode
 * - unitcode
 * - itemtype
 * - materialName
 * - itemmodel
 * - note
 */

// ========================
// Step 0: 按 CaseID 读取测试数据
// ========================
String dataFileId = 'Data Files/MaterialClassify/CopyData'
TestData testData = findTestData(dataFileId)

assert caseId?.trim() : '参数 caseId 不能为空'

int matchedRow = -1
for (int row = 1; row <= testData.getRowNumbers(); row++) {
    String currentCaseId = testData.getValue('CaseID', row)?.trim()
    if (currentCaseId == caseId.trim()) {
        matchedRow = row
        break
    }
}

assert matchedRow != -1 : "未在测试数据 [${dataFileId}] 中找到 CaseID=${caseId} 的记录"

String itemcode = testData.getValue('itemcode', matchedRow)?.trim()
String unitcode = testData.getValue('unitcode', matchedRow)?.trim()
String itemtype = testData.getValue('itemtype', matchedRow)?.trim()
String materialName = testData.getValue('materialName', matchedRow)?.trim()
String itemmodel = testData.getValue('itemmodel', matchedRow)?.trim()
String note = testData.getValue('note', matchedRow)?.trim()

WebUI.comment("执行数据 -> CaseID=${caseId}, itemcode=${itemcode}, unitcode=${unitcode}, itemtype=${itemtype}, materialName=${materialName}, itemmodel=${itemmodel}, note=${note}")

// ========================
// Step 1: 选择待复制物料
// ========================
TestObject rowCheckbox = findTestObject('04_??????_MaterialClassify/Copy/Page_- Sun.pro/td_ant-table-cell ant-table-selection-column ant')
TestObject copyButton = findTestObject('04_??????_MaterialClassify/Copy/Page_- Sun.pro/button_')
TestObject itemCodeInput = findTestObject('04_??????_MaterialClassify/Copy/Page_-/input_')
TestObject unitCodeInput = findTestObject('04_??????_MaterialClassify/Copy/Page_-/input__1')
TestObject itemTypeDropdown = findTestObject('04_??????_MaterialClassify/Copy/Page_-/span_')
TestObject itemTypeInput = findTestObject('04_??????_MaterialClassify/Copy/Page_-/input__2')
TestObject extAreaButton = findTestObject('04_??????_MaterialClassify/Copy/Page_-/div_1')
TestObject materialNameInput = findTestObject('04_??????_MaterialClassify/Copy/Page_-/input__3')
TestObject hsCodeInput = findTestObject('04_??????_MaterialClassify/Copy/Page_-/input__4')
TestObject itemModelInput = findTestObject('04_??????_MaterialClassify/Copy/Page_-/input__5')
TestObject saveButton = findTestObject('04_??????_MaterialClassify/Copy/Page_-/button_')

WebUI.waitForElementClickable(rowCheckbox, 10)
WebUI.click(rowCheckbox)

// ========================
// Step 2: 点击复制按钮，进入复制表单
// ========================
WebUI.waitForElementClickable(copyButton, 10)
WebUI.click(copyButton)

// ========================
// Step 3: 填写基础信息
// itemcode -> 物料编码
// unitcode -> 单位编码
// ========================
WebUI.waitForElementVisible(itemCodeInput, 10)
WebUI.setText(itemCodeInput, itemcode)
WebUI.setText(unitCodeInput, unitcode)

// ========================
// Step 4: 选择物料类型
// itemtype -> 物料类型
// ========================
WebUI.waitForElementClickable(itemTypeDropdown, 10)
WebUI.click(itemTypeDropdown)
WebUI.setText(itemTypeInput, itemtype)

// ========================
// Step 5: 展开扩展区域
// note -> 当前仅记录日志，待补充备注输入框对象后可直接落库
// ========================
WebUI.waitForElementClickable(extAreaButton, 10)
WebUI.click(extAreaButton)
WebUI.comment("备注 note=${note}；当前脚本尚未绑定备注输入框对象")

// ========================
// Step 6: 填写物料详情
// materialName -> 物料名称
// itemmodel -> 规格型号
// ========================
WebUI.setText(materialNameInput, materialName)
WebUI.setText(hsCodeInput, '000000')
WebUI.setText(itemModelInput, itemmodel)

// ========================
// Step 7: 提交保存
// ========================
WebUI.waitForElementClickable(saveButton, 10)
WebUI.click(saveButton)
