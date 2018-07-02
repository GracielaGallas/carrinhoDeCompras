package tests.pages;

import org.openqa.selenium.WebDriver;

public class SecretaPage extends BasePage{



    public SecretaPage(WebDriver navegador){
        super(navegador);
    }

    public ComprasPage fazerCompraPrimeiraVez(String endereco){
        navegador.get(endereco);
        return new ComprasPage(navegador);

    }

    public ComprasPage fazerComprasClienteAntigo(String endereco){
        navegador.get(endereco);
        return new ComprasPage(navegador);
    }
}


