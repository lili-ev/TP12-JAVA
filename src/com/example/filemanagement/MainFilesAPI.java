
package com.example.filemanagement;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class MainFilesAPI {

    // Lecture avec Files API
    public static void readWithFilesApi(String filePath) {
        try {
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture : " + e.getMessage());
        }
    }

    // Écriture avec Files API
    public static void writeWithFilesApi(String filePath, String content) {
        try {
            Path path = Paths.get(filePath);
            Files.write(path, content.getBytes());

            System.out.println("Fichier écrit avec succès : " + filePath);

        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture : " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Lecture avec Files API ===");
        readWithFilesApi("data/employees.txt");

        System.out.println("\n=== Écriture avec Files API ===");
        writeWithFilesApi(
            "data/nio_output.txt",
            "Alice,25,Engineer\nBob,30,Manager\nCharlie,28,Designer"
        );
    }
}
