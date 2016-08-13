import java.util.Arrays;
import java.util.List;

/**
 * https://dzone.com/articles/java-code-challenge-play-the-stock-market
 */
public class PlayTheStockMarket {

    private final List<Double> prices;

    private static final int NEXT_PRICE_OFFSET = 2;

    public PlayTheStockMarket(List<Double> prices) {
        this.prices = prices;
    }

    public List<Double> play() {
        Double low = 0.0;
        Double high = 0.0;
        Double diff = 0.0;

        for (int i = 0; i < prices.size() - NEXT_PRICE_OFFSET; i++) {
            for (int j = i + NEXT_PRICE_OFFSET; j < prices.size(); j++) {
                if ((prices.get(j) - prices.get(i)) > diff) {
                    low = prices.get(i);
                    high = prices.get(j);
                    diff = high - low;
                }
            }
        }

        return Arrays.asList(low, high);
    }

}
