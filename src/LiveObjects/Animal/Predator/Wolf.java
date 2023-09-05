package LiveObjects.Animal.Predator;

import Field.Cell;

public class Wolf extends Predator{
    public Wolf(Cell currentPosition) {
        super(currentPosition);
    }

    @Override
    public void run() {

    }

    @Override
    public Wolf reproduce() {
        Wolf child = new Wolf(getCurrentPosition());
        getCurrentPosition().addRepresentative(child);
        return child;
    }
}
