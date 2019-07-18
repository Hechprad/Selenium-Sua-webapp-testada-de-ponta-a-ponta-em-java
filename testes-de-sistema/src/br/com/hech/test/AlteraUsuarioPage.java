package br.com.hech.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlteraUsuarioPage {

	private WebDriver driver;

	public AlteraUsuarioPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public UsuariosPage para(String nome, String email) {
		// identifica os campos para alteração
		WebElement txtNome = driver.findElement(By.name("usuario.nome"));
		WebElement txtEmail = driver.findElement(By.name("usuario.email"));
		
		// limpa os campos
		txtNome.clear();
		txtEmail.clear();
		
		// insere novos dados
		txtNome.sendKeys(nome);
		txtEmail.sendKeys(email);
		
		// submete o formulário
		txtNome.submit();
		
		return new UsuariosPage(driver);
	}
}
