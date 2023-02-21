package FileOperationUtils;
import java.io.File;
public class DeleteFile {
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
