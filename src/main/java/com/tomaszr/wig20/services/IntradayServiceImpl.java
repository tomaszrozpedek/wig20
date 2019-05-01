package com.tomaszr.wig20.services;

import com.tomaszr.wig20.model.entities.Intraday;
import com.tomaszr.wig20.model.repositories.IntradayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntradayServiceImpl implements IntradayService {
    private IntradayRepository intradayRepository;

    @Autowired
    public IntradayServiceImpl(IntradayRepository intradayRepository) {
        this.intradayRepository = intradayRepository;
    }

//    public IntradayServiceImpl() {
//        this.intradayRepository = new IntradayRepository();
//    }

    @Override
    public Object[][] getIntraday(String shareName, String startDate, String endDate) {
//        List<Intraday> queryOutput = new ArrayList<>(intradayRepository.findByName(shareName));
        List<Intraday> queryOutput = new ArrayList<>(intradayRepository.findAllByNameAndDateBetween(shareName, startDate, endDate));

        int rowCount = queryOutput.size();
        Object[][] intradayPointList = new Object[rowCount][2];

        int i = 0;
        for (Intraday row : queryOutput){
            intradayPointList[i][0] =
                    row.getDate().substring(0,4)+"-"+row.getDate().substring(4,6)+"-"+row.getDate().substring(6,8)
                    +" "
                    +row.getHour().substring(0,2)+":"+row.getHour().substring(2,4);
            intradayPointList[i][1] = row.getPrice();
//            System.out.println(row.getPrice());
            i++;
        }
        return intradayPointList;
    }

}
