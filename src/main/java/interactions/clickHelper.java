package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class clickHelper implements Interaction {

    private final int number;
    private final Target element;

    public clickHelper(int number, Target element) {
        this.number = number;
        this.element = element;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 0; i < number; i++) {
            actor.attemptsTo(Click.on(element));
        }
    }
    public static clickHelper nTimes(int number, Target element) {
        return instrumented(clickHelper.class, number, element);
    }
}