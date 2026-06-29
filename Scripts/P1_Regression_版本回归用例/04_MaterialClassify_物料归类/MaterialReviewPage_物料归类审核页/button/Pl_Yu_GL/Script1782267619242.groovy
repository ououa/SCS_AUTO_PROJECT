import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys

String caseIdValue = CaseId?.trim()
TestData td = findTestData('Data Files/04_MaterialClassify/MaterialReviewPage/PL_Yu_GL_Data')
int row = -1

String getValue(TestData data, String column, int rowIndex) {
	return data.getValue(column, rowIndex)?.trim()
}

for (int i = 1; i <= td.getRowNumbers(); i++) {
	if (getValue(td, 'CaseId', i) == caseIdValue) {
		row = i
		break
	}
}

if (row == -1) {
	throw new StepFailedException("No data found for CaseId: ${caseIdValue}")
}

String isRun = getValue(td, 'IsRun', row)
if (!'Y'.equalsIgnoreCase(isRun)) {
	WebUI.comment("Skip execution for CaseId: ${caseIdValue}, IsRun=${isRun}")
	return
}

String expectedResult = getValue(td, 'ExpectedResult', row)
String loginUsername = getValue(td, 'loginUsername', row)
String loginPassword = getValue(td, 'loginPassword', row)
String batchMaterialCodes = getValue(td, 'batchMaterialCodes', row)
String searchHsCode = getValue(td, 'searchHsCode', row)
String unitCode = getValue(td, 'unitCode', row)
String taxFlag = getValue(td, 'taxFlag', row)
String digit1 = getValue(td, 'digit1', row)
String digit2 = getValue(td, 'digit2', row)
String digit3 = getValue(td, 'digit3', row)
String digit4 = getValue(td, 'digit4', row)
String digit5 = getValue(td, 'digit5', row)
String digit6 = getValue(td, 'digit6', row)
String digit7 = getValue(td, 'digit7', row)
String digit8 = getValue(td, 'digit8', row)
String keywordCn = getValue(td, 'keywordCn', row)
String keywordModel = getValue(td, 'keywordModel', row)
String keywordNote = getValue(td, 'keywordNote', row)

if (!loginUsername) {
	throw new StepFailedException("loginUsername is empty for CaseId: ${caseIdValue}")
}
if (!loginPassword) {
	throw new StepFailedException("loginPassword is empty for CaseId: ${caseIdValue}")
}
if (!batchMaterialCodes) {
	throw new StepFailedException("batchMaterialCodes is empty for CaseId: ${caseIdValue}")
}

batchMaterialCodes = batchMaterialCodes.replace('|', '\n')

WebUI.comment("Executing CaseId=${caseIdValue}, ExpectedResult=${expectedResult}")

WebUI.openBrowser('')
WebUI.navigateToUrl('https://newscs-sit.sunwoda.com/')

WebUI.waitForElementVisible(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_/input_'), 10)
WebUI.setText(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_/input_'), loginUsername)
WebUI.setEncryptedText(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_/input__1'), loginPassword)
WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_/button_'))

WebUI.waitForElementVisible(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_- Sun.pro/li__r10'), 15)
WebUI.mouseOver(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_- Sun.pro/li__r10'))
WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_- Sun.pro/span_'))
WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_- Sun.pro/a__r23'))

WebUI.waitForElementVisible(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_- Sun.pro/textarea_'), 10)
WebUI.setText(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_- Sun.pro/textarea_'), batchMaterialCodes)
WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_- Sun.pro/button_'))

WebUI.waitForElementClickable(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_- Sun.pro/input_Select all'), 10)
WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_- Sun.pro/input_Select all'))
WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_- Sun.pro/button__1'))

WebUI.waitForElementClickable(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input_'), 10)
WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input_'))
WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/span_icon iconfont icon-gengduo'))

if (searchHsCode) {
	WebUI.waitForElementVisible(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input__1'), 10)
	WebUI.setText(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input__1'), searchHsCode)
	WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/button_'))
	WebUI.waitForElementClickable(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input_ant-radio-input'), 10)
	WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input_ant-radio-input'))
	WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/span_'))
}

if (unitCode) {
	WebUI.waitForElementVisible(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input__2'), 10)
	WebUI.setText(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input__2'), unitCode)
	WebUI.sendKeys(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input__2'), Keys.chord(Keys.ENTER))
}

if (taxFlag) {
	WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/span_ant-select-selection-item'))
	WebUI.setText(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input_rc_select_27'), taxFlag)
	WebUI.sendKeys(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input_rc_select_27'), Keys.chord(Keys.ENTER))
}

if (digit1) WebUI.setText(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input_ant-input ant-input-sm css-oiqwb9 ant-inpu'), digit1)
if (digit2) WebUI.setText(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input_ant-input ant-input-sm css-oiqwb9 ant-inpu_1'), digit2)
if (digit3) WebUI.setText(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input_ant-input ant-input-sm css-oiqwb9 ant-inpu_2'), digit3)
if (digit4) WebUI.setText(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input_ant-input ant-input-sm css-oiqwb9 ant-inpu_3'), digit4)
if (digit5) WebUI.setText(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input_ant-input ant-input-sm css-oiqwb9 ant-inpu_4'), digit5)
if (digit6) WebUI.setText(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input_ant-input ant-input-sm css-oiqwb9 ant-inpu_5'), digit6)
if (digit7) WebUI.setText(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input_ant-input ant-input-sm css-oiqwb9 ant-inpu_6'), digit7)
if (digit8) WebUI.setText(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input_ant-input ant-input-sm css-oiqwb9 ant-inpu_7'), digit8)

if (keywordCn) {
	WebUI.setText(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input__3'), keywordCn)
}
if (keywordModel) {
	WebUI.setText(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input__4'), keywordModel)
}
if (keywordNote) {
	WebUI.setText(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_-/input__5'), keywordNote)
}

WebUI.waitForElementClickable(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_- Sun.pro/button__1'), 10)
WebUI.click(findTestObject('04_物料归类管理_MaterialClassify/Review_button/PL_Yu_GL/Page_- Sun.pro/button__1'))