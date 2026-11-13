
package com.example.filemanagement;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.NoSuchFileException;
import java.io.IOException;

public class MainDelete {

    // Supprimer un fichier
    public static void deleteFile(String filePath) {
        try {
            Path path = Paths.get(filePath);

            if (Files.exists(path)) {
                Files.delete(path);
                System.out.println("Fichier supprimé : " + filePath);
            } else {
                System.out.println("Le fichier n'existe pas : " + filePath);
            }

        } catch (NoSuchFileException e) {
            System.err.println("Le fichier a été supprimé entre-temps : " + e.getMessage());

        } catch (IOException e) {
            System.err.println("Erreur lors de la suppression : " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Suppression d'un fichier existant ===");
        deleteFile("data/moved_output.txt");

        System.out.println("\n=== Suppression d'un fichier inexistant ===");
        deleteFile("data/inexistant.txt");
    }
}
