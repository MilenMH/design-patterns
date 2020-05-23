package decorator.and.facade.decorator;

import decorator.and.facade.core.Hamburger;

import java.util.Arrays;

public class ClassicHamburgerWrapper implements GetIngredients{

    private Hamburger hamburger;

    public ClassicHamburgerWrapper(Hamburger hamburger) {
        this.hamburger = hamburger;
    }

    public Hamburger getHamburger() {
        return hamburger;
    }

    public void setHamburger(Hamburger hamburger) {
        this.hamburger = hamburger;
    }

    @Override
    public String[] getIngredients() {
        return hamburger.getIngredients();
    }

    @Override
    public String toString() {
        return "Classic Hamburger" +
                "hamburger=" + Arrays.toString(hamburger.getIngredients()) +
                '}';
    }
}
