package LiveObjects.Animal.Herbivore;

import Field.Cell;
import LiveObjects.Alive;
import LiveObjects.AnimalConstants;

import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Hog extends Herbivore{
    public Hog(Cell currentPosition) {
        super(currentPosition, AnimalConstants.AnimalParameters.HOG.getIcon());
        setWeight(AnimalConstants.AnimalParameters.HOG.getWeight());
        setMovementSpeed(AnimalConstants.AnimalParameters.HOG.getMovementSpeed());
        setMaxRepresentatives(AnimalConstants.AnimalParameters.HOG.getMaxRepresentatives());
        setMinFood(AnimalConstants.AnimalParameters.HOG.getMinFood());
        System.out.println("Created " + this.getIcon());

        Map<String,Integer> eatenFood = super.getEatenFoodPercents();
        eatenFood.put(AnimalConstants.AnimalParameters.WORM.getIcon(), 90);
        eatenFood.put(AnimalConstants.AnimalParameters.MOUSE.getIcon(), 50);
    }

    @Override
    public void reproduce() {
        ConcurrentLinkedDeque allThisInLocation = getCurrentPosition().getRepresentatives().get(this.getIcon());
        if ((allThisInLocation!=null) && (allThisInLocation.size() < this.getMaxRepresentatives())) {
            Alive newbie = new Hog(getCurrentPosition());
            Thread thread = new Thread(newbie);
            thread.start();
            System.out.println("New " + this.getIcon() + " was born");
        }
    }
}
