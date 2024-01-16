package tasks;

import interactions.Pause;
import interactions.ScrollDown;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EcommercePage.*;

public class selectCategory implements Task {

    private String category;
    private String subcategory;

    public selectCategory(String category, String subcategory) {
        this.category = category;
        this.subcategory = subcategory;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Pause.withDuration(1),
                WaitUntil.the(MENU_BUTTON, WebElementStateMatchers.isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(MENU_BUTTON),
                Click.on(SELECT_CATEGORY.of(category)),
                Pause.withDuration(1),
                Click.on(SELECT_SUB_CATEGORY.of(subcategory)),
                WaitUntil.the(VALIDATE_RESULT, WebElementStateMatchers.isEnabled()).forNoMoreThan(5).seconds(),
                Pause.withDuration(5),
                ScrollDown.go()
        );
    }

    public static selectCategory conFiltro(String category, String subcategory) {
        return instrumented(selectCategory.class, category, subcategory);
    }
}
