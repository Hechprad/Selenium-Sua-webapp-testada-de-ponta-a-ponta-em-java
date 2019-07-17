# Selenium: Sua webapp testada de ponta a ponta em java - Curso Alura
*** 
### 📌 Download do *Selenium* na versão mais recente:
 - Link para [download](http://selenium-release.storage.googleapis.com/index.html) da última versão do selenium.
   - Versão utilizada: selenium-server-standalone-4.0.0-alpha-2.jar
***
### 📌Para as versões recentes do Mozilla FireFox precisamos do *GeckoDriver*.
 - Link para [download](https://github.com/mozilla/geckodriver/releases) do último release do GeckoDriver.
   - Versão utilizada: geckodriver-v0.24.0-win64
 - Criar o caminho do geckodriver nas variáveis de ambiente do windows > variáveis do sistema > path > editar > novo
   - Exemplo: "C:\geckodriver.exe"
 - Utilizar a linha de código abaixo com o caminho do executável do gecko driver onde for realizar os testes com o Mozilla FireFox:
   - System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
***
