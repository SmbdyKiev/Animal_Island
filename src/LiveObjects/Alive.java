package LiveObjects;
import Field.Cell;
import Interfaces.Reproduceble;
import LiveObjects.Animal.Predator.Wolf;

import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentLinkedDeque;

public abstract class Alive implements Reproduceble, Runnable {
    private boolean alive =true;
    private double weight;
    private int movementSpeed;
    private int maxRepresentatives;
    private double minFood;
    private Cell currentPosition;
    private String icon;

    public Alive(Cell position, String icon){
        this.currentPosition = position;
        this.icon = icon;
        position.addRepresentative(this);
    }
    public void setCurrentPosition (Cell position){
        this.currentPosition=position;
    }
    public Cell getCurrentPosition(){
        return currentPosition;
    }
    public double getWeight() {
        return weight;
    }
    public int getMovementSpeed() {
        return movementSpeed;
    }
    public int getMaxRepresentatives() {
        return maxRepresentatives;
    }
    public double getMinFood() {
        return minFood;
    }
    public String getIcon(){
        return icon;
    }
    public void setIcon (String icon){
        this.icon=icon;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }
    public void setMaxRepresentatives(int maxRepresentatives) {
        this.maxRepresentatives = maxRepresentatives;
    }
    public void setMinFood(double minFood) {
        this.minFood = minFood;
    }
    public void die() {
        currentPosition.removeRepresentative(this);
        alive = false;
    }
    public boolean isAlive() {return alive;}

}
