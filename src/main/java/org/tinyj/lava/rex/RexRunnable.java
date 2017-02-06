package org.tinyj.lava.rex;

import org.tinyj.lava.LavaRunnable;
import org.tinyj.lava.Rex;

/**
 * A runnable task. This interface bridges
 * [LavaRunnable](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavarunnablee)
 * and
 * [Runnable](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html)
 * by wrapping checked exceptions raised during invocation of `run(...)` into a
 * [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).
 *
 * Usually invoking a runnable results in side effects. Subsequent
 * invocations may or may not result in further side effects.
 *
 * This is a functional interface whose functional method is `checkedRun()`.
 *
 * @param <E> upper limit of thrown exception types
 */

@FunctionalInterface
public interface RexRunnable<E extends Exception>
    extends Runnable, LavaRunnable<E> {

  /**
   * Execute the task, wrap checked Exceptions.
   *
   * @throws RuntimeException Checked exception raised during invocation will be wrapped in a
   * [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).
   */
  @Override
  default void run() {
    Rex.invoke(this);
  }

  /**
   * Safely casts between different (#RexRunnable) parametrization
   *
   * @param <E> required exception limit
   * @param runnable runnable to adopt
   * @return `runnable` casted to the compatible parametrization (#RexRunnable)`<E>`
   */
  @SuppressWarnings("unchecked")
  static <E extends Exception>
  RexRunnable<E> castDown(RexRunnable<? extends E> runnable) {
    return (RexRunnable<E>) runnable;
  }
}
