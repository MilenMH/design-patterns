package decorator.and.facade.decorator;

import decorator.and.facade.core.Hamburger;

import java.util.Arrays;
import java.util.stream.Stream;

public class HamburgerWithCheeseWrapper implements GetIngredients {
    private String cheese;

    private Hamburger hamburger;

    public HamburgerWithCheeseWrapper(String cheese, Hamburger hamburger) {
        this.cheese = cheese;
        this.hamburger = hamburger;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public Hamburger getHamburger() {
        return hamburger;
    }

    public void setHamburger(Hamburger hamburger) {
        this.hamburger = hamburger;
    }

    @Override
    public String[] getIngredients() {
        return Stream.concat(Arrays.stream(hamburger.getIngredients()), Arrays.stream(new String[]{this.getCheese()})).toArray(String[]::new);
    }

    @Override
    public String toString() {
        return "Hamburger With Cheese {" +
                ", hamburger=" + Arrays.toString(this.getIngredients()) +
                '}';
    }
}
