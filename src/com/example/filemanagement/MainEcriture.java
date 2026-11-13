
package com.example.filemanagement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MainEcriture {

    public static void writeFileWithBufferedWriter(String filePath, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(content);
            bw.newLine();
            bw.write("Ligne ajoutée avec succès.");

        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture du fichier : " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        writeFileWithBufferedWriter(
            "data/output.txt",
            "Bonjour, ceci est un fichier de test."
        );

        System.out.println("Écriture terminée.");
    }
}
