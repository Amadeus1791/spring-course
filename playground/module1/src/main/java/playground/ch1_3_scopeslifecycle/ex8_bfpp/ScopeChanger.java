package playground.ch1_3_scopeslifecycle.ex8_bfpp;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

// Runs before any bean exists. It changes the recipe, not an object.
@Component
public class ScopeChanger implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        BeanDefinition recipe = beanFactory.getBeanDefinition("robot");
        System.out.println("  recipe of robot before: scope '" + recipe.getScope() + "'");
        recipe.setScope(BeanDefinition.SCOPE_PROTOTYPE);
    }
}
