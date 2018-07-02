package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.Suporte.Generator;
import tests.Suporte.Screenshot;
import tests.Suporte.Web;

import java.util.concurrent.TimeUnit;



@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuario.csv")



public class InformacoesUsuario {
    private WebDriver navegador;
    @Rule
    public TestName test = new TestName();


    @Before
    public void setUp() {
        navegador = Web.createChrome();


        //Clicar no link que possui o texto "Account"
        navegador.findElement(By.linkText("Account")).click();
        // Logando
        navegador.findElement(By.linkText("Login")).click();
        navegador.findElement(By.id("input-email")).sendKeys("rosasilva@email.com");
        navegador.findElement(By.id("input-password")).sendKeys("123456");
        navegador.findElement(By.xpath("//input[@type='submit']")).click();


    }


    @Test
    public void fazerCompraPrimeiraVez(@Param(name="nome")String nome, @Param(name="sobrenome")String sobrenome,
                                       @Param(name="endereco")String endereco, @Param(name="cidade")String cidade,
                                       @Param(name="cep")String cep){


        //acessar página de compras
        navegador.get("https://www.journal-theme.com/1/");
        //escolhe produto
        navegador.findElement(By.linkText("Sport Watch")).click();
        //coloca no carrinho
        navegador.findElement(By.id("button-cart")).click();
        //vai para o carrinho de compras
        navegador.get("https://www.journal-theme.com/1/index.php?route=checkout/cart");

        //fazer o checkout
        navegador.findElement(By.xpath("//div[@class='pull-right']")).click();

        // preenchendo billing address

        navegador.findElement(By.id("input-payment-firstname")).sendKeys(nome);
        navegador.findElement(By.id("input-payment-lastname")).sendKeys(sobrenome);
        navegador.findElement(By.id("input-payment-address-1")).sendKeys(endereco);
        navegador.findElement(By.id("input-payment-city")).sendKeys(cidade);
        navegador.findElement(By.id("input-payment-postcode")).sendKeys(cep);
        Select paiscobranca = new Select(navegador.findElement(By.id("input-payment-country")));
        paiscobranca.selectByVisibleText("Brazil");
        Select zonecobranca = new Select(navegador.findElement(By.id("input-payment-zone")));
        zonecobranca.selectByVisibleText("Rio Grande do Sul");
        navegador.findElement(By.xpath("//input[@name='agree']")).click();


        // preenchendo Delivery Address

        navegador.findElement(By.id("input-shipping-firstname")).sendKeys(nome);
        navegador.findElement(By.id("input-shipping-lastname")).sendKeys(sobrenome);
        navegador.findElement(By.id("input-shipping-address-1")).sendKeys("rua diferente do pagamento");
        navegador.findElement(By.id("input-shipping-city")).sendKeys("bairro diferente do pagamento");
        navegador.findElement(By.id("input-shipping-postcode")).sendKeys("87654321");


        //confirmando a ordem de compra
        WebDriverWait wait = new WebDriverWait(navegador, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("journal-checkout-confirm-button")));
        navegador.findElement(By.id("journal-checkout-confirm-button")).click();
        String screenshotArquivo = "C:\\Users\\Graciela\\IdeaProjects\\carrinhoCompras\\Screens\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.take(navegador, screenshotArquivo);
        navegador.findElement(By.linkText("//a[@class='btn-primary button']")).click();

    }

    @Test
    public void fazerCompraEnderecoCadastrado() {
        //acessar página de compras
        navegador.get("https://www.journal-theme.com/1/");
        //escolhe produto
        navegador.findElement(By.linkText("Sport Watch")).click();
        //coloca no carrinho
        navegador.findElement(By.id("button-cart")).click();
        //vai para o carrinho de compras
        navegador.get("https://www.journal-theme.com/1/index.php?route=checkout/cart");

        //fazer o checkout
        navegador.findElement(By.xpath("//div[@class='pull-right']")).click();
        navegador.findElement(By.xpath("//input[@name='agree']")).click();
        WebDriverWait wait = new WebDriverWait(navegador, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("journal-checkout-confirm-button")));
        navegador.findElement(By.id("journal-checkout-confirm-button")).click();

        String screenshotArquivo = "C:\\Users\\Graciela\\IdeaProjects\\carrinhoCompras\\Screens\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.take(navegador, screenshotArquivo);


    }


     @After
     public void tearDown(){
            // fechar o navegador
           navegador.close();
        }


}
