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
		//navegador.quit();
	}
	
	@Test
	public void testCompra1() {
		String OrderComplete = new InicialPage(navegador)
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
		.ProceedCheckoutPaymentBankWire()
		.capturarTitulo();
		assertEquals("Your order on My Store is complete.",OrderComplete);
		
		String OrderAmount = new BasePage(navegador)
		.capturarAmount();
		assertEquals("$137.00", OrderAmount);
		
		String OrderAccount = new BasePage(navegador)
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
	
/*	 Assignment 3 - Automate 'Search Product' functionality of an e-commerce website
	 Test Case 1- Automate 'Search Product' Functionality of an e-commerce website
	 Steps to Automate:
	 1. Open link http://automationpractice.com/index.php
	 2. Move your cursor over Women's link.
	 3. Click on sub menu 'T-shirts'
	 4. Get Name/Text of the first product displayed on the page.
	 5. Now enter the same product name in the search bar present on top of page and click search button.
	 6. Validate that same product is displayed on searched page with same details which were displayed on T-Shirt's page.
*/
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








