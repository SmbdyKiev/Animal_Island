package LiveObjects.Animal.Predator;

import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.AnimalConstants;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Fox extends Predator{
    public Fox(Cell currentPosition) {
        super(currentPosition, AnimalConstants.AnimalParameters.FOX.getIcon());
        setWeight(AnimalConstants.AnimalParameters.FOX.getWeight());
        setMovementSpeed(AnimalConstants.AnimalParameters.FOX.getMovementSpeed());
        setMaxRepresentatives(AnimalConstants.AnimalParameters.FOX.getMaxRepresentatives());
        setMinFood(AnimalConstants.AnimalParameters.FOX.getMinFood());
        System.out.println("Created " + this.getIcon());

        Map<String,Integer> eatenFood = new HashMap<>();
        eatenFood.put(AnimalConstants.AnimalParameters.RABBIT.getIcon(), 70);
        eatenFood.put(AnimalConstants.AnimalParameters.MOUSE.getIcon(), 90);
        eatenFood.put(AnimalConstants.AnimalParameters.DUCK.getIcon(), 60);
        eatenFood.put(AnimalConstants.AnimalParameters.WORM.getIcon(), 40);
        setEatenFoodPercents(eatenFood);

    }
    @Override
    public void reproduce() {
        ConcurrentLinkedDeque allThisInLocation = getCurrentPosition().getRepresentatives().get(this.getIcon());
        if ((allThisInLocation!=null) && (allThisInLocation.size() < this.getMaxRepresentatives())) {
            Alive newbie = new Fox(getCurrentPosition());
            Thread thread = new Thread(newbie);
            thread.start();
            System.out.println("New " + this.getIcon() + " was born");
        }
    }
}
