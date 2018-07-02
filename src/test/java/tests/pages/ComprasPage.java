package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComprasPage extends BasePage {


    public ComprasPage(WebDriver navegador) {
        super(navegador);
    }

    public ComprasPage escolheProduto(String produto) {
        navegador.findElement(By.linkText(produto)).click();
        return this;

    }

    public ComprasPage colocaNoCarrinho(String botaoCarrinho){
        navegador.findElement(By.id(botaoCarrinho)).click();
        return this;
    }

    public CarrinhoComprasPage clicarCarrinho(String carrinho){
        navegador.get(carrinho);
        return new CarrinhoComprasPage(navegador);
    }

}
