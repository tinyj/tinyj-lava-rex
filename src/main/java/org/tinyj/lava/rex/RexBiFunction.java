package org.tinyj.lava.rex;

import org.tinyj.lava.LavaBiFunction;
import org.tinyj.lava.Rex;

import java.util.function.BiFunction;

/**
 * A bi-function maps its two argument to a result. This interface bridges
 * [LavaBiFunction](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabifunctionx-y-r-e)
 * and
 * [BiFunction](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html)
 * by wrapping checked exceptions raised during invocation of `apply(...)` into a
 * [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).
 *
 * While not strictly required it usually is expected that subsequent
 * invocations with the same arguments yield equal results.
 *
 * This is a functional interface whose functional method is `checkedApply(X, Y)`.
 *
 * @param <X> the bi-function's first argument type
 * @param <Y> the bi-function's second argument type
 * @param <R> the bi-function's result type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface RexBiFunction<X, Y, R, E extends Exception>
    extends BiFunction<X, Y, R>, LavaBiFunction<X, Y, R, E> {

  /**
   * Apply the function to arguments, wrap checked exceptions.
   *
   * @param x first argument to map
   * @param y second argument to map
   * @return the function's result
   * @throws RuntimeException Checked exception raised during invocation will be wrapped in a
   * [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).
   */
  @Override
  default R apply(X x, Y y) {
    return Rex.invoke(this, x, y);
  }

  /**
   * Safely casts between different (#RexBiFunction) parametrization
   *
   * @param <X> first accepted argument type
   * @param <Y> second accepted argument type
   * @param <R> required result type
   * @param <E> required exception limit
   * @param biFunction bi-function to adopt
   * @return `biFunction` casted to the compatible parametrization (#RexBiFunction)`<X, Y, R, E>`
   */
  @SuppressWarnings("unchecked")
  static <X, Y, R, E extends Exception>
  RexBiFunction<X, Y, R, E> castDown(RexBiFunction<? super X, ? super Y, ? extends R, ? extends E> biFunction) {
    return (RexBiFunction<X, Y, R, E>) biFunction;
  }
}
