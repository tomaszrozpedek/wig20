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
    public Object[][] getIntraday(String shareName) {
//        String intradayPointList="[ ";
//        String intradayPointList="";
//        Intraday row;
        List<Intraday> queryOutput = new ArrayList<>();
        queryOutput.addAll(intradayRepository.findByName(shareName));

//        [['Mar 14', 43],['Nov 14', 39],['Jan 15', 42],['Mar 15', 37],['Dec 15', 34],['Feb 16', 40]]

//        for (int i = 0; i < 100; i++) {
//            intradayPointList = intradayPointList+"['";
//            row=queryOutput.get(i);
//            intradayPointList = intradayPointList + row.getHour().toString();
//            intradayPointList=intradayPointList+"',";
//            intradayPointList = intradayPointList + row.getPrice().toString();
//            intradayPointList = intradayPointList+"],";
//        }
//        intradayPointList=intradayPointList.substring(0, intradayPointList.length() - 1);
//        intradayPointList = intradayPointList+"]";

//        System.out.println(intradayPointList);

//        for (Intraday row : queryOutput) {
//            System.out.println(row.getHour()+" "+row.getPrice());
//        }

        int rowCount = (int) queryOutput.size();
        Object[][] intradayPointList = new Object[rowCount][2];

        int i = 0;
        for (Intraday row : queryOutput){
            String hour=row.getHour().toString().substring(0,4);
            hour=hour.substring(0,2)+":"+hour.substring(2,4);
            intradayPointList[i][0] = hour;
//            intradayPointList[i][0] = row.getHour().toString().substring(0,4);
            intradayPointList[i][1] = row.getPrice();
            i++;
        }
        System.out.println(intradayPointList);
        return intradayPointList;
    }

}
