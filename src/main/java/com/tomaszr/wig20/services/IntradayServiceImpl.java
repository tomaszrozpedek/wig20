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
    public String getIntraday(String shareName){
        List<Intraday> queryOutput = new ArrayList<>();
        queryOutput.addAll(intradayRepository.findByName(shareName));

        System.out.println(queryOutput.size());

        for (Intraday row : queryOutput) {
            System.out.println(row.getHour()+" "+row.getPrice());
        }

        return " ";
    }

}
