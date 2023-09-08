package Field;

import LiveObjects.Alive;

import java.util.*;

public class Cell {
    @Override
    public String toString() {
        String s="";
        Set<String> keys = representatives.keySet();
        for (String key:keys) {
            s+="{"+key+": "+representatives.get(key).size()+"}\n";
        }
        return s;
    }

    private Map<String, List<Alive>> representatives;
    private List<Cell> neighbors;
    public void addRepresentative(Alive representative){
        if (representatives == null) representatives = new HashMap<>();
        List<Alive> list = representatives.get(representative.getKeyName());
        if (list==null) list=new ArrayList<>();
        list.add(representative);
        representatives.put(representative.getKeyName(), list);
    }

    public void addNeighbors(Cell cell){
        this.neighbors.add(cell);
    }

    public List<Cell> getNeighbors(){
        return neighbors;
    }

    public void removeRepresentative(Alive representative){
        List <Alive> alive = representatives.get(representative.getKeyName());
        if (alive != null) alive.remove(representative);
        representatives.put(representative.getKeyName(),alive);
    }
    public Map<String, List<Alive>> getRepresentatives(){return representatives;}
}
