package org.tinyj.lava.rex;

import org.tinyj.lava.LavaPredicate;
import org.tinyj.lava.Rex;

import java.util.function.Predicate;

/**
 * A special kind of function mapping its argument to
 * a {@code boolean} result.
 * This interface bridges
 * [LavaPredicate](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavapredicatex-e)
 * and
 * [Predicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html)
 * by wrapping checked exceptions raised during invocation of `test(...)` into a
 * [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).
 *
 * While not strictly required it usually is expected that subsequent
 * invocations with the same argument yield equal results.
 *
 * This is a functional interface whose functional method is {@link #checkedTest(X)}.
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
   * @return `true` if `x` matches, `false` otherwise
   * @throws RuntimeException Checked exception raised during invocation will be wrapped in a
   * [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).
   */
  @Override
  default boolean test(X x) {
    return Rex.invoke(this, x);
  }

  /**
   * Safely casts between different (#RexPredicate) parametrization
   *
   * @param <X> accepted argument type
   * @param <E> required exception limit
   * @param predicate predicate to adopt
   * @return `predicate` casted to the compatible parametrization (#RexPredicate)`<X, E>`
   */
  @SuppressWarnings("unchecked")
  static <X, E extends Exception>
  RexPredicate<X, E> castDown(RexPredicate<? super X, ? extends E> predicate) { return (RexPredicate<X, E>) predicate; }
}
