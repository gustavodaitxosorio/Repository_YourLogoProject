package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends BasePage{

	public MainPage(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}

	/*
	 * public WomenPage clicarWomenPage() {
	 * navegador.findElement(By.xpath("//li/a[text()='Women']")).click(); return new
	 * WomenPage(navegador); }
	 * 
	 * public WomenPage InicialPageWomen() { WebElement women =
	 * navegador.findElement(By.xpath("//ul/li/a[text()='Women']")); WebElement
	 * tshirt = navegador.findElement(By.xpath(
	 * "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/ul/li[1]/ul/li[1]/a"
	 * )); Actions passarMouseEClicar = new Actions(navegador);
	 * passarMouseEClicar.moveToElement(women).pause(1000).moveToElement(tshirt).
	 * click().pause(1000).perform(); System.out.println("Passei daqui"); return new
	 * WomenPage(navegador);
	 * 
	 * }
	 * 
	 * public MainPage MyWishlists() { return this; }
	 */
	
	
}
