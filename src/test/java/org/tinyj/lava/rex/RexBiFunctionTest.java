package org.tinyj.lava.rex;

import org.tinyj.lava.LavaFun;

import java.util.function.BiFunction;

import static org.tinyj.lava.Rex.rex;

public class RexBiFunctionTest {

  public static void main(String[] argv) throws Exception {
    for (int i = 0; i < 10000; i++) {
      String result = concat(i);
      System.out.println(result);
    }
  }

  private static String concat(int i) {
    BiFunction<String, String, String> f = rex(LavaFun.biFunction((x, y) -> x + y));
    return f.apply(Integer.toString(i), Integer.toHexString(i));
  }
}