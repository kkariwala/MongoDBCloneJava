package FileOperationUtils;
// Importing File class
import java.io.File;
public class MakeFolder {
    /**
     * This method creates a folder with the name in the given path
     *
     * @param filePathName Absolute path of the folder excluding the name
     * @param databaseName name of the folder to be deleted
     * @return void
     */
    public static void makeFolder(String filePathName,String databaseName){
        try {
            // Creating an object of a file
            filePathName = filePathName + databaseName;
            File f0 = new File(filePathName);
            if (f0.mkdir()) {
                System.out.println("Database directory with name " + databaseName + " is created successfully at path " + f0.getName());
            } else {
                System.out.println("Database already exists in the directory.");
            }
        } catch (SecurityException exception) {
            System.out.println("An unexpected error is occurred.");
            exception.printStackTrace();
        }
    }
}