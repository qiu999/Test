package zoom.us.springdemo.annotation;


import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface JsonSubType {
    String name() default "";
    int index() default 0;
}
