package LiveObjects.Animal.Herbivore;

import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.AnimalConstants;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Worm extends Herbivore{
    public Worm(Cell currentPosition) {
        super(currentPosition, AnimalConstants.AnimalParameters.WORM.getIcon());
        setWeight(AnimalConstants.AnimalParameters.WORM.getWeight());
        setMovementSpeed(AnimalConstants.AnimalParameters.WORM.getMovementSpeed());
        setMaxRepresentatives(AnimalConstants.AnimalParameters.WORM.getMaxRepresentatives());
        setMinFood(AnimalConstants.AnimalParameters.WORM.getMinFood());
        System.out.println("Created " + this.getIcon());
    }

    @Override
    public void reproduce() {
        ConcurrentLinkedDeque allThisInLocation = getCurrentPosition().getRepresentatives().get(this.getIcon());
        if ((allThisInLocation!=null) && (allThisInLocation.size() < this.getMaxRepresentatives())) {
            Alive newbie = new Worm(getCurrentPosition());
            Thread thread = new Thread(newbie);
            thread.start();
            System.out.println("New " + this.getIcon() + " was born");
        }
    }
}
