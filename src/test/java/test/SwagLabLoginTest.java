package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.LoginPage;
import utility.BaseClass;
import utility.Parametrization;
@Listeners(utility.Listeners.class)

public class SwagLabLoginTest extends BaseClass {
	
	@BeforeMethod
	public void openBrowser() {
		driver = Browser.launchChrome();
	}
	@Test
	public void swagLabLoginTest() throws EncryptedDocumentException, IOException {
	LoginPage loginPage = new LoginPage(driver);
	String user = Parametrization.getExcelData("Credentials", 0, 0);
	String pass = Parametrization.getExcelData("Credentials", 1, 0);
	loginPage.enterUserName(user);
	loginPage.enterPassword(pass);
	loginPage.clickonLogin();
	loginPage.doAddToCart();
	String expectedUrl ="https://www.saucedemo.com/inventory.html";
	String actualUrl = driver.getCurrentUrl();
	Assert.assertEquals(actualUrl, expectedUrl);
	//Assert.assertNotEquals(actualUrl, expectedUrl);
	
	
	
	}

}
