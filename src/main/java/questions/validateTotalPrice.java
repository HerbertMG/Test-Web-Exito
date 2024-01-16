package questions;

import models.productList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;

public class validateTotalPrice implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        double productCost = actor.recall("TOTAL");
        ArrayList<productList> items = actor.recall("ITEMS");
        double total = 0;
        for (productList item : items) {
            total += item.totalCost();
        }
        return productCost == total;
    }

    public static Question<Boolean> valTotalPrice() {
        return new validateTotalPrice();
    }
}