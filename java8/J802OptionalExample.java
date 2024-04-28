package java8;

import java.util.Optional;

/* 
 * Optional class provides robust way to handle null values in java
 * It makes your code functional and reliable
 */
public class J802OptionalExample {
    public static void main(String[] args) {
        User user = new User();

        //Without Optional
        /* String username = user.getUsername(0);
        if (username!=null) {  
            System.out.println(username);
        }else{
            System.out.println("Username not found");
        } */

        //With Optional
        Optional<String> usernameOptional = user.getUsername(12);
        usernameOptional.ifPresentOrElse(u->System.out.println(u), ()-> System.out.println("User not Found"));

        usernameOptional.map(u->u.toUpperCase()).ifPresent(System.out::println);
    }
}

class User{
    public Optional<String> getUsername(int id){
        if (id == 0) {
            return Optional.empty();
        }else{
            return Optional.ofNullable("Java");
        }
    }
}
