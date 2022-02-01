package com.scio.test.application.interfaces;

import com.scio.test.entity.CMSData;
import com.scio.test.framework.domain.CMSDataOutput;

import java.util.List;

public interface CMSDataInterface {

    List<CMSData> getCMSData();
    CMSDataOutput transformToOutput(CMSData data);
}
