import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/**
 * 新增物料主档（含事业部和定价）
 *
 * 依赖数据：
 * - Data Files/Add/Add_CaseIndex
 * - Data Files/Add/Add_MainInfo
 * - Data Files/Add/Add_OrgSelect
 * - Data Files/Add_Add/PricingInfo
 */
String caseId = (binding.hasVariable('CaseID') ? CaseID : '').toString().trim()

if (!caseId) {
	KeywordUtil.markFailedAndStop('缺少必填参数：CaseID')
}

TestData tdCaseIndex = findTestData('Data Files/Add/Add_CaseIndex')
TestData tdMain = findTestData('Data Files/Add/Add_MainInfo')
TestData tdOrg = findTestData('Data Files/Add/Add_OrgSelect')
TestData tdPrice = findTestData('Data Files/Add/Add_PricingInfo')

int caseIndexRow = findRowByCaseId(tdCaseIndex, caseId)
if (caseIndexRow == -1) {
	KeywordUtil.markFailedAndStop("CaseIndex 中未找到 CaseID='${caseId}'")
}

String executeFlag = getRequiredCell(tdCaseIndex, 'Execute', caseIndexRow, 'CaseIndex', caseId)
if (!isYes(executeFlag)) {
	KeywordUtil.markWarning("CaseID='${caseId}' 在 CaseIndex 中配置为不执行，测试结束")
	return
}

boolean hasOrgSelect = isYes(getCell(tdCaseIndex, 'HasOrgSelect', caseIndexRow))
boolean hasPricing = isYes(getCell(tdCaseIndex, 'HasPricing', caseIndexRow))

int mainRow = findRowByCaseId(tdMain, caseId)
if (mainRow == -1) {
	KeywordUtil.markFailedAndStop("MainInfo 中未找到 CaseID='${caseId}'")
}

int orgRow = findRowByCaseId(tdOrg, caseId)
if (hasOrgSelect && orgRow == -1) {
	KeywordUtil.markFailedAndStop("CaseID='${caseId}' 需要维护事业部，但 OrgSelect 中未找到对应数据")
}

List<Integer> priceRows = findAllRowsByCaseId(tdPrice, caseId)
if (hasPricing && priceRows.isEmpty()) {
	KeywordUtil.markFailedAndStop("CaseID='${caseId}' 需要维护定价，但 PricingInfo 中未找到对应数据")
}

Map mainInfo = [
	itemcode    : getRequiredCell(tdMain, 'itemcode', mainRow, 'MainInfo', caseId),
	unitcode    : getRequiredCell(tdMain, 'unitcode', mainRow, 'MainInfo', caseId),
	itemtype    : getRequiredCell(tdMain, 'itemtype', mainRow, 'MainInfo', caseId),
	materialName: getRequiredCell(tdMain, 'materialName', mainRow, 'MainInfo', caseId),
	itemmodel   : getCell(tdMain, 'itemmodel', mainRow),
	note        : getCell(tdMain, 'note', mainRow)
]

Map orgInfo = hasOrgSelect ? [
	selectVal1: getRequiredCell(tdOrg, 'selectVal1', orgRow, 'OrgSelect', caseId),
	oucode    : getRequiredCell(tdOrg, 'oucode', orgRow, 'OrgSelect', caseId),
	ouname    : getRequiredCell(tdOrg, 'ouname', orgRow, 'OrgSelect', caseId)
] : [:]

List<Map> pricingList = priceRows.collect { int row ->
	[
		KGtpye     : getRequiredCell(tdPrice, 'KGtpye', row, 'PricingInfo', caseId),
		KGcode     : getRequiredCell(tdPrice, 'KGcode', row, 'PricingInfo', caseId),
		currency   : getRequiredCell(tdPrice, 'currency', row, 'PricingInfo', caseId),
		trantype   : getRequiredCell(tdPrice, 'trantype', row, 'PricingInfo', caseId),
		priceoucode: getRequiredCell(tdPrice, 'priceoucode', row, 'PricingInfo', caseId),
		price      : getRequiredCell(tdPrice, 'price', row, 'PricingInfo', caseId)
	]
}

WebUI.comment("开始执行新增物料主档，CaseID=${caseId}")
openAddMaterialPage()
fillMainInfo(mainInfo)

if (hasOrgSelect) {
	fillOrgInfo(caseId, orgInfo)
}

if (hasPricing) {
	fillPricingInfo(caseId, pricingList)
}

WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/button_'))
WebUI.comment("新增物料主档完成，CaseID=${caseId}")

void openAddMaterialPage() {
	WebUI.mouseOver(findTestObject('Old_Obj/Page_MAT/Page_- Sun.pro/li__r10'))
	WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_- Sun.pro/span_'))
	WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_Sun.pro/a__r1p'))
	WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_- Sun.pro/svg_svg_1'))
}

void fillMainInfo(Map mainInfo) {
	WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/input_'), mainInfo.itemcode)
	WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/input__1'), mainInfo.unitcode)
	WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/input__2'), mainInfo.itemtype)
	WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/span_'))
	WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/input__3'), mainInfo.materialName)
	WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/input__4'), mainInfo.itemmodel)
	WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/input__5'), mainInfo.note)
}

void fillOrgInfo(String caseId, Map orgInfo) {
	WebUI.comment("CaseID=${caseId} 开始维护事业部信息")
	WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/span__1'))
	WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/input_rc_select_10'), orgInfo.selectVal1)
	WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_WLLX/div_XZ'))
	WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/input__6'), orgInfo.oucode)
	WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/input__7'), orgInfo.ouname)
	WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/svg_svg'))
	WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/td_ant-table-cell ant-table-selection-column ant'))
	WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/span__3'))
}

void fillPricingInfo(String caseId, List<Map> pricingList) {
	WebUI.comment("CaseID=${caseId} 开始维护定价信息，共 ${pricingList.size()} 条")
	WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/div_rc-tabs-2-tab-price'))

	pricingList.eachWithIndex { Map pricing, int index ->
		WebUI.comment("开始维护第 ${index + 1} 条定价信息")
		WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/span__4'))
		WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/div_'))
		WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/svg_svg_1'))
		WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/input__8'), pricing.KGtpye)
		WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_shangjialeixing/div_2'))
		WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/input__9'), pricing.KGcode)
		WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/div_16172URBAN WALL'))
		WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/input__10'), pricing.currency)
		WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/span_(USD)'))
		WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/input__11'), pricing.trantype)
		WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/span__6'))
		WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/input__12'), pricing.priceoucode)
		WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/span_270'))
		WebUI.setText(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/input__13'), pricing.price)
		WebUI.click(findTestObject('Old_Obj/Page_MAT/Page_AddItem/Page_Peoa/Page_-/span__3'))
	}
}

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

List<Integer> findAllRowsByCaseId(TestData td, String targetCaseId) {
	List<Integer> rows = []
	int rowCount = td.getRowNumbers()
	for (int i = 1; i <= rowCount; i++) {
		String value = td.getValue('CaseID', i)?.toString()?.trim()
		if (targetCaseId == value) {
			rows.add(i)
		}
	}
	return rows
}

String getCell(TestData td, String columnName, int row) {
	return td.getValue(columnName, row)?.toString()?.trim() ?: ''
}

String getRequiredCell(TestData td, String columnName, int row, String dataName, String caseIdValue) {
	String value = getCell(td, columnName, row)
	if (!value) {
		KeywordUtil.markFailedAndStop("${dataName} 中 CaseID='${caseIdValue}' 的字段 '${columnName}' 不能为空")
	}
	return value
}

boolean isYes(String value) {
	return value != null && ['Y', 'YES', 'TRUE', '1'].contains(value.trim().toUpperCase())
}
