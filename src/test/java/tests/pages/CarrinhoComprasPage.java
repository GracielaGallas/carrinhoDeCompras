package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class CarrinhoComprasPage extends BasePage {

    public CarrinhoComprasPage(WebDriver navegador) {
        super(navegador);
    }

    public CarrinhoComprasPage clicaremCheckout(String botaoCheckout){
        navegador.findElement(By.xpath(botaoCheckout)).click();
        return this;
    }

    public CarrinhoComprasPage confirmarCompra(String botaoConfirmaCompra){
        navegador.findElement(By.id(botaoConfirmaCompra)).click();
        return this;
    }




}
