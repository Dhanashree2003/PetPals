package Model;


public class Participant implements IAdoptable {
    private String name;
    private String type; // "shelter" or "adopter"

    public Participant(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public void adopt() {
        if ("adopter".equalsIgnoreCase(type)) {
            System.out.println(name + " has adopted a pet.");
        } else {
            System.out.println(name + " (shelter) is participating in the event.");
        }
    }

    @Override
    public String toString() {
        return "Participant [name=" + name + ", type=" + type + "]";
    }
}
