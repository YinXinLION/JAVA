package Enum;

/**
 * Created by yinxin on 17-7-26.
 */
public enum  WeekDayEnum {
    Mon, Tue, Wed, Thu, Fri, Sat, Sun

}
/*
    对于这些枚举的日期，JVM 都会在运行期构造成出一个简单的对象实例一一对应。
    这些对象都有唯一的 identity，类似整形数值一样，switch 语句就根据此来进行执行跳转。
 */
