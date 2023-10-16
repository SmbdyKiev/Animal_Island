package Field;
import LiveObjects.Alive;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Cell {
    private volatile ConcurrentHashMap<String, ConcurrentLinkedDeque<Alive>> representatives;
    private List<Cell> neighbors;
    public void addNeighbors(Cell cell){
        if (this.neighbors==null) {neighbors=new ArrayList<Cell>();}
        this.neighbors.add(cell);
    }
    public List<Cell> getNeighbors(){
        return neighbors;
    }
    public void addRepresentative(Alive representative){
        if (representatives == null) {representatives = new ConcurrentHashMap<>();}
        ConcurrentLinkedDeque<Alive> list = representatives.get(representative.getIcon());
        if (list == null) {list = new ConcurrentLinkedDeque<>();}
        list.add(representative);
        representatives.put(representative.getIcon(), list);
    }
    public void removeRepresentative(Alive representative){
        if (representative != null) {
            String icon = representative.getIcon();
            if (representatives != null) {
                ConcurrentLinkedDeque<Alive> alive = representatives.get(icon);
            if ((alive != null) && alive.contains(representative)) {
                alive.remove(representative);
                if (!alive.isEmpty()) {representatives.put(icon, alive);}
                else representatives.remove(icon);
            }
            }
        }
    }
    public ConcurrentHashMap<String, ConcurrentLinkedDeque<Alive>> getRepresentatives(){return representatives;}
    @Override
    public String toString() {
        if (representatives.isEmpty()) {return "empty cell";}
        String resultString = "";
        Set<String> keys = representatives.keySet();
        for (String key:keys) {
            if (representatives.get(key).size() > 0) {
                resultString += "{" + representatives.get(key).peek().getIcon() + ": " + representatives.get(key).size()+"}\n";
            }
        }
        return resultString;
    }

    public Map<String, Integer> getPivot(){
        Map<String,Integer> resultPivot = new HashMap<>();
        Set<String> keys = representatives.keySet();
        for (String key:keys) {
            if (!representatives.get(key).isEmpty()) {
                resultPivot.put(key,representatives.get(key).size());
            }
        }
        return resultPivot;
    }
}
