import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
@SpringBootConfiguration
@SpringBootTest
public class ttt {

    @Test
    public void test(){
        Map<String, String> getenv = System.getenv();
        System.out.println(System.getenv());
    }
}
