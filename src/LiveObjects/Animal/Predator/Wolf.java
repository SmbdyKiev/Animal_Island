package LiveObjects.Animal.Predator;

import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.AnimalConstants;

import java.util.HashMap;
import java.util.Map;

public class Wolf extends Predator{
    public Wolf(Cell currentPosition) {
        super(currentPosition,AnimalConstants.AnimalParameters.WOLF.getIcon());
        setWeight(AnimalConstants.AnimalParameters.WOLF.getWeight());
        setMovementSpeed(AnimalConstants.AnimalParameters.WOLF.getMovementSpeed());
        setMaxRepresentatives(AnimalConstants.AnimalParameters.WOLF.getMaxRepresentatives());
        setMinFood(AnimalConstants.AnimalParameters.WOLF.getMinFood());
        System.out.println("Created "+this.getIcon());

        Map<String,Integer> eatenFood = new HashMap<>();
        eatenFood.put(AnimalConstants.AnimalParameters.HORSE.getIcon(), 10);
        eatenFood.put(AnimalConstants.AnimalParameters.DEER.getIcon(), 15);
        eatenFood.put(AnimalConstants.AnimalParameters.RABBIT.getIcon(), 60);
        eatenFood.put(AnimalConstants.AnimalParameters.MOUSE.getIcon(), 80);
        eatenFood.put(AnimalConstants.AnimalParameters.GOAT.getIcon(), 60);
        eatenFood.put(AnimalConstants.AnimalParameters.SHEEP.getIcon(), 70);
        eatenFood.put(AnimalConstants.AnimalParameters.HOG.getIcon(), 15);
        eatenFood.put(AnimalConstants.AnimalParameters.BULL.getIcon(), 10);
        eatenFood.put(AnimalConstants.AnimalParameters.DUCK.getIcon(), 40);
        setEatenFoodPercents(eatenFood);

    }



    @Override
    public void reproduce() {
        if (getCurrentPosition().getRepresentatives().get(this.getIcon()).size() < this.getMaxRepresentatives()){
            Alive wolf = new Wolf(getCurrentPosition());
            Thread thread = new Thread(wolf);
            thread.start();
        }

    }
}
