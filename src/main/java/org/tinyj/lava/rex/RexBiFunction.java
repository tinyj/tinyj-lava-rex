package org.tinyj.lava.rex;

import org.tinyj.lava.LavaBiFunction;
import org.tinyj.lava.WrappedCheckedException;

import java.util.function.BiFunction;

import static org.tinyj.lava.WrappedCheckedException.wrapCheckedException;

/**
 * A bi-function maps its two argument to a result.
 * <p>
 * This interface bridges {@link LavaBiFunction} and {@link BiFunction} by
 * wrapping checked exceptions raised during invocation of {@link #apply}
 * into a {@link WrappedCheckedException}.
 * <p>
 * While not strictly required it usually is expected that subsequent
 * invocations with the same arguments yield equal results.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedApply}.
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
   * @throws RuntimeException Checked exception raised during invocation will be
   *     wrapped in a {@link WrappedCheckedException}.
   */
  @Override
  default R apply(X x, Y y) {
    try {
      return checkedApply(x, y);
    } catch (Exception e) {
      throw wrapCheckedException(e);
    }
  }

  /**
   * Safely casts between different {@link RexBiFunction} parametrizations
   *
   * @param <X> first accepted argument type
   * @param <Y> second accepted argument type
   * @param <R> required result type
   * @param <E> required exception limit
   * @param biFunction bi-function to adopt
   * @return {@code biFunction} casted to the compatible parametrization
   *     {@link RexBiFunction}{@code <X, Y, R, E>}
   */
  @SuppressWarnings("unchecked")
  static <X, Y, R, E extends Exception>
  RexBiFunction<X, Y, R, E> castDown(RexBiFunction<? super X, ? super Y, ? extends R, ? extends E> biFunction) {
    return (RexBiFunction<X, Y, R, E>) biFunction;
  }
}
