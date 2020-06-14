package chain.of.responsibility.state.and.observer.core.observer;

import chain.of.responsibility.state.and.observer.core.states.ConfigureState;
import chain.of.responsibility.state.and.observer.core.states.WaitingForShipment;
import chain.of.responsibility.state.and.observer.output.OutputDevice;

import java.util.ArrayList;
import java.util.List;

public class ObserverImpl implements  Observer {

    private List<Observable> observables;

    private OutputDevice outputDevice;

    public ObserverImpl(OutputDevice outputDevice) {
        this(new ArrayList<Observable>(), outputDevice);
    }

    public ObserverImpl(List<Observable> observables, OutputDevice outputDevice) {
        this.observables = observables;
        this.outputDevice = outputDevice;
    }

    @Override
    public void update(ConfigureState observable) {
        outputDevice.write("            Observer takes the package from " + observable.getClass().getSimpleName()  + " and throw it to the storage." );
        observable.setState(new WaitingForShipment());
    }

    @Override
    public void setSubject(Observable sub) {
        this.observables.add(sub);
    }
}
