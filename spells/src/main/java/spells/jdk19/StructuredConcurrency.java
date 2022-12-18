package spells.jdk19;

import jdk.incubator.concurrent.StructuredTaskScope;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class StructuredConcurrency {

    public static void main(String[] args) {
        System.out.println(task());
    }

    private static List<? extends Serializable> task() {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Future<String> user  = scope.fork(StructuredConcurrency::findUser);
            Future<Integer> order = scope.fork(StructuredConcurrency::fetchOrder);

            scope.join();           // Join both forks
            scope.throwIfFailed();  // ... and propagate errors

            // Here, both forks have succeeded, so compose their results
            return Arrays.asList(user.resultNow(), order.resultNow());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static Integer fetchOrder() {
        return 0;
    }

    private static String findUser() {
        return "1";
    }

}
