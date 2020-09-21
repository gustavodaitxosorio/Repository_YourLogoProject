package tests;

import static org.junit.Assert.*;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
import pages.InicialPage;
import pages.loginPage;
import suporte.web;
import suporte.DSL;


public class TestsLogin {
	
	private WebDriver navegador;
	private DSL dsl;
	private InicialPage InicialPage;
	private loginPage loginPage;

	@Before 
	public void setUp(){
		navegador = web.AbrirNavegador();
		dsl = new DSL(navegador);
		InicialPage = new InicialPage(navegador);
		loginPage = new loginPage(navegador);
		
	}
	
	@After
	public void tearDown() {
		navegador.quit();
	}
	
	@Test
	public void TestLoginOk() {
		InicialPage.Clicarlogin();
		loginPage.setEmail("gustavodaitxosorio@gmail.com");
		loginPage.setSenha("gustavoerica");
		loginPage.SignIn();
	}
	
	@Test
	public void TestLoginFalhaEmail() {
		new InicialPage(navegador);
		InicialPage.Clicarlogin();
		loginPage.SignIn();
		String mensagem = loginPage.MensagemFalha("An email address required.");
		assertEquals("An email address required.",mensagem);		
		
//		String mensagem = new InicialPage(navegador)
//		.InicialPage()
//		.clicarSignFalha()
//		.capturarMensagem("An email address required.");
//		assertEquals("An email address required.",mensagem);
//		System.out.println(mensagem);
		
	}
	
	@Test
	public void TestLoginFalhaSenha() {
		new InicialPage(navegador);
		InicialPage.Clicarlogin();
		loginPage.setEmail("gustavodaitxosorio@gmail.com");
		loginPage.SignIn();
		String mensagem = loginPage.capturarMensagem("Password is required.");
		assertEquals("Password is required.", mensagem);
		
		
	}

}
