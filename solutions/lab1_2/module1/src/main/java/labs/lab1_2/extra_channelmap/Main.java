package labs.lab1_2.extra_channelmap;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Lab 1.2, extra task. Predict first, then run.
public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CardConfig.class)) {
            ChannelOverview overview = context.getBean(ChannelOverview.class);
            System.out.println("A  List:        " + overview.listTags());
            System.out.println("B  Map keys:    " + overview.mapKeys());
            System.out.println("C  Map values:  " + overview.mapTags());
        }
    }
}
