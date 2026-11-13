
package com.example.filemanagement;

import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;

public class MainBinaryRead {

    public static void readBinaryFile(String filePath) {

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            long totalBytes = 0;

            while ((bytesRead = bis.read(buffer)) != -1) {
                totalBytes += bytesRead;
            }

            System.out.println("Fichier binaire lu : " + filePath);
            System.out.println("Taille totale : " + totalBytes + " octets");

        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture binaire : " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        readBinaryFile("data/test.jpg");

    }
}
