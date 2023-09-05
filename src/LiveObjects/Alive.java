package LiveObjects;

import Interfaces.Reproduceble;

public abstract class Alive implements Reproduceble {
    private boolean alive =true;
    private String keyName = this.getClass().getName();

    private int weight;
    private int movementSpeed;
    private int maxRepresentatives;
    private int minFood;

    public int getWeight() {
        return weight;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public int getMaxRepresentatives() {
        return maxRepresentatives;
    }

    public int getMinFood() {
        return minFood;
    }


    public void die(){

        alive =false;

    }

    public boolean isAlive(){return alive;}
    public String getKeyName(){return keyName;}
}
