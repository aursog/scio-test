package com.scio.test.application.services;

import com.scio.test.entity.CMSData;
import com.scio.test.framework.adapter.CMSDataAdapter;
import com.scio.test.framework.domain.CMSDataOutput;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CMSDataServiceTest {

    @Test
    public void test_getFilteredData_when_adapter_response_success() {
        // given
        List<CMSData> dataInputs = Arrays.asList(
                CMSData.builder().region("Alabama").regionCode("Al").period(2021).build(),
                CMSData.builder().region("Alabama").regionCode("Al").period(2020).build(),
                CMSData.builder().region("Alabama").regionCode("Al").period(2019).build(),
                CMSData.builder().region("Texas").regionCode("Tx").period(2021).build(),
                CMSData.builder().region("Texas").regionCode("Tx").period(2020).build(),
                CMSData.builder().region("Texas").regionCode("Tx").period(2019).build(),
                CMSData.builder().region("Seattle").regionCode("St").period(2021).build(),
                CMSData.builder().region("Seattle").regionCode("St").period(2020).build(),
                CMSData.builder().region("Seattle").regionCode("St").period(2019).build()
        );

        CMSDataAdapter adapter = Mockito.mock(CMSDataAdapter.class);
        Mockito.when(adapter.getCMSData()).thenReturn(dataInputs);
        ModelMapper modelMapper = Mockito.mock(ModelMapper.class);
        CMSDataService service = new CMSDataService(adapter, modelMapper);

        //when
        List<CMSDataOutput> data = service.getFilteredData(2020);

        //then
        assertTrue(data.size() == 3);
    }

    @Test
    public void test_getFilteredData_when_adapter_response_when_year_is_null() {
        // given
        List<CMSData> dataInputs = Arrays.asList(
                CMSData.builder().region("Alabama").regionCode("Al").period(2021).build(),
                CMSData.builder().region("Alabama").regionCode("Al").period(2020).build(),
                CMSData.builder().region("Alabama").regionCode("Al").period(2019).build(),
                CMSData.builder().region("Texas").regionCode("Tx").period(2021).build(),
                CMSData.builder().region("Texas").regionCode("Tx").period(2020).build(),
                CMSData.builder().region("Texas").regionCode("Tx").period(2019).build(),
                CMSData.builder().region("Seattle").regionCode("St").period(2021).build(),
                CMSData.builder().region("Seattle").regionCode("St").period(2020).build(),
                CMSData.builder().region("Seattle").regionCode("St").period(2019).build()
        );

        CMSDataAdapter adapter = Mockito.mock(CMSDataAdapter.class);
        Mockito.when(adapter.getCMSData()).thenReturn(dataInputs);
        ModelMapper modelMapper = Mockito.mock(ModelMapper.class);
        CMSDataService service = new CMSDataService(adapter, modelMapper);

        //when
        List<CMSDataOutput> data = service.getFilteredData(null);

        //then
        assertTrue(data.size() == 0);
    }

    @Test
    public void test_getFilteredData_when_adapter_response_null() {
        // given
        CMSDataAdapter adapter = Mockito.mock(CMSDataAdapter.class);
        Mockito.when(adapter.getCMSData()).thenReturn(null);
        ModelMapper modelMapper = Mockito.mock(ModelMapper.class);
        CMSDataService service = new CMSDataService(adapter, modelMapper);

        //when
        List<CMSDataOutput> data = service.getFilteredData(2020);

        //then
        assertTrue(data == null);
    }

    @Test
    public void test_getFilteredData_when_adapter_response_empty_array() {
        // given
        CMSDataAdapter adapter = Mockito.mock(CMSDataAdapter.class);
        Mockito.when(adapter.getCMSData()).thenReturn(new ArrayList<>());
        ModelMapper modelMapper = Mockito.mock(ModelMapper.class);
        CMSDataService service = new CMSDataService(adapter, modelMapper);

        //when
        List<CMSDataOutput> data = service.getFilteredData(2020);

        //then
        assertTrue(data.size() == 0);
    }
}