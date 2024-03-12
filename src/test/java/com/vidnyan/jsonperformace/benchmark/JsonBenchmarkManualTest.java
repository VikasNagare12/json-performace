package com.vidnyan.jsonperformace.benchmark;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonBenchmarkManualTest {
    private  JsonBenchmarkManual benchmark;
    private  int iterations = 100;
    private String inputJson = "";

    @BeforeEach
    void setUp() {
        benchmark = new JsonBenchmarkManual();
        inputJson= "{}";
    }

    @Test
    void benchmarkJackson() throws Exception {
        benchmark.benchmarkJackson("{}", iterations);
    }

    @Test
    void benchmarkGson() {
        benchmark.benchmarkGson("{}", iterations);
    }

    @Test
    void benchmarkJsonSimple() throws ParseException {
        benchmark.benchmarkJsonSimple("{}", iterations);
    }

    @Test
    void benchmarkFastJSON() {
        benchmark.benchmarkFastJSON("{}", iterations);
    }

    @Test
    void benchmarkBoon() {
        //benchmark.benchmarkBoon("{}", 100);
    }

    @Test
    void benchmarkMoshi() throws IOException {
        benchmark.benchmarkMoshi("{}", iterations);
    }

    @Test
    void benchmarkLoganSquare() throws Exception {
        benchmark.benchmarkLoganSquare("{}", iterations);
    }
}