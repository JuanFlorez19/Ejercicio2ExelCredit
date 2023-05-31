package StepsDefinitions;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Acciones.PruebaAccion;
import CommonFuntions.BaseTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

public class TestSteps {

	WebDriver driver;
	Logger log = Logger.getLogger(TestSteps.class);
	BaseTest baseTest;
	PruebaAccion pruebaAccion;

	public TestSteps() {		
		this.driver = Driver.driver;
		pruebaAccion = new PruebaAccion(driver);
	}	
	
	@Given("^a user in the page saucedemo$")
	public void aUserInThePageSaucedemo() throws Throwable{
		
	}
	
	@When("enter a correct user {string}")
	public void enterACorrectUser(String user) throws Throwable{
		pruebaAccion.ingresarUsuario(user);
	}
	
	@And("enter a correct password {string}")
	public void enteACorrectPassword(String password) throws Throwable{
		pruebaAccion.ingresarPassword(password);
	}
	
	@And("^press the login button$")
	public void pressTheLoginButton() throws Throwable{
		pruebaAccion.presionarLogin();
	}
	
	@Then("^allows the entry to the system$")
	public void allowsTheEntryToTheSystem()throws Throwable{
		pruebaAccion.validarLogin();
	}
	
	@And("select a item required {string}")
	public void selectAItemRequired(String item)throws Throwable {
		pruebaAccion.seleccionarItem(item);
	}
	
	@And("complete the form with the information {string}{string}{string}")
	public void completeTheFormWithTheInformation(String name, String lastName, String zipCode){
		pruebaAccion.llenarinformacion(name, lastName, zipCode);
	}

	@And("validate product description and total price of the {string}")
	public void validateProductDescriptionAndTotalPriceOfThe(String item){
		pruebaAccion.validarDescripcionPrecio(item);
	}
	
	@Then("finish with the order displaying the following message {string}")
	public void finishWithTheOrderDisplayingTheFollowingMessage(String message){
		pruebaAccion.finalizarCompra(message);
	}
	
}
