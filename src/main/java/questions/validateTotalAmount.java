package questions;

import models.productList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;

public class validateTotalAmount  implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        ArrayList<productList> items = actor.recall("ITEMS");
        ArrayList<productList> cartItems = actor.recall("CARTITEMS");
        return items.size() == cartItems.size();
    }

    public static Question<Boolean> valTotalAmount() {
        return new validateTotalAmount();
    }
}