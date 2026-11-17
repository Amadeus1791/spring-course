package playground.ch1_4_propertiesprofiles.ex7_lists;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

// A bean from RobotConfig. The fields are filled by the context, like on the @Value slide.
public class Robot {

    @Value("${robot.tools}")
    private String[] toolArray;

    @Value("${robot.tools}")
    private List<String> toolList;

    @Value("#{'${robot.tools}'.split(',')}")
    private List<String> splitList;

    public String[] getToolArray() { return toolArray; }
    public List<String> getToolList() { return toolList; }
    public List<String> getSplitList() { return splitList; }
}
