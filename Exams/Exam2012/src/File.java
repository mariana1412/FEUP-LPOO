import java.util.Objects;

public class File extends Node {

    private int size;

    public File(Folder parent, String name) throws DuplicateNameException {
        super(parent, name);
        this.size = 0;
    }

    public File(Folder parent, String name, int size) throws DuplicateNameException {
        super(parent, name);
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof File)) return false;
        if (!super.equals(o)) return false;
        File file = (File) o;
        return size == file.size;
    }

}
