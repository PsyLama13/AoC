package challenges.year2022.day7;

import java.util.ArrayList;
import java.util.List;

public class AoCFileSystem {
    Folder root = new Folder("root", null);
    List<Folder> folderList = new ArrayList<>();

    public AoCFileSystem(List<String> input) {
        Folder current = root;
        for (String string : input) {
            current = handleCommand(string, current);
        }
        fillFolderList();
    }

    private void fillFolderList() {
        folderList.add(root);
        fillRecursively(root);
    }

    private void fillRecursively(Folder root) {
        for(Folder subfolder : root.getAllSubfolders()){
            folderList.add(subfolder);
            fillRecursively(subfolder);
        }
    }

    private Folder handleCommand(String string, Folder current) {
        CommandType commandType = getCommandType(string);
        String[] split = string.split(" ");
        switch (commandType) {
            case CD -> {
                String moveTo = split[2];
                switch (moveTo) {
                    case ".." -> current = current.getParent();
                    case "/" -> current = current.getRoot();
                    default -> current = current.getSubfolder(moveTo);
                }
            }
            case DIR -> {
                String folderName = split[1];
                current.createSubfolder(folderName);
            }
            case NEW_FILE -> {
                String name = split[1];
                int size = Integer.parseInt(split[0]);
                current.createFile(name, size);
            }
            case LS -> {
            }
        }
        return current;
    }

    private CommandType getCommandType(String string) {
        String[] split = string.split(" ");

        if (split[1].equals("cd")) {
            return CommandType.CD;
        }

        if (split[1].equals("ls")) {
            return CommandType.LS;
        }

        if (split[0].equals("dir")) {
            return CommandType.DIR;
        }

        try {
            int num = Integer.parseInt(split[0]);
            return CommandType.NEW_FILE;
        } catch (NumberFormatException e) {

        }

        throw new IllegalStateException();
    }

    public Integer calc1() {
        int count = 0;
        for(Folder folder : folderList){
            if(folder.getSize() < 100000){
                count += folder.getSize();
            }
        }
        return count;
    }
}
