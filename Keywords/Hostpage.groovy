import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Hostpage {

	@Keyword
	def clickonNewQuickHostButton() {

		WebUI.click(findTestObject('Object Repository/Hosts/Quickhost/newQuickhostbutton'))
	}

	@Keyword
	def clickOnNewHostButton() {
		WebUI.click(findTestObject('Object Repository/Hosts/manualHostButton'))
	}

	@Keyword
	def createNewHost() {
		clickOnNewHostButton()
		enterHostName()
		enterHostDesc()
		enterIpAdd()
		enterMetricCollector(findTestData('Data Files/Hostpage').getValue('MetricCollector', 1))
		enterHostCollector()
		enterHostGroupList()
		saveHost()
		verifyHostCreated(findTestData('Data Files/Hostpage').getValue('HostName', 1))
		selectContextMenu(findTestData('Data Files/Hostpage').getValue('HostName', 1))
		selectHostOptions(findTestData('Data Files/Hostpage').getValue('HostOptions', 1))
		selectHostProfiles(findTestData('Data Files/Hostpage').getValue('HostProfile', 1))
		addProfilesAddButton()
		verifyProfleAdded()
	}

	@Keyword
	def createQuickHost() {
		clickonNewQuickHostButton()
		enterHostName()
		enterHostDesc()
		enterIpAdd()
		selectHostprofile()
		enterMetricCollector(findTestData('Data Files/Hostpage').getValue('MetricCollector', 1))
		enterHostCollector()
		enterHostGroupList()
	}

	@Keyword
	def enterHostName() {
		WebUI.sendKeys(findTestObject('Object Repository/Hosts/Quickhost/hostName'), findTestData('Data Files/Hostpage').getValue('HostName', 1))
	}

	@Keyword
	def enterHostDesc() {
		WebUI.sendKeys(findTestObject('Object Repository/Hosts/Quickhost/hostAlias'), findTestData('Data Files/Hostpage').getValue('HostDescription', 1))
	}

	@Keyword
	def enterIpAdd() {
		WebUI.sendKeys(findTestObject('Object Repository/Hosts/Quickhost/ipAddress'), findTestData('Data Files/Hostpage').getValue('HostIpAddress', 1))
	}

	@Keyword
	def selectHostprofile() {
		WebUI.click(findTestObject('Object Repository/Hosts/Quickhost/hostprofiledropdown'))
		WebUI.click(findTestObject('Object Repository/Hosts/Quickhost/hostprofile'))
	}

	@Keyword
	def enterMetricCollector(def collector) {
		WebUI.click(findTestObject('Object Repository/Hosts/Quickhost/metricCollectordropdown'))
		WebUI.click(findTestObject('Object Repository/Hosts/Quickhost/selectMetricCollector',['collector':collector]))
	}

	@Keyword
	def enterHostCollector() {
		WebUI.click(findTestObject('Object Repository/Hosts/hostCollectorDropDown'))
		WebUI.click(findTestObject('Object Repository/Hosts/selectHostCollector'))
	}

	@Keyword
	def enterHostGroupList() {
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Hosts/Quickhost/hostGroupsList'), findTestData('Data Files/Hostpage').getValue('HostGroup', 1), false)
		WebUI.click(findTestObject('Object Repository/Hosts/Quickhost/forwardsinglehostgroup'))
	}

	@Keyword
	def saveHost() {

		WebUI.click(findTestObject('Object Repository/Hosts/saveHostBtn'))
	}

	@Keyword
	def selectCheckBox(def hostName) {
		WebUI.click(findTestObject('Object Repository/Hosts/checkBox',['host':hostName]))
	}

	@Keyword
	def selectContextMenu(def hostName) {
		WebUI.scrollToElement(findTestObject('Object Repository/Hosts/contextMenu',['host':hostName]), 5)
		WebUI.click(findTestObject('Object Repository/Hosts/contextMenu',['host':hostName]))
	}

	@Keyword
	def selectHostOptions(def hostOptions) {
		WebUI.click(findTestObject('Object Repository/Hosts/hostOptions',['hostOptions':hostOptions]))
	}

	@Keyword
	def selectHostProfiles(def profile) {
		WebUI.click(findTestObject('Object Repository/Hosts/addProfile_HostProfile'))
		WebUI.click(findTestObject('Object Repository/Hosts/addProfile_selectProfile',['profile':profile]))
	}

	@Keyword
	def addProfilesAddButton() {
		WebUI.click(findTestObject('Object Repository/Hosts/addProfile_AddButton'))
	}

	@Keyword
	def verifyProfleAdded() {
		String actualMessage = "All Done"
		String message=WebUI.getText(findTestObject('Object Repository/Hosts/addProfile_Alert'))
		if(message==actualMessage) {
			println("Host Profile added succesfully")
		}
		else if (message!=actualMessage) {
			println(message)
		}
	}
	@Keyword
	def verifyHostCreated(def hostName) {

		if(WebUI.verifyElementPresent(findTestObject('Object Repository/Hosts/Quickhost/createdQuickHostName',['hostName':hostName]), 5).equals(true)) {

			println('A new Quick host created')
		}

		else {

			println('Quick host is not created')
		}
	}
}
