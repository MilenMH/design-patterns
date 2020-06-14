package chain.of.responsibility.state.and.observer.core.employees;

import chain.of.responsibility.state.and.observer.output.OutputDevice;

public class ShipmentOfficerCity extends Employee {
    public ShipmentOfficerCity(Employee employee, OutputDevice outputDevice) {
        super(employee, outputDevice);
    }
}
