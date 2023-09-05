package LiveObjects.Animal;

import Field.Cell;
import Interfaces.Movable;
import LiveObjects.Alive;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.random.RandomGenerator;

public abstract class Animal extends Alive implements Movable <Cell>, Runnable{
    private Map<Alive,Integer> eatenFoodPercents;
    private Cell currentPosition;

    public Map<Alive, Integer> getEatenFoodPercents() {
        return eatenFoodPercents;
    }

    public void setEatenFoodPercents(Map<Alive, Integer> eatenFoodPercents) {
        this.eatenFoodPercents = eatenFoodPercents;
    }

    public Cell getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Cell currentPosition) {
        this.currentPosition = currentPosition;
        currentPosition.addRepresentative(this);
    }

    public Animal (Cell currentPosition) {
        this.currentPosition = currentPosition;
        currentPosition.addRepresentative(this);
    }

    @Override
    public Cell move(Set<Cell> availablePlaces) {
        if (availablePlaces == null) return currentPosition;
        else {
            Random random =new Random();
            Cell[] array = (Cell[]) availablePlaces.toArray();
            currentPosition.removeRepresentative(this);
            currentPosition = array[random.nextInt(availablePlaces.size())];
            currentPosition.addRepresentative(this);
            return currentPosition;
        }
    }

    public void eat(Alive food) {
        food.die();
    }

}
