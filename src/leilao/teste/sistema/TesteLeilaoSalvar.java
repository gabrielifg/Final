package leilao.teste.sistema;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLeilaoSalvar {
	
	private WebDriver browser;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
		browser = new ChromeDriver();
	}
	
	@After
	public void end() {
		browser.close();
	}
	
	//@Test
	/*public void devSalvarLeilao() {
		browser.get("http://localhost:8080/Final/cadastro-leilao.html");
		WebElement campoDescricao = browser.findElement(By.name("descricao"));
		WebElement campoValorInicial = browser.findElement(By.name("valorInicial"));
		WebElement campoDataCriacao = browser.findElement(By.name("dataCriacao"));
		WebElement campoSituacao = browser.findElement(By.name("situacao"));
		WebElement btnSalvar = browser.findElement(By.name("Salvar"));
		
		campoDescricao.sendKeys("Teste Gabriel");
		campoValorInicial.sendKeys("100000");
		campoDataCriacao.sendKeys("2000/11/10");
		campoSituacao.sendKeys("fechado");
		try {
			Thread.sleep(5000);
		}catch (Exception e) {
			e.printStackTrace();
		}
		btnSalvar.click();
	}*/
}
