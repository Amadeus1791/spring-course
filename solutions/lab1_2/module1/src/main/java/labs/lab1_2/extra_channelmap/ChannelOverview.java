package labs.lab1_2.extra_channelmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

// Gets the same channels twice: once as a List, once as a Map.
@Component
public class ChannelOverview {

    private final List<AlertChannel> list;
    private final Map<String, AlertChannel> map;

    public ChannelOverview(List<AlertChannel> list, Map<String, AlertChannel> map) {
        this.list = list;
        this.map = map;
    }

    public List<String> listTags() {
        List<String> tags = new ArrayList<>();
        for (AlertChannel channel : list) {
            tags.add(channel.tag().trim());
        }
        return tags;
    }

    public List<String> mapKeys() {
        return new ArrayList<>(map.keySet());
    }

    public List<String> mapTags() {
        List<String> tags = new ArrayList<>();
        for (AlertChannel channel : map.values()) {
            tags.add(channel.tag().trim());
        }
        return tags;
    }
}
