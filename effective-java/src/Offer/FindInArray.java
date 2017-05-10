package Offer;

/**
 * Created by 殷鑫 on 2017/4/8.
 */
/*
在一个二维数组中，每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个函数，输
入这样的一个二维数组和一个整数，判断数组中是否含有该整
数。
 */
public class FindInArray {
    public static void main(String[] args) {
        int[][] array = new int[3][3];
        int target;
    }
    public boolean Find(int target, int [][] array) {
        int x = 0,y = array[0].length - 1;
        while (x < array.length  && y >= 0){
            if (array[x][y] == target){
                return true;
            }
            if (array[x][y] > target){
                y--;
            }else {
                x++;
            }
        }
        return false;
    }

}
