package 拼多多;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by yinxin on 17-9-2.
 */
class Bear{
    int battle;
    int hungry;
    public Bear(int battle,int hungry){
        this.battle = battle;
        this.hungry = hungry;
    }
}
public class test1 {


    public static void main(String[] args) {
        PriorityQueue<Bear> q = new PriorityQueue<>(new Comparator<Bear>() {
            @Override
            public int compare(Bear o1, Bear o2) {
                return o2.battle - o1.battle;
            }
        });
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n >10){
            return;
        }
        int m = scanner.nextInt();
        if (m > 100){
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < m;i++){
            linkedList.add(scanner.nextInt());
        }
        for (int i = 0; i < n;i++){
            int battle = scanner.nextInt();
            int hungry = scanner.nextInt();
            q.add(new Bear(battle,hungry));
        }
        int index = 0;
        Bear[] bear = new Bear[n];
        while (!q.isEmpty()){
            Collections.sort(linkedList);
            Bear bear1 = q.peek();
            if (bear1.hungry == 0){
                bear[index++] = q.poll();
                continue;
            }
            for (int i = linkedList.size()-1; i >= 0; i--){
                if (bear1.hungry >= (int)linkedList.get(i)){
                    bear1.hungry = bear1.hungry - (int)linkedList.get(i);
//                    System.out.println(bear1.hungry);
                    linkedList.remove(i);

                    continue;
                }
            }

                bear[index++] = q.poll();

        }
        for (int i = 0; i < bear.length; i++){
            System.out.println(bear[i].hungry);
        }
    }


}
