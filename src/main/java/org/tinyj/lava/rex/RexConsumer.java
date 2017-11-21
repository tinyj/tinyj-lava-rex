package org.tinyj.lava.rex;

import org.tinyj.lava.LavaConsumer;
import org.tinyj.lava.WrappedCheckedException;

import java.util.function.Consumer;

import static org.tinyj.lava.WrappedCheckedException.wrapCheckedException;

/**
 * An operation on an input value.
 * <p>
 * This interface bridges {@link LavaConsumer} and {@link Consumer} by
 * wrapping checked exceptions raised during invocation of {@link #accept}
 * into a {@link WrappedCheckedException}.
 * <p>
 * Usually invoking a consumer results in side effects. Subsequent
 * invocations may or may not result in further side effects.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedAccept}
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
   *     {@link WrappedCheckedException}.
   */
  @Override
  default void accept(X x) {
    try {
      checkedAccept(x);
    } catch (Exception e) {
      throw wrapCheckedException(e);
    }
  }

  /**
   * Safely casts between different {@link RexConsumer} parametrization
   *
   * @param <X> accepted input type
   * @param <E> required exception limit
   * @param consumer consumer to adopt
   * @return {@code consumer} casted to the compatible parametrization
   *     {@link RexConsumer}{@code <X, E>}
   */
  @SuppressWarnings("unchecked")
  static <X, E extends Exception>
  RexConsumer<X, E> castDown(RexConsumer<? super X, ? extends E> consumer) { return (RexConsumer<X, E>) consumer; }
}
