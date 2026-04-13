package demo.jdk25;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.nio.file.Path;


public class FFM2 {

    void main() throws Throwable {

        Path path = Path.of("/Users/rafaelbernabeu/Projects/java-spells/jdk-news/src/main/resources/echo.o");


        try (Arena arena = Arena.ofConfined()) {

            Linker linker = Linker.nativeLinker();
            SymbolLookup lib = SymbolLookup.libraryLookup(path, arena);

            FunctionDescriptor descriptor = FunctionDescriptor.of(
                    ValueLayout.JAVA_INT,
                    ValueLayout.JAVA_INT,
                    ValueLayout.ADDRESS
            );

            MethodHandle mainFunc = lib.find("main")
                    .map(addr -> linker.downcallHandle(addr, descriptor))
                    .orElseThrow(() -> new RuntimeException("Função não encontrada!"));

            String[] argsToPass = { "meu_app", "param1", "param2", "param3" };

            MemorySegment argv = arena.allocate(ValueLayout.ADDRESS, argsToPass.length);

            for (int i = 0; i < argsToPass.length; i++) {

                MemorySegment cString = arena.allocateFrom(argsToPass[i]);
                argv.setAtIndex(ValueLayout.ADDRESS, i, cString);

            }

            int exitCode = (int) mainFunc.invoke(argsToPass.length, argv);

            IO.println(exitCode);
        }

    }
}