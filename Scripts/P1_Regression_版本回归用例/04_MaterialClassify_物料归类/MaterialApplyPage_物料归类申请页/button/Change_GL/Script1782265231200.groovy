import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String baseUrl = 'https://newscs-sit.sunwoda.com/'
String password = 'vRPQRzfLAVz/2uHe6SEpgg=='
int defaultTimeout = 20

try {
    WebUI.openBrowser('')
    WebUI.maximizeWindow()
    WebUI.navigateToUrl(baseUrl)
    WebUI.waitForPageLoad(defaultTimeout)

    TestObject usernameInput = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_changeGL/Page_/input_')
    TestObject passwordInput = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_changeGL/Page_/input__1')
    TestObject loginButton = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_changeGL/Page_/button_')

    WebUI.waitForElementVisible(usernameInput, defaultTimeout)
    WebUI.waitForElementVisible(passwordInput, defaultTimeout)
    WebUI.waitForElementClickable(loginButton, defaultTimeout)

    WebUI.setText(usernameInput, username)
    WebUI.setEncryptedText(passwordInput, password)
    WebUI.click(loginButton)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 登录成功断言（后续按实际页面元素调整）
    // WebUI.verifyElementVisible(findTestObject('your_login_success_object'))
    // WebUI.verifyTextPresent('登录成功后的关键字', false)

    TestObject materialMenu = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_changeGL/Page_- Sun.pro/li__r10')
    TestObject applyMenu = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_changeGL/Page_- Sun.pro/a__r1v')

    WebUI.waitForElementVisible(materialMenu, defaultTimeout)
    WebUI.mouseOver(materialMenu)
    WebUI.waitForElementClickable(materialMenu, defaultTimeout)
    WebUI.click(materialMenu)
    WebUI.waitForElementClickable(applyMenu, defaultTimeout)
    WebUI.click(applyMenu)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 页面跳转成功断言（后续按实际页面元素调整）
    // WebUI.verifyElementVisible(findTestObject('your_change_page_object'))
    // WebUI.verifyMatch(WebUI.getUrl(), '.*change.*', true)

    TestObject materialCodeTextarea = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_changeGL/Page_- Sun.pro/textarea_')
    TestObject searchButton = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_changeGL/Page_- Sun.pro/button_')

    WebUI.waitForElementVisible(materialCodeTextarea, defaultTimeout)
    WebUI.setText(materialCodeTextarea, materialCode)
    WebUI.waitForElementClickable(searchButton, defaultTimeout)
    WebUI.click(searchButton)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 查询结果断言（后续按实际页面元素调整）
    // WebUI.verifyTextPresent(materialCode, false)
    // WebUI.verifyElementVisible(findTestObject('your_search_result_object'))

    TestObject rowCheckbox = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_changeGL/Page_- Sun.pro/input_ant-checkbox-input')
    TestObject changeButton = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_changeGL/Page_- Sun.pro/button__1')

    WebUI.waitForElementClickable(rowCheckbox, defaultTimeout)
    WebUI.click(rowCheckbox)

    // TODO: 勾选成功断言（后续按实际页面元素调整）
    // WebUI.verifyElementChecked(rowCheckbox, defaultTimeout)

    WebUI.waitForElementClickable(changeButton, defaultTimeout)
    WebUI.click(changeButton)

    TestObject reasonTextarea = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_changeGL/Page_- Sun.pro/textarea__1')
    TestObject confirmButton = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_changeGL/Page_- Sun.pro/button__2')

    WebUI.waitForElementVisible(reasonTextarea, defaultTimeout)
    WebUI.setText(reasonTextarea, changeReason)
    WebUI.waitForElementClickable(confirmButton, defaultTimeout)
    WebUI.click(confirmButton)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 变更成功断言（后续按实际页面元素调整）
    // WebUI.verifyTextPresent('变更成功', false)
    // WebUI.verifyElementVisible(findTestObject('your_change_success_object'))

} catch (Exception e) {
    WebUI.comment('Case execution failed: ' + e.getMessage())
    WebUI.takeScreenshot()
    throw e
} finally {
    WebUI.closeBrowser()
}
