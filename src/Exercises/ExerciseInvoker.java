package Exercises;

import People.Trainer;

import java.util.Stack;

public class ExerciseInvoker {
    private final Trainer trainer;
    private final Stack<IExercise> exerciseHistory;

    public ExerciseInvoker(Trainer trainer) {
        this.trainer = trainer;
        this.exerciseHistory = new Stack<>();
    }

    public void doExercise(IExercise exercise) {
        exercise.execute(trainer);
        exerciseHistory.push(exercise);
    }

    public void undoExercise() {
        if (!exerciseHistory.isEmpty()) {
            IExercise exercise =  exerciseHistory.peek();
            exerciseHistory.pop().undo(trainer);
        }
        else
            System.out.println("Do some exercises first!");
    }
}
