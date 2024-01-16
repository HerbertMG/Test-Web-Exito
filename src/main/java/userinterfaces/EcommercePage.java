package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("page:webdriver.base.url")
public class EcommercePage extends PageObject {

    public static final Target MENU_BUTTON = Target.the("Button que despliega categorias")
            .locatedBy("//span[contains(text(),'Menú')]");
    public static final Target SELECT_CATEGORY = Target.the("Categoria a buscar")
            .locatedBy("//p[contains(text(),'{0}')]");
    public static final Target SELECT_SUB_CATEGORY = Target.the("Subcategoria a buscar")
            .locatedBy("//a[contains(text(),'{0}')]");
    public static final Target VALIDATE_RESULT = Target.the("Primer articulo en el resultado")
            .locatedBy("//article[1]");
    public static final Target CART_BUTTON = Target.the("Button del carrito")
            .locatedBy("//span[contains(text(), 'Carrito')]");
}
