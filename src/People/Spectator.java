package People;

import ObserverInterfaces.IObservable;
import ObserverInterfaces.IObserver;

public class Spectator implements IObserver {

    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private String name;
    private IObservable streamer;

    public Spectator(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(GREEN + "\nThe spectator " + this.name
                + " does the exercise " + streamer.getUpdate()
                + ", because he saw the streamer/trainee " + ((Trainee) streamer).getName()
                + " do the same" + RESET);
    }

    @Override
    public void setObservable(IObservable observable) {
        this.streamer = observable;

        System.out.println(GREEN + "\nThe viewer " + this.name
                + " is now watching the streamer " + ((Trainee) streamer).getName() + RESET);
    }

    public String getName() {
        return name;
    }
}
