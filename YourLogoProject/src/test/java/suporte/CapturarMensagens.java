package suporte;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class CapturarMensagens extends BasePage {

	public CapturarMensagens(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}
	
	
	public String capturarTitulo() {
		return navegador.findElement(By.xpath("//div/p/strong")).getText();
	}

	public String capturarAmount() {
		return navegador.findElement(By.xpath("//div/span/strong")).getText();
	}
	
	public String capturarAccount() {
		return navegador.findElement(By.xpath("//div/div/strong[text()='Pradeep Macharla']")).getText();
	}
	
	public String VerificaProduto(String item) {
		WebDriverWait wait2 = new WebDriverWait(navegador, 10);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/a/img[@title=\""+item+"\"]")));
		return navegador.findElement(By.xpath("//div/div/a[@data-id-product=\"1\"]/ancestor::div/h5/a")).getText();	
		
	}


}
