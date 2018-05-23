package lc.utils;

import java.util.Arrays;

public class PrintUtils {

  public static void out(int[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
  }

  public static void out2(Object[] array) {
    Arrays.asList(array).forEach(System.out::println);
  }
}
