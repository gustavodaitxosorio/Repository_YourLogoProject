package suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class web {
	
public static WebDriver AbrirNavegador() {
	
	System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
	
	WebDriver navegador = new FirefoxDriver();
	navegador.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	navegador.get("http://automationpractice.com/index.php");
	
	return navegador;
	
}

}
