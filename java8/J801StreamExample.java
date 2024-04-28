package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * StreamExample
 */
public class J801StreamExample {

    public static void main(String[] args) {
        /**
         * Q1. Count the occurance of each character in a string.
         * 
         * 
         * Step 1: Create Array of String
         * str.split(""): It creates char array.
         * we could have used toCharArray() to create character array,
         * but stream doesnt accept char as datatype.
         * Step 2: In terminal stage i.e. collect()
         * use aggregator function groupingBy() from Collectors class
         * Function.identity() will consider elements as grouping type
         * and maps count of occorrences of each element into Map.
         * 
         */

        String str = "JavaJavaEEz";
        Map<String, Long> map = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

        /**
         * Q2. Find all duplicate elements in a string.
         * 
         * 
         * Step 1: Create Array of String
         * str.split(""): It creates char array.
         * we could have used toCharArray() to create character array,
         * but stream doesnt accept char as datatype.
         * Step 2: In terminal stage i.e. collect()
         * use aggregator function groupingBy() from Collectors class
         * Function.identity() will consider elements as grouping type
         * and maps count of occorrences of each element into Map
         */

        List<String> duplicateElements = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(el -> el.getValue() > 1)
                .map(i -> i.getKey())
                .collect(Collectors.toList());

        System.out.println("Duplicate Elments: " + duplicateElements);

        /*
         * *
         * Q3. Find first non-repeat element from the string
         * Use LinkedHashMap for maintaining order.
         */
        String nonRepeatingElement = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i -> i.getValue() == 1)
                .findFirst()
                .get()
                .getKey();

        System.out.println("First non-repeating element: " + nonRepeatingElement);

        // Q4: Find the longest string in the array
        int[] num = { 2, 3, 61, 12, 65, 23, 88, 32, 44 };
        Integer n = Arrays.stream(num)
                .boxed() // convert to wrapper class
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println("2nd highest number " + n);

        // Q6: Find the longest string in the array
        // Use Reduce function
        String[] strArr = {"java","springboot","microservices","kubernetes"};
        String longestString = Arrays.stream(strArr)
                                .reduce((word1,word2) -> word1.length()>word2.length()?word1:word2)
                                .get();

        System.out.println("Longest String: "+longestString);

        // Q4: Find all elements in array who start with 1

        List<String> startWithOne = Arrays.stream(num)
                                            .boxed()
                                            .map(k -> k+"" )
                                            .filter(k->k.startsWith("1"))
                                            .collect(Collectors.toList());
        System.out.println("Elements Starting with 1: "+startWithOne);



        //Q7: String.join()
        List<String> list =Arrays.asList(strArr);
        String joinedString=String.join("-", list);
        System.out.println("Joined String: "+joinedString);

    }
}