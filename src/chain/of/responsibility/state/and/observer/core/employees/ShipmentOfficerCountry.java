package chain.of.responsibility.state.and.observer.core.employees;

import chain.of.responsibility.state.and.observer.output.OutputDevice;

public class ShipmentOfficerCountry extends Employee {
    public ShipmentOfficerCountry(Employee employee, OutputDevice outputDevice) {
        super(employee, outputDevice);
    }
}
