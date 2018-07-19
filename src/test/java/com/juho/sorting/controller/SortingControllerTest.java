package com.juho.sorting.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
public class SortingControllerTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private MockMvc mockMvc;

    @Autowired
    private SortingController sortingController;

    @Before
    public void setUp() throws Exception {
        mockMvc = standaloneSetup(sortingController).build();
    }

    @Test
    public void sortingBalanceDataTest() throws Exception {
        String testData = "123abc456def";
        sortingTest(testData);
    }

    @Test
    public void sortingUnbalanceTest() throws Exception {
        String testData = "dfas33123dDFDAabc64111456dDDDDef";
        sortingTest(testData);
    }

    @Test
    public void sortingOnlyNumberTest() throws Exception {
        String testData = "12351312167802165326";
        sortingTest(testData);
    }

    @Test
    public void sortingOnlyAlphabetTest() throws Exception {
        String testData = "sdfdaABCDERadgVBNedfaBDdfDfaHjKLrF";
        sortingTest(testData);
    }

    private void sortingTest(String testData) throws Exception {
        String result = sortingController.sort(testData);

        MvcResult mvcResult = mockMvc.perform(get("/sort")
                .contentType(MediaType.TEXT_PLAIN)
                .content(testData))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(result))).andReturn();

        logger.info("compare From : [{}]", result);
        logger.info("compare To   : [{}]", mvcResult.getResponse().getContentAsString());
    }
}
