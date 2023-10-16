package LiveObjects.Animal.Predator;
import Field.Cell;
import LiveObjects.Animal.Animal;


public abstract class Predator extends Animal {
    public Predator(Cell currentPosition, String icon) {
        super(currentPosition,icon);
    }
}
