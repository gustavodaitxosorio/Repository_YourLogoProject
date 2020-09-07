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
import suporte.CapturarMensagens;
import suporte.web;

public class TestCompras {

	public TestCompras() {
		// TODO Auto-generated constructor stub
	}
	
	private WebDriver navegador;

	@Before
	public void SetUp() {
		navegador = web.AbrirNavegador();
	}
	
	@After
	public void tearDown() {
//		navegador.quit();
	}
	
	@Test
	public void testCompra1() {
		new InicialPage(navegador)
		.InicialPage()
		.email("gustavodaitxosorio@gmail.com")
		.senha("gustavoerica")
		.clicarSignSucesso()
		.clicarWomenPage()
		.MouseOverEClicarMore("Blouse", "2")
		.AlterarQuantidade(5)
		.AlterarTamanho("M")
		.AlterarCor("White")
		.clicarAddToCart()
		.clicarCheckout()
		.ProceedCheckoutSummary()
		.ProceedCheckoutAdress()
		.ProceedCheckoutShipping()
		.ProceedCheckoutPaymentBankWire();
		
		String OrderComplete = new CapturarMensagens(navegador)
		.capturarTitulo();
		assertEquals("Your order on My Store is complete.",OrderComplete);
		
		String OrderAmount = new CapturarMensagens(navegador)
		.capturarAmount();
		assertEquals("$137.00", OrderAmount);
		
		String OrderAccount = new CapturarMensagens(navegador)
		.capturarAccount();
		assertEquals("Pradeep Macharla", OrderAccount);
		
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
		.VerifyPriceChange()
		.AlterarQuantidadeCheckout(150)
		.VerifyPriceChange();
	}
	

	//comentario feito do notebook
	
	@Test
	public void testSearchProduct() {
		String ProdutoQueVaiSerPesquisado = new InicialPage(navegador)
		.ClicarMenuSubMenu("Women","T-shirts")
		.MouseOverSelecionarNomeProduto("Faded Short Sleeve T-shirts");
		
		String ProdutoQueFoiPesquisado = new CapturarMensagens(navegador)	
		.VerificaProduto("Faded Short Sleeve T-shirts");
		assertEquals(ProdutoQueVaiSerPesquisado,ProdutoQueFoiPesquisado);
		
	}
	
	@Test
	public void testWishlistLogadoTodosProdutosWomen() {
		new InicialPage(navegador)
		.InicialPage()
		.RealizarLoginSucesso("gustavodaitxosorio@gmail.com", "gustavoerica")
		.clicarWomenPage()
		.MouseOverEClicarWishlist("Faded Short Sleeve T-shirts", "1")
		.clickelementPopupWishlist()
		.MouseOverEClicarWishlist("Blouse", "2")
		.clickelementPopupWishlist()
		.MouseOverEClicarWishlist("Printed Dress", "3")
		.clickelementPopupWishlist()
		.MouseOverEClicarWishlist("Printed Dress", "4")
		.clickelementPopupWishlist()
		.MouseOverEClicarWishlist("Printed Summer Dress", "5")
		.clickelementPopupWishlist()
		.MouseOverEClicarWishlist("Printed Summer Dress", "6")
		.clickelementPopupWishlist()
		.MouseOverEClicarWishlist("Printed Chiffon Dress", "7")
		.clickelementPopupWishlist()
		.clicarMyAccount()
		.clicarWishlist()
		.ClicarNaWishlistdesejada();

		
	}
	

}








