package zoom.us.springdemo.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Data
@Component
public class Types {
    private String name;
    private int code;

    public static int toCode(Types... types) {
        return Arrays.stream(types).mapToInt(type -> type.code).reduce(0, (result, code) -> result | code);
    }

    public static Types[] toArray(int code) {
        return ZoomConfiguration.typesList.stream().filter(type -> (type.code & code) == type.code).toArray(Types[]::new);
    }
}
