package Exercises;

import People.Trainer;

public class StandUpExercise implements IExercise{
    @Override
    public void execute(Trainer trainer) {
        trainer.setExercise("stand up");
    }

    @Override
    public void undo(Trainer trainer) {
        trainer.setExercise("sit down");
    }
//    @Override
//    public String getName() {
//        return "stand up";
//    }


}
