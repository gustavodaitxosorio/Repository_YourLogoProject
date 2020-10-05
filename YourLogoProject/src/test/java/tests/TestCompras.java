package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import suporte.Contorno;
import suporte.Generator;
import suporte.screenshot;
import pages.BasePage;
import pages.DetalheProdutoPage;
import pages.CheckoutPage;
import pages.InicialPage;
import pages.loginPage;
import pages.WomenPage;
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
	private WomenPage WomenPage;
	private DetalheProdutoPage DetalheProdutoPage;
	private CheckoutPage CheckoutPage;
	
	  @Rule public TestName test = new TestName();

	@Before
	public void SetUp() {
		navegador = web.AbrirNavegador();
		dsl = new DSL(navegador);
		InicialPage = new InicialPage(navegador);
		loginPage = new loginPage(navegador);
		WomenPage = new WomenPage(navegador);
		DetalheProdutoPage = new DetalheProdutoPage(navegador);
		CheckoutPage = new CheckoutPage(navegador);
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
		WomenPage.clicarMore("Blouse","2");
		DetalheProdutoPage.alterarQtd(2);
		DetalheProdutoPage.alterarTam("M");
		DetalheProdutoPage.MudarCor("White");
		DetalheProdutoPage.ClicaAddCart();
		DetalheProdutoPage.clicarCheckoutProd();
		CheckoutPage.clicarCheckoutSummary();
		CheckoutPage.ClicarCheckoutAdress();
		CheckoutPage.ClicarCheckoutShipping();
		CheckoutPage.clicarCheckoutPaymentBankWire();
		assertEquals("Your order on My Store is complete.", dsl.obterTexto(By.xpath("//div/p/strong[@class=\"dark\"]")));
		assertEquals("$56.00", dsl.obterTexto(By.xpath("//span[@class=\"price\"]/strong")));
		assertEquals("Pradeep Macharla",dsl.obterTexto(By.xpath("//div[3]/div/div/strong[1]")));
		
		//highlight no elemento
		Contorno.highLight(dsl.obterTextoWebElement(By.xpath("//div/p/strong[@class=\"dark\"]")), navegador);
		Contorno.highLight(dsl.obterTextoWebElement(By.xpath("//span[@class=\"price\"]/strong")), navegador);
		Contorno.highLight(dsl.obterTextoWebElement(By.xpath("//div[3]/div/div/strong[1]")), navegador);

		
		//tirar foto da mensagem
		String screenshotArquivo = "\\Users\\Gustavo\\Desktop\\Curso Selenium\\Output/" 
				+ Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
		screenshot.tirar(navegador, screenshotArquivo);


		
		
//		  String OrderComplete = new InicialPage(navegador) 
//		  .InicialPage()
//		  .email("gustavodaitxosorio@gmail.com") 
//		  .senha("gustavoerica")
//		  .clicarSignSucesso() 
//		  .clicarWomenPage() 
//		  .MouseOverEClicarMore("Blouse", "2")
//		  .AlterarQuantidade(5) 
//		  .AlterarTamanho("M") 
//		  .AlterarCor("White")
//		  .clicarAddToCart() 
//		  .clicarCheckout() 
//		  .ProceedCheckoutSummary()
//		  .ProceedCheckoutAdress() 
//		  .ProceedCheckoutShipping()
//		  .ProceedCheckoutPaymentBankWire() 
//		  .capturarTitulo();
//		  assertEquals("Your order on My Store is complete.",OrderComplete);
//		  
//		  String OrderAmount = new BasePage(navegador) .capturarAmount();
//		  assertEquals("$137.00", OrderAmount);
//		  
//		  String OrderAccount = new BasePage(navegador) .capturarAccount();
//		  assertEquals("Pradeep Macharla", OrderAccount);
		 		
	}

	@Test
	public void testWishlistNaoLogadoDSL() {
		InicialPage.ClicarMenuSubMenuDSL("Women","T-shirts");
		WomenPage.MouseOverEClicarWishlistDSL("Faded Short Sleeve T-shirts", "1");
	}

	
	
	
	@Test
	public void testWishlistNaoLogado() {
		String wishlistPopUp = new InicialPage(navegador)
		.ClicarMenuSubMenu("Women","T-shirts")
		.MouseOverEClicarWishlist("Faded Short Sleeve T-shirts", "1")
		.checkelement();
		//assertEquals("You must be logged in to manage your wishlist.", wishlistPopUp);
		WebElement element = navegador.findElement(By.xpath("//div/div/div/div/div[@class=\"fancybox-inner\"]/p"));
		dsl.executarJS("arguments[0].setAttribute('style', arguments[1]);", 
				element, "color: black; border: 4px solid red;");
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








