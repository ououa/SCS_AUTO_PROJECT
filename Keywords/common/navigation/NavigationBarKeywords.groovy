package common.navigation

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class NavigationBarKeywords {

    @Keyword
    def navToMaterialMaster() {
        WebUI.click(findTestObject('NavigationBar_导航栏/MaterialClassificationManage_物料归类管理_主栏/导航_01_物料主档/Page_- Sun.pro/a_'))
    }

    @Keyword
    def navToVendorMaterialMaintenance() {
        WebUI.click(findTestObject('NavigationBar_导航栏/MaterialClassificationManage_物料归类管理_主栏/导航_02_供应商物料维护/Page_- Sun.pro/a_'))
        WebUI.click(findTestObject('NavigationBar_导航栏/MaterialClassificationManage_物料归类管理_主栏/导航_02_供应商物料维护/Page_- Sun.pro/span_'))
    }

    @Keyword
    def navToMaterialClassificationApply() {
        WebUI.click(findTestObject('NavigationBar_导航栏/MaterialClassificationManage_物料归类管理_主栏/导航_03_物料归类申请/Page_- Sun.pro/a__r21'))
        WebUI.click(findTestObject('NavigationBar_导航栏/MaterialClassificationManage_物料归类管理_主栏/导航_03_物料归类申请/Page_- Sun.pro/span_'))
    }

    @Keyword
    def navToMergeRelationManage() {
        WebUI.click(findTestObject('NavigationBar_导航栏/MaterialClassificationManage_物料归类管理_主栏/导航_04_归并关系管理/Page_- Sun.pro/a__r23'))
        WebUI.click(findTestObject('NavigationBar_导航栏/MaterialClassificationManage_物料归类管理_主栏/导航_04_归并关系管理/Page_- Sun.pro/span_'))
    }

    @Keyword
    def navToMaterialClassificationReview() {
        WebUI.click(findTestObject('NavigationBar_导航栏/MaterialClassificationManage_物料归类管理_主栏/导航_05_物料归类审核/Page_- Sun.pro/a__r25'))
        WebUI.click(findTestObject('NavigationBar_导航栏/MaterialClassificationManage_物料归类管理_主栏/导航_05_物料归类审核/Page_- Sun.pro/span_'))
    }

    @Keyword
    def navToClassificationArchive() {
        WebUI.click(findTestObject('NavigationBar_导航栏/MaterialClassificationManage_物料归类管理_主栏/导航_06_归类档案库/Page_- Sun.pro/a__r27'))
        WebUI.click(findTestObject('NavigationBar_导航栏/MaterialClassificationManage_物料归类管理_主栏/导航_06_归类档案库/Page_- Sun.pro/span_'))
    }
}