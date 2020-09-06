package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.InicialPage;
import pages.loginPage;
import suporte.web;

public class TestsLogin {
	
	private WebDriver navegador;

	@Before 
	public void setUp(){
		navegador = web.AbrirNavegador();
	}
	
	@After
	public void tearDown() {
		navegador.quit();
	}
	
	@Test
	public void TestLoginOk() {
		new InicialPage(navegador)
		.InicialPage()
		.email("gustavodaitxosorio@gmail.com")
		.senha("gustavoerica")
		.clicarSignSucesso();
	}
	
	@Test
	public void TestLoginFalhaEmail() {
		String mensagem = new InicialPage(navegador)
		.InicialPage()
		.clicarSignFalha()
		.capturarMensagem("An email address required.");
		assertEquals("An email address required.",mensagem);
		
	}
	
	@Test
	public void TestLoginFalhaSenha() {
		String mensagem = new InicialPage(navegador)
		.InicialPage()
		.email("gustavodaitxosorio@gmail.com")		
		.clicarSignFalha()
		.capturarMensagem("Password is required.");
		assertEquals("Password is required.",mensagem);
		
	}

}
