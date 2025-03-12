package People;

import ObserverInterfaces.IObservable;
import ObserverInterfaces.IObserver;

public class Spectator implements IObserver {
    private String name;
    private IObservable streamer;

    public Spectator(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("\nThe spectator " + this.name
                + " does the exercise " + streamer.getUpdate()
                + ", because he saw the streamer/trainee " + ((Trainee) streamer).getName()
                + " do the same");
    }

    @Override
    public void setObservable(IObservable observable) {
        this.streamer = observable;

        System.out.println("\nThe viewer " + this.name
                + " is now watching the streamer " + ((Trainee) streamer).getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
