package chain.of.responsibility.state.and.observer.core.employees;

import chain.of.responsibility.state.and.observer.core.observer.Observer;
import chain.of.responsibility.state.and.observer.output.OutputDevice;
import javafx.beans.InvalidationListener;

public class ShipmentOfficerAbroad extends Employee {
    public ShipmentOfficerAbroad(Employee employee, OutputDevice outputDevice) {
        super(employee, outputDevice);
    }
}
