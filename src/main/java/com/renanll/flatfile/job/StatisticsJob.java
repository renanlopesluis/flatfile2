package com.renanll.flatfile.job;

import com.renanll.flatfile.service.StatisticService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class StatisticsJob {

    @Qualifier("dataRowStatistic")
    private final StatisticService statisticService;

    @Scheduled(cron = "${application.statistics.cron-job}")
    public void autoProcess() throws Exception {
        try {
            log.info("Preparing to process statistics");
            statisticService.process();
            log.info("Statistics have been successfully processed");
        } catch (Exception e) {
            log.error("An error occurred during the statistics processing {}", e);
            throw e;
        }

    }
}
