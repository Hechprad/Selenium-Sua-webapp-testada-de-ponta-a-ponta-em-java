package br.com.hech.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesSystemTest {

	private WebDriver driver;
	private LeiloesPage leiloes;

	@Before
	public void inicializa() {
		// caminho do chromedriver para utilizar o Google Chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers-para-SELENIUM\\Chromedriver\\chromedriver.exe");
		// driver do chrome
		this.driver = new ChromeDriver();
		this.leiloes = new LeiloesPage(driver);
		
		// criando novo usuário para o cenário de testes
		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra("Jorge Hech", "jorge@hech.com");
		
		// visita a página de usuários
		leiloes.visita();
	}
	
	@After
	public void finaliza() {
		// fechando o driver para encerrar a comunicação com o browser
		driver.close();
	}
	
	@Test
	public void deveCadastrarUmLeilao() {
		NovoLeilaoPage novoLeilao = leiloes.novo();
		novoLeilao.preenche("Geladeira", 1000, "Jorge Hech", true);
		
		assertTrue(leiloes.existe("Geladeira", 1000, "Jorge Hech", true));
	}
}
