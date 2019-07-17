import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAutomatizado {

	public static void main(String[] args) {
		//**************************************************
		/*
		 * Link de download do selenium na vers�o mais recente:
		 *  - http://selenium-release.storage.googleapis.com/index.html 
		 */
		//**************************************************
		/*
		 * Para as vers�es recentes do FireFox precisamos do
		 * GeckoDriver: download do �ltimo release 
		 *  - https://github.com/mozilla/geckodriver/releases
		 * criar o caminho do geckodriver nas vari�veis de ambiente 
		 * do windows > vari�veis do sistema > path > editar > novo
		 * 
		 * Utilizamos a linha de c�digo abaixo com o caminho do 
		 * execut�vel do gecko driver
		 */
		System.setProperty("webdriver.gecko.driver", "C:\\Drivers-para-SELENIUM\\Geckodriver-firefox\\geckodriver.exe");
		//**************************************************
		/*
		 * O mesmo procedimento para o chrome.
		 * Chromedriver: download da vers�o 75.0.3770.90
		 *  - http://chromedriver.storage.googleapis.com/index.html
		 */
		//System.setProperty("webdriver.chrome.driver", "C:\\Drivers-para-SELENIUM\\Chromedriver\\chromedriver.exe");
		
		// WebDriver � a abstra��o que representa todos os browsers do selenium
		WebDriver driver = new FirefoxDriver();
		//WebDriver driver2 = new ChromeDriver();
		
		// passando a url que iremos testar
		driver.get("http://www.google.com.br");
		//driver2.get("http://www.google.com.br");
		
		//WebElement representa o objeto que ele encontrou na p�gina
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		//WebElement campoDeTexto = driver2.findElement(By.name("q"));
		
		// passando valores para o input de busca do google
		campoDeTexto.sendKeys("Caelum");
		// submete o formul�rio para realizar a busca no google
		campoDeTexto.submit();		
	}
}
