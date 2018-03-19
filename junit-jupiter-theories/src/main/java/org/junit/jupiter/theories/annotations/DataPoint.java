package org.junit.jupiter.theories.annotations;

import org.apiguardian.api.API;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.apiguardian.api.API.Status.EXPERIMENTAL;
import static org.apiguardian.api.API.Status.INTERNAL;

/**
 * Annotation that indicates that an element should be treated as a data point for use with theories. May be used on:
 * <ul>
 * <li>Static fields</li>
 * <li>Static methods: Methods may be called multiple times, so they should always return the same values</li>
 * <li>Non-static fields: This requires that the class be annotated with {@code @TestInstance(TestInstance.Lifecycle.PER_CLASS)}</li>
 * <li>Non-static methods: See the limitations for static methods and non-static fields above.</li>
 * </ul>
 */
@Retention(RUNTIME)
@Target({METHOD, FIELD})
@API(status = EXPERIMENTAL, since = "5.2")
public @interface DataPoint {
    /**
     * @return the qualifier(s) for this data point. Can be empty.
     *
     * @see Qualifiers for additional information on how qualifiers work
     */
    public String[] qualifiers() default {};
}
