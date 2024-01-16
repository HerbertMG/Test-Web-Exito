package questions;

import models.productList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;

public class validateAmountXProduct implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        ArrayList<productList> items = actor.recall("ITEMS");
        ArrayList<productList> cartItems = actor.recall("CARTITEMS");
        return items.stream().mapToInt(productList::getAmount).sum() == cartItems.stream().mapToInt(productList::getAmount).sum();
    }

    public static Question<Boolean> valAmountXProduct() {
        return new validateAmountXProduct();
    }
}