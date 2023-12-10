package edu.project4.Transformations;

import edu.project4.ObjectOfImage.Pixel;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ThreadLocalRandom;
import static org.assertj.core.api.Assertions.assertThat;

public class GammaCorrectionTest {
    @Test
    void test_that_gamma_correction_exchange_all_pixels(){
        Pixel[][] pixels = new Pixel[10][10];
        Pixel[][] startPixels = new Pixel[10][10];
        for(int i = 0; i < pixels.length; ++i){
            for(int j = 0; j < pixels[0].length; ++j){
                pixels[i][j] = new Pixel();
                pixels[i][j].setR(ThreadLocalRandom.current().nextInt(256));
                pixels[i][j].setG(ThreadLocalRandom.current().nextInt(256));
                pixels[i][j].setB(ThreadLocalRandom.current().nextInt(256));
                startPixels[i][j] = new Pixel(pixels[i][j]);
            }
        }

        GammaCorrection.defaultCorrection(pixels);

        for(int i = 0; i < pixels.length; ++i){
            for(int j = 0; j < pixels[0].length; ++j){
                assertThat(pixels[i][j]).isNotEqualTo(startPixels[i][j]);
            }
        }
    }
}
