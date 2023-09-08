package LiveObjects.Animal;

import Field.Cell;
import Interfaces.Movable;
import LiveObjects.Alive;

import java.util.List;
import java.util.Map;
import java.util.Random;



public abstract class Animal extends Alive implements Movable <Cell>, Runnable{
    private Map<Alive,Integer> eatenFoodPercents;

    public Map<Alive, Integer> getEatenFoodPercents() {
        return eatenFoodPercents;
    }

    public void setEatenFoodPercents(Map<Alive, Integer> eatenFoodPercents) {
        this.eatenFoodPercents = eatenFoodPercents;
    }



    public Animal (Cell position) {
        super(position);
    }

    public Cell move(List<Cell> availablePlaces) {
        if (availablePlaces == null) return this.getCurrentPosition();
        else {
            Random random =new Random();
            for (int i=0;i<getMovementSpeed();i++){
                getCurrentPosition().removeRepresentative(this);
                setCurrentPosition(availablePlaces.get(random.nextInt(availablePlaces.size())));
            }
            return getCurrentPosition();
        }
    }

    public void eat(Alive food) {

        food.die();
    }

}
