package Acciones;

import java.awt.print.Printable;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;

import CommonFuntions.BaseTest;
import Pages.TestPages;


public class PruebaAccion extends BaseTest {

    WebDriver driver;
    private static Logger log = Logger.getLogger(PruebaAccion.class);
    TestPages testPage = new TestPages(driver);

    public PruebaAccion(WebDriver driver) {
        super(driver);
        this.driver = super.driver;
    }


    public String locator(int valor) {
        String xpatListaInput = "(//input[contains(@class,'form_input')])";
        String locator = xpatListaInput + "[" + valor + "]";
        return locator;
    }

    public void ingresarUsuario(String user) {
        log.info("**********  ingresarUsuario ************");
        try {
            esperaExplicita(testPage.inputUser);
            EscribirElemento(testPage.inputUser, user);
        } catch (Exception e) {
            log.error("########## Error - ingresarUsuario()  #######" + e);
            throw new AssertionError(e);
        }
    }


    public void ingresarPassword(String password) {
        log.info("**********  ingresarPassword ************");
        try {
            esperaExplicita(testPage.inputPassword);
            EscribirElemento(testPage.inputPassword, password);
        } catch (Exception e) {
            log.error("########## Error - ingresarPassword()  #######" + e);
            throw new AssertionError(e);
        }
    }


    public void presionarLogin() {
        log.info("**********  presionarLogin ************");
        try {

            esperaExplicita(testPage.buttonLogin);
            hacerClick(testPage.buttonLogin);

            esperaExplicita(testPage.tittleProducts);
            assertEquals("Error en el mensaje comparado", extraerTextoElemento(testPage.tittleProducts),
                    "Products");
        } catch (Exception e) {
            log.error("########## Error - presionarLogin()  #######" + e);
            throw new AssertionError(e);
        }
    }

    public void validarLogin() {
        log.info("**********  validarLogin ************");
        try {

            esperaExplicita(testPage.tittleProducts);
            assertEquals("Error en el mensaje comparado", extraerTextoElemento(testPage.tittleProducts),
                    "Products");
        } catch (Exception e) {
            log.error("########## Error - validarLogin()  #######" + e);
            throw new AssertionError(e);
        }
    }

    public void seleccionarItem(String item) {
        log.info("**********  seleccionarItem ************");
        try {

            esperaExplicita(testPage.listProducts);
            selectValorLista(testPage.listProducts, item);
            esperaExplicita(testPage.buttonAddCart);
            hacerClick(testPage.buttonAddCart);
            esperaExplicita(testPage.buttonShopping);
            hacerClick(testPage.buttonShopping);
            esperaExplicita(testPage.tittleDescription);
            assertEquals("Error los textos no coinciden", extraerTextoElemento(testPage.tittleDescription), item);
            esperaExplicita(testPage.buttonCheckout);
            hacerClick(testPage.buttonCheckout);

        } catch (Exception e) {
            log.error("########## Error - seleccionarItem()  #######" + e);
            throw new AssertionError(e);
        }
    }

    public void llenarinformacion(String nombre, String apellido, String zipCode) {
        log.info("**********  llenarInputUsuario ************");
        try {

            esperaExplicita(testPage.listInputInformation);
            List<WebElement> ListaElement = driver.findElements(testPage.listInputInformation);

            for (int i = 0; i < ListaElement.size(); i++) {

                if (i == 0) {
                    ListaElement.get(i).sendKeys(nombre);
                } else if (i == 1) {
                    Hacer_scroll(By.xpath(this.locator(i)));
                    ListaElement.get(i).sendKeys(apellido);
                    adjuntarCaptura("llenarDatos");
                } else if (i == 2) {
                    Hacer_scroll(By.xpath(this.locator(i)));
                    ListaElement.get(i).sendKeys(zipCode);
                }

            }
            esperaExplicita(testPage.buttonContinue);
            hacerClick(testPage.buttonContinue);

        } catch (Exception e) {
            log.error("########## Error - llenarInputUsuario()  #######" + e);
            throw new AssertionError(e);
        }
    }


    public void validarDescripcionPrecio(String item) {
        log.info("**********  validarDescripcionPrecio ************");
        try {
            Hacer_scroll(testPage.itemPrice);
            esperaExplicita(testPage.itemPrice);
            String value = extraerTextoElemento(testPage.itemPrice).replace("$", "");
            assertEquals("Error el valor total no coincide",
                    extraerTextoElemento(testPage.itemTotal), "Total: " + this.calcularvalorConIva(value));
        } catch (Exception e) {
            log.error("########## Error - validarDescripcionPrecio()  #######" + e);
            throw new AssertionError(e);
        }
    }

    public void finalizarCompra(String mensajeConfirmacion) {
        log.info("**********  finalizarCompra ************");
        try {
            Hacer_scroll(testPage.buttonFinish);
            esperaExplicita(testPage.buttonFinish);
            hacerClick(testPage.buttonFinish);
            Hacer_scroll(testPage.textOrderComplete);
            esperaExplicita(testPage.textOrderComplete);
            assertEquals("Error los textos no coinciden", extraerTextoElemento(testPage.textOrderComplete), mensajeConfirmacion);
        } catch (Exception e) {
            log.error("########## Error - finalizarCompra()  #######" + e);
            throw new AssertionError(e);
        }
    }


    public String calcularvalorConIva(String valor) {
        Double value = Double.parseDouble(valor);
        String sa = String.format("%.2f", (value * 0.08) + value);
        return "$" + sa.replace(",", ".");
    }


}
