package LiveObjects.Animal.Herbivore;

import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.AnimalConstants;

import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Rabbit extends Herbivore{
    public Rabbit(Cell currentPosition) {
        super(currentPosition, AnimalConstants.AnimalParameters.RABBIT.getIcon());
        setWeight(AnimalConstants.AnimalParameters.RABBIT.getWeight());
        setMovementSpeed(AnimalConstants.AnimalParameters.RABBIT.getMovementSpeed());
        setMaxRepresentatives(AnimalConstants.AnimalParameters.RABBIT.getMaxRepresentatives());
        setMinFood(AnimalConstants.AnimalParameters.RABBIT.getMinFood());
        System.out.println("Created " + this.getIcon());
    }

    @Override
    public void reproduce() {
        ConcurrentLinkedDeque allThisInLocation = getCurrentPosition().getRepresentatives().get(this.getIcon());
        if ((allThisInLocation!=null) && (allThisInLocation.size() < this.getMaxRepresentatives())) {
            Alive newbie = new Rabbit(getCurrentPosition());
            Thread thread = new Thread(newbie);
            thread.start();
            System.out.println("New " + this.getIcon() + " was born");
        }
    }
}
