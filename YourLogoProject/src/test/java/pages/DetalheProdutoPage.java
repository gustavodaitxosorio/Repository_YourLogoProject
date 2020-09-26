package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.DSL;

public class DetalheProdutoPage extends BasePage{

	private DSL dsl;
	
	public DetalheProdutoPage(WebDriver navegador) {
		super(navegador);
		dsl = new DSL(navegador);
		
	}
	
	public void alterarQtd(int num) {
		dsl.escreverNumero(By.id("quantity_wanted"), num);
	}
	
//	public DetalheProdutoPage AlterarQuantidade(int num) {
//		navegador.findElement(By.id("quantity_wanted")).clear();
//		navegador.findElement(By.id("quantity_wanted")).sendKeys(""+num);
//		return this;
//	}
	
	public void alterarTam(String opcao) {
		dsl.selecionarCombo(By.id("group_1"), opcao);
	}
	
//	public DetalheProdutoPage AlterarTamanho(String tam) {
//		
//		WebElement tamanho = navegador.findElement(By.id("group_1"));
//		new Select(tamanho).selectByVisibleText(tam);
//		
//		return this;
//	}
	
	public void MudarCor(String cor) {
		dsl.clicarbotao(By.xpath("//li/a[@title=\""+cor+"\"]"));
	}
		
//	public DetalheProdutoPage AlterarCor(String cor) {
//		navegador.findElement(By.xpath("//li/a[@title=\""+cor+"\"]")).click();
//		return this;	
//	}

	public void ClicaAddCart() {
		dsl.clicarbotao(By.id("add_to_cart"));
	}
	
	
//	public DetalheProdutoPage clicarAddToCart() {
//		navegador.findElement(By.id("add_to_cart")).click();
//		return this;	
//	}
//	

	
	public void clicarCheckoutProd() {
		dsl.AguardarElemento(By.xpath("//div/a[@title=\"Proceed to checkout\"]"));
		dsl.clicarbotao(By.xpath("//div/a[@title=\"Proceed to checkout\"]"));

	}
	
	
	
	
//	public CheckoutPage clicarCheckout() {
//		WebDriverWait wait = new WebDriverWait(navegador,10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/a[@title=\"Proceed to checkout\"]")));		
//		
//		navegador.findElement(By.xpath("//div/a[@title=\"Proceed to checkout\"]")).click();
//		return new CheckoutPage(navegador);	
//	}

}









