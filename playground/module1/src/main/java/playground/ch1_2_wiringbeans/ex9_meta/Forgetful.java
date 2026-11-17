package playground.ch1_2_wiringbeans.ex9_meta;

import org.springframework.stereotype.Component;

@Component              // but no @Retention: the default keeps it out of the running program
public @interface Forgetful {
}
