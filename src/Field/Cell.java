package Field;

import LiveObjects.Alive;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    private Map<String, Set<Alive>> representatives;
    public void addRepresentative(Alive representative){
        if (representatives == null) representatives = new HashMap<>();
        Set set = representatives.get(representative.getKeyName());
        if (set==null) set=new HashSet<>();
        set.add(representative);
        representatives.put(representative.getKeyName(), set);
    }

    public Set<Cell> getNeiborhods(Field field){
        return new HashSet<>();//todo return near cells
    }

    public void removeRepresentative(Alive representative){
        Set <Alive> alive = representatives.get(representative.getKeyName());
        if (alive != null) alive.remove(representative);
        representatives.put(representative.getKeyName(),alive);
    }
    public Map<String, Set<Alive>> getRepresentatives(){return representatives;}
}
