package 刷题;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by yinxin on 17-8-13.
 */
public class test6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//n张桌子
        int m = scanner.nextInt();//m批客人
        int[] disk = new int[n]; //桌子数组
        for (int i = 0; i < n; i ++) {
            disk[i] = scanner.nextInt();
        }
        Arrays.sort(disk); // 桌子容纳量从小到大排序
        PriorityQueue<Customer> queue = new PriorityQueue<>(); // 将客人按消费额降序加入优先级队列
        for (int i = 0; i < m;i++){
            int b = scanner.nextInt();//人数
            int c = scanner.nextInt();//金额
            if (b <= disk[n-1]){
                queue.add(new Customer(b,c));//将客人按消费额降序加入优先级队列
            }
        }
        boolean[] visited = new boolean[n];//记录桌子是否被占用
        long sum = 0;//记录总盈利
        int count = 0;//记录已使用的桌子数
        while (!queue.isEmpty()){
            Customer customer = queue.poll();
            for (int i = 0;i < n;i++){
                if (customer.peopleCount <= disk[i] && !visited[i]){
                    sum+=customer.moneyCount;
                    visited[i] = true;
                    count++;
                    break;
                }
                if (count == n){
                    break;
                }
            }
        }
        System.out.println(sum);




    }
    static class Customer implements Comparable<Customer>{
        private int peopleCount;//人数
        private int moneyCount;//钱数
        public Customer(int peopleCount, int moneyCount) {
            this.peopleCount = peopleCount;
            this.moneyCount = moneyCount;
        }
        @Override
        public int compareTo(Customer o) {
            if (o.moneyCount > this.moneyCount) return 1;
            else if (o.moneyCount < this.moneyCount) return -1;
            return 0;
        }
    }
}
