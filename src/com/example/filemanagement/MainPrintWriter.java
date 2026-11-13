
package com.example.filemanagement;

import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainPrintWriter {

    public static void writeWithPrintWriter(String filePath) {

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(filePath))) {

            pw.println("=== Rapport des employés ===");
            pw.printf("Nom: %s, Âge: %d, Poste: %s%n", "Alice", 25, "Engineer");
            pw.printf("Nom: %s, Âge: %d, Poste: %s%n", "Bob", 30, "Manager");
            pw.println("Fin du rapport.");

            if (pw.checkError()) {
                System.err.println("Erreur lors de l'écriture du fichier.");
            }

        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture : " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        writeWithPrintWriter("data/report.txt");

        System.out.println("Création du rapport terminée.");
    }
}
