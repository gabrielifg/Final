package leilao.teste.sistema;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteParticipanteSalvar {
	
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
	
	@Test
	public void devSalvarParticipante() {
		browser.get("http://localhost:8080/Final/cadastro-participante.html");
		WebElement campoNome = browser.findElement(By.name("name"));
		WebElement campoCPF = browser.findElement(By.name("cpf"));
		WebElement campoData = browser.findElement(By.name("dataAniversario"));
		WebElement btnSalvar = browser.findElement(By.name("Salvar"));
		
		campoNome.sendKeys("Teste Gabriel");
		campoCPF.sendKeys("003.999.555-88");
		campoData.sendKeys("2000/11/10");
		try {
			Thread.sleep(5000);
		}catch (Exception e) {
			e.printStackTrace();
		}
		btnSalvar.click();
	}
}
