package edu.hw6.Task3;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

@SuppressWarnings("MagicNumber")
public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    AbstractFilter REGULAR_FILE = Files::isRegularFile;
    AbstractFilter READABLE = Files::isReadable;
    AbstractFilter DIRECTORY = Files::isDirectory;
    AbstractFilter EXECUTABLE = Files::isExecutable;
    AbstractFilter HIDDEN = Files::isHidden;
    AbstractFilter WRITABLE = Files::isWritable;

    @Override
    boolean accept(Path entry) throws IOException;

    default AbstractFilter and(AbstractFilter other) {
        return entry -> accept(entry) && other.accept(entry);
    }

    static AbstractFilter largerThan(long size) {
        return entry -> {
            try {
                return Files.size(entry) > size;
            } catch (IOException e) {
                return false;
            }
        };
    }

    static AbstractFilter magicNumber(byte[] bytes) {
        return entry -> {
            try (SeekableByteChannel channel = Files.newByteChannel(entry)) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
                int countAvailableBytesForRead = channel.read(byteBuffer);
                if (bytes.length != countAvailableBytesForRead) {
                    return false;
                }

                byteBuffer.flip();
                for (int aByte : bytes) {
                    if ((byteBuffer.get() & 0xff) != aByte) {
                        return false;
                    }
                }

                return true;
            } catch (IOException e) {
                return false;
            }
        };
    }

    static AbstractFilter extension(String glob) {
        return entry -> {
            String fileName = entry.getFileName().toString();

            return fileName.endsWith("." + glob);
        };
    }

    static AbstractFilter regexNamePattern(String regex) {
        Pattern pattern = Pattern.compile(regex);
        return entry -> pattern.matcher(entry.toString()).find();
    }
}
