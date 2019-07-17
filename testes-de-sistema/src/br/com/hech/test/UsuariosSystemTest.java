package br.com.hech.test;

import static org.junit.Assert.assertFalse;
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
	public void setUp() {
		// caminho do chromedriver para utilizar o Google Chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers-para-SELENIUM\\Chromedriver\\chromedriver.exe");
		// driver do chrome
		driver = new ChromeDriver();
	}
	
	@After
	public void closeDriver() {
		// fechando o driver para encerrar a comunicação com o browser
		driver.close();
	}
	
	@Test
	public void deveAdicionarUmUsuario() {
		// passando a url que iremos testar
		driver.get("http://localhost:8080/usuarios/new");

		// encontrando os inputs pelo nome
		WebElement nome = driver.findElement(By.name("usuario.nome"));
		WebElement email = driver.findElement(By.name("usuario.email"));

		// passando valor para os inputs
		nome.sendKeys("Jorge Hech");
		email.sendKeys("jorge@hech.com");

		// localizando e clicando no botão salvar
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();

		// .getPageSource() devolve o código fonte da página
		boolean achouNome = driver.getPageSource().contains("Jorge Hech");
		
		// assertTrue do JUnit
		assertTrue(achouNome);
		assertTrue(driver.getPageSource().contains("jorge@hech.com"));
	}
	
	@Test
	public void deveRetornarMensagemDeErroSeUsuarioNaoPreencherNome() {
		// passando a url que iremos testar
		driver.get("http://localhost:8080/usuarios/new");

		//encontrando input do e-mail e colocando valor
		WebElement email = driver.findElement(By.name("usuario.email"));
		email.sendKeys("email@mail.com");
		
		//outra forma de submeter o formulário sem precisar clicar no botão salvar
		email.submit();
		
		assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
	}
}
