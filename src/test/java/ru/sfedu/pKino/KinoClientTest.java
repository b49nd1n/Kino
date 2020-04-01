package ru.sfedu.pKino;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class KinoClientTest {

    @org.junit.jupiter.api.Test
    void logBasicSystemInfo() {
        KinoClient client = new KinoClient();
        client.logBasicSystemInfo();
    }
}