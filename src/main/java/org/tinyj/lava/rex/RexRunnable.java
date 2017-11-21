package org.tinyj.lava.rex;

import org.tinyj.lava.LavaRunnable;
import org.tinyj.lava.WrappedCheckedException;

import static org.tinyj.lava.WrappedCheckedException.wrapCheckedException;

/**
 * A runnable task.
 * <p>
 * This interface bridges {@link LavaRunnable} and {@link Runnable} by
 * wrapping checked exceptions raised during invocation of {@link #run}
 * into a {@link WrappedCheckedException}.
 * <p>
 * Usually invoking a runnable results in side effects. Subsequent
 * invocations may or may not result in further side effects.
 * <p>
 * This is a functional interface whose functional method is
 * {@link #checkedRun}.
 *
 * @param <E> upper limit of thrown exception types
 */

@FunctionalInterface
public interface RexRunnable<E extends Exception>
    extends Runnable, LavaRunnable<E> {

  /**
   * Execute the task, wrap checked Exceptions.
   *
   * @throws RuntimeException Checked exception raised during invocation will be
   *     wrapped in a {@link WrappedCheckedException}.
   */
  @Override
  default void run() {
    wrapCheckedException(this);
  }

  /**
   * Safely casts between different {@link RexRunnable} parametrization
   *
   * @param <E> required exception limit
   * @param runnable runnable to adopt
   * @return {@code runnable} casted to the compatible parametrization
   *     {@link RexRunnable}{@code <E>}
   */
  @SuppressWarnings("unchecked")
  static <E extends Exception>
  RexRunnable<E> castDown(RexRunnable<? extends E> runnable) {
    return (RexRunnable<E>) runnable;
  }
}
