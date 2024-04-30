package reflectionapis;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionAPIExample {
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        User user= new User("Max");
        
        //Set username from Max to Jack.
        Field username=User.class.getDeclaredField("username");
        username.setAccessible(true);
        username.set(user, "Jack");

        // Invokde Private method
        Method methObj=User.class.getDeclaredMethod("getUsername");
        methObj.setAccessible(true);
        String name=(String) methObj.invoke(user);
        System.out.println("Username: "+name);
    }
}

class User{
    private String username;

    public User(String username) {
        this.username=username;
        System.out.println("Default user: "+this.username);
    }

    private String getUsername(){
        return this.username;

    }
}
