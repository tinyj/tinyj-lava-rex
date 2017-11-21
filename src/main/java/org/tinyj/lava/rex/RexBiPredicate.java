package org.tinyj.lava.rex;

import org.tinyj.lava.LavaBiPredicate;
import org.tinyj.lava.WrappedCheckedException;

import java.util.function.BiPredicate;

import static org.tinyj.lava.WrappedCheckedException.wrapCheckedException;

/**
 * A special kind of bi-function mapping its arguments to a {@code boolean}.
 * <p>
 * This interface bridges {@link LavaBiPredicate} and {@link BiPredicate} by
 * wrapping checked exceptions raised during invocation of {@link #test}
 * into a {@link WrappedCheckedException}.
 * <p>
 * While not strictly required it usually is expected that subsequent
 * invocations with the same argument yield equal results.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedTest}.
 *
 * @param <X> the function's argument type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface RexBiPredicate<X, Y, E extends Exception>
    extends BiPredicate<X, Y>, LavaBiPredicate<X, Y, E> {

  /**
   * Test if the arguments matches the predicate, wrap checked exceptions.
   *
   * @param x first argument to the match
   * @param y second argument to the match
   * @return {@code true} if {@code x, y} matches, {@code false} otherwise
   * @throws RuntimeException Checked exception raised during invocation will be
   *     wrapped in a {@link WrappedCheckedException}.
   */
  @Override
  default boolean test(X x, Y y) {
    try {
      return checkedTest(x, y);
    } catch (Exception e) {
      throw wrapCheckedException(e);
    }

  }

  /**
   * Safely casts between different {@link RexBiPredicate}parametrization
   *
   * @param <X> first accepted argument type
   * @param <Y> second accepted argument type
   * @param <E> required exception limit
   * @param biPredicate bi-predicate to adopt
   * @return {@code biPredicate} casted to the compatible parametrization
   *     {@link RexBiPredicate}{@code <X, E>}
   */
  @SuppressWarnings("unchecked")
  static <X, Y, E extends Exception>
  RexBiPredicate<X, Y, E> castDown(RexBiPredicate<? super X, ? super Y, ? extends E> biPredicate) {
    return (RexBiPredicate<X, Y, E>) biPredicate;
  }
}
