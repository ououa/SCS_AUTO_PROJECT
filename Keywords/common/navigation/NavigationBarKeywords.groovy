package common.navigation

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class NavigationBarKeywords {

    private void clickMenu(String parentObjectId, String childObjectId) {
        WebUI.waitForElementVisible(findTestObject(parentObjectId), 10)
        WebUI.waitForElementClickable(findTestObject(parentObjectId), 10)
        WebUI.click(findTestObject(parentObjectId))

        WebUI.waitForElementVisible(findTestObject(childObjectId), 10)
        WebUI.waitForElementClickable(findTestObject(childObjectId), 10)
        WebUI.click(findTestObject(childObjectId))

        WebUI.delay(1)
    }

    @Keyword
    def goto供应商物料维护() {
        clickMenu(
            'Object Repository/NavigationBar_导航栏/导航_01_物料主档/Page_- Sun.pro/a__r1t',
            'Object Repository/NavigationBar_导航栏/导航_02_供应商物料维护/Page_- Sun.pro/a_'
        )
    }

    @Keyword
    def goto物料归类申请() {
        clickMenu(
            'Object Repository/NavigationBar_导航栏/导航_01_物料主档/Page_- Sun.pro/a__r1t',
            'Object Repository/NavigationBar_导航栏/导航_03_物料归类申请/Page_- Sun.pro/a__r21'
        )
    }

    @Keyword
    def goto归并关系管理() {
        clickMenu(
            'Object Repository/NavigationBar_导航栏/导航_01_物料主档/Page_- Sun.pro/a__r1t',
            'Object Repository/NavigationBar_导航栏/导航_04_归并关系管理/Page_- Sun.pro/a__r23'
        )
    }

    @Keyword
    def goto物料归类审核() {
        clickMenu(
            'Object Repository/NavigationBar_导航栏/导航_01_物料主档/Page_- Sun.pro/a__r1t',
            'Object Repository/NavigationBar_导航栏/导航_05_物料归类审核/Page_- Sun.pro/a__r25'
        )
    }

    @Keyword
    def goto归类档案库() {
        clickMenu(
            'Object Repository/NavigationBar_导航栏/导航_01_物料主档/Page_- Sun.pro/a__r1t',
            'Object Repository/NavigationBar_导航栏/导航_06_归类档案库/Page_- Sun.pro/a__r27'
        )
    }

    @Keyword
    def goto物料主档管理() {
        WebUI.waitForElementVisible(findTestObject('Object Repository/NavigationBar_导航栏/导航_01_物料主档/Page_- Sun.pro/a__r1t'), 10)
        WebUI.waitForElementClickable(findTestObject('Object Repository/NavigationBar_导航栏/导航_01_物料主档/Page_- Sun.pro/a__r1t'), 10)
        WebUI.click(findTestObject('Object Repository/NavigationBar_导航栏/导航_01_物料主档/Page_- Sun.pro/a__r1t'))
        WebUI.delay(1)
    }
}
