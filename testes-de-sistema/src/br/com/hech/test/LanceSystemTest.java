package br.com.hech.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class LanceSystemTest {

	private ChromeDriver driver;

	@Before
	public void inicializa() {
		// caminho do chromedriver para utilizar o Google Chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers-para-SELENIUM\\Chromedriver\\chromedriver.exe");
		// driver do chrome
		this.driver = new ChromeDriver();
		
		// limpa as informações do banco de dados
		driver.get("http://localhost:8080/apenas-teste/limpa");
	}
	
	@After
	public void finaliza() {
		// fechando o driver para encerrar a comunicação com o browser
		driver.close();
	}
	
	@Test
	public void deveFazerUmLance() {
		leilao.detalhe(1);
		
		lances.lance("Jorge Hech", 150);
		
		assertTrue(lances.existeLance("Jorge Hech", 150));
	}
}
