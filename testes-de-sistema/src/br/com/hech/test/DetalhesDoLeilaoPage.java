package br.com.hech.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetalhesDoLeilaoPage {

	private WebDriver driver;

	public DetalhesDoLeilaoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void lance(String usuario, double valor) {
		// tf valor
		WebElement txtValor = driver.findElement(By.name("lance.valor"));
		
		// combo box usuário
		Select cbUsuario = new Select(driver.findElement(By.name("lance.usuario.id")));
		
		// passando valor
		cbUsuario.selectByVisibleText(usuario);
		txtValor.sendKeys(String.valueOf(valor));
		
		// submetendo o formulário
		driver.findElement(By.id("btnDarLance")).click();
	}
	
	public boolean existeLance(String usuario, double valor) {
		/*
		 * implicit waits 
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * exemplo: WebElement elementoSurpresa = driver.findElement(By.id("surpresa"));
		 * 
		 * o implicit waits precisa ser desligado se não fará isso para todos testes
		 * 
		 * driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		 */
		
		// link com ExpectedConditions - https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html#textToBePresentInElement-org.openqa.selenium.WebElement-java.lang.String-
		// explicit wait (para esperar a requisição ajax)
		boolean temUsuario = new WebDriverWait(driver, 10).until(ExpectedConditions
		.textToBePresentInElementLocated(By.id("lancesDados"), usuario));
		
		if(temUsuario) return driver.getPageSource().contains(String.valueOf(valor));
		
		return false;
	}
	
}
