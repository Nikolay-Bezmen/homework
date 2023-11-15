package edu.hw6.Task6;

import org.junit.jupiter.api.Test;
import static edu.hw6.Task6.PortScanner.ANSI_GREEN;
import static edu.hw6.Task6.PortScanner.Protocol.TCP;
import static edu.hw6.Task6.PortScanner.Status.OPEN;
import static edu.hw6.Task6.PortScanner.scanPort;
import static edu.hw6.Task6.PortScanner.scanTcpPort;
import static edu.hw6.Task6.PortScanner.scanUdpPort;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PortScannerTest {

    @Test
    void test_scan_port_method(){
        assertDoesNotThrow(() -> scanPort(135));
    }

    @Test
    void test_scan_tcp_port_method_without_throws(){
        assertDoesNotThrow(() -> scanTcpPort(445));
    }
    @Test
    void test_scan_udp_port_method_without_throws(){
        assertDoesNotThrow(() -> scanUdpPort(27017));
    }

    @Test
    void test_get_condition_socket(){
        assertDoesNotThrow(() -> PortScanner.getConditionSocketOnScreen(OPEN, TCP, ANSI_GREEN, 5353));
    }
}
