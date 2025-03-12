package Exercises;

import People.Trainer;

public class SitDownExercise implements IExercise{
    @Override
    public void execute(Trainer trainer) {
        trainer.setExercise("sit down");
    }

    @Override
    public void undo(Trainer trainer) {
        trainer.setExercise("stand up");
    }
}
