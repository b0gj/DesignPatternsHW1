package Exercises;

import People.Trainer;

public interface IExercise {
    void execute(Trainer trainer);
    void undo(Trainer trainer);
//    String getName();

}
