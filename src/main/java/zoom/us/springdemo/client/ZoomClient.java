package zoom.us.springdemo.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface ZoomClient {

    @RequestMapping(method = RequestMethod.GET,params = "zoom/getRecording")
    public Object getRecordingUrl();
}
