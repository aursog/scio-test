package com.scio.test.application.services;

import com.scio.test.application.interfaces.CMSDataInterface;
import com.scio.test.entity.CMSData;
import com.scio.test.framework.domain.CMSDataOutput;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.scio.test.entity.CMSData.DEFAULT_YEAR;

@Service
public class CMSDataService {

    CMSDataInterface cmsDataAdapter;
    ModelMapper modelMapper;

    public CMSDataService(CMSDataInterface cmsDataAdapter, ModelMapper modelMapper) {
        this.cmsDataAdapter = cmsDataAdapter;
        this.modelMapper = modelMapper;
    }

    public List<CMSData> get() {
        return cmsDataAdapter.getCMSData();
    }

    public List<CMSDataOutput> getFilteredData(Integer year) {
        List<CMSData> allData = cmsDataAdapter.getCMSData();
        Integer filterYear = year == null ? DEFAULT_YEAR : year;

        if (allData != null) {
            return allData.stream()
                    .filter(data -> data.getPeriod() != null && data.getPeriod().equals(filterYear))
                    .sorted(Comparator.comparing(CMSData::getRegion).reversed())
                    .map(cmsDataAdapter::transformToOutput)
                    .collect(Collectors.toList());
        }

        return null;
    }
}
