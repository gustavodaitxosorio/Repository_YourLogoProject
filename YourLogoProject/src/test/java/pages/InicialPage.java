package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InicialPage extends BasePage{

	public InicialPage(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}
	
	public loginPage InicialPage() {
		navegador.findElement(By.xpath("//div/a[@class='login']")).click();		
		return new loginPage(navegador);
	}
	
	public WomenPage clicarWomenPage() {
		navegador.findElement(By.xpath("//li/a[text()='Women']")).click();
		return new WomenPage(navegador);
	}
	
	public WomenPage ClicarMenuSubMenu(String menu, String submenu) {
		WebElement women = navegador.findElement(By.xpath("//div/ul/li/a[text()='"+menu+"']"));
		WebElement tshirt = navegador.findElement(By.xpath("//ul/li/ul/li/ul/li/a[text()='"+submenu+"']"));
		Actions passarMouseEClicar = new Actions(navegador);
		passarMouseEClicar.moveToElement(women).pause(1000).moveToElement(tshirt).click().pause(1000).perform();
		System.out.println("Passei daqui");
		return new WomenPage(navegador);	
		
	}	
	
	public InicialPage MyWishlists() {
		return this;
	}
}
