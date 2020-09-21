package tests;

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

//@RunWith(DataDrivenTestRunner.class)
//@DataLoader(filePaths = "testPriceChangesWithTheQuantity.csv")


public class TestCompraTDD {
	
	
	private WebDriver navegador;

	@Before 
	public void setUp(){
		navegador = web.AbrirNavegador();
		new InicialPage(navegador)
		.InicialPage()
		.email("gustavodaitxosorio@gmail.com")
		.senha("gustavoerica")
		.clicarSignSucesso();
	}
	
	@After
	public void tearDown() {
		//navegador.quit();
	}

	@Test
	public void testPriceChangesWithTheQuantity(

//			@Param(name="menu") String menu,
//			@Param(name="submenu") String submenu,
//			@Param(name="nomeproduto") String nomeproduto,
//			@Param(name="numproduto") String numproduto,			
//			@Param(name="alteraqtd") int alteraqtd,			
//			@Param(name="alteraqtdcheckout") int alteraqtdcheckout			
//			
			) {
//		new InicialPage(navegador)
//		.ClicarMenuSubMenu(menu,submenu)
//		.MouseOverEClicarMore(nomeproduto, numproduto)
//		.AlterarQuantidade(alteraqtd)
//		.clicarAddToCart()
//		.clicarCheckout()
//		.VerifyPriceChange()
//		.AlterarQuantidadeCheckout(alteraqtdcheckout)
//		.VerifyPriceChange();
//		
		new InicialPage(navegador)

		.ClicarMenuSubMenu("Women","T-shirts")
		.MouseOverEClicarMore("Faded Short Sleeve T-shirts", "1")
		.AlterarQuantidade(61)
		.clicarAddToCart()
		.clicarCheckout()
		//.VerifyPriceChange() - coloquei a validação no proprio teste, precisa passa aqui tbm(esse passo acho que nao precisa)
		.AlterarQuantidadeCheckout(150);
		//.VerifyPriceChange(); - coloquei a validação no proprio teste, precisa passa aqui tbm
	
	}

}
