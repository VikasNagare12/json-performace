package com.vidnyan.jsonperformace.benchmark;


import com.alibaba.fastjson2.JSON;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.squareup.moshi.Moshi;
import lombok.extern.log4j.Log4j2;
import org.boon.json.JsonFactory;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Log4j2
@Component
public class JsonBenchmarkManual {

    public void benchmarkJackson(String jsonData, int iterations) throws Exception {

        long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();

        ObjectMapper mapper = new ObjectMapper();
        for (int i = 0; i < iterations; i++) {
            mapper.readValue(jsonData, Object.class);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000;
        long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        log.info("Jackson Parsing Time: {} nanoseconds", duration);
        log.info("Jackson memory used: {} bytes", (after - before));


    }

    public void benchmarkGson(String jsonData, int iterations) {
        long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();

        Gson gson = new Gson();
        for (int i = 0; i < iterations; i++) {
            gson.fromJson(jsonData, Object.class);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000;
        long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        log.info("Gson Parsing Time: {} nanoseconds", duration);
        log.info("Gson memory used: {} bytes", (after - before));
    }

    public  void benchmarkJsonSimple(String jsonData, int iterations) throws ParseException {
        long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            parser.parse(jsonData);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000;
        long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        log.info("JSON.simple Parsing Time: {} nanoseconds", duration);
        log.info("JSON.simple memory used: {} bytes", (after - before));
    }

    public  void benchmarkFastJSON(String jsonData, int iterations) {
        long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            JSON.parse(jsonData);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000;
        long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        log.info("JSON.simple Parsing Time: {} nanoseconds", duration);
        log.info("JSON.simple memory used: {} bytes", (after - before));
    }

    public  void benchmarkBoon(String jsonData, int iterations) {
        long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            org.boon.json.ObjectMapper mapper = JsonFactory.create();
            mapper.readValue(jsonData, Object.class);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000;
        long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        log.info("Boon Parsing Time: {} nanoseconds", duration);
        log.info("Boon memory used: {} bytes", (after - before));
    }

    public  void benchmarkMoshi(String jsonData, int iterations) throws IOException {
        long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        Moshi moshi = new Moshi.Builder().build();

        for (int i = 0; i < iterations; i++) {
            moshi.adapter(Object.class).fromJson(jsonData);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000;
        long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        log.info("Moshi Parsing Time: {} nanoseconds", duration);
        log.info("Moshi memory used: {} bytes", (after - before));
    }

    public  void benchmarkLoganSquare(String jsonData, int iterations) throws Exception {
        long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            LoganSquare.parse(jsonData, Object.class);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000;
        long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        log.info("LoganSquare Parsing Time: {} nanoseconds", duration);
        log.info("LoganSquare memory used: {} bytes", (after - before));
    }

}


