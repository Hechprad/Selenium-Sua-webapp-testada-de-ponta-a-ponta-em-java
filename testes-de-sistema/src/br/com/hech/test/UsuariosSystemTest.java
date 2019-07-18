package br.com.hech.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsuariosSystemTest {
	
	private WebDriver driver;

	@Before
	public void inicializa() {
		// caminho do chromedriver para utilizar o Google Chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers-para-SELENIUM\\Chromedriver\\chromedriver.exe");
		// driver do chrome
		driver = new ChromeDriver();
		// passando a url que iremos testar
		driver.get("http://localhost:8080/usuarios/new");
	}
	
	@After
	public void finaliza() {
		// fechando o driver para encerrar a comunicação com o browser
		driver.close();
	}
	
	@Test
	public void deveAdicionarUmUsuario() {
//		// encontrando os inputs pelo nome
//		WebElement nome = driver.findElement(By.name("usuario.nome"));
//		WebElement email = driver.findElement(By.name("usuario.email"));
//
//		// passando valor para os inputs
//		nome.sendKeys("Jorge Hech");
//		email.sendKeys("jorge@hech.com");
//
//		// localizando e clicando no botão salvar
//		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
//		botaoSalvar.click();
//
//		// .getPageSource() devolve o código fonte da página
//		boolean achouNome = driver.getPageSource().contains("Jorge Hech");
//		
//		// assertTrue do JUnit
//		assertTrue(achouNome);
//		assertTrue(driver.getPageSource().contains("jorge@hech.com"));
		
		// código novo
		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.novo().cadastra("Jorge Hech", "jorge@hech.com");
		
		assertTrue(usuarios.existeNaListagem("Jorge Hech", "jorge@hech.com"));
	}
	
	@Test
	public void naoDeveAdicionarUmUsuarioSemNome() {
		//encontrando input do e-mail e colocando valor
		WebElement email = driver.findElement(By.name("usuario.email"));
		email.sendKeys("email@mail.com");
		//outra forma de submeter o formulário sem precisar clicar no botão salvar
		email.submit();
		
		// verificando se existe a mensagem de erro
		assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
	}
	
	@Test
	public void naoDeveAdicionarUmUsuarioSemNomeOuEmail() {
		// localizando e clicando no botão salvar
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
		
		// verificando se as mensagens de validação foram exibidas
		assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
		assertTrue(driver.getPageSource().contains("E-mail obrigatorio!"));
	}
	
	@Test
	public void deveVerificarSeLinkParaNovoUsuarioEstaValido() {
		// passando a url que iremos testar
		driver.get("http://localhost:8080/usuarios");
		
		// procurando e clicando no link de texto
		driver.findElement(By.linkText("Novo Usuário")).click();
		
		// verificando a URL esperada com a URL atual
		assertEquals("http://localhost:8080/usuarios/new", driver.getCurrentUrl());
	}
}
