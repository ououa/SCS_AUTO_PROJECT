import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys

String baseUrl = 'https://newscs-sit.sunwoda.com/'
String password = 'vRPQRzfLAVz/2uHe6SEpgg=='
int defaultTimeout = 20

try {
    WebUI.openBrowser('')
    WebUI.maximizeWindow()
    WebUI.navigateToUrl(baseUrl)
    WebUI.waitForPageLoad(defaultTimeout)

    TestObject usernameInput = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_applymat/Page_/input_')
    TestObject passwordInput = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_applymat/Page_/input__1')
    TestObject loginButton = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_applymat/Page_/button_')

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

    TestObject materialMenu = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_applymat/Page_- Sun.pro/li__r10')
    TestObject applyMenu = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_applymat/Page_- Sun.pro/a__r1v')

    WebUI.waitForElementVisible(materialMenu, defaultTimeout)
    WebUI.mouseOver(materialMenu)
    WebUI.waitForElementClickable(materialMenu, defaultTimeout)
    WebUI.click(materialMenu)
    WebUI.waitForElementClickable(applyMenu, defaultTimeout)
    WebUI.click(applyMenu)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 页面跳转成功断言（后续按实际页面元素调整）
    // WebUI.verifyElementVisible(findTestObject('your_apply_page_object'))
    // WebUI.verifyMatch(WebUI.getUrl(), '.*apply.*', true)

    TestObject materialCodeTextarea = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_applymat/Page_- Sun.pro/textarea_')
    TestObject classifyDropdown = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_applymat/Page_- Sun.pro/div_')
    TestObject classifyInput = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_applymat/Page_- Sun.pro/input_')
    TestObject searchButton = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_applymat/Page_- Sun.pro/button_')

    WebUI.waitForElementVisible(materialCodeTextarea, defaultTimeout)
    WebUI.setText(materialCodeTextarea, materialCode)
    WebUI.waitForElementClickable(classifyDropdown, defaultTimeout)
    WebUI.click(classifyDropdown)
    WebUI.waitForElementVisible(classifyInput, defaultTimeout)
    WebUI.setText(classifyInput, classifyCode)
    WebUI.sendKeys(classifyInput, Keys.chord(Keys.ENTER))
    WebUI.waitForElementClickable(searchButton, defaultTimeout)
    WebUI.click(searchButton)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 查询结果断言（后续按实际页面元素调整）
    // WebUI.verifyTextPresent(materialCode, false)
    // WebUI.verifyElementVisible(findTestObject('your_search_result_object'))

    TestObject rowCheckbox = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_applymat/Page_- Sun.pro/input_ant-checkbox-input')
    TestObject submitButton = findTestObject('04_??????_MaterialClassify/Apply_buttom/Page_applymat/Page_- Sun.pro/button__1')

    WebUI.waitForElementClickable(rowCheckbox, defaultTimeout)
    WebUI.click(rowCheckbox)

    // TODO: 勾选成功断言（后续按实际页面元素调整）
    // WebUI.verifyElementChecked(rowCheckbox, defaultTimeout)

    WebUI.waitForElementClickable(submitButton, defaultTimeout)
    WebUI.click(submitButton)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 提交成功断言（后续按实际页面元素调整）
    // WebUI.verifyTextPresent('提交成功', false)
    // WebUI.verifyElementVisible(findTestObject('your_submit_success_object'))

} catch (Exception e) {
    WebUI.comment('Case execution failed: ' + e.getMessage())
    WebUI.takeScreenshot()
    throw e
} finally {
    WebUI.closeBrowser()
}
