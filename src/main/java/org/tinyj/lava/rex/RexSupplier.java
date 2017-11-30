package org.tinyj.lava.rex;

import org.tinyj.lava.LavaSupplier;
import org.tinyj.lava.WrappedCheckedException;

import java.util.function.Supplier;

import static org.tinyj.lava.WrappedCheckedException.wrapCheckedException;

/**
 * A supplier of values.
 * <p>
 * This interface bridges {@link LavaSupplier} and {@link Supplier} by
 * wrapping checked exceptions raised during invocation of {@link #get}
 * into a {@link WrappedCheckedException}.
 * <p>
 * There is no requirement that a new or distinct result be returned each time
 * the supplier is invoked.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedGet}.
 *
 * @param <R> type of supplied values
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface RexSupplier<R, E extends Exception>
    extends Supplier<R>, LavaSupplier<R, E> {

  /**
   * Produce a value, wrap checked Exceptions.
   *
   * @return a value
   * @throws RuntimeException Checked exception raised during invocation will be
   *     wrapped in a {@link WrappedCheckedException}.
   */
  @Override
  default R get() {
    return wrapCheckedException(this);
  }

  /**
   * Safely casts between different {@link RexSupplier} parametrization
   *
   * @param <R> required result type
   * @param <E> required exception limit
   * @param supplier supplier to adopt
   * @return {@code supplier} casted to the compatible parametrization {@link RexSupplier}{@code <R, E>}
   */
  @SuppressWarnings("unchecked")
  static <R, E extends Exception>
  RexSupplier<R, E> castDown(RexSupplier<? extends R, ? extends E> supplier) {
    return (RexSupplier<R, E>) supplier;
  }
}
