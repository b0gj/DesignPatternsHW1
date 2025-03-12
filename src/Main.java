import Exercises.ExerciseInvoker;
import Exercises.IExercise;
import Exercises.SitDownExercise;
import Exercises.StandUpExercise;
import People.Spectator;
import People.Trainee;
import People.Trainer;

public class Main {
    public static void main(String[] args) {

        Trainer trainer = new Trainer("Ivan");


        Trainee trainee = new Trainee("Gergana");
        trainer.subscribe(trainee);


        Spectator spectator1 = new Spectator("Pavel");
        trainee.subscribe(spectator1);

        Spectator spectator2 = new Spectator("Maria");
        trainee.subscribe(spectator2);

        Spectator spectator3 = new Spectator("Denis");
        trainee.subscribe(spectator3);


        IExercise standUp = new StandUpExercise();
        IExercise sitDown = new SitDownExercise();

        ExerciseInvoker invoker = new ExerciseInvoker(trainer);


        invoker.doExercise(standUp);
        invoker.doExercise(sitDown);

        invoker.undoExercise();

    }
}