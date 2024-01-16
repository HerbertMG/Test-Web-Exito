package questions;

import models.productList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import utils.cleanPrice;

import java.util.ArrayList;

import static userinterfaces.CartPage.*;

public class validateNames implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        ArrayList<productList> items = actor.recall("ITEMS");
        ArrayList<productList> cartItems = new ArrayList<>();

        for (int i = 1; i <= items.size(); i++) {
            String name = TEXT_PRODUCT.of(String.valueOf(i)).resolveFor(actor).getText();
            double value = cleanPrice.number(TEXT_PRICE.of(String.valueOf(i)).resolveFor(actor).getText());
            int amount = Integer.parseInt(TEXT_AMOUNT.of(String.valueOf(i)).resolveFor(actor).getText());
            cartItems.add(new productList(name, value / amount, amount-1));
        }
        actor.remember("CARTITEMS", cartItems);
        actor.remember("TOTAL", cleanPrice.number(TOTAL_PRICE.resolveFor(actor).getText()));
        return items.equals(cartItems);
    }

    public static Question<Boolean> validateProductName() {
        return new validateNames();
    }
}