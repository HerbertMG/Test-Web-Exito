package tasks;

import interactions.BackPage;
import interactions.Pause;
import interactions.clickHelper;
import models.productList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils.cleanPrice;
import utils.randomPoss;

import java.util.ArrayList;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.ProductPage.*;

public class addArticles implements Task {

    private final int nroProducts;

    public addArticles(int nroProducts) {
        this.nroProducts = nroProducts;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        int amount = randomPoss.randomNumber(10);  //obtengo cantidades aleatorias para cada producto
        int[] element = randomPoss.randomArray(15,nroProducts); //obtengo producto en posicion aleatoria
        ArrayList<productList> items =new ArrayList<>();

        for (int j : element) {

            actor.attemptsTo(
                    Pause.withDuration(3),
                    Scroll.to(ARTICLES_IN_LIST.of(String.valueOf(j))),
                    Click.on(ARTICLES_IN_LIST.of(String.valueOf(j))),
                    Pause.withDuration(5),
                    WaitUntil.the(BUTTON_ADD, WebElementStateMatchers.isEnabled()).forNoMoreThan(5).seconds(),
                    Click.on(BUTTON_ADD),
                    WaitUntil.the(BUTTON_ADD_PLUS, WebElementStateMatchers.isEnabled()).forNoMoreThan(5).seconds(),
                    clickHelper.nTimes(amount,BUTTON_ADD_PLUS),
                    Pause.withDuration(5),
                    WaitUntil.the(PRODUCT_PRICE, WebElementStateMatchers.isEnabled()).forNoMoreThan(5).seconds(),
                    WaitUntil.the(PRODUCT_NAME, WebElementStateMatchers.isEnabled()).forNoMoreThan(5).seconds()
            );

            String nombreProducto = PRODUCT_NAME.resolveFor(actor).getText();
            double precioProducto = cleanPrice.number(PRODUCT_PRICE.resolveFor(actor).getText());
            items.add(new productList(nombreProducto,precioProducto,amount));

            actor.attemptsTo(
                    BackPage.backPage(),
                    Pause.withDuration(7)
            );
        }

        actor.remember("ITEMS",items);

    }

    public static addArticles conCantidad(int number) {
        return instrumented(addArticles.class, number);
    }
}
