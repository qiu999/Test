package zoom.us.springdemo.event;

import lombok.Data;
import zoom.us.springdemo.annotation.JsonSubType;

@JsonSubType(name="meeting.delete",index = 0x40000)
@Data
public class MeetingDelete implements ZoomEvent{
    private String delete;
    private String index;
}
