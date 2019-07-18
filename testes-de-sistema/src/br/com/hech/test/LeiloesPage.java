package br.com.hech.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeiloesPage {

	private WebDriver driver;

	public LeiloesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void visita() {
		driver.get("http://localhost:8080/leiloes");
	}
	
	public NovoLeilaoPage novo() {
		// clica no link de novo leilão
		driver.findElement(By.linkText("Novo Leilão")).click();
		// retorna a classe que representa a nova página
		return new NovoLeilaoPage(driver);
	}
	
	public boolean existe(String produto, double valor, String usuario, boolean usado) {
		return driver.getPageSource().contains(produto)
				&& driver.getPageSource().contains(String.valueOf(valor))
				&& driver.getPageSource().contains(usuario)
				&& driver.getPageSource().contains(usado ? "Sim" : "Não");
	}
}
