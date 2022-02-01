package com.scio.test.services;

import com.scio.test.domain.CMSDataInput;
import com.scio.test.entity.CMSData;
import com.scio.test.domain.CMSDataOutput;
import com.scio.test.restclient.CMSDataRestClient;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.scio.test.entity.CMSData.DEFAULT_YEAR;

@Service
public class CMSDataService {

    CMSDataRestClient cmsDataRestClient;
    ModelMapper modelMapper;

    public CMSDataService(CMSDataRestClient cmsDataRestClient, ModelMapper modelMapper) {
        this.cmsDataRestClient = cmsDataRestClient;
        this.modelMapper = modelMapper;
    }

    public List<CMSData> get() {
        return cmsDataRestClient.get()
                .stream()
                .map(data -> modelMapper.map(data, CMSData.class))
                .collect(Collectors.toList());
    }

    public List<CMSDataOutput> getFilteredData(Integer year) {
        List<CMSDataInput> allData = cmsDataRestClient.get();
        Integer filterYear = year == null ? DEFAULT_YEAR : year;

        return allData.stream()
                .filter(data -> data.getPeriod() != null && data.getPeriod().equals(filterYear))
                .sorted(Comparator.comparing(CMSDataInput::getRegion).reversed())
                .map(data -> modelMapper.map(data, CMSDataOutput.class))
                .collect(Collectors.toList());
    }
}
