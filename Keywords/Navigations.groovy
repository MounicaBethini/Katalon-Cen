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
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable

public class Navigations {
	@Keyword
	def navigate_TO_AdminTab() {
		//Click on Admin tab
		WebUI.click(findTestObject('Object Repository/PageNavigation/Naviate_to_admintab'))
	}
	@Keyword
	def navigateToManagamenet() {
		//Click on Management
		WebUI.click(findTestObject('Object Repository/PageNavigation/NaviateTO_management'))
	}

	@Keyword
	def navigateToCollectorPage() {
		//Click on Collectors
		WebUI.click(findTestObject('Object Repository/PageNavigation/Navigate_to_collector'))
	}

	@Keyword
	def navigateToDiscoveryPage() {
		WebUI.click(findTestObject('Object Repository/PageNavigation/discoveryPage'))
	}

	@Keyword
	def naviateToHostPage() {

		WebUI.click(findTestObject('Object Repository/PageNavigation/hostpage'))
	}

	@Keyword
	def navigateToBSMPage() {

		WebUI.click(findTestObject('Object Repository/PageNavigation/BussinesServicePage'))
	}

	@Keyword
	def switchToFrame() {

		WebUI.switchToFrame(findTestObject('Object Repository/PageNavigation/SwitchFrame'), 2, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def naviateToMapsMainPage() {
		WebUI.click(findTestObject('Object Repository/PageNavigation/mapsMainpage'), FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def navigateToMapDesignerPage() {
		WebUI.click(findTestObject('Object Repository/PageNavigation/mapDesigner'), FailureHandling.STOP_ON_FAILURE)
	}
	
	@Keyword
	def navigateToAdminAboutPage() {
		WebUI.click(findTestObject('Object Repository/PageNavigation/AdminABoutPage'))
	}
}
