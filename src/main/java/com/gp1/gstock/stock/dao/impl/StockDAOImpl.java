package com.gp1.gstock.stock.dao.impl;

import com.gp1.gstock.common.aop.AopService;
import com.gp1.gstock.stock.dao.StockDAO;
import com.gp1.gstock.stock.entity.Stock;
import com.gp1.gstock.stock.entity.StockId;
import com.gp1.gstock.stock.entity.StockPrice;
import com.gp1.gstock.stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StockDAOImpl extends AopService implements StockDAO {

    private final StockRepository stockRepository;
    private final EntityManager em;
    @Override
    public void insertStock(Stock stock){
        log.info("Insert Stock : \n" + stock.toString());
        stockRepository.save(stock);
    }
    @Override
    @Transactional
    public void insertStockPrice(StockPrice stockPrice){
        log.info("Insert Stock price: \n" + stockPrice.toString());
        em.persist(stockPrice);
    }
    @Override
    public Stock selectStock(String bseDt, String srtnCd){
        return stockRepository.findById(new StockId(bseDt,srtnCd)).orElse(new Stock());
    }
    @Override
    public void updateStock(String bseDt, String srtnCd) throws Exception{
        Optional<Stock> target = stockRepository.findById(new StockId(bseDt,srtnCd));

        if(target.isPresent()){
            Stock stock = target.get();
            stockRepository.save(stock);
        }else {
            log.error("입력하신 정보에 해당하는 데이터가 존재하지 않습니다.\n");
        }
    }
    @Override
    public void deleteStock(String bseDt, String srtnCd) throws Exception{
        Optional<Stock> target = stockRepository.findById(new StockId(bseDt,srtnCd));
        if(target.isPresent()){
            Stock stock = target.get();
            stockRepository.delete(stock);
        }else {
            log.error("입력하신 정보에 해당하는 데이터가 존재하지 않습니다.\n");
        }
    }

}
