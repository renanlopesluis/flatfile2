package com.renanll.flatfile.job;

import com.renanll.flatfile.service.StatisticService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StatisticsJobTest {

    @InjectMocks
    private StatisticsJob job;
    @Mock
    private StatisticService statisticService;

    @Test
    public void shouldExecuteJob() throws Exception {
        doNothing().when(statisticService).process();

        job.autoProcess();

        verify(statisticService).process();
    }

    @Test(expected = Exception.class)
    public void shouldNotExecuteJob() throws Exception {
        doThrow(new Exception()).when(statisticService).process();

        job.autoProcess();

        verify(statisticService, never()).process();
    }
}
