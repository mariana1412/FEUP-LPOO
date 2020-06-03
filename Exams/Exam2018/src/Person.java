import java.util.Objects;

public abstract class Person extends User implements Comparable{
    private String name;
    private int age;

    public Person(String name) {
        super(name, 0);
        this.name = name;
        this.age = 0;
    }

    public Person(String name, int age) {
        super(name, age);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Object o) {
        return name.compareTo(((Person)o).getName());
    }
}
