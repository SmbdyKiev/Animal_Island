package LiveObjects.Animal.Herbivore;

import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.AnimalConstants;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Sheep extends Herbivore{
    public Sheep(Cell currentPosition) {
        super(currentPosition, AnimalConstants.AnimalParameters.SHEEP.getIcon());
        setWeight(AnimalConstants.AnimalParameters.SHEEP.getWeight());
        setMovementSpeed(AnimalConstants.AnimalParameters.SHEEP.getMovementSpeed());
        setMaxRepresentatives(AnimalConstants.AnimalParameters.SHEEP.getMaxRepresentatives());
        setMinFood(AnimalConstants.AnimalParameters.SHEEP.getMinFood());
        System.out.println("Created " + this.getIcon());
    }

    @Override
    public void reproduce() {
        ConcurrentLinkedDeque allThisInLocation = getCurrentPosition().getRepresentatives().get(this.getIcon());
        if ((allThisInLocation!=null) && (allThisInLocation.size() < this.getMaxRepresentatives())) {
            Alive newbie = new Sheep(getCurrentPosition());
            Thread thread = new Thread(newbie);
            thread.start();
            System.out.println("New " + this.getIcon() + " was born");
        }
    }
}
