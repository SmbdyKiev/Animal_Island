package LiveObjects.Animal.Herbivore;

import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.AnimalConstants;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Horse extends Herbivore{
    public Horse(Cell currentPosition) {
        super(currentPosition, AnimalConstants.AnimalParameters.HORSE.getIcon());
        setWeight(AnimalConstants.AnimalParameters.HORSE.getWeight());
        setMovementSpeed(AnimalConstants.AnimalParameters.HORSE.getMovementSpeed());
        setMaxRepresentatives(AnimalConstants.AnimalParameters.HORSE.getMaxRepresentatives());
        setMinFood(AnimalConstants.AnimalParameters.HORSE.getMinFood());
        System.out.println("Created " + this.getIcon());

    }
    @Override
    public void reproduce() {
        ConcurrentLinkedDeque allThisInLocation = getCurrentPosition().getRepresentatives().get(this.getIcon());
        if ((allThisInLocation!=null) && (allThisInLocation.size() < this.getMaxRepresentatives())) {
            Alive newbie = new Horse(getCurrentPosition());
            Thread thread = new Thread(newbie);
            thread.start();
            System.out.println("New " + this.getIcon() + " was born");
        }
    }
}
