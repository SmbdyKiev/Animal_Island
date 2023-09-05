package LiveObjects.Plant;

import LiveObjects.Alive;
import LiveObjects.Animal.Animal;

public class Plant extends Alive {

    public Plant(){
    }

    @Override
    public Plant reproduce() {
        return new Plant();
    }
}
