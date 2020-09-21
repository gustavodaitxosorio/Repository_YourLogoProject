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
	
	public void clicarMore() {
		
	}
	
	
	
	
	public DetalheProduto MouseOverEClicarMore(String item, String numeroProduto) {
		WebDriverWait wait = new WebDriverWait(navegador, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/a/img[@title=\""+item+"\"]")));
				
		JavascriptExecutor jse = (JavascriptExecutor)navegador;
		jse.executeScript("scroll(0, 800);");;
		
		WebElement MouseOver = navegador.findElement(By.xpath("//div/a/img[@title=\""+item+"\"]"));
		WebElement ClicarDetalhe = navegador.findElement(By.xpath("//div/div/div/a[@data-id-product=\""+numeroProduto+"\"]/span[text()='Add to cart']/ancestor::a/following-sibling::a/span[text()='More']"));	
		Actions passarMouseEClicar = new Actions(navegador);
		passarMouseEClicar.moveToElement(MouseOver).moveToElement(ClicarDetalhe).click().perform();

		return new DetalheProduto(navegador);
	}
	
	public DetalheProduto MouseOverEClicarWishlist(String item, String numeroProduto) {
		WebDriverWait wait = new WebDriverWait(navegador, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/a/img[@title=\""+item+"\"]")));
		
		JavascriptExecutor jse = (JavascriptExecutor)navegador;
		jse.executeScript("scroll(0, 800);");;
		
		WebElement MouseOver = navegador.findElement(By.xpath("//div/a/img[@title=\""+item+"\"]"));
		WebElement ClicarDetalhe = navegador.findElement(By.xpath("//div/div/div/a[@data-id-product=\""+numeroProduto+"\"]/span[text()='Add to cart']/ancestor::div//ancestor::div[@class=\"wishlist\"]/a[@rel=\""+numeroProduto+"]"));	
		Actions passarMouseEClicar = new Actions(navegador);
		passarMouseEClicar.moveToElement(MouseOver).moveToElement(ClicarDetalhe).click().build().perform();
		
		return new DetalheProduto(navegador);
	}


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

}
