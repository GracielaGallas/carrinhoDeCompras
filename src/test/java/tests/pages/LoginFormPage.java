package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage {


    public LoginFormPage(WebDriver navegador) {
        super(navegador);
    }


    public LoginFormPage typeLogin(String login){
        navegador.findElement(By.id("input-email")).sendKeys(login);
        return this;
    }

    public LoginFormPage typePassword(String password){
        navegador.findElement(By.id("input-password")).sendKeys(password);
        return this;
    }

    public SecretaPage clicarSignIn(){
        navegador.findElement(By.xpath("//input[@type='submit']")).click();
        return new SecretaPage(navegador);
    }

    public SecretaPage fazerLogin(String login, String password){
        typeLogin(login);
        typePassword(password);
        clicarSignIn();

        return new SecretaPage(navegador);
    }
}
