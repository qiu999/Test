package zoom.us.springdemo.event;

import lombok.Data;
import zoom.us.springdemo.annotation.JsonSubType;

@JsonSubType(name = "meeting.create",index = 0x20000)
@Data
public class MeetingCreate implements ZoomEvent{
    private String create;
    private String index;
}
