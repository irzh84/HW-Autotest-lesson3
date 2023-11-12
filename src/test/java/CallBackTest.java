import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class CallBackTest {
    @Test
    void shouldTest() {
        open("http://localhost:9999");
    }
}
