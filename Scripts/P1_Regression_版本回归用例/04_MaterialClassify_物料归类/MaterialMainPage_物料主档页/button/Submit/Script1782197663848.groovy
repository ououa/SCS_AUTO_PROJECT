import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.click(findTestObject('Object Repository/04_物料归类管理_MaterialClassify/Main_button/list_checkbox/input__checkbox'))

WebUI.click(findTestObject('Object Repository/04_物料归类管理_MaterialClassify/Main_button/Page_button/button_submit'))

WebUI.click(findTestObject('Object Repository/04_物料归类管理_MaterialClassify/Main_button/Page_button/span__submit_sure'))

TestObject txtStopSuccess = new TestObject('txtStopSuccess')

txtStopSuccess.addProperty('xpath', ConditionType.EQUALS, '//*[normalize-space(text())=\'提交商品维护成功\']')

WebUI.verifyElementPresent(txtStopSuccess, 10)

