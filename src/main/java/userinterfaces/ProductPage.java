package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProductPage {

    public static final Target ARTICLES_IN_LIST = Target.the("Producto en lista").
            locatedBy("(//article[1]//h3)[{0}]");
    public static final Target BUTTON_ADD = Target.the("Button para agregar al carrito ").
            locatedBy("(//button//span[contains(text(), 'Agregar')])[1]");
    public static final Target BUTTON_ADD_PLUS = Target.the("Button para agregar mas productos").
            locatedBy("(((//main//section[1]//section[1]//section[1])[4]//div[1])[7]//button)[2]");

    public static final Target PRODUCT_PRICE = Target.the("Precio del producto").
            locatedBy("(//p[@class='ProductPrice_container__price__LS1Td'])[1]");
    public static final Target PRODUCT_NAME = Target.the("Nombre del producto").
            locatedBy("(//h1[@class='product-title_product-title__heading__eJJqz'])[1]");
}
