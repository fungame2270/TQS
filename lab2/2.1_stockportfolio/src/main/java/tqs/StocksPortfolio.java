package tqs;

import java.util.ArrayList;
import java.util.List;

public class StocksPortfolio {
    private List<Stock> stocks = new ArrayList<>();
    private IStockMarketService stockMarketService;

    public StocksPortfolio(IStockMarketService stockMarketService){
        this.stockMarketService = stockMarketService;
    }

    public void addStock(Stock stock){
        stocks.add(stock);
    }

    public double totalValue(){
        double value = 0;
        for (Stock stock : stocks) {
            value += stockMarketService.lookUpPrice(stock.getLabel()) * stock.getQuantity();
        }
        return value;
    }

}
