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

public class BussinessServicesPage {
	
	@Keyword
	def createBSM() {
		
		clickOnNewBSMButton()
		WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)
		enterBSMName()
		enterBSMDescription()
		clickOncontactGroupdropdown()
		navigateToNextPage()
		addHostToBSM()
		navigateToNextPage()
		navigateToNextPage()
		addThresholdValues()
	}

	@Keyword
	def clickOnNewBSMButton() {
		

		WebUI.click(findTestObject('Object Repository/BussinessServicesPage/newBSMButton'))
	}

	@Keyword
	def enterBSMName() {

		WebUI.sendKeys((findTestObject('Object Repository/BussinessServicesPage/bsmName')), 'test2')
	}

	@Keyword
	def enterBSMDescription() {

		WebUI.sendKeys((findTestObject('Object Repository/BussinessServicesPage/bsmDescription')), 'test')
	}

	@Keyword
	def clickOncontactGroupdropdown() {

		WebUI.click(findTestObject('Object Repository/BussinessServicesPage/bsmContactGroupDropdown'))
		WebUI.click(findTestObject('Object Repository/BussinessServicesPage/adminCG'))
		
	}
	
	@Keyword
	def navigateToNextPage() {
		
		WebUI.click(findTestObject('Object Repository/BussinessServicesPage/nextButton'))
	}
	
	@Keyword
	def addHostToBSM() {
		
		WebUI.click(findTestObject('Object Repository/BussinessServicesPage/AddHost'))
	}
	
	@Keyword
	def addThresholdValues() {
		
		WebUI.sendKeys(findTestObject('Object Repository/BussinessServicesPage/criticalValue'), '80')
		WebUI.sendKeys(findTestObject('Object Repository/BussinessServicesPage/okstateValue'), '85')
	}
	
	@Keyword
	def clickOnFinishBtn() {
		
		WebUI.click(findTestObject('Object Repository/BussinessServicesPage/finishButton'))
	}
}
