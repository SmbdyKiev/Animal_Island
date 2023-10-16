package LiveObjects.Animal.Predator;

import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.AnimalConstants;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Eagle extends Predator{
    public Eagle(Cell currentPosition) {
        super(currentPosition, AnimalConstants.AnimalParameters.EAGLE.getIcon());
        setWeight(AnimalConstants.AnimalParameters.EAGLE.getWeight());
        setMovementSpeed(AnimalConstants.AnimalParameters.EAGLE.getMovementSpeed());
        setMaxRepresentatives(AnimalConstants.AnimalParameters.EAGLE.getMaxRepresentatives());
        setMinFood(AnimalConstants.AnimalParameters.EAGLE.getMinFood());
        System.out.println("Created " + this.getIcon());

        Map<String,Integer> eatenFood = new HashMap<>();
        eatenFood.put(AnimalConstants.AnimalParameters.FOX.getIcon(), 10);
        eatenFood.put(AnimalConstants.AnimalParameters.RABBIT.getIcon(), 90);
        eatenFood.put(AnimalConstants.AnimalParameters.MOUSE.getIcon(), 90);
        eatenFood.put(AnimalConstants.AnimalParameters.DUCK.getIcon(), 80);
        setEatenFoodPercents(eatenFood);
    }
    @Override
    public void reproduce() {
        ConcurrentLinkedDeque allThisInLocation = getCurrentPosition().getRepresentatives().get(this.getIcon());
        if ((allThisInLocation!=null) && (allThisInLocation.size() < this.getMaxRepresentatives())) {
            Alive newbie = new Eagle(getCurrentPosition());
            Thread thread = new Thread(newbie);
            thread.start();
            System.out.println("New " + this.getIcon() + " was born");
        }
    }
}
