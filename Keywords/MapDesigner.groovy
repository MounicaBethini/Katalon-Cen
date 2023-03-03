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
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

import internal.GlobalVariable

public class MapDesigner {
	
	WebDriver driver = DriverFactory.getWebDriver()
	
	@Keyword
	def createMap() {
		
		clickOnAddMapButton()
		switchWindow()
		saveMapName()
		clickOnHostIcon()
		clickOnHostroupIcon()
		clickOnLinkIcon()
		linkHostAndHostGroup()
		assignHosttoElement()
		assignHostGroupToElement(findTestData('Data Files/MapPage').getValue('HostGroup', 1))
		saveTheMap()
		verifyMapSaved()
		closeAndMoveToOriginalWindow()
		//verifyMapCreated(findTestData('Data Files/MapPage').getValue('MapName', 1))
		
		
	}

	@Keyword
	def clickOnAddMapButton() {
		
		WebUI.click(findTestObject('Object Repository/Maps/addMapButton'))
		println(WebUI.getWindowTitle())
	}
	@Keyword
	def switchWindow() {
		
		WebUI.switchToWindowIndex(1, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def saveMapName() {
		
		WebUI.click(findTestObject('Object Repository/Maps/newMapButton'))
		driver.switchTo().alert().sendKeys(findTestData('Data Files/MapPage').getValue('MapName', 1))
		WebUI.acceptAlert()
	}
	
	@Keyword
	def clickOnHostIcon() {
		
		WebUI.click(findTestObject('Object Repository/Maps/hostIcon'))
		
	}
	
	@Keyword
	def clickOnHostroupIcon() {
		
		WebUI.click(findTestObject('Object Repository/Maps/hostGroupIcon'))
		WebUI.dragAndDropByOffset(findTestObject('Object Repository/Maps/hgElement'), 150, 150)
		
	}
	
	@Keyword
	def clickOnLinkIcon() {
		WebUI.click(findTestObject('Object Repository/Maps/linkIcon'))
		
	}
	@Keyword
	def linkHostAndHostGroup() {
		
		Actions builder = new Actions(driver)
		WebElement sourceElement = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Maps/hostElement'), 20)
		WebElement destElement = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Maps/hgElement'), 20)
		builder.clickAndHold(sourceElement)
		WebUI.delay(5)
		builder.moveToElement(destElement).release().build().perform()
	}
	
	@Keyword
	def assignHosttoElement() {
		WebUI.scrollToElement(findTestObject('Object Repository/Maps/hostElement'), 2)
		WebUI.doubleClick(findTestObject('Object Repository/Maps/hostElement'))
		WebUI.click(findTestObject('Object Repository/Maps/enableHostListRadioButton'))
		WebUI.click(findTestObject('Object Repository/Maps/selectHostList'))
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Maps/hostsList'), 1)
		WebUI.click(findTestObject('Object Repository/Maps/saveElement'))
	}
	
	@Keyword
	def assignHostGroupToElement(def host_group) {
		WebUI.doubleClick(findTestObject('Object Repository/Maps/hgElement'))
		WebUI.click(findTestObject('Object Repository/Maps/enbaleHGListRadioButton'))
		WebUI.click(findTestObject('Object Repository/Maps/selectHostGroupList'))
		WebUI.scrollToElement(findTestObject('Object Repository/Maps/hostGroupName',['host_group': host_group]), 5)
		WebUI.click(findTestObject('Object Repository/Maps/hostGroupName',['host_group': host_group]))
		WebUI.click(findTestObject('Object Repository/Maps/saveElement'))
	}
	
	@Keyword
	def saveTheMap() {
		
		WebUI.click(findTestObject('Object Repository/Maps/saveMap'))
	}
	
	@Keyword
	def verifyMapSaved() {
	
		if(WebUI.verifyAlertPresent(5).equals(true)) {
		
		def expectedresult = 'Your map was saved'
	    def actualresult = WebUI.getAlertText()
		if(actualresult.equals(expectedresult)){
			
			println('Map saved sucesfully')
		}
		
		WebUI.acceptAlert()
		
	}
}
	@Keyword
	def closeAndMoveToOriginalWindow() {
		
		WebUI.closeWindowIndex(1)
		WebUI.switchToWindowIndex(0)
		WebUI.refresh()
	}
	
	@Keyword
	def verifyMapCreated(def mapname) {
		
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/Maps/verifyMapName', ['map_name': mapname]),  20).equals(true)) {
			
			println('Map created sucessfully')
		}
	}
}
