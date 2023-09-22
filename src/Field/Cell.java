package Field;

import LiveObjects.Alive;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Cell {
    @Override
    public String toString() {
        String s="";
        Set<String> keys = representatives.keySet();
        for (String key:keys) {
            if (representatives.get(key).size()>0) s+="{"+representatives.get(key).get(0).getIcon()+": "+representatives.get(key).size()+"}\n";
        }
        return s;
    }

    private volatile ConcurrentHashMap<String, List<Alive>> representatives;
    private List<Cell> neighbors;
    public void addRepresentative(Alive representative){
        if (representatives == null) representatives = new ConcurrentHashMap<>();
        System.out.println("will search in representatives "+representative.getIcon());
        List<Alive> list = representatives.get(representative.getIcon());
        if (list==null) list=new ArrayList<>();
        list.add(representative);
        representatives.put(representative.getIcon(), list);
    }

    public void addNeighbors(Cell cell){
        this.neighbors.add(cell);
    }

    public List<Cell> getNeighbors(){
        return neighbors;
    }

    public void removeRepresentative(Alive representative){
        List <Alive> alive = representatives.get(representative.getIcon());
        if (alive != null) alive.remove(representative);
        representatives.put(representative.getKeyName(),alive);
    }
    public ConcurrentHashMap<String, List<Alive>> getRepresentatives(){return representatives;}
}
