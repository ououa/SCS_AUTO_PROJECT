import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
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

    TestObject usernameInput = findTestObject('04_物料归类管理_MaterialClassify/Review_button/Yu_GL/Page_/input_')
    TestObject passwordInput = findTestObject('04_物料归类管理_MaterialClassify/Review_button/Yu_GL/Page_/input__1')
    TestObject loginButton = findTestObject('04_物料归类管理_MaterialClassify/Review_button/Yu_GL/Page_/button_')

    WebUI.waitForElementVisible(usernameInput, defaultTimeout)
    WebUI.waitForElementVisible(passwordInput, defaultTimeout)
    WebUI.waitForElementClickable(loginButton, defaultTimeout)

    WebUI.setText(usernameInput, username)
    WebUI.setEncryptedText(passwordInput, password)
    WebUI.click(loginButton)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 登录成功断言（后续按实际页面元素调整）
    // WebUI.verifyElementVisible(findTestObject('your_login_success_object'), FailureHandling.STOP_ON_FAILURE)
    // WebUI.verifyTextPresent('登录成功后的关键字', false)

    TestObject materialMenu = findTestObject('04_物料归类管理_MaterialClassify/Review_button/Yu_GL/Page_- Sun.pro/li__r10')
    TestObject reviewSubMenu = findTestObject('04_物料归类管理_MaterialClassify/Review_button/Yu_GL/Page_- Sun.pro/span_')
    TestObject reviewPageMenu = findTestObject('04_物料归类管理_MaterialClassify/Review_button/Yu_GL/Page_- Sun.pro/a__r23')

    WebUI.waitForElementVisible(materialMenu, defaultTimeout)
    WebUI.mouseOver(materialMenu)
    WebUI.waitForElementClickable(reviewSubMenu, defaultTimeout)
    WebUI.click(reviewSubMenu)
    WebUI.waitForElementClickable(reviewPageMenu, defaultTimeout)
    WebUI.click(reviewPageMenu)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 页面跳转成功断言（后续按实际页面元素调整）
    // WebUI.verifyElementVisible(findTestObject('your_review_page_object'), FailureHandling.STOP_ON_FAILURE)
    // WebUI.verifyMatch(WebUI.getUrl(), '.*MaterialReview.*', true)

    TestObject materialCodeTextarea = findTestObject('04_物料归类管理_MaterialClassify/Review_button/Yu_GL/Page_- Sun.pro/textarea_')
    TestObject searchButton = findTestObject('04_物料归类管理_MaterialClassify/Review_button/Yu_GL/Page_- Sun.pro/button_')

    WebUI.waitForElementVisible(materialCodeTextarea, defaultTimeout)
    WebUI.setText(materialCodeTextarea, materialCode)
    WebUI.waitForElementClickable(searchButton, defaultTimeout)
    WebUI.click(searchButton)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 查询结果断言（后续按实际页面元素调整）
    // WebUI.verifyTextPresent(materialCode, false)
    // WebUI.verifyElementVisible(findTestObject('your_search_result_object'), FailureHandling.STOP_ON_FAILURE)

    TestObject rowCheckbox = findTestObject('04_物料归类管理_MaterialClassify/Review_button/Yu_GL/Page_- Sun.pro/input_ant-checkbox-input')
    TestObject classifyActionButton = findTestObject('04_物料归类管理_MaterialClassify/Review_button/Yu_GL/Page_- Sun.pro/svg_svg')

    WebUI.waitForElementClickable(rowCheckbox, defaultTimeout)
    WebUI.click(rowCheckbox)

    // TODO: 勾选成功断言（后续按实际页面元素调整）
    // WebUI.verifyElementChecked(rowCheckbox, defaultTimeout)

    WebUI.waitForElementClickable(classifyActionButton, defaultTimeout)
    WebUI.click(classifyActionButton)

    TestObject classifyDropdown = findTestObject('04_物料归类管理_MaterialClassify/Review_button/Yu_GL/Page_-/span_(001)')
    TestObject classifyInput = findTestObject('04_物料归类管理_MaterialClassify/Review_button/Yu_GL/Page_-/input_')
    TestObject submitButton = findTestObject('04_物料归类管理_MaterialClassify/Review_button/Yu_GL/Page_-/button_')

    WebUI.waitForElementVisible(classifyDropdown, defaultTimeout)
    WebUI.click(classifyDropdown)
    WebUI.waitForElementVisible(classifyInput, defaultTimeout)
    WebUI.setText(classifyInput, classifyCode)
    WebUI.sendKeys(classifyInput, Keys.chord(Keys.ENTER))

    // TODO: 归类值选择成功断言（后续按实际页面元素调整）
    // WebUI.verifyTextPresent(classifyCode, false)
    // WebUI.verifyElementVisible(findTestObject('your_classify_selected_object'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementClickable(submitButton, defaultTimeout)
    WebUI.click(submitButton)
    WebUI.waitForPageLoad(defaultTimeout)

    // TODO: 提交成功断言（后续按实际页面元素调整）
    // WebUI.verifyTextPresent('提交成功', false)
    // WebUI.verifyElementVisible(findTestObject('your_submit_success_object'), FailureHandling.STOP_ON_FAILURE)

} catch (Exception e) {
    WebUI.comment('Case execution failed: ' + e.getMessage())
    WebUI.takeScreenshot()
    throw e
} finally {
    WebUI.closeBrowser()
}
