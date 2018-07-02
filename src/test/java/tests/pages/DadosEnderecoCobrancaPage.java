package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DadosEnderecoCobrancaPage extends BasePage{

    public String idNomePagamento = "input-payment-firstname";
    public String idSobrenomePagamento = "input-payment-lastname";
    public String idEndereco1 = "input-payment-address-1";
    public String idCidade = "input-payment-city";
    public String idCep = "input-payment-postcode";
    public String idPais = "input-payment-country";
    public String idEstado = "input-payment-zone";


    public DadosEnderecoCobrancaPage(WebDriver navegador) {
        super(navegador);
    }

    public DadosEnderecoCobrancaPage digitaNome(String nome){
        navegador.findElement(By.id(idNomePagamento)).sendKeys(nome);
        return this;
    }
    public DadosEnderecoCobrancaPage digitaSobrenome (String sobrenome){
        navegador.findElement(By.id(idSobrenomePagamento)).sendKeys(sobrenome);
        return this;
    }

    public DadosEnderecoCobrancaPage digitaEndereco(String endereco){
        navegador.findElement(By.id(idEndereco1)).sendKeys(endereco);
        return this;
    }

    public DadosEnderecoCobrancaPage digitaCidade(String cidade){
        navegador.findElement(By.id(idCidade)).sendKeys(cidade);
        return this;
    }

    public DadosEnderecoCobrancaPage digitaCep(String cep){
        navegador.findElement(By.id(idCep)).sendKeys(cep);
        return this;
    }

    public DadosEnderecoCobrancaPage selecionaPais(String pais){
        Select paiscobranca = new Select(navegador.findElement(By.id(idPais)));
        paiscobranca.selectByVisibleText(pais);
        return this;
    }
    public DadosEnderecoCobrancaPage selecionaEstado(String estado){
        Select zonecobranca = new Select(navegador.findElement(By.id(idEstado)));
        zonecobranca.selectByVisibleText(estado);
        return this;
    }
    public DadosEnderecoCobrancaPage selecionarAceitoRadio(String radioAceito){
        navegador.findElement(By.xpath(radioAceito)).click();
        return this;
    }
}
