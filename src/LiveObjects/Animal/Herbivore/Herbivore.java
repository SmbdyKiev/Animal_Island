package LiveObjects.Animal.Herbivore;
import Field.Cell;
import LiveObjects.Animal.Animal;
import LiveObjects.AnimalConstants;
import java.util.HashMap;
import java.util.Map;
public abstract class Herbivore extends Animal {
    public Herbivore(Cell currentPosition, String icon) {
        super(currentPosition,icon);
        Map<String,Integer> eatenFood = new HashMap<>();
        eatenFood.put(AnimalConstants.AnimalParameters.PLANT.getIcon(), 100);
        setEatenFoodPercents(eatenFood);
    }
}
