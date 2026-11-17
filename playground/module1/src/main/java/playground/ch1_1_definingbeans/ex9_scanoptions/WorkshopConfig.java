package playground.ch1_1_definingbeans.ex9_scanoptions;

import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import playground.ch1_1_definingbeans.ex9_scanoptions.garage.Robot;
import playground.ch1_1_definingbeans.ex9_scanoptions.garage.parts.Battery;
import playground.ch1_1_definingbeans.ex9_scanoptions.tools.Wrench;

// Same packages as ex5_scan, the config outside them. Two settings of @ComponentScan:
// basePackageClasses scans the package of each class (and below), excludeFilters drops Battery.
@Configuration
@ComponentScan(
  basePackageClasses = {Robot.class, Wrench.class},
  excludeFilters = @Filter(type = ASSIGNABLE_TYPE,
                           classes = Battery.class))
public class WorkshopConfig { }
