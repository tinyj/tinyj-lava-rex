package org.tinyj.lava.rex;

import org.tinyj.lava.LavaFunction;
import org.tinyj.lava.Rex;
import org.tinyj.lava.WrappedCheckedException;

import java.util.function.Function;

/**
 * A function maps its argument to a result.
 * <p>
 * This interface bridges {@link LavaFunction} and {@link Function} by
 * wrapping checked exceptions raised during invocation of {@link #apply}
 * into a {@link WrappedCheckedException}.
 * <p>
 * While not strictly required it usually is expected that subsequent
 * invocations with the same argument yield equal results.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedApply}.
 *
 * @param <X> the function's argument type
 * @param <R> the function's result type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface RexFunction<X, R, E extends Exception>
    extends Function<X, R>, LavaFunction<X, R, E> {

  /**
   * Apply the function to an argument, wrap checked exceptions.
   *
   * @param x argument to map
   * @return the function's result
   * @throws RuntimeException Checked exception raised during invocation will be
   *     wrapped in a {@link WrappedCheckedException}.
   */
  @Override
  default R apply(X x) {
    return Rex.invoke(this, x);
  }

  /**
   * Safely casts between different {@link RexFunction} parametrization
   *
   * @param <X> accepted argument type
   * @param <R> required result type
   * @param <E> required exception limit
   * @param function function to adopt
   * @return {@code function} casted to the compatible parametrization
   *     {@link RexFunction}{@code <X, R, E>}
   */
  @SuppressWarnings("unchecked")
  static <X, R, E extends Exception>
  RexFunction<X, R, E> castDown(RexFunction<? super X, ? extends R, ? extends E> function) { return (RexFunction<X, R, E>) function; }
}
