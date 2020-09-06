package pages;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.DecimalFormatSymbols;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}
	
	public CheckoutPage ProceedCheckoutSummary() {
		navegador.findElement(By.xpath("//p/a[@title=\"Proceed to checkout\"]")).click();
		return this;
	}
	
	public CheckoutPage ProceedCheckoutAdress() {
		navegador.findElement(By.xpath("//p/button/span")).click();
		return this;
	}
	
	public CheckoutPage ProceedCheckoutShipping() {
		navegador.findElement(By.id("cgv")).click();
		navegador.findElement(By.xpath("//p/button/span")).click();
		return this;
	}
	
	public CheckoutPage ProceedCheckoutPaymentBankWire() {
		navegador.findElement(By.xpath("//p/a[@title=\"Pay by bank wire\"]")).click();
		WebDriverWait wait = new WebDriverWait(navegador, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p/button/span")));
		navegador.findElement(By.xpath("//p/button/span")).click();
		return this;
	}

	public CheckoutPage AlterarQuantidadeCheckout(int num) {
		WebElement qty = navegador.findElement(By.xpath("//tr/td/input[@type=\"text\"]"));
		qty.clear();
		qty.sendKeys(""+num);
		try {
			Thread.sleep(4500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}	
	
	public CheckoutPage VerifyPriceChange() {
		
		String valorUnitString = navegador.findElement(By.xpath("//tr/td/span/span[@class=\"price\"]")).getText();
		float valorUnitFloat = Float.parseFloat(valorUnitString.substring(1));

		String QtyUnitString = navegador.findElement(By.xpath("//tr/td/input[@type=\"text\"]")).getAttribute("value");
		float QtyUnitFloat = Float.parseFloat(QtyUnitString);

		String valorTotalString = navegador.findElement(By.xpath("//tbody/tr/td[@class=\"cart_total\"]/span[@class=\"price\"]")).getText();
		float valorTotalFloat = Float.parseFloat(valorTotalString.substring(1).replaceAll(",", ""));
	
		float VerifyValorTotal = valorUnitFloat*QtyUnitFloat;
		assertEquals(VerifyValorTotal,valorTotalFloat, 0.1);			
		
		return this;
	}



}
