package LiveObjects.Animal.Herbivore;

import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.AnimalConstants;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Goat extends Herbivore{
    public Goat(Cell currentPosition) {
        super(currentPosition, AnimalConstants.AnimalParameters.GOAT.getIcon());
        setWeight(AnimalConstants.AnimalParameters.GOAT.getWeight());
        setMovementSpeed(AnimalConstants.AnimalParameters.GOAT.getMovementSpeed());
        setMaxRepresentatives(AnimalConstants.AnimalParameters.GOAT.getMaxRepresentatives());
        setMinFood(AnimalConstants.AnimalParameters.GOAT.getMinFood());
        System.out.println("Created " + this.getIcon());
    }

    @Override
    public void reproduce() {
        ConcurrentLinkedDeque allThisInLocation = getCurrentPosition().getRepresentatives().get(this.getIcon());
        if ((allThisInLocation!=null) && (allThisInLocation.size() < this.getMaxRepresentatives())) {
            Alive newbie = new Goat(getCurrentPosition());
            Thread thread = new Thread(newbie);
            thread.start();
            System.out.println("New " + this.getIcon() + " was born");
        }
    }
}
