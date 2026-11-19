package playground.ch2_1_aspects.ex9_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// A marker. On its own it does nothing: LogAspect looks for it.
@Retention(RetentionPolicy.RUNTIME)   // the usual choice for annotations that frameworks read
@Target(ElementType.METHOD)
public @interface Logged {
}
