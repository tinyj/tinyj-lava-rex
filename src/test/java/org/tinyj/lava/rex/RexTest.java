package org.tinyj.lava.rex;

import org.testng.annotations.Test;
import org.tinyj.lava.throwing.*;
import org.tinyj.lava.utils.Throwing;

import java.util.Objects;
import java.util.function.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.tinyj.lava.rex.MockProxy.mockProxy;

public class RexTest {

  @Test
  public void unchecked_exception_from_runnable_falls_through() throws Exception {
    final Exception originalException = new RuntimeException();

    try {
      Rex.run(Throwing.runnable(() -> raise(originalException))).run();

    } catch (Exception e) {
      assertThat(e).isSameAs(originalException);
    }
  }

  @Test
  public void unchecked_exception_from_consumer_falls_through() throws Exception {
    final Exception originalException = new RuntimeException();

    try {
      Rex.accept(Throwing.consumer(x -> raise(originalException))).accept("x");

    } catch (Exception e) {
      assertThat(e).isSameAs(originalException);
    }
  }

  @Test
  public void unchecked_exception_from_biConsumer_falls_through() throws Exception {
    final Exception originalException = new RuntimeException();

    try {
      Rex.accept(Throwing.biConsumer((x, y) -> raise(originalException))).accept("x", "y");

    } catch (Exception e) {
      assertThat(e).isSameAs(originalException);
    }
  }

  @Test
  public void unchecked_exception_from_supplier_falls_through() throws Exception {
    final Exception originalException = new RuntimeException();

    try {
      Rex.get(Throwing.supplier(() -> raise(originalException))).get();

    } catch (Exception e) {
      assertThat(e).isSameAs(originalException);
    }
  }

  @Test
  public void unchecked_exception_from_function_falls_through() throws Exception {
    final Exception originalException = new RuntimeException();

    try {
      Rex.apply(Throwing.function(x -> raise(originalException))).apply("x");

    } catch (Exception e) {
      assertThat(e).isSameAs(originalException);
    }
  }

  @Test
  public void unchecked_exception_from_biFunction_falls_through() throws Exception {
    final Exception originalException = new RuntimeException();

    try {
      Rex.apply(Throwing.biFunction((x, y) -> raise(originalException))).apply("x", "y");

    } catch (Exception e) {
      assertThat(e).isSameAs(originalException);
    }
  }

  @Test
  public void unchecked_exception_from_predicate_falls_through() throws Exception {
    final Exception originalException = new RuntimeException();

    try {
      Rex.test(Throwing.predicate(x -> raise(originalException))).test("x");

    } catch (Exception e) {
      assertThat(e).isSameAs(originalException);
    }
  }

  @Test
  public void unchecked_exception_from_biPredicate_falls_through() throws Exception {
    final Exception originalException = new RuntimeException();

    try {
      Rex.test(Throwing.biPredicate((x, y) -> raise(originalException))).test("x", "y");

    } catch (Exception e) {
      assertThat(e).isSameAs(originalException);
    }
  }

  @Test
  public void checked_exception_from_runnable_is_wrapped_into_unchecked_exception() throws Exception {
    final Exception originalException = new Exception();

    try {
      Rex.run(Throwing.runnable(() -> raise(originalException))).run();

    } catch (Exception e) {
      assertThat(e)
          .isInstanceOf(RuntimeException.class)
          .hasCause(originalException);
    }
  }

  @Test
  public void checked_exception_from_consumer_is_wrapped_into_unchecked_exception() throws Exception {
    final Exception originalException = new Exception();

    try {
      Rex.accept(Throwing.consumer(x -> raise(originalException))).accept("x");

    } catch (Exception e) {
      assertThat(e)
          .isInstanceOf(RuntimeException.class)
          .hasCause(originalException);
    }
  }

  @Test
  public void checked_exception_from_biConsumer_is_wrapped_into_unchecked_exception() throws Exception {
    final Exception originalException = new Exception();

    try {
      Rex.accept(Throwing.biConsumer((x, y) -> raise(originalException))).accept("x", "y");

    } catch (Exception e) {
      assertThat(e)
          .isInstanceOf(RuntimeException.class)
          .hasCause(originalException);
    }
  }

  @Test
  public void checked_exception_from_supplier_is_wrapped_into_unchecked_exception() throws Exception {
    final Exception originalException = new Exception();

    try {
      Rex.get(Throwing.supplier(() -> raise(originalException))).get();

    } catch (Exception e) {
      assertThat(e)
          .isInstanceOf(RuntimeException.class)
          .hasCause(originalException);
    }
  }

  @Test
  public void checked_exception_from_function_is_wrapped_into_unchecked_exception() throws Exception {
    final Exception originalException = new Exception();

    try {
      Rex.apply(Throwing.function(x -> raise(originalException))).apply("x");

    } catch (Exception e) {
      assertThat(e)
          .isInstanceOf(RuntimeException.class)
          .hasCause(originalException);
    }
  }

  @Test
  public void checked_exception_from_biFunction_is_wrapped_into_unchecked_exception() throws Exception {
    final Exception originalException = new Exception();

    try {
      Rex.apply(Throwing.biFunction((x, y) -> raise(originalException))).apply("x", "y");

    } catch (Exception e) {
      assertThat(e)
          .isInstanceOf(RuntimeException.class)
          .hasCause(originalException);
    }
  }

  @Test
  public void checked_exception_from_predicate_is_wrapped_into_unchecked_exception() throws Exception {
    final Exception originalException = new Exception();

    try {
      Rex.test(Throwing.predicate(x -> raise(originalException))).test("x");

    } catch (Exception e) {
      assertThat(e)
          .isInstanceOf(RuntimeException.class)
          .hasCause(originalException);
    }
  }

  @Test
  public void checked_exception_from_biPredicate_is_wrapped_into_unchecked_exception() throws Exception {
    final Exception originalException = new Exception();

    try {
      Rex.test(Throwing.biPredicate((x, y) -> raise(originalException))).test("x", "y");

    } catch (Exception e) {
      assertThat(e)
          .isInstanceOf(RuntimeException.class)
          .hasCause(originalException);
    }
  }

  @Test
  public void on_invocation_runnable_is_invoked() throws Exception {
    final ThrowingRunnable<?> runnable = mock(ThrowingRunnable.class);
    final Runnable rexRunnable = Rex.run(runnable);
    verifyZeroInteractions(runnable);

    rexRunnable.run();

    verify(runnable).run();
  }

  @Test
  public void on_invocation_consumer_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final ThrowingConsumer<String, ?> consumer = mock(ThrowingConsumer.class);
    final Consumer<String> rexConsumer = Rex.accept(consumer);
    verifyZeroInteractions(consumer);

    rexConsumer.accept("x");

    verify(consumer).accept("x");
  }

  @Test
  public void on_invocation_biConsumer_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final ThrowingBiConsumer<String, String, ?> biConsumer = mock(ThrowingBiConsumer.class);
    final BiConsumer<String, String> rexBiConsumer = Rex.accept(biConsumer);
    verifyZeroInteractions(biConsumer);

    rexBiConsumer.accept("x", "y");

    verify(biConsumer).accept("x", "y");
  }

  @Test
  public void on_invocation_supplier_is_invoked() throws Exception {
    final ThrowingSupplier<?, ?> supplier = mockProxy(ThrowingSupplier.class, () -> "x");
    final Supplier<?> rexSupplier = Rex.get(supplier);
    verifyZeroInteractions(supplier);

    final Object result = rexSupplier.get();

    assertThat(result).isEqualTo("x");
  }

  @Test
  public void on_invocation_function_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final ThrowingFunction<String, ?, ?> function = mockProxy(ThrowingFunction.class, x -> x);
    final Function<String, ?> rexFunction = Rex.apply(function);
    verifyZeroInteractions(function);

    final Object result = rexFunction.apply("x");

    assertThat(result).isEqualTo("x");
  }

  @Test
  public void on_invocation_biFunction_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final ThrowingBiFunction<String, String, ?, ?> biFunction = mockProxy(ThrowingBiFunction.class, (x, y) -> x.toString() + y);
    final BiFunction<String, String, ?> rexBiFunction = Rex.apply(biFunction);
    verifyZeroInteractions(biFunction);

    final Object result = rexBiFunction.apply("x", "y");

    assertThat(result).isEqualTo("xy");
  }

  @Test
  public void on_invocation_predicate_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final ThrowingPredicate<String, ?> predicate = mockProxy(ThrowingPredicate.class, x -> Objects.equals(x, "x"));
    final Predicate<String> rexPredicate = Rex.test(predicate);
    verifyZeroInteractions(predicate);

    final boolean result = rexPredicate.test("x");

    assertThat(result).isTrue();
  }

  @Test
  public void on_invocation_biPredicate_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final ThrowingBiPredicate<String, String, ?> biPredicate = mockProxy(ThrowingBiPredicate.class, Objects::equals);
    final BiPredicate<String, String> rexBiPredicate = Rex.test(biPredicate);
    verifyZeroInteractions(biPredicate);

    final boolean result = rexBiPredicate.test("x", "x");

    assertThat(result).isTrue();
  }

  private static <T, E extends Exception> T raise(E e) throws E {
    throw e;
  }
}