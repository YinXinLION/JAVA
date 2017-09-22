package 迅雷;

import org.junit.Test;

/**
 * Created by yinxin on 17-9-19.
 */
public class test2 {
    public double equation(double a, double b, double c) throws Exception {
        if ((2 * a + b) == 0) {
            throw new Exception("error:2*a+b=0");
        } else if (a == 0) {
            return (double) (-c / b);
        } else if (b == 0) {
            return (double) (-c / 2 * a);
        } else {
            return (double) (-c / (2 * a + b));
        }
    }

    @Test
    public void test5() {
        try {
            double result = equation(1, 2, 2);
            System.out.println("结果---》" + result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
