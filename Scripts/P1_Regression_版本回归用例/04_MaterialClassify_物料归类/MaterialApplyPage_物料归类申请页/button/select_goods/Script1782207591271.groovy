import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String baseUrl = 'https://newscs-sit.sunwoda.com/'
String password = 'vRPQRzfLAVz/2uHe6SEpgg=='
int defaultTimeout = 20

Closure waitAndClick = { TestObject to, int timeout = defaultTimeout ->
    WebUI.waitForElementClickable(to, timeout)
    WebUI.click(to)
}

Closure waitAndSetText = { TestObject to, String value, int timeout = defaultTimeout ->
    WebUI.waitForElementVisible(to, timeout)
    WebUI.clearText(to, FailureHandling.OPTIONAL)
    WebUI.setText(to, value)
}

try {
    WebUI.openBrowser('')
    WebUI.maximizeWindow()
    WebUI.navigateToUrl(baseUrl)
    WebUI.waitForPageLoad(defaultTimeout)

    TestObject usernameInput = findTestObject('04_??????_MaterialClassify/Page_apply/select_goods/Page_/input__1')
    TestObject passwordInput = findTestObject('04_??????_MaterialClassify/Page_apply/select_goods/Page_/input_')
    TestObject loginButton = findTestObject('04_??????_MaterialClassify/Page_apply/select_goods/Page_/button_')

    waitAndSetText(usernameInput, username)
    WebUI.waitForElementVisible(passwordInput, defaultTimeout)
    WebUI.setEncryptedText(passwordInput, password)
    waitAndClick(loginButton)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 登录成功断言（后续按实际页面元素调整）
    // WebUI.verifyElementVisible(findTestObject('your_login_success_object'), FailureHandling.STOP_ON_FAILURE)
    // WebUI.verifyTextPresent('登录成功后的关键字', false)

    TestObject materialMenu = findTestObject('04_??????_MaterialClassify/Page_apply/select_goods/Page_- Sun.pro/li__r10')
    TestObject applySubMenu = findTestObject('04_??????_MaterialClassify/Page_apply/select_goods/Page_- Sun.pro/span_')
    TestObject applyPageMenu = findTestObject('04_??????_MaterialClassify/Page_apply/select_goods/Page_- Sun.pro/a__r1v')

    WebUI.waitForElementVisible(materialMenu, defaultTimeout)
    WebUI.mouseOver(materialMenu)
    waitAndClick(applySubMenu)
    waitAndClick(applyPageMenu)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 页面跳转成功断言（后续按实际页面元素调整）
    // WebUI.verifyElementVisible(findTestObject('your_select_goods_page_object'), FailureHandling.STOP_ON_FAILURE)
    // WebUI.verifyMatch(WebUI.getUrl(), '.*apply.*', true)

    TestObject openSelectGoodsButton = findTestObject('04_??????_MaterialClassify/Page_apply/select_goods/Page_- Sun.pro/button_')
    TestObject materialCodeInput = findTestObject('04_??????_MaterialClassify/Page_apply/select_goods/Page_- Sun.pro/input_')
    TestObject materialNameInput = findTestObject('04_??????_MaterialClassify/Page_apply/select_goods/Page_- Sun.pro/input__1')
    TestObject currencyInput = findTestObject('04_??????_MaterialClassify/Page_apply/select_goods/Page_- Sun.pro/input__2')
    TestObject currencyDropdownItem = findTestObject('04_??????_MaterialClassify/Page_apply/select_goods/Page_- Sun.pro/div_currCode_list')
    TestObject searchButton = findTestObject('04_??????_MaterialClassify/Page_apply/select_goods/Page_- Sun.pro/button__1')

    waitAndClick(openSelectGoodsButton)
    waitAndSetText(materialCodeInput, materialCode)
    waitAndSetText(materialNameInput, materialName)
    waitAndSetText(currencyInput, currencyCode)
    waitAndClick(currencyDropdownItem)
    waitAndClick(searchButton)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 查询结果断言（后续按实际页面元素调整）
    // WebUI.verifyTextPresent(materialCode, false)
    // WebUI.verifyElementVisible(findTestObject('your_search_result_object'), FailureHandling.STOP_ON_FAILURE)

    TestObject rowCheckbox = findTestObject('04_??????_MaterialClassify/Page_apply/select_goods/Page_- Sun.pro/input_ant-checkbox-input')
    TestObject confirmButton = findTestObject('04_??????_MaterialClassify/Page_apply/select_goods/Page_- Sun.pro/button__2')

    waitAndClick(rowCheckbox)

    // TODO: 勾选成功断言（后续按实际页面元素调整）
    // WebUI.verifyElementChecked(rowCheckbox, defaultTimeout)

    waitAndClick(confirmButton)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 选择商品成功断言（后续按实际页面元素调整）
    // WebUI.verifyTextPresent(materialCode, false)
    // WebUI.verifyElementVisible(findTestObject('your_select_goods_success_object'), FailureHandling.STOP_ON_FAILURE)

} catch (Exception e) {
    WebUI.comment('Case execution failed: ' + e.getMessage())
    WebUI.takeScreenshot()
    throw e
} finally {
    WebUI.closeBrowser()
}
