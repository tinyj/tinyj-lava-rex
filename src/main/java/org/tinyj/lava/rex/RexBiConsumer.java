package org.tinyj.lava.rex;

import org.tinyj.lava.LavaBiConsumer;
import org.tinyj.lava.Rex;

import java.util.function.BiConsumer;

/**
 * An operation on two input values. This interface bridges
 * [LavaBiConsumer](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavabiconsumerx-y-e)
 * and
 * [BiConsumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html)
 * by wrapping checked exceptions raised during invocation of `accept(...)` into a
 * [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).
 *
 * Usually invoking a bi-consumer results in side effects. Subsequent
 * invocations may or may not result in further side effects.
 *
 * This is a functional interface whose functional method is `checkedAccept(X, Y)`.
 *
 * @param <X> first consumed value type
 * @param <Y> second consumed value type
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface RexBiConsumer<X, Y, E extends Exception>
    extends BiConsumer<X, Y>, LavaBiConsumer<X, Y, E> {

  /**
   * Perform operation on inputs, wrap checked exceptions.
   *
   * @param x first consumed value
   * @param y second consumed value
   * @throws RuntimeException Checked exception raised during invocation will be wrapped in a
   * [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).
   */
  @Override
  default void accept(X x, Y y) {
    Rex.invoke(this, x, y);
  }

  /**
   * Safely casts between different (#RexBiConsumer) parametrization
   *
   * @param <X> first accepted input type
   * @param <Y> second accepted input type
   * @param <E> required exception limit
   * @param biConsumer bi-consumer to adopt
   * @return `biConsumer` casted to the compatible parametrization (#RexBiConsumer)`<X, Y, E>`
   */
  @SuppressWarnings("unchecked")
  static <X, Y, E extends Exception>
  RexBiConsumer<X, Y, E> castDown(RexBiConsumer<? super X, ? super Y, ? extends E> biConsumer) {
    return (RexBiConsumer<X, Y, E>) biConsumer;
  }
}
