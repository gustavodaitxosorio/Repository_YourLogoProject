package suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.DetalheProdutoPage;

public class DSL {

	private WebDriver navegador;
	
	public DSL(WebDriver navegador) {
	this.navegador = navegador;
	}
	
	//Escrever em campo texto
	public void escrever(By by, String texto) {
		navegador.findElement(by).clear();
		navegador.findElement(by).sendKeys(texto);
	}

	public void clicarbotao(By by) {
		navegador.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		navegador.findElement(by).click();	
	}
	
	public void AguardarElemento(By by) {
		WebDriverWait wait = new WebDriverWait(navegador,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public String obterTexto(By by) {
		return navegador.findElement(by).getText();	
	}
	
	// Escrever em campo numerico -- Ver melhor como fazer 
	
	public void escreverNumero(By by, int num) {
		navegador.findElement(by).clear();
		navegador.findElement(by).sendKeys(""+num);
	}
	
	//SelecionarItem Combo
	
	public void selecionarCombo(By by, String opcao){
		WebElement texto = navegador.findElement(by);
		new Select(texto).selectByVisibleText(opcao);

	}
	
	
	 // Passar Mouse e selecionar item
	public void passarMouseClicarItem(By item, By num) {
		WebDriverWait wait = new WebDriverWait(navegador, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(item));
			
		JavascriptExecutor jse = (JavascriptExecutor)navegador;
		jse.executeScript("scroll(0, 800);");
	
		WebElement MouseOver = navegador.findElement(item);
		WebElement ClicarDetalhe = navegador.findElement(num);	
		Actions passarMouseEClicar = new Actions(navegador);
		passarMouseEClicar.moveToElement(MouseOver).moveToElement(ClicarDetalhe).click().perform();
	
	}

//	public void alterarQuantidadeCheckoutPage(By by, int num) {
//		WebElement qty = navegador.findElement(by);
//		qty.clear();
//		qty.sendKeys(""+num);
//		try {
//			Thread.sleep(4500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	public void alterarQuantidadeCheckoutPage(By by, int num) {
		WebElement qty = navegador.findElement(by);
		qty.clear();
		qty.sendKeys(""+num);
		try {
			Thread.sleep(4500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	
	
	
	
	
}
