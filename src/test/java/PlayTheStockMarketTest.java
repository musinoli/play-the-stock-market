import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PlayTheStockMarketTest {

    @Test
    public void sample1() {
        assertBestDealFound(Arrays.asList(19.35, 19.30, 18.88, 18.93, 18.95, 19.03, 19.00, 18.97, 18.97, 18.98),
                Arrays.asList(18.88, 19.03));
    }

    @Test
    public void sample2() throws IOException {
        assertBestDealFound(getNumbersFromFile(
                        "src/test/resources/StockMarketInput.txt"),
                Arrays.asList(8.03, 9.34));
    }

    @Test
    public void only3Prices() {
        assertBestDealFound(Arrays.asList(15.00, 16.00, 19.00),
                Arrays.asList(15.00, 19.00));
    }

    @Test
    public void skipsNextPrice() {
        assertBestDealFound(Arrays.asList(15.00, 19.00, 16.00),
                Arrays.asList(15.00, 16.00));
    }

    @Test
    public void smallestPriceNearEnd() {
        assertBestDealFound(Arrays.asList(6.00, 8.00, 9.00, 5.00, 5.50, 7.00),
                Arrays.asList(6.00, 9.00));
    }

    @Test
    public void descendingPrices() {
        assertBestDealFound(Arrays.asList(5.00, 4.00, 3.00),
                Arrays.asList(0.00, 0.00));
    }

    private void assertBestDealFound(List<Double> input, List<Double> expectedResult) {
        Assert.assertEquals(expectedResult, new PlayTheStockMarket(input).play());
    }

    private static List<Double> getNumbersFromFile(String filePath) throws IOException {
        List<Double> numbers = new LinkedList<>();
        Scanner scanner = new Scanner(Paths.get(filePath));
        while (scanner.hasNext()) {
            numbers.add(scanner.nextDouble());
        }
        return numbers;
    }

}
