package com.helios.hmanager.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import lombok.AccessLevel;
import lombok.Getter;

/**
 * Base exception class.
 *
 * @author Iliyan Venkov
 */
@Getter
public class BaseException extends RuntimeException {
  private final String messageId;

  @Getter(AccessLevel.NONE)
  private final transient Object[] args;

  /**
   * BaseException constructor.
   *
   * @param messageId identifier of the message
   * @param args additional arguments
   */
  public BaseException(final String messageId, final Object[] args) {
    super(messageId);
    this.args = new Object[] {args};
    this.messageId = messageId;
  }

  protected static <K, V> Map<K, V> toMap(
      final Class<K> keyType, final Class<V> valueType, final Object... entries) {
    if (entries.length % 2 == 1) {
      throw new IllegalArgumentException("exception.illegal.argument.entries");
    }
    return IntStream.range(0, entries.length / 2)
        .map(i -> i * 2)
        .collect(
            HashMap::new,
            (m, i) -> m.put(keyType.cast(entries[i]), valueType.cast(entries[i + 1])),
            Map::putAll);
  }
}
