package com.scio.test.framework.adapter;

import com.scio.test.application.interfaces.CMSDataInterface;
import com.scio.test.entity.CMSData;
import com.scio.test.framework.domain.CMSDataInput;
import com.scio.test.framework.domain.CMSDataOutput;
import com.scio.test.framework.restclient.CMSDataRestClient;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CMSDataAdapter implements CMSDataInterface {

    CMSDataRestClient cmsDataRestClient;
    ModelMapper modelMapper;

    public CMSDataAdapter(CMSDataRestClient cmsDataRestClient, ModelMapper modelMapper) {
        this.cmsDataRestClient = cmsDataRestClient;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CMSData> getCMSData() {
        List<CMSDataInput> dataInputs = cmsDataRestClient.get();
        return dataInputs.stream().map(cmsData -> modelMapper.map(cmsData, CMSData.class)).collect(Collectors.toList());
    }

    @Override
    public CMSDataOutput transformToOutput(CMSData data) {
        return modelMapper.map(data, CMSDataOutput.class);
    }
}
