package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage extends BasePage {

	public loginPage(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}

	public loginPage email(String email) {
		navegador.findElement(By.id("email")).sendKeys(email);
		return this;
	}
	
	public loginPage senha(String senha) {
		navegador.findElement(By.id("passwd")).sendKeys(senha);
		return this;
	}

	public loginPage clicarSignFalha() {
		navegador.findElement(By.id("SubmitLogin")).click();
		return this;
	}
	
	public InicialPage clicarSignSucesso() {
		navegador.findElement(By.id("SubmitLogin")).click();
		return new InicialPage(navegador);
	}

	public String capturarMensagem(String texto) {
		return navegador.findElement(By.xpath("//div/ol/li[text()='"+texto+"']")).getText();
	}

}
