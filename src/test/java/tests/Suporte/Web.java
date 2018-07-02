package tests.Suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createChrome(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Graciela\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        //Navegar para a página inicial
        navegador.get("https://www.journal-theme.com/1/index.php?route=common/home");
        navegador.manage().window().maximize();

        return navegador;
    }
}
