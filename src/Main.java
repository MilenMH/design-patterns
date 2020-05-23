import decorator.and.facade.facade.HamburgerStoreFacade;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        HamburgerStoreFacade hamburgerStoreFacade = new HamburgerStoreFacade();
        hamburgerStoreFacade.orderClassicHamburger();
        hamburgerStoreFacade.orderHamburgerWithCheese();
        hamburgerStoreFacade.orderHamburgerWithEgg();

    }
}
