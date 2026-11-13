
package com.example.filemanagement;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.IOException;

public class MainCopyMove {

    // Copier un fichier
    public static void copyFile(String source, String destination) {
        try {
            Path sourcePath = Paths.get(source);
            Path destPath = Paths.get(destination);

            Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Fichier copié de " + source + " vers " + destination);

        } catch (IOException e) {
            System.err.println("Erreur lors de la copie : " + e.getMessage());
        }
    }

    // Déplacer un fichier
    public static void moveFile(String source, String destination) {
        try {
            Path sourcePath = Paths.get(source);
            Path destPath = Paths.get(destination);

            Files.move(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Fichier déplacé de " + source + " vers " + destination);

        } catch (IOException e) {
            System.err.println("Erreur lors du déplacement : " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Copie du fichier ===");
        copyFile("data/employees.txt", "data/employees_backup.txt");

        System.out.println("\n=== Déplacement du fichier ===");
        moveFile("data/nio_output.txt", "data/moved_output.txt");
    }
}
