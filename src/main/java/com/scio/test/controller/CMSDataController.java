package com.scio.test.controller;

import com.scio.test.services.CMSDataService;
import com.scio.test.entity.CMSData;
import com.scio.test.domain.CMSDataOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CMSDataController {

    CMSDataService cmsDataService;

    public CMSDataController(CMSDataService cmsDataService) {
        this.cmsDataService = cmsDataService;
    }

    @GetMapping("/cms/filter")
    public ResponseEntity getCmsFiltered(@RequestParam(name="year", required=false) Integer year) {
        List<CMSDataOutput> data = cmsDataService.getFilteredData(year);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/cms")
    public ResponseEntity getCms() {
        List<CMSData> data = cmsDataService.get();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
