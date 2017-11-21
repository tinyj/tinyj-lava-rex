package org.tinyj.lava.rex;

import org.tinyj.lava.LavaBiConsumer;
import org.tinyj.lava.WrappedCheckedException;

import java.util.function.BiConsumer;

import static org.tinyj.lava.WrappedCheckedException.wrapCheckedException;

/**
 * An operation on two input values.
 * <p>
 * This interface bridges {@link LavaBiConsumer} and {@link BiConsumer} by
 * wrapping checked exceptions raised during invocation of {@link #accept}
 * into a {@link WrappedCheckedException}.
 * <p>
 * Usually invoking a bi-consumer results in side effects. Subsequent
 * invocations may or may not result in further side effects.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedAccept}.
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
   * @throws RuntimeException Checked exception raised during invocation will be
   *     wrapped in a {@link WrappedCheckedException}.
   */
  @Override
  default void accept(X x, Y y) {
    try {
      checkedAccept(x, y);
    } catch (Exception e) {
      throw wrapCheckedException(e);
    }
  }

  /**
   * Safely casts between different {@link RexBiConsumer} parametrization
   *
   * @param <X> first accepted input type
   * @param <Y> second accepted input type
   * @param <E> required exception limit
   * @param biConsumer bi-consumer to adopt
   * @return {@code biConsumer} casted to the compatible parametrization
   *     {@link RexBiConsumer}{@code <X, Y, E>}
   */
  @SuppressWarnings("unchecked")
  static <X, Y, E extends Exception>
  RexBiConsumer<X, Y, E> castDown(RexBiConsumer<? super X, ? super Y, ? extends E> biConsumer) {
    return (RexBiConsumer<X, Y, E>) biConsumer;
  }
}
