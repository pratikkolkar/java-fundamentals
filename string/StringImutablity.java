/**
 * StringImutablity
 */
public class StringImutablity {

    public static void main(String[] args) {

        String s1 = "Hello";// String "Hello" is created in string pool
        String s2 = s1.concat("World"); // creates a new String "Hello World" in heap memory
        String s3 = s1.concat("World").intern(); // Checks if "Hello World" is present in String pool if it does not
                                                 // exists then it creates in string pool
        String s4 = "Hello World";
        String s5 = new String("Hello World"); // Creates new String object in the heap memory.

    }
}