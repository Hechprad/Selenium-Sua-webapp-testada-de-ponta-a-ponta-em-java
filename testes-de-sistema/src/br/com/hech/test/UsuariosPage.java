package br.com.hech.test;

import org.openqa.selenium.WebDriver;

public class UsuariosPage {
	
	private WebDriver driver;

	public void visita() {
		// página com lista de usuários cadastrados
		driver.get("http://localhost:8080/usuarios/");
	}
}
