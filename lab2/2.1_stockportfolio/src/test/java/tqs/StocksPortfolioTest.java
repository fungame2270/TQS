package tqs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StocksPortfolioTest {
    @InjectMocks
    StocksPortfolio stocksPortfolio;

    @Mock
    IStockMarketService stockMarketService;

    @Test
    public void totalValueTest(){
        when(stockMarketService.lookUpPrice("Tesla")).thenReturn(2.0);
        when(stockMarketService.lookUpPrice("Ferrari")).thenReturn(3.0);
        when(stockMarketService.lookUpPrice("BMW")).thenReturn(4.0);

        stocksPortfolio.addStock(new Stock("Tesla", 2));
        stocksPortfolio.addStock(new Stock("Ferrari", 1));
        stocksPortfolio.addStock(new Stock("BMW", 2));

        double value = stocksPortfolio.totalValue();
        //verify
        assertEquals(15, value);
        verify(stockMarketService,times(3)).lookUpPrice(anyString());
    }

}
