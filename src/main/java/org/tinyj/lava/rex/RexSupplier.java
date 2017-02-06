package org.tinyj.lava.rex;

import org.tinyj.lava.LavaSupplier;
import org.tinyj.lava.Rex;

import java.util.function.Supplier;

/**
 * A supplier of values. This interface bridges
 * [LavaSupplier](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#lavasupplierr-e)
 * and
 * [Supplier](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html)
 * by wrapping checked exceptions raised during invocation of `get(...)` into a
 * [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).
 *
 * There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 *
 * This is a functional interface whose functional method is `checkedGet()`.
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
   * @throws RuntimeException Checked exception raised during invocation will be wrapped in a
   * [WrappedCheckedException](https://github.com/tinyj/tinyj-lava-api/blob/master/APIdoc.md#wrappedcheckedexception).
   */
  @Override
  default R get() {
    return Rex.invoke(this);
  }

  /**
   * Safely casts between different (#RexSupplier) parametrization
   *
   * @param <R> required result type
   * @param <E> required exception limit
   * @param supplier supplier to adopt
   * @return `supplier` casted to the compatible parametrization (#RexSupplier)`<R, E>`
   */
  @SuppressWarnings("unchecked")
  static <R, E extends Exception>
  RexSupplier<R, E> castDown(RexSupplier<? extends R, ? extends E> supplier) {
    return (RexSupplier<R, E>) supplier;
  }
}
