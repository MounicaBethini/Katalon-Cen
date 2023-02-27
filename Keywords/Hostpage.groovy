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
		enterMetricCollector()
	}
	
	@Keyword
	def enterHostName() {
		WebUI.sendKeys(findTestObject('Object Repository/Hosts/Quickhost/hostName'), 'Manual_host')
			}
			
	@Keyword
	def enterHostDesc() {
		WebUI.sendKeys(findTestObject('Object Repository/Hosts/Quickhost/hostAlias'), 'Description')
	}
	
	@Keyword
	def enterIpAdd() {
		WebUI.sendKeys(findTestObject('Object Repository/Hosts/Quickhost/ipAddress'), '10.0.35.67')
	}
	
	@Keyword
	def enterMetricCollector() {
		WebUI.click(findTestObject('Object Repository/Hosts/Quickhost/metricCollectordropdown'))
		WebUI.click(findTestObject('Object Repository/Hosts/Quickhost/selectMetricCollector'))
	}
	
	@Keyword
	def enterHostGroupList() {
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Hosts/Quickhost/hostGroupsList'), 'Linux-Servers', false)
	}

	@Keyword
	def enterDatatoQuickHost() {

		WebUI.sendKeys(findTestObject('Object Repository/Hosts/Quickhost/hostName'), 'Quick_host')
		WebUI.sendKeys(findTestObject('Object Repository/Hosts/Quickhost/hostAlias'), 'Desc')
		WebUI.sendKeys(findTestObject('Object Repository/Hosts/Quickhost/ipAddress'), '10.0.35.78')
		WebUI.click(findTestObject('Object Repository/Hosts/Quickhost/hostprofiledropdown'))
		WebUI.click(findTestObject('Object Repository/Hosts/Quickhost/hostprofile'))
		WebUI.click(findTestObject('Object Repository/Hosts/Quickhost/metricCollectordropdown'))
		WebUI.click(findTestObject('Object Repository/Hosts/Quickhost/selectMetricCollector'))
		//WebUI.selectAllOption(findTestObject('Object Repository/Hosts/Quickhost/hostGroupsList'), FailureHandling.STOP_ON_FAILURE)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Hosts/Quickhost/hostGroupsList'), 'Linux-Servers', false)
		WebUI.click(findTestObject('Object Repository/Hosts/Quickhost/forwardsinglehostgroup'))
	
	}
	@Keyword
	def saveQuickHost() {

		WebUI.click(findTestObject('Object Repository/Hosts/saveHostBtn'))
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
