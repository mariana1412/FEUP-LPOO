import java.util.ArrayList;
import java.util.Objects;

public class Folder extends Node{
    private ArrayList<Node> child;

    public Folder(Folder parent, String name) throws DuplicateNameException {
        super(parent, name);
        this.child = new ArrayList<>();
    }

    public Folder(FileSystem fileSystem) {
        super(fileSystem);
        this.child = new ArrayList<>();
    }

    @Override
    public int getSize() {
        int size = 0;
        for(Node node : child) size += node.getSize();
        return size;
    }

    public void addChild(Node node) throws DuplicateNameException {
        if(getChildByName(node.getName()) != null) throw new DuplicateNameException();
        this.child.add(node);
    }

    public Node[] getChild() {
        return child.toArray(new Node[0]);
    }

    public Node getChildByName(String name) {
        for(Node node : child){
            if(name == node.getName()) return node;
        }
        return null;
    }


    public Folder clone(Folder parent, String name) throws CloneNotSupportedException, DuplicateNameException {
        Folder folder = new Folder(parent, name);

        for(Node node : child){
            Node cloneNode;
            if(node instanceof File) cloneNode = (Node)node.clone();
            else cloneNode = ((Folder)node).clone(folder, node.getName());
            try {
                folder.addChild(cloneNode);
            } catch (DuplicateNameException e) {

            }
        }

        return folder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Folder)) return false;
        if (!super.equals(o)) return false;
        Folder folder = (Folder) o;
        return Objects.equals(child, folder.child);
    }

}
