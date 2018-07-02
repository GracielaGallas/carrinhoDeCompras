package tests;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import tests.Suporte.Generator;
import tests.Suporte.Screenshot;
import tests.pages.*;
import tests.Suporte.Web;

import java.util.concurrent.TimeUnit;


public class InformacoesUsuarioPageObjectsTest {

    public String email = "joanasilveira@email.com";
    public String password = "123456";
    public String enderecoPaginaCompras = "https://www.journal-theme.com/1/";
    public String produtoEscolhido = "Sport Watch";
    public String botaoAddCarrinho = "button-cart";
    public String botaoVerCarrinho = "https://www.journal-theme.com/1/index.php?route=checkout/cart";
    public String botaoCheckout = "//div[@class='pull-right']";
    public String pais = "Brazil";
    public String estado ="Rio Grande do Sul";
    public String radioAceito = "//input[@name='agree']";
    public String nome = "joana";
    public String sobrenome = "silveira";
    public String endereco = "rua das ruas";
    public String cidade = "Feliz";
    public String cep = "99999999";
    public String botaoConfirmaCompra = "journal-checkout-confirm-button";
    public String caminhoDaScreen = "C:\\Users\\Graciela\\IdeaProjects\\carrinhoCompras\\Screens\\";



    private WebDriver navegador;
    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp() {
        navegador = Web.createChrome();


        new LoginPage(navegador)
                .clickSignIn()
                .fazerLogin(email, password);
    }


    @Test
    public void comprarPrimeiraVez(){
            new SecretaPage(navegador)
                .fazerCompraPrimeiraVez(enderecoPaginaCompras)
                .escolheProduto(produtoEscolhido)
                .colocaNoCarrinho(botaoAddCarrinho)
                .clicarCarrinho(botaoVerCarrinho);
            new CarrinhoComprasPage(navegador)
                .clicaremCheckout(botaoCheckout);
            new DadosEnderecoCobrancaPage(navegador)
                .digitaNome(nome)
                .digitaSobrenome(sobrenome)
                .digitaEndereco(endereco)
                .digitaCidade(cidade)
                .digitaCep(cep)
                .selecionaPais(pais)
                .selecionaEstado(estado)
                .selecionarAceitoRadio(radioAceito);
            new DadosEnderecoEntregaPage(navegador)
                .digitaNome(nome)
                .digitaSobrenome(sobrenome)
                .digitaEndereco(endereco)
                .digitaCidade(cidade)
                .digitaCep(cep);

        String screenshotArquivo = caminhoDaScreen + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.take(navegador, screenshotArquivo);
            new CarrinhoComprasPage(navegador).confirmarCompra(botaoConfirmaCompra);
            new CarrinhoComprasPage(navegador).confirmarCompra(botaoConfirmaCompra);


    }







//    @After
//    public void tearDown() {
//        navegador.quit();
//    }
}

