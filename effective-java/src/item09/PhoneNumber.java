package item09;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 殷鑫 on 2017/2/6.
 */
public final class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max)
            throw new IllegalArgumentException(name + ": " + arg);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (!(obj instanceof PhoneNumber)){
            return  false;
        }
        PhoneNumber pn = (PhoneNumber)obj;
        return pn.lineNumber == lineNumber && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

//     @Override public int hashCode() {
//     int result = 17;
//     result = 31 * result + areaCode;
//     result = 31 * result + prefix;
//     result = 31 * result + lineNumber;
//     return result;
//     }

    //延迟加载
    //第一次初始化完成hashCode取值
     private volatile int hashCode;

     @Override public int hashCode() {
     int result = hashCode;
     if (result == 0) {
     result = 17;
     result = 31 * result + areaCode;
     result = 31 * result + prefix;
     result = 31 * result + lineNumber;
     hashCode = result;
     }
     return result;
     }

    public static void main(String[] args) {
        Map<PhoneNumber,String> m = new HashMap<PhoneNumber,String>();
        m.put(new PhoneNumber(100,222,5300),"LION");

        System.out.println(m.get(new PhoneNumber(100,222,5300))); //相同hascode为true
    }
}
