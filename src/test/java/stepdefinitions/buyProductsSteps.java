package stepdefinitions;

import cucumber.api.java.es.*;
import interactions.Pause;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import questions.validateAmountXProduct;
import questions.validateNames;
import questions.validateTotalAmount;
import questions.validateTotalPrice;
import tasks.addArticles;
import tasks.selectCategory;
import userinterfaces.EcommercePage;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static userinterfaces.EcommercePage.CART_BUTTON;

public class buyProductsSteps {

    private Actor actor = Actor.named("ClienteExito");
    private EcommercePage homePage = new EcommercePage();

    @Dado("^que un usuario ingresa al HOME de la WEB$")
    public void queUnUsuarioIngresaAlHomeDeLaWeb() {
        actor.can(BrowseTheWeb.with(getDriver()));
        actor.wasAbleTo(Open.browserOn(homePage));
        getDriver().manage().window().maximize();
    }

    @Cuando("^selecciona una (.*) con (.*)$")
    public void seleccionaUnaCategoria(String categoria, String subcategoria) {
        actor.attemptsTo(
                selectCategory.conFiltro(categoria, subcategoria)
        );
    }

    @Cuando("^selecciona (.*) productos aleatorios con cantidades aleatorias$")
    public void seleccionaProductosAleatorios(int cantidad) {
        actor.attemptsTo(
                addArticles.conCantidad(cantidad)
        );
    }

    @Entonces("se validara el nombre de los productos en el carrito")
    public void seValidaElNombreDeLosProductos() {
        getDriver().navigate().refresh();
        actor.attemptsTo(
                Pause.withDuration(3),
                WaitUntil.the(CART_BUTTON, WebElementStateMatchers.isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(CART_BUTTON),
                Pause.withDuration(3)
        );
        actor.should(
                GivenWhenThen.seeThat(validateNames.validateProductName())
        );
    }

    @Entonces("se valida el precio total")
    public void seValidaElPrecioTotal() {
        actor.should(
                GivenWhenThen.seeThat(validateTotalPrice.valTotalPrice())
        );
    }

    @Entonces("se valida la cantidad de cada producto agregado")
    public void seValidaLaCantidadDeCadaProductoAgregado() {
        actor.should(
                GivenWhenThen.seeThat(validateAmountXProduct.valAmountXProduct())
        );
    }

    @Entonces("se valida el total de productos agregados")
    public void seValidaElTotalDeProductosAgregados() {
        actor.should(
                GivenWhenThen.seeThat(validateTotalAmount.valTotalAmount())
        );
        actor.attemptsTo(Pause.withDuration(10));

    }

}
