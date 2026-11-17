package playground.ch1_2_wiringbeans.ex11_none;

import org.springframework.beans.factory.annotation.Autowired;

public class Panel {

    @Autowired(required = false)        // no Battery bean: the field stays null
    private Battery battery;

    public Battery battery() { return battery; }
}
