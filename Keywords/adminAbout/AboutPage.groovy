package adminAbout

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

public class AboutPage {

	@Keyword
	def verifySoftwareVersion(def softwareVersion) {
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/AdminAboutPage/softwareVersion'), 1, FailureHandling.STOP_ON_FAILURE)) {
			def version = WebUI.getText(findTestObject('Object Repository/AdminAboutPage/softwareVersion'))
			if(version != null && version == softwareVersion) {
				println ("The actual version and expected version are matching with following version : "+version);
			}
			else {
				println ("The actual version and expected version are mis matching with following version : "+version)
			}
		}
	}

	@Keyword
	def clickOnSummary() {
		WebUI.click(findTestObject('Object Repository/AdminAboutPage/summaryMenu'))
	}

	@Keyword
	def verifyHostName() {
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/AdminAboutPage/hostName'), 1, FailureHandling.STOP_ON_FAILURE)) {
			String hostName = WebUI.getText(findTestObject('Object Repository/AdminAboutPage/hostName'))
			int hostlength = hostName.length();
			if(hostName != null && hostlength>9) {
				println ("The Host Name is of New Type and it is as follows :"+hostName)
			}
			else {
				println("The Host Name is of Old Type which is not acceptable and it is as follows :"+hostName)
			}
		}
	}

	@Keyword
	def verifyLicenseKey() {
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/AdminAboutPage/key'), 1, FailureHandling.STOP_ON_FAILURE)) {
			String licenseKey = WebUI.getText(findTestObject('Object Repository/AdminAboutPage/key'))

			if(licenseKey != null) {
				println ("The License Key is present and it is as follows :"+licenseKey)
			}
		}
	}


	@Keyword
	def verifyDealerKey() {
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/AdminAboutPage/dealerPublicKey'), 1, FailureHandling.STOP_ON_FAILURE)) {
			String dealerKey = WebUI.getText(findTestObject('Object Repository/AdminAboutPage/dealerPublicKey'))

			if(dealerKey != null) {
				println ("The Dealer Key present and it is as follows :"+dealerKey)
			}
		}
	}

	@Keyword
	def verifySQLRunnerKey() {
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/AdminAboutPage/sqlRunnerKey'), 1, FailureHandling.STOP_ON_FAILURE)) {
			String sqlRunnerKey = WebUI.getText(findTestObject('Object Repository/AdminAboutPage/sqlRunnerKey'))

			if(sqlRunnerKey != null) {
				println ("The SQL Runner Key is present and it is as follows :"+sqlRunnerKey)
			}
		}
	}

	@Keyword
	def clickOnLicenseMenu() {
		WebUI.click(findTestObject('Object Repository/AdminAboutPage/licenseMenu'))
	}

	@Keyword
	def verifyVersionInLicenseMenu(def softwareVersion) {
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/AdminAboutPage/versionLicensePage'), 1, FailureHandling.STOP_ON_FAILURE)) {
			def version = WebUI.getText(findTestObject('Object Repository/AdminAboutPage/versionLicensePage'))
			if(version != null && version == softwareVersion) {
				println ("The actual version and expected version are matching with following version : "+version);
			}
			else {
				println("The actual version and expected version are mis matching with following version :"+version)
			}
		}
	}
}

