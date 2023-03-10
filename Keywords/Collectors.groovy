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

public class Collectors {

	@Keyword
	def runPolicyForAllCollectors() {
		//Switch to frame
		WebUI.switchToFrame(findTestObject('Object Repository/PageNavigation/SwitchFrame'), 2, FailureHandling.STOP_ON_FAILURE)
		System.out.println(WebUI.getText(findTestObject('Object Repository/CollectorPage/Total_collectors_count')).trim())
		def Total_collectors = WebUI.getText(findTestObject('Object Repository/CollectorPage/Total_collectors_count')).trim()
		def Expected_result = "0 Collectors"
		//Check if any agents connected to centerity or not
		if(Expected_result.equals(Total_collectors)) {

			println("Please connect at least one agent to centerity")

		}

		else {

			println("You have "+ Total_collectors)
			println("Running policy.........")

			WebUI.click(findTestObject('Object Repository/CollectorPage/SelectALlCollector'))
			WebUI.click(findTestObject('Object Repository/CollectorPage/Run_policy'))

			WebUI.click(findTestObject('Object Repository/CollectorPage/Run_poilicy_button'))

			WebUI.waitForElementVisible(findTestObject('Object Repository/CollectorPage/policySuccessVerificationText'), 10, FailureHandling.STOP_ON_FAILURE)

			def Policy_color = WebUI.getAttribute(findTestObject('Object Repository/CollectorPage/policySuccessVerificationIcon'), 'style')
			println(Policy_color)

			if(Policy_color.equals('color: green;'))
			{

				println("Policy Run completed sucessfully")

			}

			else {

				println("Policy failed...")
				println("Please check policy debug log!")
			}

		}

	}
}
