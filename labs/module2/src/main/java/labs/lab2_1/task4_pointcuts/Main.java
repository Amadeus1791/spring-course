package labs.lab2_1.task4_pointcuts;

import java.lang.reflect.Method;
import labs.lab2_1.task4_pointcuts.repository.CardRepository;
import labs.lab2_1.task4_pointcuts.service.CardService;
import labs.lab2_1.task4_pointcuts.service.LimitCalculator;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

// Lab 2.1, task 4. Asks Spring which pointcut matches which method, without a context.
public class Main {

    static final String BASE = "labs.lab2_1.task4_pointcuts";

    // TODO Lab 2.1, task 4: your own pointcut, matching exactly pay and refund
    static final String MINE = "execution(void " + BASE + "..*.*(..))";

    public static void main(String[] args) throws Exception {
        String[] pointcuts = {
            "execution(* " + BASE + ".service.*.*(..))",
            "execution(* " + BASE + ".*.*(..))",
            "execution(* " + BASE + "..*.*(..))",
            "execution(* *(String))",
            "execution(int *(..))",
        };
        Method[] methods = {
            CardService.class.getMethod("pay", int.class),
            CardService.class.getMethod("refund", int.class),
            LimitCalculator.class.getMethod("dailyLimit", String.class),
            CardRepository.class.getMethod("findByNumber", String.class),
        };
        System.out.println("A pay(int)  B refund(int)  C dailyLimit(String)  D findByNumber(String)");
        System.out.println("       A  B  C  D");
        for (int i = 0; i < pointcuts.length; i++) {
            print(String.valueOf(i + 1), pointcuts[i], methods);
        }
        print("mine", MINE, methods);
    }

    private static void print(String label, String expression, Method[] methods) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(expression);
        StringBuilder line = new StringBuilder(String.format("%-5s", label));
        for (Method method : methods) {
            boolean match = pointcut.matches(method, method.getDeclaringClass());
            line.append(match ? "  x" : "  -");
        }
        System.out.println(line.toString().stripTrailing());
    }
}
