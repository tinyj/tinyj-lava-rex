package org.tinyj.lava.rex;

import org.testng.annotations.Test;
import org.tinyj.lava.*;

import java.util.Objects;
import java.util.function.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.tinyj.lava.rex.MockProxy.mockProxy;
import static org.tinyj.lava.rex.Rex.rex;
import static org.tinyj.lava.utils.LavaFun.*;

public class RexTest {

  @Test
  public void unchecked_exception_from_runnable_falls_through() throws Exception {
    final Exception originalException = new RuntimeException();

    try {
      rex(runnable(() -> raise(originalException))).run();

    } catch (Exception e) {
      assertThat(e).isSameAs(originalException);
    }
  }

  @Test
  public void unchecked_exception_from_consumer_falls_through() throws Exception {
    final Exception originalException = new RuntimeException();

    try {
      rex(consumer(x -> raise(originalException))).accept("x");
    } catch (Exception e) {
      assertThat(e).isSameAs(originalException);
    }
  }

  @Test
  public void unchecked_exception_from_biConsumer_falls_through() throws Exception {
    final Exception originalException = new RuntimeException();

    try {
      rex(biConsumer((x, y) -> raise(originalException))).accept("x", "y");

    } catch (Exception e) {
      assertThat(e).isSameAs(originalException);
    }
  }

  @Test
  public void unchecked_exception_from_supplier_falls_through() throws Exception {
    final Exception originalException = new RuntimeException();

    try {
      rex(supplier(() -> raise(originalException))).get();

    } catch (Exception e) {
      assertThat(e).isSameAs(originalException);
    }
  }

  @Test
  public void unchecked_exception_from_function_falls_through() throws Exception {
    final Exception originalException = new RuntimeException();

    try {
      rex(function(x -> raise(originalException))).apply("x");

    } catch (Exception e) {
      assertThat(e).isSameAs(originalException);
    }
  }

  @Test
  public void unchecked_exception_from_biFunction_falls_through() throws Exception {
    final Exception originalException = new RuntimeException();

    try {
      rex(biFunction((x, y) -> raise(originalException))).apply("x", "y");

    } catch (Exception e) {
      assertThat(e).isSameAs(originalException);
    }
  }

  @Test
  public void unchecked_exception_from_condition_falls_through() throws Exception {
    final Exception originalException = new RuntimeException();

    try {
      rex(condition(() -> { throw originalException; })).getAsBoolean();

    } catch (Exception e) {
      assertThat(e).isSameAs(originalException);
    }
  }

  @Test
  public void unchecked_exception_from_predicate_falls_through() throws Exception {
    final Exception originalException = new RuntimeException();

    try {
      rex(predicate(x -> { throw originalException; })).test("x");

    } catch (Exception e) {
      assertThat(e).isSameAs(originalException);
    }
  }

  @Test
  public void unchecked_exception_from_biPredicate_falls_through() throws Exception {
    final Exception originalException = new RuntimeException();

    try {
      rex(biPredicate((x, y) -> { throw originalException; })).test("x", "y");

    } catch (Exception e) {
      assertThat(e).isSameAs(originalException);
    }
  }

  @Test
  public void checked_exception_from_runnable_is_wrapped_into_unchecked_exception() throws Exception {
    final Exception originalException = new Exception();

    try {
      rex(runnable(() -> raise(originalException))).run();

    } catch (Exception e) {
      assertThat(e)
          .isInstanceOf(WrappedCheckedException.class)
          .hasCause(originalException);
    }
  }

  @Test
  public void checked_exception_from_consumer_is_wrapped_into_unchecked_exception() throws Exception {
    final Exception originalException = new Exception();

    try {
      rex(consumer(x -> raise(originalException))).accept("x");

    } catch (Exception e) {
      assertThat(e)
          .isInstanceOf(WrappedCheckedException.class)
          .hasCause(originalException);
    }
  }

  @Test
  public void checked_exception_from_biConsumer_is_wrapped_into_unchecked_exception() throws Exception {
    final Exception originalException = new Exception();

    try {
      rex(biConsumer((x, y) -> raise(originalException))).accept("x", "y");

    } catch (Exception e) {
      assertThat(e)
          .isInstanceOf(WrappedCheckedException.class)
          .hasCause(originalException);
    }
  }

  @Test
  public void checked_exception_from_supplier_is_wrapped_into_unchecked_exception() throws Exception {
    final Exception originalException = new Exception();

    try {
      rex(supplier(() -> raise(originalException))).get();

    } catch (Exception e) {
      assertThat(e)
          .isInstanceOf(WrappedCheckedException.class)
          .hasCause(originalException);
    }
  }

  @Test
  public void checked_exception_from_function_is_wrapped_into_unchecked_exception() throws Exception {
    final Exception originalException = new Exception();

    try {
      rex(function(x -> raise(originalException))).apply("x");

    } catch (Exception e) {
      assertThat(e)
          .isInstanceOf(WrappedCheckedException.class)
          .hasCause(originalException);
    }
  }

  @Test
  public void checked_exception_from_biFunction_is_wrapped_into_unchecked_exception() throws Exception {
    final Exception originalException = new Exception();

    try {
      rex(biFunction((x, y) -> raise(originalException))).apply("x", "y");

    } catch (Exception e) {
      assertThat(e)
          .isInstanceOf(WrappedCheckedException.class)
          .hasCause(originalException);
    }
  }

  @Test
  public void checked_exception_from_condition_is_wrapped_into_unchecked_exception() throws Exception {
    final Exception originalException = new Exception();

    try {
      rex(condition(() -> { throw originalException; })).getAsBoolean();

    } catch (Exception e) {
      assertThat(e)
          .isInstanceOf(WrappedCheckedException.class)
          .hasCause(originalException);
    }
  }

  @Test
  public void checked_exception_from_predicate_is_wrapped_into_unchecked_exception() throws Exception {
    final Exception originalException = new Exception();

    try {
      rex(predicate(x -> { throw originalException; })).test("x");

    } catch (Exception e) {
      assertThat(e)
          .isInstanceOf(WrappedCheckedException.class)
          .hasCause(originalException);
    }
  }

  @Test
  public void checked_exception_from_biPredicate_is_wrapped_into_unchecked_exception() throws Exception {
    final Exception originalException = new Exception();

    try {
      rex(biPredicate((x, y) -> { throw originalException; })).test("x", "y");

    } catch (Exception e) {
      assertThat(e)
          .isInstanceOf(WrappedCheckedException.class)
          .hasCause(originalException);
    }
  }

  @Test
  public void on_invocation_runnable_is_invoked() throws Exception {
    final LavaRunnable<?> runnable = mock(LavaRunnable.class);
    final Runnable rexRunnable = rex(runnable);
    verifyZeroInteractions(runnable);

    rexRunnable.run();

    verify(runnable).checkedRun();
  }

  @Test
  public void on_invocation_consumer_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final LavaConsumer<String, ?> consumer = mock(LavaConsumer.class);
    final Consumer<String> rexConsumer = rex(consumer);
    verifyZeroInteractions(consumer);

    rexConsumer.accept("x");

    verify(consumer).checkedAccept("x");
  }

  @Test
  public void on_invocation_biConsumer_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final LavaBiConsumer<String, String, ?> biConsumer = mock(LavaBiConsumer.class);
    final BiConsumer<String, String> rexBiConsumer = rex(biConsumer);
    verifyZeroInteractions(biConsumer);

    rexBiConsumer.accept("x", "y");

    verify(biConsumer).checkedAccept("x", "y");
  }

  @Test
  public void on_invocation_supplier_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final LavaSupplier<String, ?> supplier = mockProxy(LavaSupplier.class, () -> "x");
    final Supplier<?> rexSupplier = rex(supplier);
    verifyZeroInteractions(supplier);

    final Object result = rexSupplier.get();

    assertThat(result).isEqualTo("x");
  }

  @Test
  public void on_invocation_function_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final LavaFunction<String, String, ?> function = mockProxy(LavaFunction.class, x -> x);
    final Function<String, ?> rexFunction = rex(function);
    verifyZeroInteractions(function);

    final Object result = rexFunction.apply("x");

    assertThat(result).isEqualTo("x");
  }

  @Test
  public void on_invocation_biFunction_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final LavaBiFunction<String, String, String, ?> biFunction = mockProxy(LavaBiFunction.class, (x, y) -> x.toString() + y);
    final BiFunction<String, String, ?> rexBiFunction = rex(biFunction);
    verifyZeroInteractions(biFunction);

    final Object result = rexBiFunction.apply("x", "y");

    assertThat(result).isEqualTo("xy");
  }

  @Test
  public void on_invocation_condition_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final LavaCondition<?> condition = mockProxy(LavaCondition.class, () -> true);
    final BooleanSupplier rexCondition = rex(condition);
    verifyZeroInteractions(condition);

    final boolean result = rexCondition.getAsBoolean();

    assertThat(result).isTrue();
    verify(condition).checkedTest();
  }

  @Test
  public void on_invocation_predicate_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final LavaPredicate<String, ?> predicate = mockProxy(LavaPredicate.class, x -> Objects.equals(x, "x"));
    final Predicate<String> rexPredicate = rex(predicate);
    verifyZeroInteractions(predicate);

    final boolean result = rexPredicate.test("x");

    assertThat(result).isTrue();
  }

  @Test
  public void on_invocation_biPredicate_is_invoked() throws Exception {
    @SuppressWarnings("unchecked")
    final LavaBiPredicate<String, String, ?> biPredicate = mockProxy(LavaBiPredicate.class, Objects::equals);
    final BiPredicate<String, String> rexBiPredicate = rex(biPredicate);
    verifyZeroInteractions(biPredicate);

    final boolean result = rexBiPredicate.test("x", "x");

    assertThat(result).isTrue();
  }

  private static <T, E extends Exception> T raise(E e) throws E {
    throw e;
  }
}
