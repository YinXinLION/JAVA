import java.util.List;

/**
 * Created by yinxin on 17-9-8.
 */
public class 全组合 {
    public void combination(List<Integer> selected,List<Integer> data, int n){
        //initial value
        if (n == 0){
         //n==0时 只用1中做法
        //return empty list
            for (Integer integer:selected){
                System.out.print(integer +" ");
            }
            System.out.println();
            return;
         }
        if (data.isEmpty()){
            return;
        }

        //how to select elements
        //how to output
        //select element 0
        selected.add(data.get(0));
        combination(selected,data.subList(1,data.size()),n-1);
        selected.remove(selected.size()-1);//最后的remove
        combination(selected,data.subList(1,data.size()),n);
    }
    public static void main(String[] args) {

    }
}
