package LiveObjects.Animal;
import Field.Cell;
import Interfaces.Movable;
import LiveObjects.Alive;
import LiveObjects.AnimalConstants;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.random.RandomGenerator;

public abstract class Animal extends Alive implements Movable<Cell> {
    private Map<String, Integer> eatenFoodPercents;
    public Animal(Cell position, String icon) {
        super(position, icon);
    }
    public Map<String, Integer> getEatenFoodPercents() {
        return eatenFoodPercents;
    }
    public void setEatenFoodPercents(Map<String, Integer> eatenFoodPercents) {
        this.eatenFoodPercents = eatenFoodPercents;
    }
    public Cell move() {
        List<Cell> availablePlaces = this.getCurrentPosition().getNeighbors();
        if (availablePlaces == null) {
            System.out.println(this.getIcon() + " stays the same position");
            return this.getCurrentPosition();
        }
        else {
            for (int i = 0; i < getMovementSpeed(); i++) {
                Cell newPosition = availablePlaces.get(AnimalConstants.generator.nextInt(availablePlaces.size()));
                getCurrentPosition().removeRepresentative(this);
                newPosition.addRepresentative(this);
                this.setCurrentPosition(newPosition);
            }
            System.out.println(this.getIcon()+" get new position");
            return getCurrentPosition();
        }
    }
    public Alive findFood() {
        ConcurrentHashMap<String, ConcurrentLinkedDeque<Alive>> allAliveInLocation = getCurrentPosition().getRepresentatives();
        Set<String> menu = getEatenFoodPercents().keySet();
        for (String eatenAlive : menu) {
            ConcurrentLinkedDeque<Alive> currentAlivesToEat = allAliveInLocation.get(eatenAlive);
            if (currentAlivesToEat != null) {
                for (Alive food : currentAlivesToEat) {
                    int chanceToEatSelectedFood = AnimalConstants.generator.nextInt(100);
                    if (chanceToEatSelectedFood < eatenFoodPercents.get(eatenAlive)) {
                        return food;
                    }
                }
            }
        }
        return null;
    }
    public void eat() {
        double eatenFoodWeight = 0.0;
        boolean thereIsFood = true;
        while ((this.isAlive()) && (eatenFoodWeight < this.getMinFood()) && thereIsFood) {
            Alive food = findFood();
            if (food != null) {
                eatenFoodWeight += food.getWeight();
                System.out.println(this.getIcon() + " just have eat " + food.getIcon()+" and it is "+ eatenFoodWeight+" from "+getMinFood());
                food.die();
            } else {
                thereIsFood = false;
                System.out.println("no any food was found for " + this.getIcon());
            }
        }
        if (eatenFoodWeight < this.getMinFood()) {
            this.die();
        }
        else {
            System.out.println(this.getIcon() + " not hungry anymore");
        }
    }
    @Override
    public void run() {
        while (this.isAlive()) {
            eat();
            if (this.isAlive()) {move();}
            if (this.isAlive()) {reproduce();}
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("was interrupted");
            }
        }
    }
}
