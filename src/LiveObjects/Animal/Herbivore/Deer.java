package LiveObjects.Animal.Herbivore;

import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.AnimalConstants;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Deer extends Herbivore{
    public Deer(Cell currentPosition) {
        super(currentPosition, AnimalConstants.AnimalParameters.DEER.getIcon());
        setWeight(AnimalConstants.AnimalParameters.DEER.getWeight());
        setMovementSpeed(AnimalConstants.AnimalParameters.DEER.getMovementSpeed());
        setMaxRepresentatives(AnimalConstants.AnimalParameters.DEER.getMaxRepresentatives());
        setMinFood(AnimalConstants.AnimalParameters.DEER.getMinFood());
        System.out.println("Created " + this.getIcon());
    }

    @Override
    public void reproduce() {
        ConcurrentLinkedDeque allThisInLocation = getCurrentPosition().getRepresentatives().get(this.getIcon());
        if ((allThisInLocation!=null) && (allThisInLocation.size() < this.getMaxRepresentatives())) {
            Alive newbie = new Deer(getCurrentPosition());
            Thread thread = new Thread(newbie);
            thread.start();
            System.out.println("New " + this.getIcon() + " was born");
        }
    }
}
