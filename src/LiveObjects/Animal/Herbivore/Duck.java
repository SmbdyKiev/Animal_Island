package LiveObjects.Animal.Herbivore;

import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.AnimalConstants;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Duck extends Herbivore{
    public Duck(Cell currentPosition) {
        super(currentPosition, AnimalConstants.AnimalParameters.DUCK.getIcon());
        setWeight(AnimalConstants.AnimalParameters.DUCK.getWeight());
        setMovementSpeed(AnimalConstants.AnimalParameters.DUCK.getMovementSpeed());
        setMaxRepresentatives(AnimalConstants.AnimalParameters.DUCK.getMaxRepresentatives());
        setMinFood(AnimalConstants.AnimalParameters.DUCK.getMinFood());
        System.out.println("Created " + this.getIcon());

        Map<String,Integer> eatenFood = super.getEatenFoodPercents();
        eatenFood.put(AnimalConstants.AnimalParameters.WORM.getIcon(), 90);
    }

    @Override
    public void reproduce() {
        ConcurrentLinkedDeque allThisInLocation = getCurrentPosition().getRepresentatives().get(this.getIcon());
        if ((allThisInLocation!=null) && (allThisInLocation.size() < this.getMaxRepresentatives())) {
            Alive newbie = new Duck(getCurrentPosition());
            Thread thread = new Thread(newbie);
            thread.start();
            System.out.println("New " + this.getIcon() + " was born");
        }
    }
}
