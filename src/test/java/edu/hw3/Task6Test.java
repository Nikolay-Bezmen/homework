package edu.hw3;

import edu.hw3.Task6.Stock;
import edu.hw3.Task6.StockOfMarket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    StockOfMarket stockOfMarket;

    @BeforeEach
    void set_up() {
        stockOfMarket = new StockOfMarket();
    }

    @Test
    void test_add_work_correct() {
        Stock apple = new Stock("Apple", 105);
        Stock microsoft = new Stock("Microsoft", 250);
        Stock tiktok = new Stock("Tik-Tok", 567);

        stockOfMarket.add(apple);
        stockOfMarket.add(microsoft);

        assertThat(stockOfMarket.containsStock(apple)).isTrue();
        assertThat(stockOfMarket.containsStock(microsoft)).isTrue();
        assertThat(stockOfMarket.containsStock(tiktok)).isFalse();
    }

    @Test
    void test_remove_work_correct() {
        Stock apple = new Stock("Apple", 105);
        Stock microsoft = new Stock("Microsoft", 250);

        stockOfMarket.add(apple);
        stockOfMarket.add(microsoft);
        stockOfMarket.remove(apple);
        stockOfMarket.remove(microsoft);

        assertThat(stockOfMarket.containsStock(apple)).isFalse();
        assertThat(stockOfMarket.containsStock(microsoft)).isFalse();
    }

    @Test
    void test_most_valuable_stock_first() {
        Stock apple = new Stock("Apple", 105);
        Stock microsoft = new Stock("Microsoft", 250);

        stockOfMarket.add(apple);
        stockOfMarket.add(microsoft);

        assertThat(stockOfMarket.mostValuableStock()).isEqualTo(microsoft);
    }

    @Test
    void test_most_valuable_stock_second() {
        Stock apple = new Stock("Apple", 105);
        Stock microsoft = new Stock("Microsoft", 250);
        Stock BMW = new Stock("BMW", 198);
        Stock SP500 = new Stock("SP500", 287);

        stockOfMarket.add(apple);
        stockOfMarket.add(microsoft);
        stockOfMarket.add(BMW);
        stockOfMarket.add(SP500);

        assertThat(stockOfMarket.mostValuableStock()).isEqualTo(SP500);
    }

    @Test
    void test_most_valuable_stock_third() {
        Stock apple = new Stock("Apple", 105);
        Stock microsoft = new Stock("Microsoft", 250);
        Stock BMW = new Stock("BMW", 198);
        Stock SP500 = new Stock("SP500", 287);
        Stock amazon = new Stock("amazon", 243);
        Stock tiktok = new Stock("Tik-Tok", 567);

        stockOfMarket.add(apple);
        stockOfMarket.add(microsoft);
        stockOfMarket.add(BMW);
        stockOfMarket.add(SP500);
        stockOfMarket.add(amazon);
        stockOfMarket.add(tiktok);

        assertThat(stockOfMarket.mostValuableStock()).isEqualTo(tiktok);
    }

}
