package com.renanll.flatfile.service;

import com.renanll.flatfile.model.*;
import com.renanll.flatfile.stub.DataRowStub;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SummaryServiceTest {
	

	
	@Test
	public void shouldSummarizeADataRowList() {
		SummarizerService summarizerService = new SalesSummarizerService();
		Summary summary = summarizerService.summarize(DataRowStub.build());
		assertsResult(summary);
	}
	
	private void assertsResult(Summary summary) {
		Assert.assertEquals(3, summary.getSalesmenAmount().intValue());
		Assert.assertEquals(4, summary.getClientsAmount().intValue());
		Assert.assertEquals(12, summary.getMostExpensiveSaleId().intValue());
		Assert.assertEquals("Rambo", summary.getWorstSalesman());
	}
}
