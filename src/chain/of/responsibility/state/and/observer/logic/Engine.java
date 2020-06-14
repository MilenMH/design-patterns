package chain.of.responsibility.state.and.observer.logic;

import chain.of.responsibility.state.and.observer.core.employees.Employee;
import chain.of.responsibility.state.and.observer.core.observer.Observer;
import chain.of.responsibility.state.and.observer.core.shipments.Shipment;
import chain.of.responsibility.state.and.observer.core.states.PrepareShipment;
import chain.of.responsibility.state.and.observer.output.OutputDevice;

import java.util.Iterator;
import java.util.List;

public class Engine {

    private Employee shipmentOfficer;
    private List<Shipment> shipments;
    private OutputDevice outputDevice;
    private Observer observer;

    public Engine(Employee shipmentOfficer, List<Shipment> shipments, OutputDevice outputDevice, Observer observer) {
        this.shipmentOfficer = shipmentOfficer;
        this.shipments = shipments;
        this.outputDevice =  outputDevice;
        this.observer = observer;
    }


    public void run() {
        Iterator<Shipment> iterator = shipments.iterator();
        while (iterator.hasNext()){
            Shipment shipment = iterator.next();
            outputDevice.write("Shipment : " + shipment.getClass().getSimpleName());

            boolean canHandle = shipmentOfficer.canHandleShipment(shipment);
            while (!canHandle){
                shipmentOfficer = shipmentOfficer.getNext();
                canHandle = shipmentOfficer.canHandleShipment(shipment);
            }

            shipmentOfficer.setState(new PrepareShipment());
            shipmentOfficer.notifyObservers();

            outputDevice.write("");
            iterator.remove();

        }



    }


}
