package org.tinyj.lava.rex;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.mock;

public class MockProxy {

  static <T> T mockProxy(Class<T> aClass, T proxied) {
    return mock(aClass, new ProxyAnswer<>(proxied));
  }

  static <T> Answer proxy(T proxied) {
    return new ProxyAnswer<>(proxied);
  }

  private static class ProxyAnswer<T> implements Answer {

    private final T proxied;

    public ProxyAnswer(T proxied) {
      this.proxied = proxied;
    }

    @Override
    public Object answer(InvocationOnMock invocation) throws Throwable {
      return invocation.getMethod().invoke(proxied, invocation.getArguments());
    }
  }
}
