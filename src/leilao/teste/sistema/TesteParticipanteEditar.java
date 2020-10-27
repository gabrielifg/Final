package leilao.teste.sistema;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteParticipanteEditar {
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
	public void devEditarParticipante() {
		browser.get("http://localhost:8080/Final/cadastro-participante.html?cpf=132.712.786-43");
		WebElement campoNome = browser.findElement(By.name("name"));
		WebElement campoData = browser.findElement(By.name("dataAniversario"));
		WebElement btnSalvar = browser.findElement(By.name("Salvar"));
		campoNome.sendKeys("Eduardo Bessa");
		campoData.sendKeys("2000/11/11");
		try {
			Thread.sleep(5000);
		}catch (Exception e) {
			e.printStackTrace();
		}
		btnSalvar.click();
	}
}

