package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    public static final Target TEXT_PRODUCT = Target.the("Nombre del producto")
            .locatedBy("(//div[@data-molecule-product-detail-name]/span)[{0}]");
    public static final Target TEXT_PRICE = Target.the("Precio del producto")
            .locatedBy("(//div[@data-molecule-product-detail-price-best-price]/span)[{0}]");
    public static final Target TEXT_AMOUNT = Target.the("Cantidad del producto")
            .locatedBy("(//div[@data-molecule-quantity-und])[{0}]/span");
    public static final Target TOTAL_PRICE = Target.the("Precio total de la compra")
            .locatedBy("(//span[@data-molecule-summary-item-value])[2]");
}
