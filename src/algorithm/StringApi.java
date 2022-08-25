package algorithm;

import java.util.Arrays;

/**
 * @author miaomeiqi
 */
public class StringApi {
    public static void main(String[] args) {
        String s = "     hello.my//name.is.vickie//do.you//know.what ,he,is,      ";

        /*
         * split()方法返回字符串数组，其中"."、"$"、"|"、"*"这种转义字符做分隔符时前面需要加双反斜杠
         */
        String[] arr = s.split("\\.");

        String[] arr1 = s.split("as|\\.");

        String[] arr2 = s.split(",|//");

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        /*
         * trim()方法去掉前后空格
         */
        System.out.println(s.trim());


        /*
         * String.join( , )方法，返回以第一个参数作为分隔的拼接好的字符串
         */
        String[] words = {"hi", "my", "name", "is", "bob"};
        System.out.println(String.join(",", words));

    }
}
