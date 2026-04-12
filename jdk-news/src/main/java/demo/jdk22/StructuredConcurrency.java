package demo.jdk22;

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

    private static List<? extends Serializable> task() throws InterruptedException {
        try (var scope = StructuredTaskScope.open(StructuredTaskScope.Joiner.allSuccessfulOrThrow())) {
            Subtask<String> user  = scope.fork(StructuredConcurrency::findUser);
            Subtask<Integer> order = scope.fork(StructuredConcurrency::fetchOrder);

            scope.join();           // Join both forks

            // Here, both forks have succeeded, so compose their results
            return Arrays.asList(user.get(), order.get());
        } catch (InterruptedException e) {
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
