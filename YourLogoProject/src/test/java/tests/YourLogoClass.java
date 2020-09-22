package tests;

import java.lang.System;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait; 


public class YourLogoClass {
	
	
	@Test
	public void TestBuyOrder() {

	
	System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\\\chromedriver.exe");
	
	WebDriver navegador = new ChromeDriver();
	navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	navegador.get("http://automationpractice.com/index.php");
	
	navegador.findElement(By.xpath("//div/a[@class='login']")).click();
	
	WebDriverWait esperar = new WebDriverWait(navegador,10);
	esperar.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
	
	navegador.findElement(By.id("email")).sendKeys("gustavodaitxosorio@gmail.com");
	navegador.findElement(By.id("passwd")).sendKeys("gustavoerica");
	
	navegador.findElement(By.id("SubmitLogin")).click();
	
	navegador.quit();
	
	}

}