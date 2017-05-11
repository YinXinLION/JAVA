package Chapter7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by 殷鑫 on 2017/5/11.
 */
public class AtomicIntegerFieldUpdaterTest {
    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class,"old");

    public static void main(String[] args) {
        //设置年龄
        User conan =new User("conan",10);
        System.out.println(a.getAndIncrement(conan));
        System.out.println(a.get(conan));
    }

    public static class User{
        private String name;
        private volatile int old;
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
