# Selenium: Sua webapp testada de ponta a ponta em java
*** 
### 📌 Download do *Selenium* na versão mais recente:
 - Link para [download](http://selenium-release.storage.googleapis.com/index.html) da última versão do selenium.
   - Versão utilizada: selenium-server-standalone-4.0.0-alpha-2.jar
***
### 📌Para o Google Chrome precisamos do *ChromeDriver*.
 - Link para [download](http://chromedriver.storage.googleapis.com/index.html) do ChromeDriver.
   - Versão utilizada: 75.0.3770.90 chromedriver_win32
 - Criar o caminho do chromedriver nas variáveis de ambiente do windows > variáveis do sistema > path > editar > novo
   - Exemplo: "C:\chromedriver.exe"
 - Utilizar a linha de código abaixo com o caminho do executável do chromedriver onde for realizar os testes com o Google Chrome:
   - System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
***
### 📌Para o Mozilla FireFox precisamos do *GeckoDriver*.
 - Link para [download](https://github.com/mozilla/geckodriver/releases) do último release do GeckoDriver.
   - Versão utilizada: geckodriver-v0.24.0-win64
 - Criar o caminho do geckodriver nas variáveis de ambiente do windows > variáveis do sistema > path > editar > novo
   - Exemplo: "C:\geckodriver.exe"
 - Utilizar a linha de código abaixo com o caminho do executável do geckodriver onde for realizar os testes com o Mozilla FireFox:
   - System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
***

