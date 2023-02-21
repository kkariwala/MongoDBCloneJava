package FileOperationUtils;
import MongoUtils.JSONObjectSelf;

import java.io.File;
public class DeleteFile {
    /**
     * This method deletes a file from the file Path
     *
     * @param filePath Absolute path of the JSON file excluding the name
     * @param fileName name of the file to be deleted
     * @return void
     */
    public static void deleteFile(String filePath,String fileName){
        try {
            // Creating an object of a file
            filePath += fileName;
            File f0 = new File(filePath);
            if (f0.delete()) {
                System.out.println("File" + fileName + " deleted successfully");
            }
            else {
                System.out.println("Failed to delete the file " + fileName);
            }
        }  catch (SecurityException exception) {
            System.out.println("An unexpected error is occurred.");
            exception.printStackTrace();
        }
    }
}
