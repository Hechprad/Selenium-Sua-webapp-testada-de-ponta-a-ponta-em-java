package br.com.hech.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class LanceSystemTest {

	private ChromeDriver driver;
	private LeiloesPage leiloes;

	@Before
	public void inicializa() {
		// caminho do chromedriver para utilizar o Google Chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers-para-SELENIUM\\Chromedriver\\chromedriver.exe");
		// driver do chrome
		driver = new ChromeDriver();
		leiloes = new LeiloesPage(driver);
		
		// limpa as informações do banco de dados
		driver.get("http://localhost:8080/apenas-teste/limpa");
		
		// cenário padrão
		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra("Jorge Hech", "jorge@hech.com");
		usuarios.novo().cadastra("Alan R", "alan@email.com");
		
		LeiloesPage leiloes = new LeiloesPage(driver);
		leiloes.visita();
		leiloes.novo().preenche("Geladeira", 100, "Alan R", false);
		
	}
	
	@After
	public void finaliza() {
		// fechando o driver para encerrar a comunicação com o browser
		driver.close();
	}
	
	@Test
	public void deveFazerUmLance() {
		DetalhesDoLeilaoPage lances = leiloes.detalhes(1);
		
		lances.lance("Jorge Hech", 150);
		
		assertTrue(lances.existeLance("Jorge Hech", 150));
	}
}
