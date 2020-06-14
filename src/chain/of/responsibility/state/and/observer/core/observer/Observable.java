package chain.of.responsibility.state.and.observer.core.observer;

public interface Observable {

    void register(Observer obj);

    void notifyObservers();

}
