package LiveObjects.Plant;

import Field.Cell;
import LiveObjects.Alive;

public class Plant extends Alive {

    public Plant(Cell position){
        super(position);
    }

    @Override
    public Plant reproduce() {
        return new Plant(this.getCurrentPosition());
    }
}
