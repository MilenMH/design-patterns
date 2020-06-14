package chain.of.responsibility.state.and.observer.core.employees;

import chain.of.responsibility.state.and.observer.core.observer.Observable;
import chain.of.responsibility.state.and.observer.core.observer.Observer;
import chain.of.responsibility.state.and.observer.core.shipments.Shipment;
import chain.of.responsibility.state.and.observer.core.states.ConfigureState;
import chain.of.responsibility.state.and.observer.core.states.State;
import chain.of.responsibility.state.and.observer.output.OutputDevice;

import java.util.UUID;

public abstract class Employee implements Observable, ConfigureState {

    private Employee next;

    private State state;

    private OutputDevice outputDevice;

    private Observer observer;

    public Employee(Employee next, OutputDevice outputDevice) {
        this.setNext(next);
        this.setOutputDevice(outputDevice);
    }

    public final Employee getNext(){
        return this.next;
    }

    public void setNext(Employee next) {
        this.next = next;
    }

    public State getState() {
        return state;
    }

    public void setOutputDevice(OutputDevice outputDevice) {
        this.outputDevice = outputDevice;
    }

    public void setState(State state) {
        String officerClassName = this.getClass().getSimpleName();
        String stateClassName = state.getClass().getSimpleName();
        outputDevice.write("        " + officerClassName + " change state to " + stateClassName);
        this.state = state;
    }

    public final boolean canHandleShipment(Shipment shipment){
        String shipmentClassName = shipment.getClass().getSimpleName();
        String context = shipmentClassName.replace("Shipment", "");
        String officerClassName = this.getClass().getSimpleName();
        outputDevice.write("    " + officerClassName + " try handle " + shipmentClassName);
        boolean canHandle = officerClassName.contains(context);
        outputDevice.write("    " + officerClassName + (canHandle ? " can handle " : " can not handle ") + shipmentClassName);
        return canHandle;
    }


    @Override
    public void register(Observer obj) {
        this.observer = obj;
    }

    @Override
    public void notifyObservers() {
        this.observer.update(this);
    }

}
