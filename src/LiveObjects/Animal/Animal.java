package LiveObjects.Animal;

import Field.Cell;
import Interfaces.Movable;
import LiveObjects.Alive;
import LiveObjects.Animal.Predator.Wolf;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.random.RandomGenerator;


public abstract class Animal extends Alive implements Movable <Cell>{
    private Map<String,Integer> eatenFoodPercents;

    public Map<String, Integer> getEatenFoodPercents() {
        return eatenFoodPercents;
    }

    public void setEatenFoodPercents(Map<String, Integer> eatenFoodPercents) {
        this.eatenFoodPercents = eatenFoodPercents;
    }



    public Animal (Cell position, String icon) {
        super(position,icon);
    }

    public Cell move(List<Cell> availablePlaces) {
        if (availablePlaces == null) return this.getCurrentPosition();
        else {
            Random random =new Random();
            for (int i=0;i<getMovementSpeed();i++){
                getCurrentPosition().removeRepresentative(this);
                setCurrentPosition(availablePlaces.get(random.nextInt(availablePlaces.size())));
            }
            return getCurrentPosition();
        }
    }

    public Alive findFood(){
        ConcurrentHashMap<String,List<Alive>> allAlivesInLocation =getCurrentPosition().getRepresentatives();
        Set <String> menu=getEatenFoodPercents().keySet();
        for (String s:menu) {
            List <Alive> list = allAlivesInLocation.get(s);
            if (RandomGenerator.getDefault().nextInt(100)<eatenFoodPercents.get(s))
            return list.get(list.size()-1);

        }

        return null;
    }
    public void eat() {
        double eatenFoodWeight=0.0;
        boolean thereIsFood=true;
        while (eatenFoodWeight<this.getMinFood()&&thereIsFood){
            Alive food=findFood();
            if (food!=null){
                eatenFoodWeight+=food.getWeight();
                System.out.println(this.getIcon()+ " just have eat "+ food.getIcon());
                food.die();
            }
            else {
                thereIsFood=false;
            }
        }
        if (eatenFoodWeight<this.getMinFood()) this.die();
        else System.out.println(this.getIcon()+" Not hangry anymore");
    }
    @Override
    public void run() {
        while (isAlive()){
            eat();
            //move();
            reproduce();
        }

    }

}
