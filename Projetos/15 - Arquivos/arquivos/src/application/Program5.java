package application;

import java.io.File;
import java.util.Scanner;

public class Program5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        File[] folders = path.listFiles(File::isDirectory);
        System.out.println("FOLDERS: ");
        for (File folder : folders) {
            System.out.println(folder);
        }

        System.out.println();

        File[] files = path.listFiles(File::isFile);
        System.out.println("FILES: ");
        assert files != null;
        for (File file : files) {
            System.out.println(file);
        }

        boolean success = new File(strPath + "/subdir").mkdir();
        System.out.println("Directory created sucessfully: " + success);

        sc.close();
    }
}
