package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetalheProduto extends BasePage{

	
	public DetalheProduto(WebDriver navegador) {
		super(navegador);
		
	}
	
	public DetalheProduto AlterarQuantidade(int num) {
		navegador.findElement(By.id("quantity_wanted")).clear();
		navegador.findElement(By.id("quantity_wanted")).sendKeys(""+num);
		return this;
	}
	
	public DetalheProduto AlterarTamanho(String tam) {
		
		WebElement tamanho = navegador.findElement(By.id("group_1"));
		new Select(tamanho).selectByVisibleText(tam);
		
		return this;
	}
	
	public DetalheProduto AlterarCor(String cor) {
		navegador.findElement(By.xpath("//li/a[@title=\""+cor+"\"]")).click();
		return this;	
	}
	
	public DetalheProduto clicarAddToCart() {
		navegador.findElement(By.id("add_to_cart")).click();
		return this;	
	}
	
	public CheckoutPage clicarCheckout() {
		WebDriverWait wait = new WebDriverWait(navegador,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/a[@title=\"Proceed to checkout\"]")));		
		
		navegador.findElement(By.xpath("//div/a[@title=\"Proceed to checkout\"]")).click();
		return new CheckoutPage(navegador);	
	}

}
