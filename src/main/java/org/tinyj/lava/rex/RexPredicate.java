package org.tinyj.lava.rex;

import org.tinyj.lava.LavaPredicate;
import org.tinyj.lava.WrappedCheckedException;

import java.util.function.Predicate;

import static org.tinyj.lava.WrappedCheckedException.wrapCheckedException;

/**
 * A special kind of function mapping its argument to a {@code boolean} result.
 * <p>
 * This interface bridges {@link LavaPredicate} and {@link Predicate} by
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
public interface RexPredicate<X, E extends Exception>
    extends Predicate<X>, LavaPredicate<X, E> {

  /**
   * Test if the argument matches the predicate, wrap checked Exceptions.
   *
   * @param x argument to the match
   * @return {@code true} if {@code x} matches, {@code false} otherwise
   * @throws RuntimeException Checked exception raised during invocation will be
   *     wrapped in a {@link WrappedCheckedException}.
   */
  @Override
  default boolean test(X x) {
    try {
      return checkedTest(x);
    } catch (Exception e) {
      throw wrapCheckedException(e);
    }

  }

  /**
   * Safely casts between different {@link RexPredicate} parametrization
   *
   * @param <X> accepted argument type
   * @param <E> required exception limit
   * @param predicate predicate to adopt
   * @return {@code predicate} casted to the compatible parametrization
   *     {@link RexPredicate}{@code <X, E>}
   */
  @SuppressWarnings("unchecked")
  static <X, E extends Exception>
  RexPredicate<X, E> castDown(RexPredicate<? super X, ? extends E> predicate) { return (RexPredicate<X, E>) predicate; }
}
