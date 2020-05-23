package decorator.and.facade.facade;

import decorator.and.facade.core.Hamburger;
import decorator.and.facade.decorator.ClassicHamburgerWrapper;
import decorator.and.facade.decorator.HamburgerWithCheeseWrapper;
import decorator.and.facade.decorator.HamburgerWithEggWrapper;

public class HamburgerStoreFacade {

    private ClassicHamburgerWrapper classicHamburgerWrapper;

    private HamburgerWithEggWrapper hamburgerWithEggWrapper;

    private HamburgerWithCheeseWrapper hamburgerWithCheeseWrapper;

    public HamburgerStoreFacade() {
        Hamburger hamburger = new Hamburger("Upper slice of bread", "lower slice of bread", "meatball", "lettuce" );

        classicHamburgerWrapper = new ClassicHamburgerWrapper(hamburger );

        hamburgerWithEggWrapper = new HamburgerWithEggWrapper("egg", hamburger);

        hamburgerWithCheeseWrapper = new HamburgerWithCheeseWrapper("cheese", hamburger);

    }

    public void orderClassicHamburger(){
        System.out.println(classicHamburgerWrapper.toString());
    }

    public void orderHamburgerWithCheese(){
        System.out.println(hamburgerWithCheeseWrapper.toString());
    }

    public void orderHamburgerWithEgg(){
        System.out.println(hamburgerWithEggWrapper.toString());
    }
}
