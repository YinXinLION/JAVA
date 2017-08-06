package string;

/**
 * Created by yinxin on 17-8-6.
 */
//0-1交换问题
public class Example1 {
    public static void main(String[] args) {
        String str = "01010010101";
        char[] array = str.toCharArray();

        for (int i = 0,j = array.length-1; i <j;i++,j--){
            for (;i<j;i++){
                if (array[i] == '1'){
                    break;
                }
            }
            for (;i<j;j--){
                if (array[j] == '0')
                    break;
            }
            System.out.println("~");
            char temp = array[i];
            array[i] = array[j];
            array[j] =  temp;
        }
        for (char i : array){
            System.out.println(i);
        }
    }
}
