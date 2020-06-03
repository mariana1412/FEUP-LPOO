import java.util.Objects;

public class Room extends Facility{

    private final Building building;
    private final int floor;
    private final String number;

    public Room(Building building, String number, int floor) throws IllegalArgumentException, DuplicateRoomException {

        super(building.getName() + number, 0);

        if(building.getMaxFloor() < floor || (building.getMinFloor() > floor))
            throw new IllegalArgumentException();

        this.building = building;
        this.floor = floor;
        this.number = number;

        this.building.addRoom(this);
    }

    public Room(Building building, String number, int floor, int capacity) throws IllegalArgumentException, DuplicateRoomException {

        super(building.getName() + number, capacity);

        if(building.getMaxFloor() < floor || (building.getMinFloor() > floor))
            throw new IllegalArgumentException();

        this.building = building;
        this.floor = floor;
        this.number = number;

        this.building.addRoom(this);
    }

    public Building getBuilding() {
        return building;
    }

    public int getFloor() {
        return floor;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public void authorize(User user){
        super.authorize(user);
        this.building.authorize(user);
    }

    @Override
    public String toString() {
        return "Room(" + building.getName() + "," + number + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return floor == room.floor &&
                Objects.equals(building, room.building) &&
                Objects.equals(number, room.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(building, floor, number);
    }
}
