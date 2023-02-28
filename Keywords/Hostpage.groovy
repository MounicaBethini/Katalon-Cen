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
	def createNewHost(def collector) {
		clickOnNewHostButton()
		enterHostName("ManuaHost")
		enterHostDesc()
		enterIpAdd()
		enterMetricCollector(collector)
		enterHostCollector()
		enterHostGroupList()
		saveHost()
		//selectCheckBox("ManuaHost")
		selectContextMenu("ManuaHost")
		selectHostOptions("Add Profile")
	}
	
	@Keyword
	def createQuickHost(def collector) {

		clickonNewQuickHostButton()
		enterHostName("QuickHost")
		enterHostDesc()
		enterIpAdd()
		selectHostprofile()
		enterMetricCollector(collector)
		enterHostCollector()
		enterHostGroupList()
	}

	@Keyword
	def enterHostName(def hostName) {
		WebUI.sendKeys(findTestObject('Object Repository/Hosts/Quickhost/hostName'), hostName)
	}

	@Keyword
	def enterHostDesc() {
		WebUI.sendKeys(findTestObject('Object Repository/Hosts/Quickhost/hostAlias'), "Description")
	}

	@Keyword
	def enterIpAdd() {
		WebUI.sendKeys(findTestObject('Object Repository/Hosts/Quickhost/ipAddress'), "10.0.35.67")
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
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Hosts/Quickhost/hostGroupsList'), 'Linux-Servers', false)
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
		WebUI.click(findTestObject('Object Repository/Hosts/contextMenu',['host':hostName]))
	}
	@Keyword
	def selectHostOptions(def hostOptions) {
		WebUI.click(findTestObject('Object Repository/Hosts/hostOptions',['hostOptions':hostOptions]))
	}
	
	@Keyword
	def verifyHostCreated() {

		if(WebUI.verifyElementPresent(findTestObject('Object Repository/Hosts/Quickhost/createdQuickHostName'), 5).equals(true)) {

			println('A new Quick host created')
		}

		else {

			println('Quick host is not created')
		}
	}
}
