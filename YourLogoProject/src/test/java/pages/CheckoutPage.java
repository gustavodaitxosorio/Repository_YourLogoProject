package pages;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.DecimalFormatSymbols;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.DSL;

public class CheckoutPage extends BasePage{
	
	private DSL dsl;

	public CheckoutPage(WebDriver navegador) {
		super(navegador);
		dsl = new DSL(navegador);
		// TODO Auto-generated constructor stub
	}
	
	public void clicarCheckoutSummary() {
		dsl.AguardarElemento(By.xpath("//p/a[@title=\"Proceed to checkout\"]"));
		dsl.clicarbotao(By.xpath("//p/a[@title=\"Proceed to checkout\"]"));
	}
	
//	public CheckoutPage ProceedCheckoutSummary() {
//		navegador.findElement(By.xpath("//p/a[@title=\"Proceed to checkout\"]")).click();
//		return this;
//	}
	
	public void ClicarCheckoutAdress() {
		dsl.clicarbotao(By.xpath("//p/button/span"));
	}
	
//	public CheckoutPage ProceedCheckoutAdress() {
//		navegador.findElement(By.xpath("//p/button/span")).click();
//		return this;
//	}
	
	public void ClicarCheckoutShipping() {
		dsl.clicarbotao(By.id("cgv"));
		dsl.clicarbotao(By.xpath("//p/button/span"));
	}
	
//	public CheckoutPage ProceedCheckoutShipping() {
//		navegador.findElement(By.id("cgv")).click();
//		navegador.findElement(By.xpath("//p/button/span")).click();
//		return this;
//	}
	
	public void clicarCheckoutPaymentBankWire() {
		dsl.clicarbotao(By.xpath("//p/a[@title=\"Pay by bank wire\"]"));
		dsl.AguardarElemento(By.xpath("//p/button/span"));
		dsl.clicarbotao(By.xpath("//p/button/span"));
	}
	
//	public CheckoutPage ProceedCheckoutPaymentBankWire() {
//		navegador.findElement(By.xpath("//p/a[@title=\"Pay by bank wire\"]")).click();
//		WebDriverWait wait = new WebDriverWait(navegador, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p/button/span")));
//		navegador.findElement(By.xpath("//p/button/span")).click();
//		return this;
//	}

	public void alterarQuantidadeCheckout(int num) {
		dsl.alterarQuantidadeCheckoutPage(By.xpath("//tr/td/input[@type=\"text\"]"), num);
	}
	
//	public CheckoutPage AlterarQuantidadeCheckout(int num) {
//		WebElement qty = navegador.findElement(By.xpath("//tr/td/input[@type=\"text\"]"));
//		qty.clear();
//		qty.sendKeys(""+num);
//		try {
//			Thread.sleep(4500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return this;
//	}	
	
public String OrderMessage() {
	return dsl.obterTexto(By.xpath(""));
}





}
