package spells;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author Rafael Bernabeu
 */
public class WalkDir {

    static long dirVisitado = 0;
    static long dirErro = 0;

    public static void main(String[] args) throws IOException {

        Files.walkFileTree(Paths.get("/"),
                new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                        System.out.printf("Visiting file %s\n", file);
                        dirVisitado++;

                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFileFailed(Path file, IOException e) {
                        System.err.printf("Visiting failed for %s\n", file);
                        dirErro++;

                        return FileVisitResult.SKIP_SUBTREE;
                    }

                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                        System.out.printf("About to visit directory %s\n", dir);

                        return FileVisitResult.CONTINUE;
                    }
                });


        System.out.println("Diretórios visitados: " + dirVisitado);
        System.out.println("Diretórios com erro: " + dirErro);
    }



}