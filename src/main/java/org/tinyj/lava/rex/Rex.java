package org.tinyj.lava.rex;

import org.tinyj.lava.throwing.*;

import java.util.function.*;

import static org.tinyj.lava.rex.UncheckedException.wrapCheckedException;

public class Rex {

  public static Runnable
  run(ThrowingRunnable<?> throwing) {
    return () -> {
      try {
        throwing.run();
      } catch (Exception e) {
        throw wrapCheckedException(e);
      }
    };
  }

  public static <X> Consumer<X>
  accept(ThrowingConsumer<X, ?> throwing) {
    return x -> {
      try {
        throwing.accept(x);
      } catch (Exception e) {
        throw wrapCheckedException(e);
      }
    };
  }

  public static <X, Y> BiConsumer<X, Y>
  accept(ThrowingBiConsumer<X, Y, ?> throwing) {
    return (x, y) -> {
      try {
        throwing.accept(x, y);
      } catch (Exception e) {
        throw wrapCheckedException(e);
      }
    };
  }

  public static <R> Supplier<R>
  get(ThrowingSupplier<R, ?> throwing) {
    return () -> {
      try {
        return throwing.get();
      } catch (Exception e) {
        throw wrapCheckedException(e);
      }
    };
  }

  public static <X, R> Function<X, R>
  apply(ThrowingFunction<X, R, ?> throwing) {
    return x -> {
      try {
        return throwing.apply(x);
      } catch (Exception e) {
        throw wrapCheckedException(e);
      }
    };
  }

  public static <X, Y, R> BiFunction<X, Y, R>
  apply(ThrowingBiFunction<X, Y, R, ?> throwing) {
    return (x, y) -> {
      try {
        return throwing.apply(x, y);
      } catch (Exception e) {
        throw wrapCheckedException(e);
      }
    };
  }

  public static <X> Predicate<X>
  test(ThrowingPredicate<X, ?> throwing) {
    return x -> {
      try {
        return throwing.test(x);
      } catch (Exception e) {
        throw wrapCheckedException(e);
      }
    };
  }

  public static <X, Y> BiPredicate<X, Y>
  test(ThrowingBiPredicate<X, Y, ?> throwing) {
    return (x, y) -> {
      try {
        return throwing.test(x, y);
      } catch (Exception e) {
        throw wrapCheckedException(e);
      }
    };
  }
}
