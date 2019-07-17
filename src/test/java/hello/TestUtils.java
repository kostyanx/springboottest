package hello;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestUtils {
    public static String readResource(String resourceName) throws URISyntaxException, IOException {
        return new String(
                Files.readAllBytes(Paths.get(TestUtils.class.getResource(resourceName).toURI())),
                StandardCharsets.UTF_8
        );
    }
}
