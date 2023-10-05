package LiveObjects;

import Field.Cell;
import LiveObjects.Animal.Herbivore.Horse;
import LiveObjects.Animal.Predator.Wolf;
import LiveObjects.Plant.Plant;

public class AliveFactory {
    public Alive randomAlive(Cell cell){
        return new Plant(cell);
    }
    public Alive ramdomPredator(Cell cell){
        return new Wolf(cell);
    }

    public Alive randomHerbivore (Cell cell){
        return new Horse(cell);
    }

    public Alive optionalAlive (AnimalConstants.AnimalParameters animal, Cell cell){
        switch (animal){
            case WOLF -> {return new Wolf(cell);}
            case BULL -> {return  new Horse(cell);}
            case PLANT -> {return new Plant(cell);}
            default -> {return null;}
        }
    }
}
