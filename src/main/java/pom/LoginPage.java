package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath = "//input[@id='user-name']") private WebElement userName;
	@FindBy(xpath = "//input[@type='password']") private WebElement password;
	@FindBy(xpath = "//input[@type='submit']") private WebElement login;
	@FindBy(xpath = "(//button[text()='Add to cart'])[1]") private WebElement AddToCart;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void enterUserName(String user) {
		userName.sendKeys(user);
	}
	public void enterPassword(String user) {
		password.sendKeys(user);
	}
	public void clickonLogin() {
		login.click();
	}
	public void doAddToCart() {
		AddToCart.click();
	}
	

}
