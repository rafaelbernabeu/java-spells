package demo.jdk25;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.util.Arrays;


public class FFM {

    void main() throws Throwable {

        // 1. Find foreign function on the C library path
        Linker linker = Linker.nativeLinker();
        SymbolLookup stdlib = linker.defaultLookup();
        Linker.Option[] options = new Linker.Option[]{Linker.Option.critical(true)};

        FunctionDescriptor descriptor = FunctionDescriptor.of(
                ValueLayout.JAVA_INT,     // Retorno
                ValueLayout.ADDRESS,      // base (ponteiro para ponteiros)
                ValueLayout.JAVA_INT,     // nmemb
                ValueLayout.ADDRESS,      // table (usaremos NULL)
                ValueLayout.JAVA_INT      // endbyte
        );

        MethodHandle radixsort = linker.downcallHandle(stdlib.findOrThrow("radixsort"), descriptor, options);
        // 2. Allocate on-heap memory to store four strings
        String[] javaStrings = {"mouse", "cat", "dog", "car"};
        IO.println(Arrays.stream(javaStrings).toList());
        // 3. Use try-with-resources to manage the lifetime of off-heap memory
        try (Arena offHeap = Arena.ofConfined()) {
            // 4. Allocate a region of off-heap memory to store four pointers
            MemorySegment pointers = offHeap.allocate(ValueLayout.ADDRESS, javaStrings.length);
            // 5. Copy the strings from on-heap to off-heap
            for (int i = 0; i < javaStrings.length; i++) {
                MemorySegment cString = offHeap.allocateFrom(javaStrings[i]);
                pointers.setAtIndex(ValueLayout.ADDRESS, i, cString);
            }
            // 6. Sort the off-heap data by calling the foreign function
            radixsort.invoke(pointers, javaStrings.length, MemorySegment.NULL, '\0');
            // 7. Copy the (reordered) strings from off-heap to on-heap
            for (int i = 0; i < javaStrings.length; i++) {
                MemorySegment cString = pointers.getAtIndex(ValueLayout.ADDRESS, i);
                javaStrings[i] = cString.reinterpret(Long.MAX_VALUE).getString(0);
            }
        } // 8. All off-heap memory is deallocated here

        IO.println(Arrays.stream(javaStrings).toList());

    }
}