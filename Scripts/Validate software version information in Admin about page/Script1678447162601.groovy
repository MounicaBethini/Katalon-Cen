import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomKeywords.'Login_page.loginTOTheApplication'()
CustomKeywords.'Navigations.navigate_TO_AdminTab'()
CustomKeywords.'Navigations.navigateToAdminAboutPage'()
CustomKeywords.'Navigations.switchToFrame'()
CustomKeywords.'adminAbout.AboutPage.verifySoftwareVersion'("5.1.1.0")
CustomKeywords.'adminAbout.AboutPage.clickOnSummary'()
CustomKeywords.'adminAbout.AboutPage.verifyHostName'()
CustomKeywords.'adminAbout.AboutPage.verifyLicenseKey'()
CustomKeywords.'adminAbout.AboutPage.verifyDealerKey'()
CustomKeywords.'adminAbout.AboutPage.verifySQLRunnerKey'()
CustomKeywords.'adminAbout.AboutPage.clickOnLicenseMenu'()
CustomKeywords.'adminAbout.AboutPage.verifyVersionInLicenseMenu'("5.1.1.0")