package br.com.hech.test;

import org.openqa.selenium.WebDriver;

public class UsuariosPage {
	
	private WebDriver driver;

	public void visita() {
		// p�gina com lista de usu�rios cadastrados
		driver.get("http://localhost:8080/usuarios/");
	}
}
