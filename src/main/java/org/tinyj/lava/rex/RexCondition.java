package org.tinyj.lava.rex;

import org.tinyj.lava.LavaCondition;
import org.tinyj.lava.WrappedCheckedException;

import java.util.function.BooleanSupplier;

import static org.tinyj.lava.WrappedCheckedException.wrapCheckedException;

/**
 * A supplier of values.
 * <p>
 * This interface bridges {@link LavaCondition} and {@link BooleanSupplier} by
 * wrapping checked exceptions raised during invocation of {@link #getAsBoolean}
 * into a {@link WrappedCheckedException}.
 * <p>
 * There is no requirement that a new or distinct result be returned each time
 * the supplier is invoked.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedTest}.
 *
 * @param <E> upper limit of thrown exception types
 */
@FunctionalInterface
public interface RexCondition<E extends Exception>
    extends BooleanSupplier, LavaCondition<E> {

  /**
   * Produce a value, wrap checked Exceptions.
   *
   * @return a value
   * @throws RuntimeException Checked exception raised during invocation will be
   *     wrapped in a {@link WrappedCheckedException}.
   */
  @Override
  default boolean getAsBoolean() {
    try {
      return checkedTest();
    } catch (Exception e) {
      throw wrapCheckedException(e);
    }
  }

  /**
   * Safely casts between different {@link RexCondition} parametrization
   *
   * @param <E> required exception limit
   * @param supplier supplier to adopt
   * @return {@code supplier} casted to the compatible parametrization {@link RexCondition}{@code <R, E>}
   */
  @SuppressWarnings("unchecked")
  static <E extends Exception>
  RexCondition<E> castDown(RexCondition<? extends E> supplier) {
    return (RexCondition<E>) supplier;
  }
}
