package zoom.us.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootApplication
public class SpringBootTest {
  public static void main(String[] args) {
    System.out.println("=============");
    //
      SpringApplication.run(SpringdemoApplication.class, args);

  }
}
