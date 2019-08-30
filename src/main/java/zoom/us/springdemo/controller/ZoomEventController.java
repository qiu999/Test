package zoom.us.springdemo.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zoom.us.springdemo.annotation.JsonSubType;
import zoom.us.springdemo.configuration.Types;
import zoom.us.springdemo.event.ZoomEvent;

import java.util.Arrays;

@RestController
public class ZoomEventController {

  @Autowired
  private ObjectMapper objectMapper;

  @RequestMapping("/zoom/event")
  public String event(@RequestBody ZoomEvent zoomEvent) {
    objectMapper.getNodeFactory().arrayNode();
    JsonSubType jsonSubType=zoomEvent.getClass().getAnnotation(JsonSubType.class);
    Types types=new Types();
    types.setName(jsonSubType.name());
    types.setCode(jsonSubType.index());
    System.out.println(Types.toCode(types));
    System.out.println(Types.toArray(zoomEvent.getClass().getAnnotation(JsonSubType.class).index()));
    Arrays.stream(Types.toArray(types.getCode())).forEach(o -> System.out.println(o.getName()));
    return "success";
  }
}
