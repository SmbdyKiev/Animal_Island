package LiveObjects;

import Field.Cell;
import LiveObjects.Animal.Herbivore.*;
import LiveObjects.Animal.Predator.*;
import LiveObjects.Plant.Plant;

import java.util.ArrayList;

public class AliveFactory {
    public Alive randomAlive(Cell cell){
        AnimalConstants.AnimalParameters [] aliveArray = AnimalConstants.AnimalParameters.values();
        Alive alive = optionalAlive(aliveArray[AnimalConstants.generator.nextInt(aliveArray.length)], cell);
        return alive;
    }
    public Alive randomPredator(Cell cell){
        ArrayList predators = AnimalConstants.AnimalParameters.predatorList();
        Alive alive = optionalAlive((AnimalConstants.AnimalParameters) predators.get(AnimalConstants.generator.nextInt(predators.size())), cell);
        return alive;
    }

    public Alive randomHerbivore (Cell cell){
        ArrayList  herbivores = AnimalConstants.AnimalParameters.herbivoreList();
        Alive alive = optionalAlive((AnimalConstants.AnimalParameters) herbivores.get(AnimalConstants.generator.nextInt(herbivores.size())), cell);
        System.out.println(alive.getIcon() + "will be created in cell");
        return alive;
    }

    public Alive randomPlant(Cell cell){
        Alive alive = optionalAlive(AnimalConstants.AnimalParameters.PLANT, cell);
        return alive;
    }

    public Alive optionalAlive (AnimalConstants.AnimalParameters animal, Cell cell){
        Alive alive;
        switch (animal){
            case WOLF -> alive = new Wolf(cell);
            case BULL -> alive = new Bull(cell);
            case PLANT -> alive = new Plant(cell);
            case SNAKE -> alive = new Snake(cell);
            case BEAR -> alive = new Bear(cell);
            case FOX -> alive = new Fox(cell);
            case EAGLE -> alive = new Eagle(cell);
            case DEER -> alive = new Deer(cell);
            case RABBIT -> alive = new Rabbit(cell);
            case MOUSE -> alive = new Mouse(cell);
            case GOAT -> alive = new Goat(cell);
            case SHEEP -> alive = new Sheep(cell);
            case HOG -> alive = new Hog(cell);
            case HORSE -> alive = new Horse(cell);
            case DUCK -> alive = new Duck(cell);
            case WORM -> alive = new Worm(cell);
            default -> alive= null;
        }
        Thread thread = new Thread(alive);
        thread.start();
        return alive;
    }
}
