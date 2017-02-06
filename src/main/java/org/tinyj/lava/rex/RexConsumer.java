package org.tinyj.lava.rex;

import org.tinyj.lava.LavaConsumer;
import org.tinyj.lava.Rex;

import java.util.function.Consumer;

/**
 * An operation on an input value. This interface bridges
 * [LavaConsumer](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavaconsumerx-e)
 * and
 * [Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)
 * by wrapping checked exceptions raised during invocation of `accept(...)` into a
 * [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).
 *
 * Usually invoking a consumer results in side effects. Subsequent
 * invocations may or may not result in further side effects.
 *
 * This is a functional interface whose functional method is `checkedAccept(X)`.
 *
 * @param <X> consumed value type
 * @param <E> upper limit of thrown exception types
 */

@FunctionalInterface
public interface RexConsumer<X, E extends Exception>
    extends Consumer<X>, LavaConsumer<X, E> {

  /**
   * Perform operation on input, wrap checked exceptions.
   *
   * @param x consumed value
   * @throws RuntimeException Checked exception raised during invocation will be wrapped in a
   * [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).
   */
  @Override
  default void accept(X x) {
    Rex.invoke(this, x);
  }

  /**
   * Safely casts between different (#RexConsumer) parametrization
   *
   * @param <X> accepted input type
   * @param <E> required exception limit
   * @param consumer consumer to adopt
   * @return `consumer` casted to the compatible parametrization (#RexConsumer)`<X, E>`
   */
  @SuppressWarnings("unchecked")
  static <X, E extends Exception>
  RexConsumer<X, E> castDown(RexConsumer<? super X, ? extends E> consumer) { return (RexConsumer<X, E>) consumer; }
}
