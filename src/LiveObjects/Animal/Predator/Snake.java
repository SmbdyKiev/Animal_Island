package LiveObjects.Animal.Predator;

import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.AnimalConstants;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Snake extends Predator{
    public Snake(Cell currentPosition) {
        super(currentPosition, AnimalConstants.AnimalParameters.SNAKE.getIcon());
        setWeight(AnimalConstants.AnimalParameters.SNAKE.getWeight());
        setMovementSpeed(AnimalConstants.AnimalParameters.SNAKE.getMovementSpeed());
        setMaxRepresentatives(AnimalConstants.AnimalParameters.SNAKE.getMaxRepresentatives());
        setMinFood(AnimalConstants.AnimalParameters.SNAKE.getMinFood());
        System.out.println("Created " + this.getIcon());

        Map<String,Integer> eatenFood = new HashMap<>();
        eatenFood.put(AnimalConstants.AnimalParameters.FOX.getIcon(), 15);
        eatenFood.put(AnimalConstants.AnimalParameters.RABBIT.getIcon(), 20);
        eatenFood.put(AnimalConstants.AnimalParameters.MOUSE.getIcon(), 40);
        eatenFood.put(AnimalConstants.AnimalParameters.DUCK.getIcon(), 10);
        setEatenFoodPercents(eatenFood);

    }
    @Override
    public void reproduce() {
        ConcurrentLinkedDeque allThisInLocation = getCurrentPosition().getRepresentatives().get(this.getIcon());
        if ((allThisInLocation!=null) && (allThisInLocation.size() < this.getMaxRepresentatives())) {
            Alive newbie = new Snake(getCurrentPosition());
            Thread thread = new Thread(newbie);
            thread.start();
            System.out.println("New " + this.getIcon() + " was born");
        }
    }
}
