package tests;

import static org.junit.Assert.assertEquals;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import pages.InicialPage;
import suporte.web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "TestLoginFalhaSenha.csv")


public class TestLoginFalhaTDD {
	
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
	public void TestLoginFalhaSenha(			
			@Param(name="email") String email,
			@Param(name="capturarMensagem") String capturaMensagem
			
			) {
		String mensagem = new InicialPage(navegador)
		.InicialPage()
		.email(email)		
		.clicarSignFalha()
		.capturarMensagem(capturaMensagem);
		assertEquals("Password is required.",mensagem);
		
	}

}
