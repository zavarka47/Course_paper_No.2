import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;

public class FunctionalProgramming {
    public static void main(String[] args) {
        String string = "yourapp the quick brown fox jumps over the lazy dog";

        Arrays.stream(string.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(comparingByKey()))
                .limit(10)
                .forEach(s -> System.out.println(s.getValue() + " - " + s.getKey()));


    }
}
