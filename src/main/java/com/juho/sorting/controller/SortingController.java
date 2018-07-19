package com.juho.sorting.controller;

import com.juho.sorting.util.SortingUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SortingController {

    @RequestMapping("/sort")
    public String sort(@RequestBody String data) throws Exception {

        return SortingUtil.sort(data);
    }
}
