package challenges.year2022.day7;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private Folder parent;
    private List<Folder> subfolders = new ArrayList<>();
    private List<AoCFile> files = new ArrayList<>();
    private String name;

    public Folder(String name, Folder parent) {
        this.name = name;
        this.parent = parent;
    }

    public void createSubfolder(String name) {
        subfolders.add(new Folder(name, this));
    }

    public void createFile(String name, int size) {
        files.add(new AoCFile(name, size));
    }

    public Folder getParent() {
        if (parent != null) {
            return parent;
        }
        return this;
    }

    public Folder getRoot() {
        return rootSearch(this);
    }

    private Folder rootSearch(Folder current) {
        if (current.parent == null) {
            return current;
        }

        return rootSearch(current.getParent());
    }

    public Folder getSubfolder(String name) {
        return subfolders.stream().filter(i -> i.name.equals(name)).findFirst().orElseThrow();
    }

    public int getSize() {
        int totalSize = 0;

        for(AoCFile file : files){
            totalSize += file.size();
        }

        for(Folder subfolder : subfolders){
            totalSize += subfolder.getSize();
        }

        return totalSize;
    }

    public List<Folder> getAllSubfolders(){
        return subfolders;
    }
}
