package org.apereo.cas;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.mock.env.MockEnvironment;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is {@link CasConfigurationServerBannerTests}.
 *
 * @author Misagh Moayyed
 * @since 6.2.0
 */
public class CasConfigurationServerBannerTests {
    @Test
    public void verifyOperation() throws Exception {
        val banner = new CasConfigurationServerBanner();
        assertNotNull(banner.getTitle());

        val environment = new MockEnvironment();
        try (val os = new ByteArrayOutputStream(); val out = new PrintStream(os)) {
            assertDoesNotThrow(new Executable() {
                @Override
                public void execute() {
                    banner.printBanner(environment, CasConfigurationServerBannerTests.this.getClass(), out);
                }
            });
            assertNotNull(os.toByteArray());
        }
    }
}
