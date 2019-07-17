import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAutomatizado {

	public static void main(String[] args) {
		/* Para as versões recentes do FireFox precisamos do
		 * GeckoDriver:
		 * criar o caminho do geckodriver nas variaveis de ambiente 
		 * do windows > variaveis do sistema > path > editar > novo
		 * 
		 * Utilizamos a linha de código abaixo com o caminho do executável do gecko driver
		 */
		System.setProperty("webdriver.gecko.driver", "C:\\Geckodriver\\geckodriver.exe");

		// WebDriver é a abstração que representa todos os browsers do selenium
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.google.com.br");
		
		//WebElemente representa o objeto que ele encontrou na página
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		// passando valores para o input de busca do google
		campoDeTexto.sendKeys("Caelum");
		
		// submit no formulário para realizar a busca no google
		campoDeTexto.submit();
		
	}
}
