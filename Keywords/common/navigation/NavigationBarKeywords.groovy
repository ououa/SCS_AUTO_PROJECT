package common.navigation

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class NavigationBarKeywords {

    @Keyword
    def openSupplierMaterialMaintenance() {
        WebUI.click(findTestObject('??_02_???????/Page_- Sun.pro/a_'))
        WebUI.click(findTestObject('null'))
    }

    @Keyword
    def openMergeRelationshipManagement() {
        WebUI.callTestCase(findTestCase('Test Cases/P1_Regression_版本回归用例/NavigationBar_导航栏/Common_导航_归并关系管理'), [:])
    }

    @Keyword
    def openClassificationArchive() {
        WebUI.callTestCase(findTestCase('Test Cases/P1_Regression_版本回归用例/NavigationBar_导航栏/Common_导航_归类档案库'), [:])
    }

    @Keyword
    def openMaterialMasterManagement() {
        WebUI.callTestCase(findTestCase('Test Cases/P1_Regression_版本回归用例/NavigationBar_导航栏/Common_导航_物料主档管理'), [:])
    }

    @Keyword
    def openMaterialClassificationReview() {
        WebUI.callTestCase(findTestCase('Test Cases/P1_Regression_版本回归用例/NavigationBar_导航栏/Common_导航_物料归类审核'), [:])
    }

    @Keyword
    def openMaterialClassificationApply() {
        WebUI.callTestCase(findTestCase('Test Cases/P1_Regression_版本回归用例/NavigationBar_导航栏/Common_导航_物料归类申请'), [:])
    }
}
