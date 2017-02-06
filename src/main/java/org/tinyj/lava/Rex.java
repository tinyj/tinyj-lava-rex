package org.tinyj.lava;

import org.tinyj.lava.rex.*;

import java.util.function.*;

import static org.tinyj.lava.WrappedCheckedException.wrapCheckedException;

/**
 * Utility class
 */
public class Rex {

  /**
   * This method simplifies the creation of (#RexRunnable) lambdas in places where a
   * [Runnable](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html) is
   * is expected. E.g. `new Thread(Rex.runnable(() -> {...code throwing checked exception...}))`
   *
   * @return `runnable`
   */
  public static Runnable
  runnable(RexRunnable runnable) { return runnable; }

  /**
   * This method simplifies the creation of (#RexSupplier) lambdas in places where a
   * [Supplier](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html)
   * is expected. E.g. `Stream.generate(Rex.supplier(() -> {...code throwing checked exception...}))`
   *
   * @return `supplier`
   */
  public static <R> Supplier<R>
  supplier(RexSupplier<R, ?> supplier) { return supplier; }

  /**
   * This method simplifies the creation of (#RexFunction) lambdas in places where a
   * [Function](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)
   * is expected. E.g. `Stream.map(Rex.function(element -> {...code throwing checked exception...}))`
   *
   * @return `function`
   */
  public static <X, R> Function<X, R>
  function(RexFunction<X, R, ?> function) { return function; }

  /**
   * This method simplifies the creation of (#RexBiFunction) lambdas in places where a
   * [BiFunction](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html)
   * is expected. E.g. `map.replaceAll(Rex.biFunction((key, value) -> {...code throwing checked exception...}))`
   *
   * @return `biFunction`
   */
  public static <X, Y, R> BiFunction<X, Y, R>
  biFunction(RexBiFunction<X, Y, R, ?> biFunction) { return biFunction; }

  /**
   * This method simplifies the creation of (#RexConsumer) lambdas in places where a
   * [Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)
   * is expected. E.g. `stream.forEach(Rex.consumer(element -> {...code throwing checked exception...}))`
   *
   * @return `consumer`
   */
  public static <X> Consumer<X>
  consumer(RexConsumer<X, ?> consumer) { return consumer; }

  /**
   * This method simplifies the creation of (#RexBiConsumer) lambdas in places where a
   * [BiConsumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html)
   * is expected. E.g. `map.forEach(Rex.biConsumer((key, value) -> {...code throwing checked exception...}))`
   *
   * @return `biConsumer`
   */
  public static <X, Y> BiConsumer<X, Y>
  biConsumer(RexBiConsumer<X, Y, ?> biConsumer) { return biConsumer; }

  /**
   * This method simplifies the creation of (#RexPredicate) lambdas in places where a
   * [Predicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html)
   * is expected. E.g. `stream.filter(Rex.predicate(element -> {...code throwing checked exception...}))`
   *
   * @return `predicate`
   */
  public static <X> Predicate<X>
  predicate(RexPredicate<X, ?> predicate) { return predicate; }

  /**
   * This method simplifies the creation of (#RexBiPredicate) lambdas in places where a
   * [BiPredicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiPredicate.html)
   * is expected. E.g. `Files.find(start, depth, Rex.biPredicate((path, attributes) -> {...code throwing checked exception...}))`
   *
   * @return `biPredicate`
   */
  public static <X, Y> BiPredicate<X, Y>
  biPredicate(RexBiPredicate<X, Y, ?> biPredicate) { return biPredicate; }

  /**
   * This method is equivalent to `Rex.function(operator)`.
   */
  public static <X> Function<X, X>
  unaryOp(RexFunction<X, X, ?> operator) { return operator; }

  /**
   * This method is equivalent to `Rex.biFunction(operator)`.
   */
  public static <X> BiFunction<X, X, X>
  binaryOp(RexBiFunction<X, X, X, ?> operator) { return operator; }

  /**
   * This method is equivalent to `Rex.biPredicate(relation)`.
   */
  public static <X> BiPredicate<X, X>
  relation(RexBiPredicate<X, X, ?> relation) { return relation; }

  /**
   * Bridge [LavaRunnable](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavarunnablee)
   * to [Runnable](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html)
   * by wrapping checked exceptions raised.
   */
  public static Runnable
  rex(LavaRunnable<?> checked) {
    return (RexRunnable) checked::checkedRun;
  }

  /**
   * Bridge [LavaConsumer](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavaconsumerx-e)
   * to [Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)
   * by wrapping checked exceptions raised.
   */
  public static <X> Consumer<X>
  rex(LavaConsumer<X, ?> checked) {
    return (RexConsumer<X, ?>) checked::checkedAccept;
  }

  /**
   * Bridge [LavaBiConsumer](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabiconsumerx-y-e)
   * to [BiConsumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html)
   * by wrapping checked exceptions raised.
   */
  public static <X, Y> BiConsumer<X, Y>
  rex(LavaBiConsumer<X, Y, ?> checked) {
    return (RexBiConsumer<X, Y, ?>) checked::checkedAccept;
  }

  /**
   * Bridge [LavaSupplier](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavasupplierr-e)
   * to [Supplier](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html)
   * by wrapping checked exceptions raised.
   */
  public static <R> Supplier<R>
  rex(LavaSupplier<R, ?> checked) {
    return (RexSupplier<R, ?>) checked::checkedGet;
  }

  /**
   * Bridge [LavaFunction](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavafunctionx-r-e)
   * to [Function](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)
   * by wrapping checked exceptions raised.
   */
  public static <X, R> Function<X, R>
  rex(LavaFunction<X, R, ?> checked) {
    return (RexFunction<X, R, ?>) checked::checkedApply;
  }

  /**
   * Bridge [LavaBiFunction](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabifunctionx-y-r-e)
   * to [BiFunction](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html)
   * by wrapping checked exceptions raised.
   */
  public static <X, Y, R> BiFunction<X, Y, R>
  rex(LavaBiFunction<X, Y, R, ?> checked) {
    return (RexBiFunction<X, Y, R, ?>) checked::checkedApply;
  }

  /**
   * Bridge [LavaPredicate](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavapredicatex-e)
   * to [Predicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html)
   * by wrapping checked exceptions raised.
   */
  public static <X> Predicate<X>
  rex(LavaPredicate<X, ?> checked) {
    return (RexPredicate<X, ?>) checked::checkedTest;
  }

  /**
   * Bridge [LavaBiPredicate](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabipredicatex-y-e)
   * to [BiPredicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiPredicate.html)
   * by wrapping checked exceptions raised.
   */
  public static <X, Y> BiPredicate<X, Y>
  rex(LavaBiPredicate<X, Y, ?> checked) {
    return (RexBiPredicate<X, Y, ?>) checked::checkedTest;
  }

  /**
   * Convenience method invoking [LavaRunnable](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavarunnablee)
   * wrapping checked exceptions raised.
   */
  public static void
  invoke(LavaRunnable<?> checked) {
    wrapCheckedException(checked);
  }

  /**
   * Convenience method invoking [LavaConsumer](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavaconsumerx-e)
   * wrapping checked exceptions raised.
   */
  public static <X> void
  invoke(LavaConsumer<X, ?> checked, X x) {
    wrapCheckedException(() -> checked.checkedAccept(x));
  }

  /**
   * Convenience method invoking [LavaBiConsumer](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabiconsumerx-y-e)
   * wrapping checked exceptions raised.
   */
  public static <X, Y> void
  invoke(LavaBiConsumer<X, Y, ?> checked, X x, Y y) {
    wrapCheckedException(() -> checked.checkedAccept(x, y));
  }

  /**
   * Convenience method invoking [LavaSupplier](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavasupplierr-e)
   * wrapping checked exceptions raised.
   */
  public static <R> R
  invoke(LavaSupplier<R, ?> checked) {
    return wrapCheckedException(checked);
  }

  /**
   * Convenience method invoking [LavaFunction](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavafunctionx-r-e)
   * wrapping checked exceptions raised.
   */
  public static <X, R> R
  invoke(LavaFunction<X, R, ?> checked, X x) {
    return wrapCheckedException(() -> checked.checkedApply(x));
  }

  /**
   * Convenience method invoking [LavaBiFunction](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabifunctionx-y-r-e)
   * wrapping checked exceptions raised.
   */
  public static <X, Y, R, E extends Exception> R
  invoke(LavaBiFunction<X, Y, R, E> checked, X x, Y y) {
    return wrapCheckedException(() -> checked.checkedApply(x, y));
  }

  /**
   * Convenience method invoking [LavaPredicate](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavapredicatex-e)
   * wrapping checked exceptions raised.
   */
  public static <X> boolean
  invoke(LavaPredicate<X, ?> checked, X x) {
    return wrapCheckedException(() -> checked.checkedTest(x));
  }

  /**
   * Convenience method invoking [LavaBiPredicate](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabipredicatex-y-e)
   * wrapping checked exceptions raised.
   */
  public static <X, Y> boolean
  invoke(LavaBiPredicate<X, Y, ?> checked, X x, Y y) {
    return wrapCheckedException(() -> checked.checkedTest(x, y));
  }
}
