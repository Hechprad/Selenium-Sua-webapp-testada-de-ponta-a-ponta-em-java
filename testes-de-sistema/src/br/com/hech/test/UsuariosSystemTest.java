package br.com.hech.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsuariosSystemTest {
	
	@Test
	public void deveAdicionarUmUsuario() {
		// caminho do chromedriver para utilizar o Google Chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers-para-SELENIUM\\Chromedriver\\chromedriver.exe");
		// driver do chrome
		WebDriver driver = new ChromeDriver();

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
		boolean achouEmail = driver.getPageSource().contains("jorge@hech.com");
		
		// assert do JUnit
		assertTrue(achouNome);
		assertTrue(achouEmail);
	}
}
