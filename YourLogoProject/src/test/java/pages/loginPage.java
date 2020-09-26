package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import suporte.DSL;

public class loginPage extends BasePage {
	
	private DSL dsl;

	public loginPage(WebDriver navegador) {
		super(navegador);
		dsl = new DSL(navegador);
		// TODO Auto-generated constructor stub
	}

	public void setEmail(String email) {
		dsl.escrever(By.id("email"),email);
	}

//	public loginPage email(String email) {
//		navegador.findElement(By.id("email")).sendKeys(email);
//		return this;
//	}
	
	public void setSenha(String senha){
		dsl.escrever(By.id("passwd"), senha);
	}
	
//	public loginPage senha(String senha) {
//		navegador.findElement(By.id("passwd")).sendKeys(senha);
//		return this;
//	}

	public void SignIn() {
		dsl.clicarbotao(By.id("SubmitLogin"));
	}
	
	public String MensagemFalha(String texto) {

		return dsl.obterTexto(By.xpath("//div/ol/li[text()='"+texto+"']"));
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
	
	public InicialPage RealizarLoginSucesso(String email, String senha) {
		email(email)
		.senha(senha)
		.clicarSignSucesso();
		return new InicialPage(navegador);
		
	}

}




