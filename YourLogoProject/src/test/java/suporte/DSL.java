package suporte;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DSL {

	private WebDriver navegador;
	
	public DSL(WebDriver navegador) {
	this.navegador = navegador;
	}
	
	//Escrever em campo texto
	public void escrever(By by, String texto) {
		navegador.findElement(by).sendKeys(texto);
	}

	public void clicarbotao(By by) {
		navegador.findElement(by).click();	
	}

	public String obterTexto(By by) {
		return navegador.findElement(by).getText();	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
