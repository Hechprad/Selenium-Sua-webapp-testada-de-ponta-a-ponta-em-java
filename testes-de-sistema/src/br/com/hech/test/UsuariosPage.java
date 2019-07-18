package br.com.hech.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsuariosPage {
	
	private WebDriver driver;
	
	public UsuariosPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visita() {
		// p�gina com lista de usu�rios cadastrados
		driver.get("http://localhost:8080/usuarios");
	}
	
	public NovoUsuarioPage novo() {
		driver.findElement(By.linkText("Novo Usu�rio")).click();
		return new NovoUsuarioPage(driver);
	}
	
	public boolean existeNaListagem(String nome, String email) {
		return driver.getPageSource().contains(nome) && driver.getPageSource().contains(email);
	}

	public void deletaUsuarioNaPosicao(int posicao) {
		// localiza o bot�o do usu�rio que queremos excluir
		driver.findElements(By.tagName("button")).get(posicao-1).click();
		// pega o alert que est� aberto
		Alert alerta = driver.switchTo().alert();
		// confirma
		alerta.accept();
	}

}
