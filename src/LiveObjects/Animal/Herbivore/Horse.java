package LiveObjects.Animal.Herbivore;

import Field.Cell;

public class Horse extends Herbivore{
    {

    }
    public Horse(Cell currentPosition) {
        super(currentPosition);

    }

    @Override
    public void run() {

    }

    @Override
    public Horse reproduce() {
        Horse child = new Horse(getCurrentPosition());
        getCurrentPosition().addRepresentative(child);
        return child;
    }
}
