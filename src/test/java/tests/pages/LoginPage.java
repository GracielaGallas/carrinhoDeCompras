package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver navegador){
        super(navegador);
    }

    public LoginFormPage clickSignIn(){
        navegador.findElement(By.linkText("Account")).click();
        navegador.findElement(By.linkText("Login")).click();

        return new LoginFormPage(navegador);
    }
}
