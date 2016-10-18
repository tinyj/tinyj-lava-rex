package org.tinyj.lava.rex;

/**
 * Unchecked exception wrapping a checked exception.
 */
public final class UncheckedException extends RuntimeException {

  /**
   * {@link UncheckedException} cannot be instantiated directly. Use
   * {@link UncheckedException#wrapCheckedException(Exception)} instead.
   *
   * @param cause the wrapped checked exception
   */
  private UncheckedException(Exception cause) {
    super(cause.getMessage(), assertCheckedException(cause));
  }

  /**
   * @param e {@link Exception} to wrap
   * @return {@code e} if {@code e} is {@code null} or a {@link RuntimeException},
   * a {@link UncheckedException} wrapping {@code e} otherwise
   */
  public static RuntimeException wrapCheckedException(Exception e) {
    return e == null || e instanceof RuntimeException ? (RuntimeException) e
                                                      : new UncheckedException(e);
  }

  private static Exception assertCheckedException(Exception cause) {
    assert cause != null && !(cause instanceof RuntimeException);
    return cause;
  }
}
