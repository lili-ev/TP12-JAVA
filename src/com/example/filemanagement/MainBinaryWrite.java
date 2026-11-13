
package com.example.filemanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MainBinaryWrite {

    // Lire les octets d'un fichier
    public static byte[] readBinaryFile(String filePath) {

        try (BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream(filePath));
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            return baos.toByteArray();

        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture : " + e.getMessage());
            return null;
        }
    }

    // Écrire les octets dans un fichier
    public static void writeBinaryFile(String filePath, byte[] data) {

        try (BufferedOutputStream bos =
                new BufferedOutputStream(new FileOutputStream(filePath))) {

            bos.write(data);
            bos.flush();

            System.out.println("Fichier binaire écrit : " + filePath);
            System.out.println("Taille écrite : " + data.length + " octets");

        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture binaire : " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        byte[] data = readBinaryFile("data/test.jpg");

        if (data != null) {
            writeBinaryFile("data/copy_binary.bin", data);
        }
    }
}
