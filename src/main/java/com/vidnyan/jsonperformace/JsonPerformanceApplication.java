package com.vidnyan.jsonperformace;

import com.vidnyan.jsonperformace.benchmark.JsonBenchmarkManual;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsonPerformanceApplication {

	public static void main(String[] args) throws Exception {
		//SpringApplication.run(JsonPerformanceApplication.class, args);

		JsonBenchmarkManual jsonBenchmarkManual = new JsonBenchmarkManual();
		// Define your JSON data
		String jsonData = "{\"name\": \"John\", \"age\": 30, \"city\": \"New York\"}";
		// Benchmark Jackson
		jsonBenchmarkManual.benchmarkJackson(jsonData, 1000);

		// Benchmark Gson
		jsonBenchmarkManual.benchmarkGson(jsonData, 1000);

		// Benchmark JSON.simple
		jsonBenchmarkManual.benchmarkJsonSimple(jsonData, 1000);

		// Benchmark FastJSON
		jsonBenchmarkManual.benchmarkFastJSON(jsonData, 1000);

		// Benchmark Boon
		//benchmarkBoon(jsonData);

		// Benchmark Moshi
		jsonBenchmarkManual.benchmarkMoshi(jsonData,1000);

		// Benchmark LoganSquare
		jsonBenchmarkManual.benchmarkLoganSquare(jsonData, 1000);
	}

}
