import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Building extends Facility{

    private int minFloor;
    private int maxFloor;
    private Set<Room> rooms;

    public Building(String name, int minFloor, int maxFloor) throws IllegalArgumentException {

        super(name, 0);

        if(minFloor > maxFloor) throw new IllegalArgumentException();

        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.rooms = new HashSet<>();
    }


    public int getMinFloor() {
        return minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }


    public void addRoom(Room room) throws DuplicateRoomException {
        if(!rooms.add(room)) throw new DuplicateRoomException();
        setCapacity(getCapacity() + room.getCapacity());
    }


    @Override
    public String toString() {
        return "Building(" + getName() + ")";
    }


}
