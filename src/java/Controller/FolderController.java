package Controller;

import java.util.HashMap;
import model.MyFolder;

public class FolderController {
 
    private static HashMap<String, MyFolder> allFiles = new HashMap();
    
    public static void addFolder(String name, MyFolder folder){
        allFiles.put(name,folder);
    }
    
     public static MyFolder getFolder(String name){
        return allFiles.get(name);
    }
    
}
