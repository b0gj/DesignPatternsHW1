package People;

import ObserverInterfaces.IObservable;
import ObserverInterfaces.IObserver;

import java.util.ArrayList;
import java.util.List;

public class Trainer implements IObservable {

    private String name;
    private final List<IObserver> trainees;
    private String exercise;

    public Trainer(String name) {
        this.name = name;
        this.trainees = new ArrayList<>();
    }

    @Override
    public void subscribe(IObserver observer) {
        this.trainees.add(observer);
        observer.setObservable(this);
    }

    @Override
    public void unsubscribe(IObserver observer) {
        this.trainees.remove(observer);
        observer.setObservable(null);

        System.out.println("The trainer " + this.name
                + " stopped training " + ((Trainee) observer).getName());
    }

    @Override
    public void notifyObservers() {
        for(IObserver trainee : trainees) {
            System.out.println("\nThe trainer " + this.name
                    + " told the trainee " + ((Trainee) trainee).getName()
                    + " to " + this.exercise);

            trainee.update();
        }
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

    public void setName(String name) {
        this.name = name;
    }
}
