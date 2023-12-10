package edu.project4.Transformations;

import edu.project4.ObjectOfImage.Point;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AffineTest {
    @Test
    void test_that_affine_transform_is_correct(){

    }
    @Test
    public void testTransform() {
        Affine affine = new Affine();
        Point point = new Point(1, 1);
        Point result = affine.transform(point);
        assertThat(result).isNotNull();
    }

    @Test
    public void testRed() {
        Affine affine = new Affine();
        int red = affine.red();
        assertThat(red).isBetween(0, 255);
    }

    @Test
    public void testGreen() {
        Affine affine = new Affine();
        int green = affine.green();
        assertThat(green).isBetween(0, 255);
    }

    @Test
    public void testBlue() {
        Affine affine = new Affine();
        int blue = affine.blue();
        assertThat(blue).isBetween(0, 255);
    }
}
