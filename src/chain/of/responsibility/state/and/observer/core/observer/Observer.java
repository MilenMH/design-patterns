package chain.of.responsibility.state.and.observer.core.observer;

import chain.of.responsibility.state.and.observer.core.states.ConfigureState;

public interface Observer {

    public void update(ConfigureState observable);

    public void setSubject(Observable sub);

}
