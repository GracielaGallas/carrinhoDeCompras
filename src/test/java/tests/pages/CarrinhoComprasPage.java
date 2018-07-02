package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CarrinhoComprasPage extends BasePage {

    public CarrinhoComprasPage(WebDriver navegador) {
        super(navegador);
    }

    public CarrinhoComprasPage clicaremCheckout(String botaoCheckout){
        navegador.findElement(By.xpath(botaoCheckout)).click();
        return this;
    }

    public CarrinhoComprasPage confirmarCompra(String botaoConfirmaCompra){
        WebDriverWait wait = new WebDriverWait(navegador, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(botaoConfirmaCompra)));
        navegador.findElement(By.id(botaoConfirmaCompra)).click();
        return this;
    }

    public CarrinhoComprasPage inserirMensagem(String mensagem){
        navegador.findElement(By.name("comment")).sendKeys(mensagem);
        return  this;
    }




}
