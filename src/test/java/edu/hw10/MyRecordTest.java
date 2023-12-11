package edu.hw10;

import edu.hw10.Task1.MyRecord;
import edu.hw10.Task1.RandomObjectGenerator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MyRecordTest {
    @Test
    public void testHuman() {
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();
        MyRecord record = randomObjectGenerator.nextObject(MyRecord.class);

        assertThat(record.month()).isBetween(1,12);
        assertThat(record.year()).isGreaterThan(-1);
        assertThat(record.numberOfRecord()).isGreaterThan(0);
        assertThat(record.description()).isNotNull();
        assertThat(record.description()).isNotEmpty();
    }
}
