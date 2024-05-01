package cn.zyy;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @Author: Zz
 * @Date: 2024/05/01/17:06
 * @Description: 致敬
 */
public class LambdaTest {


    /**
     * ============================= start-- 语法格式一: 无参无返回值=====================================================
     */
    @Test
    public void test1(){

        //之前的写法
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("test1  init");
            }
        };
        runnable.run();

        //lambda 写法

        Runnable r2 = () -> System.out.println("test1 lambda 写法");
    }

    /**
     * ============================= start-- 语法格式一: 需要一个参数无返回值=====================================================
     */
    @Test
    public void test2(){

        //旧写法
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("123456");

        //lambda 写法
        Consumer<String> consumer2 = (String s) -> System.out.println(s);
        consumer2.accept("7891011");

    }


    /**
     * ============================= start-- 语法格式三: 数据类型可以省略，可由编译器推断得出，称为类型推断=====================================================
     */
    @Test
    public void test3(){
        //旧写法
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("123456");

        //lambda 写法
        Consumer<String> consumer2 = (String s) -> System.out.println(s);
        consumer2.accept("7891011");

        //lambda 类型推断写法
        Consumer<String> consumer3 = s -> System.out.println(s);
        consumer3.accept("abcdefg");
    }


    /**
     * ============================= start-- 语法格式四: 如若只有一个参数，则参数外的小括号可以省略=====================================================
     */
    @Test
   public  void test4(){

    }


    /**
     * ============================= start-- 语法格式五: 两个或以上的参数，多条执行语句 ，并且可以有返回值=====================================================
     */
    @Test
   public  void test5(){

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12, 21));

        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        System.out.println(com2.compare(32,34));
    }


    /**
     * ============================= start-- 语法格式六: 当Lambda体只有一条语句时，return 与大括号若有，都可以省略=====================================================
     */
    @Test
    public  void  test6(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12, 21));

        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(32,34));

    }
}
