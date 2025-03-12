package People;

import ObserverInterfaces.IObservable;
import ObserverInterfaces.IObserver;

import java.util.ArrayList;
import java.util.List;

public class Trainee implements IObserver, IObservable {

    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";

    private String name;
    private IObservable trainer;
    private final List<IObserver> spectators;
    private String exercise;

    public Trainee(String name) {
        this.name = name;
        this.spectators = new ArrayList<>();
    }

    //IObserver
    @Override
    public void update() {
        System.out.println(BLUE + "\nThe trainee " + this.name
                + " does the exercise " + trainer.getUpdate()
                + ", because the trainer " + ((Trainer) trainer).getName()
                + " told them to" + RESET);
        this.setExercise(trainer.getUpdate());
    }

    @Override
    public void setObservable(IObservable observable) {
        this.trainer = observable;
    }

    //IObservable
    @Override
    public void subscribe(IObserver observer) {
        this.spectators.add(observer);
        observer.setObservable(this);
    }

    @Override
    public void unsubscribe(IObserver observer) {
        this.spectators.remove(observer);
        observer.setObservable(null);

        System.out.println(BLUE + "The viewer " + ((Spectator) observer).getName()
                + " stopped watching the streamer/trainee " + this.name + RESET);
    }

    @Override
    public void notifyObservers() {
        for (IObserver spectator : spectators)
            spectator.update();
    }

    @Override
    public String getUpdate() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
        this.notifyObservers();
    }

    public String getName() {
        return name;
    }

}
