package tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import tests.Suporte.Generator;
import tests.Suporte.Screenshot;
import tests.pages.*;
import tests.Suporte.Web;




public class InformacoesUsuarioPageObjectsTest {

    private String email = "alguem@email.com";
    private String password = "123456";
    private String enderecoPaginaCompras = "https://www.journal-theme.com/1/";
    private String produtoEscolhido = "Sport Watch";
    private String botaoAddCarrinho = "button-cart";
    private String botaoVerCarrinho = "https://www.journal-theme.com/1/index.php?route=checkout/cart";
    private String botaoCheckout = "//div[@class='pull-right']";
    private String pais = "Brazil";
    private String estado ="Rio Grande do Sul";
    private String radioAceito = "//input[@name='agree']";
    private String nome = "alguem";
    private String sobrenome = "silva";
    private String endereco = "rua das ruas";
    private String cidade = "Feliz";
    private String cep = "99999999";
    private String botaoConfirmaCompra = "journal-checkout-confirm-button";
    private String caminhoDaScreen = "C:\\Users\\Graciela\\IdeaProjects\\carrinhoCompras\\Screens\\";
    private String mensagem = "\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"";


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



    }

    @Test
    public void comprarNovamente(){
        new SecretaPage(navegador)
                .fazerComprasClienteAntigo(enderecoPaginaCompras)
                .escolheProduto(produtoEscolhido)
                .colocaNoCarrinho(botaoAddCarrinho)
                .clicarCarrinho(botaoVerCarrinho);
        new CarrinhoComprasPage(navegador)
                .clicaremCheckout(botaoCheckout);
        new DadosEnderecoCobrancaPage(navegador)
                .selecionarAceitoRadio(radioAceito);

        String screenshotArquivo = caminhoDaScreen + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.take(navegador, screenshotArquivo);

        new CarrinhoComprasPage(navegador)
                .inserirMensagem(mensagem);

        new CarrinhoComprasPage(navegador).confirmarCompra(botaoConfirmaCompra);

    }


    @After
    public void tearDown() {
        navegador.quit();
    }
}

