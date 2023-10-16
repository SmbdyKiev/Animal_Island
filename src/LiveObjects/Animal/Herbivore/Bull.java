package LiveObjects.Animal.Herbivore;

import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.AnimalConstants;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Bull extends Herbivore{
    public Bull(Cell currentPosition) {
        super(currentPosition, AnimalConstants.AnimalParameters.BULL.getIcon());
        setWeight(AnimalConstants.AnimalParameters.BULL.getWeight());
        setMovementSpeed(AnimalConstants.AnimalParameters.BULL.getMovementSpeed());
        setMaxRepresentatives(AnimalConstants.AnimalParameters.BULL.getMaxRepresentatives());
        setMinFood(AnimalConstants.AnimalParameters.BULL.getMinFood());
        System.out.println("Created " + this.getIcon());
    }

    @Override
    public void reproduce() {
        ConcurrentLinkedDeque allThisInLocation = getCurrentPosition().getRepresentatives().get(this.getIcon());
        if ((allThisInLocation!=null) && (allThisInLocation.size() < this.getMaxRepresentatives())) {
            Alive newbie = new Bull(getCurrentPosition());
            Thread thread = new Thread(newbie);
            thread.start();
            System.out.println("New " + this.getIcon() + " was born");
        }
    }
}
