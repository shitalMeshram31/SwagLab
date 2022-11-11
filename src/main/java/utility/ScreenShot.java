package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {
	public static void Openscreenshot(WebDriver driver, String name) throws IOException {
WebDriverManager.chromedriver().setup();
		
		driver.get("https://www.saucedemo.com/");	
		driver.manage().window().maximize();
		File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
		File destination = new File("D:\\velocity\\SwagLabs\\ScreenShots\\"+name+".png");
		FileHandler.copy(Source, destination);
	}
	}


