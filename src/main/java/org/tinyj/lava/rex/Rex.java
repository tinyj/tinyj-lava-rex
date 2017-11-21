package org.tinyj.lava.rex;

import org.tinyj.lava.*;

import java.util.function.*;

import static org.tinyj.lava.WrappedCheckedException.wrapCheckedException;

/**
 * Utility class
 */
public class Rex {

  /**
   * Do not instantiate
   */
  protected Rex() { assert false : "Rex is a utility class, static use only."; }

  /**
   * This method simplifies the creation of {@link RexRunnable} lambdas in
   * places where a {@link Runnable} is expected or disambiguation between
   * {@link RexSupplier} and {@link RexRunnable} is required.
   * <p>
   * E.g. {@code new Thread(Rex.runnable(() -> {...code throwing checked exception...}))}
   *
   * @param <E> upper exception limit
   * @param runnable lambda
   * @return {@code runnable}
   */
  public static <E extends Exception> RexRunnable<E>
  runnable(RexRunnable<? extends E> runnable) { return RexRunnable.castDown(runnable); }

  /**
   * This method simplifies the creation of {@link RexSupplier} lambdas in
   * places where a {@link Supplier} is expected or disambiguation between
   * {@link RexSupplier} and {@link RexRunnable} is required.
   * <p>
   * E.g. {@code Stream.generate(Rex.supplier(() -> {...code throwing checked exception...}))}
   *
   * @param <R> return type
   * @param <E> upper exception limit
   * @param supplier lambda
   * @return {@code supplier}
   */
  public static <R, E extends Exception> RexSupplier<R, E>
  supplier(RexSupplier<? extends R, ? extends E> supplier) { return RexSupplier.castDown(supplier); }

  /**
   * This method simplifies the creation of {@link RexFunction} lambdas in
   * places where a {@link Function} is expected or a disambiguation between
   * {@link RexFunction} and {@link RexConsumer} is required.
   * <p>
   * E.g. {@code Stream.map(Rex.function(element -> {...code throwing checked exception...}))}
   *
   * @param <X> parameter type
   * @param <R> return type
   * @param <E> upper exception limit
   * @param function lambda
   * @return {@code function}
   */
  public static <X, R, E extends Exception> RexFunction<X, R, E>
  function(RexFunction<? super X, ? extends R, ? extends E> function) { return RexFunction.castDown(function); }

  /**
   * This method simplifies the creation of {@link RexBiFunction} lambdas in
   * places where a {@link BiFunction} is expected or a disambiguation between
   * {@link RexBiFunction} and {@link RexBiConsumer} is required.
   * <p>
   * E.g. {@code map.replaceAll(Rex.biFunction((key, value) -> {...code throwing checked exception...}))}
   *
   * @param <X> first parameter type
   * @param <Y> second parameter type
   * @param <R> return type
   * @param <E> upper exception limit
   * @param biFunction lambda
   * @return {@code biFunction}
   */
  public static <X, Y, R, E extends Exception> RexBiFunction<X, Y, R, E>
  biFunction(RexBiFunction<? super X, ? super Y, ? extends R, ? extends E> biFunction) { return RexBiFunction.castDown(biFunction); }

  /**
   * This method simplifies the creation of {@link RexConsumer} lambdas in
   * places where a {@link Consumer} is expected or a disambiguation between
   * {@link RexFunction} and {@link RexConsumer} is required.
   * <p>
   * E.g. {@code stream.forEach(Rex.consumer(element -> {...code throwing checked exception...}))}
   *
   * @param <X> parameter type
   * @param <E> upper exception limit
   * @param consumer lambda
   * @return {@code consumer}
   */
  public static <X, E extends Exception> RexConsumer<X, E>
  consumer(RexConsumer<? super X, ? extends E> consumer) { return RexConsumer.castDown(consumer); }

  /**
   * This method simplifies the creation of {@link RexBiConsumer} lambdas in
   * places where a {@link BiConsumer} is expected or a disambiguation between
   * {@link RexBiFunction} and {@link RexBiConsumer} is required.
   * <p>
   * E.g. {@code map.forEach(Rex.biConsumer((key, value) -> {...code throwing checked exception...}))}
   *
   * @param <X> first parameter type
   * @param <Y> second parameter type
   * @param <E> upper exception limit
   * @param biConsumer lambda
   * @return {@code biConsumer}
   */
  public static <X, Y, E extends Exception> RexBiConsumer<X, Y, E>
  biConsumer(RexBiConsumer<? super X, ? super Y, ? extends E> biConsumer) { return RexBiConsumer.castDown(biConsumer); }

  /**
   * This method simplifies the creation of {@link RexPredicate} lambdas in
   * places where a {@link Predicate} is expected or a disambiguation between
   * {@link RexFunction} and {@link RexPredicate} is required.
   * <p>
   * E.g. {@code stream.filter(Rex.predicate(element -> {...code throwing checked exception...}))}
   *
   * @param <X> parameter type
   * @param <E> upper exception limit
   * @param predicate lambda
   * @return {@code predicate}
   */
  public static <X, E extends Exception> RexPredicate<X, E>
  predicate(RexPredicate<? super X, ? extends E> predicate) { return RexPredicate.castDown(predicate); }

  /**
   * This method simplifies the creation of {@link RexBiPredicate} lambdas in
   * places where a {@link BiPredicate} is expected or a disambiguation between
   * {@link RexFunction} and {@link RexBiPredicate} is required.
   * <p>
   * E.g. {@code Files.find(start, depth, Rex.biPredicate((path, attributes) -> {...code throwing checked exception...}))}
   *
   * @param <X> first parameter type
   * @param <Y> second parameter type
   * @param <E> upper exception limit
   * @param biPredicate lambda
   * @return {@code biPredicate}
   */
  public static <X, Y, E extends Exception> RexBiPredicate<X, Y, E>
  biPredicate(RexBiPredicate<? super X, ? super Y, ? extends E> biPredicate) { return RexBiPredicate.castDown(biPredicate); }

  /**
   * This method is equivalent to {@code function(operator)}.
   *
   * @param <X> parameter type
   * @param <E> upper exception limit
   * @param operator lambda
   * @return {@code operator}
   */
  public static <X, E extends Exception> RexFunction<X, X, E>
  unaryOp(RexFunction<? super X, ? extends X, ? extends E> operator) { return RexFunction.castDown(operator); }

  /**
   * This method is equivalent to {@code biFunction(operator)}.
   *
   * @param <X> parameter type
   * @param <E> upper exception limit
   * @param operator lambda
   * @return {@code operator}
   */
  public static <X, E extends Exception> RexBiFunction<X, X, X, E>
  binaryOp(RexBiFunction<? super X, ? super X, ? extends X, ? extends E> operator) { return RexBiFunction.castDown(operator); }

  /**
   * This method is equivalent to {@code biPredicate(relation)}.
   *
   * @param <X> parameter type
   * @param <E> upper exception limit
   * @param relation lambda
   * @return {@code operator}
   */
  public static <X, E extends Exception> RexBiPredicate<X, X, E>
  relation(RexBiPredicate<? super X, ? super X, ? extends E> relation) { return RexBiPredicate.castDown(relation); }

  /**
   * Bridge {@link LavaRunnable} to {@link Runnable} by wrapping checked
   * exceptions raised.
   *
   * @param <E> upper exception limit
   * @param checked {@link LavaRunnable} to wrap
   * @return {@link RexRunnable} wrapping {@code checked}
   */
  public static <E extends Exception> RexRunnable<E>
  rex(LavaRunnable<? extends E> checked) { return RexRunnable.castDown(checked::checkedRun); }

  /**
   * Bridge {@link LavaConsumer} to {@link Consumer} by wrapping checked
   * exceptions raised.
   *
   * @param <X> parameter type
   * @param <E> upper exception limit
   * @param checked {@link LavaConsumer} to wrap
   * @return {@link RexConsumer} wrapping {@code checked}
   */
  public static <X, E extends Exception> RexConsumer<X, E>
  rex(LavaConsumer<? super X, ? extends E> checked) { return RexConsumer.castDown(checked::checkedAccept); }

  /**
   * Bridge {@link LavaBiConsumer} to {@link BiConsumer} by wrapping checked
   * exceptions raised.
   *
   * @param <X> first parameter type
   * @param <Y> second parameter type
   * @param <E> upper exception limit
   * @param checked {@link LavaBiConsumer} to wrap
   * @return {@link RexBiConsumer} wrapping {@code checked}
   */
  public static <X, Y, E extends Exception> RexBiConsumer<X, Y, E>
  rex(LavaBiConsumer<? super X, ? super Y, ? extends E> checked) { return RexBiConsumer.castDown(checked::checkedAccept); }

  /**
   * Bridge {@link LavaSupplier} to {@link Supplier} by wrapping checked
   * exceptions raised.
   *
   * @param <R> return type
   * @param <E> upper exception limit
   * @param checked {@link LavaSupplier} to wrap
   * @return {@link RexSupplier} wrapping {@code checked}
   */
  public static <R, E extends Exception> RexSupplier<R, E>
  rex(LavaSupplier<? extends R, ? extends E> checked) { return RexSupplier.castDown(checked::checkedGet); }

  /**
   * Bridge {@link LavaFunction} to {@link Function} by wrapping checked
   * exceptions raised.
   *
   * @param <X> parameter type
   * @param <R> return type
   * @param <E> upper exception limit
   * @param checked {@link LavaFunction} to wrap
   * @return {@link RexFunction} wrapping {@code checked}
   */
  public static <X, R, E extends Exception> RexFunction<X, R, E>
  rex(LavaFunction<? super X, ? extends R, ? extends E> checked) { return RexFunction.castDown(checked::checkedApply); }

  /**
   * Bridge {@link LavaBiFunction} to {@link BiFunction} by wrapping checked
   * exceptions raised.
   *
   * @param <X> first parameter type
   * @param <Y> second parameter type
   * @param <R> return type
   * @param <E> upper exception limit
   * @param checked {@link LavaBiFunction} to wrap
   * @return {@link RexBiFunction} wrapping {@code checked}
   */
  public static <X, Y, R, E extends Exception> RexBiFunction<X, Y, R, E>
  rex(LavaBiFunction<? super X, ? super Y, ? extends R, ? extends E> checked) { return RexBiFunction.castDown(checked::checkedApply); }

  /**
   * Bridge {@link LavaCondition} to {@link BooleanSupplier} by wrapping checked
   * exceptions raised.
   *
   * @param <E> upper exception limit
   * @param checked {@link LavaCondition} to wrap
   * @return {@link RexCondition} wrapping {@code checked}
   */
  public static <E extends Exception> RexCondition<E>
  rex(LavaCondition<? extends E> checked) { return RexCondition.castDown(checked::checkedTest); }

  /**
   * Bridge {@link LavaPredicate} to {@link Predicate} by wrapping checked
   * exceptions raised.
   *
   * @param <X> parameter type
   * @param <E> upper exception limit
   * @param checked {@link LavaPredicate} to wrap
   * @return {@link RexPredicate} wrapping {@code checked}
   */
  public static <X, E extends Exception> RexPredicate<X, E>
  rex(LavaPredicate<? super X, ? extends E> checked) { return RexPredicate.castDown(checked::checkedTest); }

  /**
   * Bridge {@link LavaBiPredicate} to {@link BiPredicate} by wrapping checked
   * exceptions raised.
   *
   * @param <X> first parameter type
   * @param <Y> second parameter type
   * @param <E> upper exception limit
   * @param checked {@link LavaConsumer} to wrap
   * @return {@link RexConsumer} wrapping {@code checked}
   */
  public static <X, Y, E extends Exception> RexBiPredicate<X, Y, E>
  rex(LavaBiPredicate<? super X, ? super Y, ? extends E> checked) { return RexBiPredicate.castDown(checked::checkedTest); }

  /**
   * Convenience method invoking {@link LavaRunnable} wrapping checked
   * exceptions raised.
   * <p>
   * Equivalent to {@code rex(checked).run()}
   *
   * @param checked {@link LavaRunnable} to invoke
   */
  public static void
  invoke(LavaRunnable<?> checked) {
    wrapCheckedException(checked);
  }

  /**
   * Convenience method invoking {@link LavaConsumer} wrapping checked
   * exceptions raised.
   * <p>
   * Equivalent to {@code rex(checked).accept(x)}
   *
   * @param <X> parameter type
   * @param checked {@link LavaConsumer} to invoke
   * @param x parameter to {@code checked}
   */
  public static <X> void
  invoke(LavaConsumer<X, ?> checked, X x) {
    rex(checked).accept(x);
  }

  /**
   * Convenience method invoking {@link LavaBiConsumer} wrapping checked
   * exceptions raised.
   * <p>
   * Equivalent to {@code rex(checked).accept(x, y)}
   *
   * @param <X> first parameter type
   * @param <Y> second parameter type
   * @param checked {@link LavaBiConsumer} to invoke
   * @param x first parameter to {@code checked}
   * @param y second parameter to {@code checked}
   */
  public static <X, Y> void
  invoke(LavaBiConsumer<X, Y, ?> checked, X x, Y y) {
    rex(checked).accept(x, y);
  }

  /**
   * Convenience method invoking {@link LavaSupplier} wrapping checked
   * exceptions raised.
   * <p>
   * Equivalent to {@code rex(checked).get()}
   *
   * @param <R> return type
   * @param checked {@link LavaSupplier} to invoke
   * @return result of invoking {@code checked}
   */
  public static <R> R
  invoke(LavaSupplier<R, ?> checked) {
    return wrapCheckedException(checked);
  }

  /**
   * Convenience method invoking {@link LavaFunction} wrapping checked
   * exceptions raised.
   * <p>
   * Equivalent to {@code rex(checked).apply(x)}
   *
   * @param <X> parameter type
   * @param <R> return type
   * @param checked {@link LavaFunction} to invoke
   * @param x parameter to {@code checked}
   * @return result of invoking {@code checked}
   */
  public static <X, R> R
  invoke(LavaFunction<X, R, ?> checked, X x) {
    return rex(checked).apply(x);
  }

  /**
   * Convenience method invoking {@link LavaBiFunction} wrapping checked
   * exceptions raised.
   * <p>
   * Equivalent to {@code rex(checked).apply(x, y)}
   *
   * @param <X> first parameter type
   * @param <Y> second parameter type
   * @param <R> return type
   * @param checked {@link LavaBiFunction} to invoke
   * @param x first parameter to {@code checked}
   * @param y second parameter to {@code checked}
   * @return result of invoking {@code checked}
   */
  public static <X, Y, R> R
  invoke(LavaBiFunction<X, Y, R, ?> checked, X x, Y y) {
    return rex(checked).apply(x, y);
  }

  /**
   * Convenience method invoking {@link LavaCondition} wrapping checked
   * exceptions raised.
   * <p>
   * Equivalent to {@code rex(checked).apply(x)}
   *
   * @param <X> parameter type
   * @param checked {@link LavaCondition} to invoke
   * @return result of invoking {@code checked}
   */
  public static <X> boolean
  invoke(LavaCondition<?> checked) {
    return rex(checked).getAsBoolean();
  }

  /**
   * Convenience method invoking {@link LavaPredicate} wrapping checked
   * exceptions raised.
   * <p>
   * Equivalent to {@code rex(checked).apply(x)}
   *
   * @param <X> parameter type
   * @param checked {@link LavaPredicate} to invoke
   * @param x first parameter to {@code checked}
   * @return result of invoking {@code checked}
   */
  public static <X> boolean
  invoke(LavaPredicate<X, ?> checked, X x) {
    return rex(checked).test(x);
  }

  /**
   * Convenience method invoking {@link LavaBiPredicate} wrapping checked
   * exceptions raised.
   * <p>
   * Equivalent to {@code rex(checked).apply(x, y)}
   *
   * @param <X> first parameter type
   * @param <Y> second parameter type
   * @param checked {@link LavaBiPredicate} to invoke
   * @param x first parameter to {@code checked}
   * @param y second parameter to {@code checked}
   * @return result of invoking {@code checked}
   */
  public static <X, Y> boolean
  invoke(LavaBiPredicate<X, Y, ?> checked, X x, Y y) {
    return rex(checked).test(x, y);
  }
}
