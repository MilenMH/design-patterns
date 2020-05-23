package decorator.and.facade.decorator;

import decorator.and.facade.core.Hamburger;

import java.util.Arrays;
import java.util.stream.Stream;

public class HamburgerWithEggWrapper implements GetIngredients {

    private String egg;

    private Hamburger hamburger;

    public HamburgerWithEggWrapper(String egg, Hamburger hamburger) {
        this.egg = egg;
        this.hamburger = hamburger;
    }

    public String getEgg() {
        return egg;
    }

    public void setEgg(String egg) {
        this.egg = egg;
    }

    public Hamburger getHamburger() {
        return hamburger;
    }

    public void setHamburger(Hamburger hamburger) {
        this.hamburger = hamburger;
    }

    @Override
    public String[] getIngredients() {
        return Stream.concat(Arrays.stream(hamburger.getIngredients()), Arrays.stream(new String[]{this.getEgg()})).toArray(String[]::new);
    }

    @Override
    public String toString() {
        return "Hamburger With Egg {" +
                ", hamburger=" + Arrays.toString(this.getIngredients()) +
                '}';
    }

}
