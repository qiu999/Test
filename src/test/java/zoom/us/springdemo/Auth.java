package zoom.us.springdemo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "zoom.oauth2.clients.googleanalytics")
@Data
public class Auth {

  private String authorize;
  private String token;
  private String authorizationMode;

  private String clientName;
  private String clientId;
  private String clientSecret;
  private String scopes;
}
