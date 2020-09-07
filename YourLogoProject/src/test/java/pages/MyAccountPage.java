package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver navegador) {
		super(navegador);
	}

	public MyAccountPage clicarWishlist() {
		navegador.findElement(By.xpath("//li/a[@title=\"My wishlists\"]")).click();
		return this;
	}

	public ListaWishlistPage ClicarNaWishlistdesejada() {
		navegador.findElement(By.xpath("//tbody/tr/td[@style=\"width:200px;\"]/a")).click();
		return new ListaWishlistPage(navegador);
	}
	
	

}
