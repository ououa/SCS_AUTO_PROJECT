import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.click(findTestObject('Object Repository/04_物料归类管理_MaterialClassify/Main_button/list_checkbox/input__checkbox'))
WebUI.click(findTestObject('Object Repository/04_物料归类管理_MaterialClassify/Main_button/Page_button/button_stop'))
WebUI.click(findTestObject('Object Repository/04_物料归类管理_MaterialClassify/Main_button/Page_button/button_stop_sure'))
WebUI.verifyTextPresent('停用成功', false)
