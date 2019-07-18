package br.com.hech.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsuariosSystemTest {
	
	private WebDriver driver;
	private UsuariosPage usuarios;

	@Before
	public void inicializa() {
		// caminho do chromedriver para utilizar o Google Chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers-para-SELENIUM\\Chromedriver\\chromedriver.exe");
		// driver do chrome
		this.driver = new ChromeDriver();
		this.usuarios = new UsuariosPage(driver);
		
		// visita a página de usuários
		usuarios.visita();
	}
	
	@After
	public void finaliza() {
		// fechando o driver para encerrar a comunicação com o browser
		driver.close();
	}
	
	@Test
	public void deveAdicionarUmUsuario() {
		usuarios.novo().cadastra("Jorge Hech", "jorge@hech.com");
		assertTrue(usuarios.existeNaListagem("Jorge Hech", "jorge@hech.com"));
		
		// limpando o BD
		usuarios.deletaUsuarioNaPosicao(1);
	}
	
	@Test
	public void naoDeveAdicionarUmUsuarioSemNome() {
		NovoUsuarioPage form = usuarios.novo();
		form.cadastra("", "jorge@email.com");
		assertTrue(form.validacaoDeNomeObrigatorio());
	}
	
	@Test
	public void naoDeveAdicionarUmUsuarioSemNomeOuEmail() {
		NovoUsuarioPage formVazio = usuarios.novo(); 
		formVazio.cadastra("", "");
		// verificando se as mensagens de validação foram exibidas
		assertTrue(formVazio.validacaoDeNomeObrigatorio());
		assertTrue(formVazio.validacaoDeEmailObrigatorio());
	}
	
	@Test
	public void deveVerificarSeLinkParaNovoUsuarioEstaValido() {
		// procurando e clicando no link de texto
		driver.findElement(By.linkText("Novo Usuário")).click();
		
		// verificando a URL esperada com a URL atual
		assertEquals("http://localhost:8080/usuarios/new", driver.getCurrentUrl());
	}
	
	@Test
	public void deveExcluirUmUsuario() {
		usuarios.novo().cadastra("Jorge Hech", "jorge@hech.com");
		assertTrue(usuarios.existeNaListagem("Jorge Hech", "jorge@hech.com"));

		usuarios.deletaUsuarioNaPosicao(1);
		assertFalse(usuarios.existeNaListagem("Jorge Hech", "jorge@hech.com"));
	}
}
