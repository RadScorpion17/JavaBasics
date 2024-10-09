package ZooHomework;

import java.util.HashSet;

public class Zoo {
    public String name;
    HashSet<ZooAreas> areas = new HashSet<>();

    public Zoo(String name) {
        this.name = name;
    }

    public void addArea(ZooAreas area){
        areas.add(area);
    }
}
