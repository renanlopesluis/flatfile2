package com.renanll.flatfile.api.v1;

import com.renanll.flatfile.service.StatisticService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(MockitoJUnitRunner.class)
public class StatisticsApiTest {
    @InjectMocks
    private StatisticsApi api;
    @Mock
    private StatisticService statisticService;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(api).build();
    }

    @Test
    public void shouldManuallyProcessStatistics()  throws Exception{
        doNothing().when(statisticService).process();
        MockHttpServletResponse response = mockMvc.perform(
                post("/v1/statistics/manual-processing")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test(expected = Exception.class)
    public void shouldNotManuallyProcessStatistics()  throws Exception{
        doThrow(new Exception()).when(statisticService).process();
        MockHttpServletResponse response = mockMvc.perform(
                post("/v1/statistics/manual-processing")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
    }

}
