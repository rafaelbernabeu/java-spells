package br.bernabeu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFiles {

    public static void main(String[] args) throws IOException {

        zipFolder("/home/rab/Pictures/", "zipFile.zip", 99);

    }

    public static void zipFolder(String path, String zipFile, int maxDepth) throws IOException {

        Path root = Paths.get(path);
        Path zipPath = root.resolve(zipFile) ;
        ZipOutputStream zipOut = new ZipOutputStream(Files.newOutputStream(zipPath));
        zipOut.setLevel(Deflater.BEST_COMPRESSION);

        Files.walk(root, maxDepth).forEach(fileToZip -> {

            try {
                if (!Files.isSameFile(fileToZip, zipPath)) {

                    byte[] bytes = Files.readAllBytes(fileToZip);

                    ZipEntry zipEntry = new ZipEntry(fileToZip.getFileName().toString());
                    zipEntry.setSize(bytes.length);

                    zipOut.putNextEntry(zipEntry);
                    zipOut.write(bytes);
                    zipOut.closeEntry();

                }
            } catch (IOException e) {}

        });

        zipOut.close();

    }
}
