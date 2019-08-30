package zoom.us.springdemo.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import zoom.us.springdemo.annotation.JsonSubType;
import zoom.us.springdemo.event.ZoomEvent;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Configuration
public class ZoomConfiguration {
    @Autowired
    private List<ZoomEvent> zoomEventList;
    public static final List<Types> typesList=new ArrayList<>();
    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);

        objectMapper.registerSubtypes(ZoomEvent.class);
        zoomEventList.stream().forEach(zoomEvent -> {
            JsonSubType jsonSubType=zoomEvent.getClass().getAnnotation(JsonSubType.class);
            if(jsonSubType!=null){
                String name=jsonSubType.name();
                int index=jsonSubType.index();
                Types types=new Types();
                types.setCode(index);
                types.setName(name.toUpperCase());
                typesList.add(types);
                objectMapper.registerSubtypes(new NamedType(zoomEvent.getClass(),name));

            }
        });
        return objectMapper;
    }

    public void regeist(){

    }

}
