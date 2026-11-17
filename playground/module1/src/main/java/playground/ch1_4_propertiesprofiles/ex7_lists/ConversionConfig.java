package playground.ch1_4_propertiesprofiles.ex7_lists;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

// RobotConfig plus a conversion service. The bean name must be "conversionService".
@Configuration
@Import(RobotConfig.class)
public class ConversionConfig {

    @Bean
    public ConversionService conversionService() {
        return new DefaultConversionService();
    }
}
