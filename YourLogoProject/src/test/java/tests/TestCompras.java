package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.BasePage;
import pages.InicialPage;
import pages.loginPage;
import suporte.DSL;
import suporte.web;

public class TestCompras {

	private DSL dsl;
	
//	public TestCompras() {
//		// TODO Auto-generated constructor stub
//	}
	
	private WebDriver navegador;
	private loginPage loginPage;
	private InicialPage InicialPage;
	private WomanPage WomanPage;
	

	@Before
	public void SetUp() {
		navegador = web.AbrirNavegador();
	}
	
	@After
	public void tearDown() {
		//navegador.quit();
	}
	
	@Test
	public void testCompra1() {
		new InicialPage(navegador);
		InicialPage.Clicarlogin();
		loginPage.setEmail("gustavodaitxosorio@gmail.com");
		loginPage.setSenha("gustavoerica");
		loginPage.SignIn();
		InicialPage.clicarWomen();
		
				
		
		
		
		
		
		
		
		
//		String OrderComplete = new InicialPage(navegador)
//		.InicialPage()
//		.email("gustavodaitxosorio@gmail.com")
//		.senha("gustavoerica")
//		.clicarSignSucesso()
//		.clicarWomenPage()
//		.MouseOverEClicarMore("Blouse", "2")
//		.AlterarQuantidade(5)
//		.AlterarTamanho("M")
//		.AlterarCor("White")
//		.clicarAddToCart()
//		.clicarCheckout()
//		.ProceedCheckoutSummary()
//		.ProceedCheckoutAdress()
//		.ProceedCheckoutShipping()
//		.ProceedCheckoutPaymentBankWire()
//		.capturarTitulo();
//		assertEquals("Your order on My Store is complete.",OrderComplete);
//		
//		String OrderAmount = new BasePage(navegador)
//		.capturarAmount();
//		assertEquals("$137.00", OrderAmount);
//		
//		String OrderAccount = new BasePage(navegador)
//		.capturarAccount();
//		assertEquals("Pradeep Macharla", OrderAccount);
		
	}

	@Test
	public void testWishlistNaoLogado() {
		String wishlistPopUp = new InicialPage(navegador)
		.ClicarMenuSubMenu("Women","T-shirts")
		.MouseOverEClicarWishlist("Faded Short Sleeve T-shirts", "1")
		.checkelement();
		assertEquals("You must be logged in to manage your wishlist.", wishlistPopUp);
	}
	
	@Test
	public void testPriceChangesWithTheQuantity() {
		new InicialPage(navegador)
		.InicialPage()
		.email("gustavodaitxosorio@gmail.com")
		.senha("gustavoerica")
		.clicarSignSucesso()
		.ClicarMenuSubMenu("Women","T-shirts")
		.MouseOverEClicarMore("Faded Short Sleeve T-shirts", "1")
		.AlterarQuantidade(61)
		.clicarAddToCart()
		.clicarCheckout()
		//.VerifyPriceChange()
		.AlterarQuantidadeCheckout(150);
		
		String valorUnitString = navegador.findElement(By.xpath("//tr/td/span/span[@class=\"price\"]")).getText();
		float valorUnitFloat = Float.parseFloat(valorUnitString.substring(1));

		String QtyUnitString = navegador.findElement(By.xpath("//tr/td/input[@type=\"text\"]")).getAttribute("value");
		float QtyUnitFloat = Float.parseFloat(QtyUnitString);

		String valorTotalString = navegador.findElement(By.xpath("//tbody/tr/td[@class=\"cart_total\"]/span[@class=\"price\"]")).getText();
		float valorTotalFloat = Float.parseFloat(valorTotalString.substring(1).replaceAll(",", ""));
	
		float VerifyValorTotal = valorUnitFloat*QtyUnitFloat;
		assertEquals(VerifyValorTotal,valorTotalFloat, 0.1);			
		
		//.VerifyPriceChange();
	
	}

	@Test
	public void testSearchProduct() {
		String ProdutoQueVaiSerPesquisado = new InicialPage(navegador)
		.ClicarMenuSubMenu("Women","T-shirts")
		.MouseOverSelecionarNomeProduto("Faded Short Sleeve T-shirts");
	
		String ProdutoQueFoiPesquisado = new BasePage(navegador)	
		.VerificaProduto("Faded Short Sleeve T-shirts");
		
		assertEquals(ProdutoQueVaiSerPesquisado,ProdutoQueFoiPesquisado);

}

}








