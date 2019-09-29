package com.sample.shop.common;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Provide utility methods needed throughout application
 *
 * @author Ammarah Shakeel
 */
public class Util {
    public static OffsetDateTime dateTimeFromMillis(Long millis) {
        return Instant.ofEpochMilli(millis).atZone(ZoneOffset.UTC).toOffsetDateTime();
    }
}