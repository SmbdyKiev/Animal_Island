package LiveObjects.Animal.Predator;

import Field.Cell;
import LiveObjects.Animal.Animal;

import java.util.Set;

public abstract class Predator extends Animal {

    public Predator(Cell currentPosition) {
        super(currentPosition);
    }
}
