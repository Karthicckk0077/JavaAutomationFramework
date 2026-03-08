package Utils;

import java.io.File;

public class FileRenamer {

    public static void renameFiles(String folderPath, String baseName) {

        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("No files found.");
            return;
        }

        int count = 1;

        for (File file : files) {

            if (file.isFile() && file.getName().endsWith(".png")) {

                String newName = baseName + "_" + String.format("%03d", count) + ".png";
                File newFile = new File(folderPath + "/" + newName);

                boolean renamed = file.renameTo(newFile);

                if (renamed) {
                    System.out.println("Renamed: " + file.getName() + " → " + newName);
                }

                count++;
            }
        }
    }
}
