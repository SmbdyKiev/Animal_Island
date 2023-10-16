package LiveObjects.Animal.Herbivore;

import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.AnimalConstants;

import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Mouse extends Herbivore{
    public Mouse(Cell currentPosition) {
        super(currentPosition, AnimalConstants.AnimalParameters.MOUSE.getIcon());
        setWeight(AnimalConstants.AnimalParameters.MOUSE.getWeight());
        setMovementSpeed(AnimalConstants.AnimalParameters.MOUSE.getMovementSpeed());
        setMaxRepresentatives(AnimalConstants.AnimalParameters.MOUSE.getMaxRepresentatives());
        setMinFood(AnimalConstants.AnimalParameters.MOUSE.getMinFood());
        System.out.println("Created " + this.getIcon());

        Map<String,Integer> eatenFood = super.getEatenFoodPercents();
        eatenFood.put(AnimalConstants.AnimalParameters.WORM.getIcon(), 90);
    }

    @Override
    public void reproduce() {
        ConcurrentLinkedDeque allThisInLocation = getCurrentPosition().getRepresentatives().get(this.getIcon());
        if ((allThisInLocation!=null) && (allThisInLocation.size() < this.getMaxRepresentatives())) {
            Alive newbie = new Mouse(getCurrentPosition());
            Thread thread = new Thread(newbie);
            thread.start();
            System.out.println("New " + this.getIcon() + " was born");
        }
    }
}
