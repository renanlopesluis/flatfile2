package com.renanll.flatfile.api.v1;

import com.renanll.flatfile.service.StatisticService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/statistics")
public class StatisticsApi {

	@Qualifier("dataRowStatistic")
	private StatisticService statisticService;

	@Operation(summary = "Sales statistics manual processing.", responses = {
			@ApiResponse(description = "Successful Operation", responseCode = "200"),
			@ApiResponse(responseCode = "500", description = "Server Internal Error")
	})
	@PostMapping("/manual-processing")
	public void processStatistics(){
		try {
			statisticService.process();
		}catch(Exception e) {
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred during the statistics processing.");
		}
	}
}
