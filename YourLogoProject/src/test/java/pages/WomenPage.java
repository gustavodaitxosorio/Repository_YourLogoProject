package pages;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.DSL;

public class WomenPage extends BasePage {

	private DSL dsl;
	
	public WomenPage(WebDriver navegador) {
		super(navegador);
		dsl = new DSL(navegador);
		// TODO Auto-generated constructor stub
	}
	
	public void clicarMore(String item, String numeroProduto) {
		dsl.passarMouseClicarItem(By.xpath("//div/a/img[@title=\""+item+"\"]"), 
				By.xpath("//div/div/div/a[@data-id-product=\""+numeroProduto+
				"\"]/span[text()='Add to cart']/ancestor::a/following-sibling::a/span[text()='More']"));
	}
	
	
	
	
	/*
	 * public DetalheProduto MouseOverEClicarMore(String item, String numeroProduto)
	 * { WebDriverWait wait = new WebDriverWait(navegador, 10);
	 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
	 * "//div/a/img[@title=\""+item+"\"]")));
	 * 
	 * JavascriptExecutor jse = (JavascriptExecutor)navegador;
	 * jse.executeScript("scroll(0, 800);");
	 * 
	 * WebElement MouseOver =
	 * navegador.findElement(By.xpath("//div/a/img[@title=\""+item+"\"]"));
	 * WebElement ClicarDetalhe =
	 * navegador.findElement(By.xpath("//div/div/div/a[@data-id-product=\""+
	 * numeroProduto+"\"]/span[text()='Add to cart']/ancestor::a/following-sibling::a/span[text()='More']"
	 * )); Actions passarMouseEClicar = new Actions(navegador);
	 * passarMouseEClicar.moveToElement(MouseOver).moveToElement(ClicarDetalhe).
	 * click().perform();
	 * 
	 * return new DetalheProduto(navegador); }
	 */
	
	public void MouseOverEClicarWishlistDSL(String TituloItem, String numeroProduto) {
		dsl.passarMouseClicarItem(By.xpath("//div/a/img[@title=\""+TituloItem+"\"]"), By.xpath("//div/div/div/a[@data-id-product=\""+numeroProduto+"\"]/ancestor::div/h5/a"));
	}
	
	
	public WomenPage MouseOverEClicarWishlist(String TituloItem, String numeroProduto) {
		WebDriverWait wait = new WebDriverWait(navegador, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/a/img[@title=\""+TituloItem+"\"]")));
		WebElement tituloproduto = navegador.findElement(By.xpath("//div/div/div/a[@data-id-product=\""+numeroProduto+"\"]/ancestor::div/h5/a"));
		
		((JavascriptExecutor) navegador).executeScript("arguments[0].scrollIntoView(true);", tituloproduto);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		WebElement MouseOver = navegador.findElement(By.xpath("//div/div/div/a[@data-id-product=\""+numeroProduto+"\"]/ancestor::div/h5/a"));
		WebElement ClicarDetalhe = navegador.findElement(By.xpath("//div/div/div/a[@data-id-product=\""+numeroProduto+"\"]/span[text()='Add to cart']/ancestor::div//ancestor::div[@class=\"wishlist\"]/a[@rel=\""+numeroProduto+"\"]"));
		Actions passarMouseEClicar = new Actions(navegador);
		passarMouseEClicar.moveToElement(MouseOver).moveToElement(ClicarDetalhe).click().build().perform();

		return this;
	}
	
	public String checkelement() {
		return navegador.findElement(By.xpath("//div/div/div/div/div[@class=\"fancybox-inner\"]/p")).getText();
	}
	
	public WomenPage clickelementPopupWishlist() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		navegador.findElement(By.xpath("//div/div/div/a[@title=\"Close\"]")).click();
		return this;
	}

	

				//Esse metodo seleciona um item e escreve esse item na pesquisa de produtos e clica enter
	public String MouseOverSelecionarNomeProduto(String item) {
		
		WebDriverWait wait = new WebDriverWait(navegador, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/a/img[@title=\""+item+"\"]")));
		
		JavascriptExecutor jse = (JavascriptExecutor)navegador;
		jse.executeScript("scroll(0, 800);");;
	
		String ClicarDetalhe = navegador.findElement(By.xpath("//div/div/a[@data-id-product=\"1\"]/ancestor::div/h5/a")).getText();	
		WebElement pesquisar = navegador.findElement(By.id("search_query_top"));
		
		pesquisar.sendKeys(ClicarDetalhe);
		pesquisar.sendKeys(Keys.ENTER);

		return ClicarDetalhe;
	
	}

	public MyAccountPage clicarMyAccount() {

		WebDriverWait wait = new WebDriverWait(navegador, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav/div/a[@class=\"account\"]")));
		navegador.findElement(By.xpath("//nav/div/a[@class=\"account\"]")).click();
		return new MyAccountPage(navegador);
	}
	

}
