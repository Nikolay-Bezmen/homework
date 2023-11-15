package edu.hw6.Task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static edu.hw6.Task6.PortScanner.Protocol.TCP;
import static edu.hw6.Task6.PortScanner.Protocol.UDP;
import static edu.hw6.Task6.PortScanner.Status.CLOSED;
import static edu.hw6.Task6.PortScanner.Status.OPEN;

@SuppressWarnings({"MagicNumber", "HideUtilityClassConstructor"})
public class PortScanner {
    private final static Logger LOGGER = LogManager.getLogger();
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    private static final int MIN_PORT = 0;
    private static final int MAX_PORT = 49151;
    public static final Map<Integer, String> COMMOT_PORTS = new HashMap<>() {{
        put(135, "EPMAP");
        put(137, "Служба имен NetBIOS");
        put(138, "Служба датаграмм NetBIOS");
        put(139, "Служба сеансов NetBIOS");
        put(445, "Microsoft-DS Active Directory");
        put(843, "Adobe Flash");
        put(1900, "Simple Service Discovery Protocol (SSDP)");
        put(3702, "Динамическое обнаружение веб-служб");
        put(5040, "");
        put(5050, "");
        put(5353, "Многоадресный DNS");
        put(5355, "Link-Local Multicast Name Resolution (LLMNR)");
        put(5939, "");
        put(6463, "");
        put(6942, "");
        put(17500, "Dropbox");
        put(17600, "");
        put(27017, "MongoDB");
        put(42420, "");
    }};

    enum Protocol {
        TCP, UDP
    }

    enum Status {
        OPEN, CLOSED
    }

    public static void scanPorts() {
        for (int port = MIN_PORT; port <= MAX_PORT; ++port) {
            if (COMMOT_PORTS.containsKey(port)) {
                scanPort(port);
            }
        }
    }

    protected static void scanPort(int port) {
        scanTcpPort(port);
        scanUdpPort(port);
    }

    static void scanTcpPort(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            getConditionSocketOnScreen(OPEN, TCP, ANSI_GREEN, port);
        } catch (IOException e) {
            getConditionSocketOnScreen(CLOSED, TCP, ANSI_RED, port);
        }
    }

    static void scanUdpPort(int port) {
        try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
            getConditionSocketOnScreen(OPEN, UDP, ANSI_GREEN, port);
        } catch (IOException e) {
            getConditionSocketOnScreen(CLOSED, UDP, ANSI_RED, port);
        }
    }

    static void getConditionSocketOnScreen(Status status, Protocol protocol, String color, int port) {
        String nameOfService = COMMOT_PORTS.getOrDefault(port, "");
        if (!nameOfService.isEmpty()) {
            LOGGER.info(String.format("%-1s %-10s %-6s %-9d %-50s %-10s",
                color, status, protocol, port, nameOfService, ANSI_RESET
            ));
        }
    }
}
