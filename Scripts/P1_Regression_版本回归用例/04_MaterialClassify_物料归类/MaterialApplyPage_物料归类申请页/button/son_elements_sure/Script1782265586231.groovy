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

    TestObject usernameInput = findTestObject('04_??????_MaterialClassify/Review_button/Yu_GL/Page_/input_')
    TestObject passwordInput = findTestObject('04_??????_MaterialClassify/Review_button/Yu_GL/Page_/input__1')
    TestObject loginButton = findTestObject('04_??????_MaterialClassify/Review_button/Yu_GL/Page_/button_')

    waitAndSetText(usernameInput, username)
    WebUI.waitForElementVisible(passwordInput, defaultTimeout)
    WebUI.setEncryptedText(passwordInput, password)
    waitAndClick(loginButton)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 登录成功断言（后续按实际页面元素调整）
    // WebUI.verifyElementVisible(findTestObject('your_login_success_object'), FailureHandling.STOP_ON_FAILURE)
    // WebUI.verifyTextPresent('登录成功后的关键字', false)

    TestObject materialMenu = findTestObject('04_??????_MaterialClassify/Review_button/Yu_GL/Page_- Sun.pro/li__r10')
    TestObject targetPageMenu = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_sonelementsure/Page_-/a__r1v')

    WebUI.waitForElementVisible(materialMenu, defaultTimeout)
    WebUI.mouseOver(materialMenu)
    waitAndClick(targetPageMenu)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 页面跳转成功断言（后续按实际页面元素调整）
    // WebUI.verifyElementVisible(findTestObject('your_son_element_page_object'), FailureHandling.STOP_ON_FAILURE)
    // WebUI.verifyMatch(WebUI.getUrl(), '.*apply.*', true)

    TestObject materialCodeTextarea = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_sonelementsure/Page_- Sun.pro/textarea__1')
    TestObject searchButton = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_sonelementsure/Page_- Sun.pro/button__1')
    TestObject firstCheckbox = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_sonelementsure/Page_- Sun.pro/input_ant-checkbox-input_2')
    TestObject firstConfirmButton = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_sonelementsure/Page_- Sun.pro/button__2')
    TestObject secondCheckbox = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_sonelementsure/Page_- Sun.pro/input_ant-checkbox-input_3')
    TestObject secondConfirmButton = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_sonelementsure/Page_- Sun.pro/button__3')

    waitAndSetText(materialCodeTextarea, materialCode)
    waitAndClick(searchButton)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 查询结果断言（后续按实际页面元素调整）
    // WebUI.verifyTextPresent(materialCode, false)
    // WebUI.verifyElementVisible(findTestObject('your_search_result_object'), FailureHandling.STOP_ON_FAILURE)

    waitAndClick(firstCheckbox)

    // TODO: 第一次勾选成功断言（后续按实际页面元素调整）
    // WebUI.verifyElementChecked(firstCheckbox, defaultTimeout)

    waitAndClick(firstConfirmButton)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 第一次确认成功断言（后续按实际页面元素调整）
    // WebUI.verifyTextPresent('第一次确认成功', false)

    waitAndClick(secondCheckbox)

    // TODO: 第二次勾选成功断言（后续按实际页面元素调整）
    // WebUI.verifyElementChecked(secondCheckbox, defaultTimeout)

    waitAndClick(secondConfirmButton)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 最终提交成功断言（后续按实际页面元素调整）
    // WebUI.verifyTextPresent('提交成功', false)
    // WebUI.verifyElementVisible(findTestObject('your_submit_success_object'), FailureHandling.STOP_ON_FAILURE)

} catch (Exception e) {
    WebUI.comment('Case execution failed: ' + e.getMessage())
    WebUI.takeScreenshot()
    throw e
} finally {
    WebUI.closeBrowser()
}
