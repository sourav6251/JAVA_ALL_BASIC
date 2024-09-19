import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class File_Handling {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {  // Use while(true) for a loop that continues indefinitely until a break condition
            System.out.print("Enter file name: ");
            String fileName = scan.nextLine();
            File file = new File(fileName);

            if (file.exists()) {
                System.out.println("""
                        File exists. What method do you want to perform: 
                        1. Read
                        2. Add data
                        3. Delete file
                        4. Path of the file
                        5. Size of the file
                        6. Create a directory (folder):
                        """);

                int choice = scan.nextInt();
                scan.nextLine();  // Consume the newline

                switch (choice) {
                    case 1: { // Read data
                        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            System.out.println("An error occurred while reading the file.");
                            e.printStackTrace();
                        }
                        break;
                    }

                    case 2: { // Add data
                        System.out.println("Enter data to add: ");
                        String data = scan.nextLine();
                        try (FileWriter fw = new FileWriter(file, true)) {
                            fw.write(data + System.lineSeparator());
                            System.out.println("Data added successfully.");
                        } catch (IOException e) {
                            System.out.println("An error occurred while adding data.");
                            e.printStackTrace();
                        }
                        break;
                    }

                    case 3: { // Delete file
                        System.out.println("Are you sure you want to delete the file (y/n)? ");
                        char confirm = Character.toUpperCase(scan.nextLine().charAt(0));
                        if (confirm == 'Y') {
                            if (file.delete()) {
                                System.out.println("File deleted successfully.");
                            } else {
                                System.out.println("Failed to delete the file.");
                            }
                        }
                        break;
                    }

                    case 4: { // Path of the file
                        System.out.println("File path: " + file.getAbsolutePath());
                        break;
                    }

                    case 5: { // File size
                        double size = file.length();
                        if (size >= 1024 * 1024 * 1024) {  // GB
                            size /= (1024.0 * 1024.0 * 1024.0);
                            System.out.println("File size: " + size + " GB");
                        } else if (size >= 1024 * 1024) {  // MB
                            size /= (1024.0 * 1024.0);
                            System.out.println("File size: " + size + " MB");
                        } else if (size >= 1024) {  // KB
                            size /= 1024.0;
                            System.out.println("File size: " + size + " KB");
                        } else {  // Bytes
                            System.out.println("File size: " + size + " bytes");
                        }
                        break;
                    }

                    case 6: { // Create a directory
                        System.out.println("Enter directory name: ");
                        String dirName = scan.nextLine();
                        File dir = new File(dirName);
                        if (dir.mkdirs()) { // Use mkdirs() to create parent directories if needed
                            System.out.println("Directory created successfully.");
                        } else {
                            System.out.println("Failed to create directory.");
                        }
                        break;
                    }

                    default:
                        System.out.println("Invalid option selected.");
                        break;
                }
            } else {
                System.out.println("File does not exist. Do you want to create a new file (y/n)? ");
                char confirm = Character.toUpperCase(scan.nextLine().charAt(0));
                if (confirm == 'Y') {
                    System.out.println("Enter the file name (include path if necessary): ");
                    String newFilePath = scan.nextLine();
                    File newFile = new File(newFilePath);
                    try {
                        if (newFile.createNewFile()) {
                            System.out.println("File created successfully at: " + newFile.getAbsolutePath());
                        } else {
                            System.out.println("File already exists or could not be created.");
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred while creating the file.");
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Do you want to perform another operation (y/n)? ");
            char continueOption = Character.toUpperCase(scan.nextLine().charAt(0));
            if (continueOption != 'Y') {
                break;  // Exit the loop if the user does not want to continue
            }
        }

        scan.close();  // Close the Scanner after exiting the loop
    }
}

//import java.io.IOException;
//import java.io.*;
//import java.lang.Exception;
//import java.util.*;
//public class File_Handling {
//
//    public static void main(String[] args) throws IOException {
//        System.out.print("Enter file name: ");
//        Scanner scan=new Scanner(System.in);
//        String file_name=scan.nextLine();
//        File file=new File(file_name);
//
//        if(file.exists()){
//
//
//            System.out.println("""
//                    File is exist what method you want to perform: \
//
//                    1. Read\
//
//                    2.Add data\
//
//                    3. Delete file\
//
//                    4. Path of the file\
//
//                    5. Size of the file\
//
//                    6. Create a directory(folder):\t""");
//            int i= scan.nextInt();
//            scan.nextLine();
//            switch (i){
//                case 1:{ // Read data
//                    try(BufferedReader br=new BufferedReader(new FileReader(file))){
//                        String line;
//                        line = br.readLine();
//                        System.out.println(line);
//
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
//                    break;
//                }     //Read file
//
//                case 2:{  //Add data
//                    System.out.println("Enter your data which you want to add: ");
//                    String data=scan.nextLine();
//                    try (FileWriter FW =new FileWriter(file,true)){
//                        FW.write(data);
//                        System.out.println("Your data is added successful.... ");
//
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                    break;
//
//                }  //Add data
//
//                case 3:{  //Delete file
//                    System.out.println("Are you sure(y/n): ");
//                    char ch=Character.toUpperCase(scan.nextLine().charAt(0));
//                    if(ch=='Y'){
//                        if(file.delete()){
//                            System.out.println("File delete successful ........");
//                        }
//                        else {
//                            System.out.println("File is not  deleted");
//                        }
//                    }
//                    break;
//                }  //Delete Data
//
//                case 4:{
//                    System.out.println("Your file path is: "+file.getAbsolutePath());
//                    break;
//                }  // Path of the file
//
//                case 5:{  // File size
//                    double size = file.length();
//                    if (size >= 1024 * 1024 * 1024) {  // GB
//                        size = size / (1024.0 * 1024.0 * 1024.0);
//                        System.out.println("the file size is: " + size + "GB");
//                    } else if (size >= 1024 * 1024) {  // MB
//                        size = size / (1024.0 * 1024.0);
//                        System.out.println("the file size is: " + size + "MB");
//                    } else if (size >= 1024) {  // KB
//                        size = size / 1024.0;
//                        System.out.println("the file size is: " + size + "KB");
//                    } else {  // Bytes
//                        System.out.println("the file size is: " + size + "byte");
//                    }
//
//
//
//                }  // File size
//
//                case 6:{   //Create a directory
//                    System.out.println("Enter directory name: ");
//                    String Directory_name= scan.nextLine();
//                    File Dir=new File(Directory_name);
//                    if (Dir.mkdir()){
//                        if(Dir.exists()){
//                            System.out.println("Directory create successful .....");
//                        }
//                        else {
//                            System.out.println("Fail to create Directory ......");
//                        }
//                    }
//
//                }   //Create a directory
//            }
//        }
//        else {
//            System.out.println("Want to create new file(y/n):");
//            char ch=Character.toUpperCase(scan.nextLine().charAt(0));
////            scan.nextLine();
//            if (ch == 'Y'){
//                System.out.println("Enter file name\n(if you want to create new file in another directory then write path before file name like\"/path/of/your/directory/filname\": )");
//                String path= scan.nextLine();
//                File Path=new File(path);
//                boolean newFile = Path.createNewFile();
//                if (Path.exists()){
//                    System.out.println("File create successfully.....\n"+Path.getAbsolutePath());
//                }
//            }
//        }
//
//
//        System.out.println(file.canRead());
//
//    }
//
//}
//
//
