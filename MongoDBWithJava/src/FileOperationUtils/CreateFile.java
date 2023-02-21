package FileOperationUtils;
// Importing File class
import MongoUtils.JSONObjectSelf;

import java.io.File;
// Importing the IOException class for handling errors
import java.io.IOException;
public class CreateFile {
    /**
     * This method creates a file
     *
     * @param filePathName Absolute path of the JSON file including the name
     * @return void
     */
    public static void createFile(String filePathName){
        try {
            // Creating an object of a file
            File f0 = new File(filePathName);
            if (f0.createNewFile()) {
                System.out.println("File " + f0.getName() + " is created successfully.");
            } else {
                System.out.println("File is already exist in the directory.");
            }
        } catch (IOException exception) {
            System.out.println("An unexpected error is occurred.");
            exception.printStackTrace();
        }
    }
}