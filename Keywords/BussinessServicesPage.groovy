import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.server.handler.FindElement

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
	//	WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)
	    enterBSMName()
		enterBSMDescription()
		clickOncontactGroupdropdown(findTestData('Data Files/BSM').getValue('ContactGroup', 1))
		navigateToNextPage()
		addHostToBSM(findTestData('Data Files/BSM').getValue('Hostname', 1))
		navigateToNextPage()
		WebUI.click(findTestObject('Object Repository/BussinessServicesPage/OS'))
		navigateToNextPage()
		//selectthresholdTab()
		addThresholdValues()
		clickOnFinishBtn()
		verifyBSMcreated(findTestData('Data Files/BSM').getValue('Name', 1))
	}

	@Keyword
	def clickOnNewBSMButton() {

		WebUI.waitForElementClickable(findTestObject('Object Repository/BussinessServicesPage/newBSMButton'), 5)
		WebUI.click(findTestObject('Object Repository/BussinessServicesPage/newBSMButton'))
	}

	@Keyword
	def enterBSMName() {

		WebUI.sendKeys((findTestObject('Object Repository/BussinessServicesPage/bsmName')), findTestData('Data Files/BSM').getValue('Name', 1))
	}

	@Keyword
	def enterBSMDescription() {

		WebUI.sendKeys((findTestObject('Object Repository/BussinessServicesPage/bsmDescription')), findTestData('Data Files/BSM').getValue('Description', 1))
	}

	@Keyword
	def clickOncontactGroupdropdown(def CG) {

		WebUI.click(findTestObject('Object Repository/BussinessServicesPage/bsmContactGroupDropdown'))
		WebUI.click(findTestObject('Object Repository/BussinessServicesPage/adminCG', ['CG':CG]))
	}

	@Keyword
	def navigateToNextPage() {
		
		
		WebUI.click(findTestObject('Object Repository/BussinessServicesPage/nextButton'))
	}

	@Keyword
	def addHostToBSM(def hostname) {

		WebUI.click(findTestObject('Object Repository/BussinessServicesPage/AddHost', ['host':hostname]))
	}
	
	@Keyword
	def selectthresholdTab() {
		
		WebUI.click(findTestObject('Object Repository/BussinessServicesPage/OS'))
		WebUI.click(findTestObject('Object Repository/BussinessServicesPage/thresholdTab'))
	}

	@Keyword
	def addThresholdValues() {

		WebUI.sendKeys(findTestObject('Object Repository/BussinessServicesPage/criticalValue'), findTestData('Data Files/BSM').getValue('CriticalValue', 1))
		WebUI.sendKeys(findTestObject('Object Repository/BussinessServicesPage/okstateValue'), findTestData('Data Files/BSM').getValue('OkValue', 1))
	}

	@Keyword
	def clickOnFinishBtn() {

		
		WebUI.click(findTestObject('Object Repository/BussinessServicesPage/finishButton'))
	}
	
	@Keyword
	def verifyBSMcreated(def BSMname) {
		
		WebUI.scrollToElement(findTestObject('Object Repository/BussinessServicesPage/createdBSMName', ['BSMname': BSMname]), 5)
		 
	   if(WebUI.verifyElementPresent(findTestObject('Object Repository/BussinessServicesPage/createdBSMName', ['BSMname': BSMname]), 5).equals(true)) {
		   
		   if(WebUI.verifyElementPresent(findTestObject('Object Repository/BussinessServicesPage/statuscoulmn',['BSMname': BSMname]), 5).equals(true)) {
		   println("BSM created successfully")
		   }
	   }
		else {
			
			println('failed')
			}
	    }
}
