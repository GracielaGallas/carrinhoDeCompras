package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DadosEnderecoEntregaPage extends BasePage {

    String idNomePagamento = "input-shipping-firstname";
    String idSobrenomePagamento = "input-shipping-lastname";
    String idEndereco1 = "input-shipping-address-1";
    String idCidade = "input-shipping-city";
    String idCep = "input-shipping-postcode";
    String idPais = "input-shipping-country";
    String idEstado = "input-shipping-zone";


    public DadosEnderecoEntregaPage(WebDriver navegador) {
        super(navegador);
    }

    public DadosEnderecoEntregaPage digitaNome(String nome) {
        navegador.findElement(By.id(idNomePagamento)).sendKeys(nome);
        return this;
    }

    public DadosEnderecoEntregaPage digitaSobrenome(String sobrenome) {
        navegador.findElement(By.id(idSobrenomePagamento)).sendKeys(sobrenome);
        return this;
    }

    public DadosEnderecoEntregaPage digitaEndereco(String endereco) {
        navegador.findElement(By.id(idEndereco1)).sendKeys(endereco);
        return this;
    }

    public DadosEnderecoEntregaPage digitaCidade(String cidade) {
        navegador.findElement(By.id(idCidade)).sendKeys(cidade);
        return this;
    }

    public DadosEnderecoEntregaPage digitaCep(String cep) {
        navegador.findElement(By.id(idCep)).sendKeys(cep);
        return this;
    }


}