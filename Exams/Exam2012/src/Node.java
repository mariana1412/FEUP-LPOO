import java.util.Objects;

public abstract class Node implements Cloneable {

    private FileSystem fileSystem;
    private Folder parent;
    private String name;
    private static int number = 0;

    public Node(Folder parent, String name) throws DuplicateNameException {
        this.parent = parent;
        this.name = name;
        this.parent.addChild(this);
        this.fileSystem = parent.getFileSystem();
        this.number += 1;
    }

    public Node(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
        this.name = "";
        this.number += 1;
    }

    public static void resetNumbering(int n) {
        number = n;
    }

    public Folder getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public static int getNumber() {
        return number;
    }

    public FileSystem getFileSystem() {
        return fileSystem;
    }

    public abstract int getSize();

    public String getPath() {
        if(parent == null) return "";
        return parent.getPath() + fileSystem.getNameFormatter().getSeparator() + name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return Objects.equals(fileSystem, node.fileSystem) &&
                Objects.equals(parent, node.parent) &&
                Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileSystem, parent, name);
    }

    public void move(Folder newParent, String newName) throws CycleException {

        if(newParent.getParent() == this) throw new CycleException();

        this.parent = newParent;
        this.fileSystem = parent.getFileSystem();
        this.name = newName;
    }
}
