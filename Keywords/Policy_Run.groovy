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

public class Policy_Run {
	@Keyword
	def navigate_TO_AdminTab() {
//Click on Admin tab
		WebUI.click(findTestObject('Object Repository/PageNavigation/Naviate_to_admintab'))
//Click on Management
		WebUI.click(findTestObject('Object Repository/PageNavigation/NaviateTO_management'))
		
//Click on Collectors
		WebUI.click(findTestObject('Object Repository/PageNavigation/Navigate_to_collector'))
	}
	@Keyword
	def run_policyForAllCollectors() {
//Switch to frame
		WebUI.switchToFrame(findTestObject('Object Repository/PageNavigation/SwitchFrame'), 2, FailureHandling.STOP_ON_FAILURE)
		System.out.println(WebUI.getText(findTestObject('Object Repository/SelectAllCollector/Total_collectors_count')).trim())
		def Total_collectors = WebUI.getText(findTestObject('Object Repository/SelectAllCollector/Total_collectors_count')).trim()
		def Expected_result = "0 Collectors"
		//Check if any agents connected to centerity or not
	if(Expected_result.equals(Total_collectors)) {
		
		System.out.println("Please connect at least one agent to centerity")
		
		}
		
	else {
		
		System.out.println("You have "+ Total_collectors)
		System.out.println("Running policy.........")
		
		WebUI.click(findTestObject('Object Repository/SelectAllCollector/SelectALlCollector'))
		WebUI.click(findTestObject('Object Repository/SelectAllCollector/Run_policy'))
		
		WebUI.click(findTestObject('Object Repository/SelectAllCollector/Run_poilicy_button'))
		
		def POlicy_sucess_bool = WebUI.waitForElementVisible(findTestObject('Object Repository/SelectAllCollector/Policy_success'), 7)
		
		if(POlicy_sucess_bool.equals(true))
		{
			
			System.out.println("Policy Run completed sucessfully")
		//def String = WebUI.getCSSValue(null, null)
		
		//System.out.println(WebUI.waitForElementVisible(findTestObject('Object Repository/SelectAllCollector/Policy_success'), 7))
			}
			
		}
		
	}	
}
