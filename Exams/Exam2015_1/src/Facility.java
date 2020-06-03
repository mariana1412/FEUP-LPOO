import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Facility {

    private String name;
    private int capacity;
    private Set<User> users;

    public Facility(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.users = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void authorize(User user){
        users.add(user);
    }

    public boolean canEnter(User user){
        return users.contains(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Facility)) return false;
        Facility facility = (Facility) o;
        return Objects.equals(name, facility.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
