package demo.jdk21;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;

public class StructuredConcurrency {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(task());
    }

    private static List<? extends Serializable> task() throws ExecutionException, InterruptedException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Subtask<String> user  = scope.fork(StructuredConcurrency::findUser);
            Subtask<Integer> order = scope.fork(StructuredConcurrency::fetchOrder);

            scope.join();           // Join both forks
            scope.throwIfFailed();  // ... and propagate errors

            // Here, both forks have succeeded, so compose their results
            return Arrays.asList(user.get(), order.get());
        } catch (ExecutionException | InterruptedException e) {
            throw e;
        }
    }

    private static Integer fetchOrder() {
        return 0;
    }

    private static String findUser() {
        return "1";
    }

}
