package Chapter7;

import javax.jws.soap.SOAPBinding;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by 殷鑫 on 2017/5/11.
 */
public class AtomicReferenceTest {
    private static AtomicReference<User> atomicReference = new AtomicReference<User>();
    public static void main(String[] args) {
        User user = new User("lion",6);
        atomicReference.set(user);
        User updateUser = new User("Li",16);
        atomicReference.compareAndSet(user,updateUser);
        System.out.println(atomicReference.get().getName());
        System.out.println(atomicReference.get().getOld());
    }
    static class User{
        private String name;
        private int old;
        public User(String name, int old){
            this.name = name;
            this.old = old;
        }
        public String getName(){
            return name;
        }
        public int getOld(){
            return old;
        }
    }
}
