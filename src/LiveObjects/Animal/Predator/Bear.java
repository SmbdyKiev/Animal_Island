package LiveObjects.Animal.Predator;

import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.Animal.Herbivore.Worm;
import LiveObjects.AnimalConstants;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Bear extends Predator{
    public Bear(Cell currentPosition) {
        super(currentPosition, AnimalConstants.AnimalParameters.BEAR.getIcon());
        setWeight(AnimalConstants.AnimalParameters.BEAR.getWeight());
        setMovementSpeed(AnimalConstants.AnimalParameters.BEAR.getMovementSpeed());
        setMaxRepresentatives(AnimalConstants.AnimalParameters.BEAR.getMaxRepresentatives());
        setMinFood(AnimalConstants.AnimalParameters.BEAR.getMinFood());
        System.out.println("Created " + this.getIcon());

        Map<String,Integer> eatenFood = new HashMap<>();
        eatenFood.put(AnimalConstants.AnimalParameters.SNAKE.getIcon(), 80);
        eatenFood.put(AnimalConstants.AnimalParameters.HORSE.getIcon(), 40);
        eatenFood.put(AnimalConstants.AnimalParameters.DEER.getIcon(), 80);
        eatenFood.put(AnimalConstants.AnimalParameters.MOUSE.getIcon(), 90);
        eatenFood.put(AnimalConstants.AnimalParameters.RABBIT.getIcon(), 80);
        eatenFood.put(AnimalConstants.AnimalParameters.SHEEP.getIcon(), 70);
        eatenFood.put(AnimalConstants.AnimalParameters.GOAT.getIcon(), 70);
        eatenFood.put(AnimalConstants.AnimalParameters.BULL.getIcon(), 20);
        eatenFood.put(AnimalConstants.AnimalParameters.HOG.getIcon(), 50);
        eatenFood.put(AnimalConstants.AnimalParameters.DUCK.getIcon(), 10);
        setEatenFoodPercents(eatenFood);

    }
    @Override
    public void reproduce() {
        ConcurrentLinkedDeque allThisInLocation = getCurrentPosition().getRepresentatives().get(this.getIcon());
        if ((allThisInLocation!=null) && (allThisInLocation.size() < this.getMaxRepresentatives())) {
            Alive newbie = new Bear(getCurrentPosition());
            Thread thread = new Thread(newbie);
            thread.start();
            System.out.println("New " + this.getIcon() + " was born");
        }
    }
}
