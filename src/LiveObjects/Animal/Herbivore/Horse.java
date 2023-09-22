package LiveObjects.Animal.Herbivore;

import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.AnimalConstants;

import java.util.HashMap;
import java.util.Map;

public class Horse extends Herbivore{

    public Horse(Cell currentPosition) {
        super(currentPosition, AnimalConstants.AnimalParameters.HORSE.getIcon());
        setWeight(AnimalConstants.AnimalParameters.HORSE.getWeight());
        setMovementSpeed(AnimalConstants.AnimalParameters.HORSE.getMovementSpeed());
        setMaxRepresentatives(AnimalConstants.AnimalParameters.HORSE.getMaxRepresentatives());
        setMinFood(AnimalConstants.AnimalParameters.HORSE.getMinFood());
        System.out.println("Created "+this.getIcon());

    }

    @Override
    public void reproduce() {
        if (getCurrentPosition().getRepresentatives().get(this.getIcon()).size()<this.getMaxRepresentatives()) {
            Alive horse = new Horse(getCurrentPosition());
            Thread thread = new Thread(horse);
            thread.start();
        }
    }


}
