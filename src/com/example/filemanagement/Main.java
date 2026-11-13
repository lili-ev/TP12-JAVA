
package com.example.filemanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void readFileWithBufferedReader(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : "
                    + e.getMessage());
        }
    }

    public static void main(String[] args) {

        System.out.println("Lecture du fichier employees.txt :");

        readFileWithBufferedReader("data/employees.txt");
    }
}
