package com.renanll.flatfile.service;

import com.renanll.flatfile.model.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

@Service
public class SalesSummarizerService implements SummarizerService {

	@Override
	public Summary summarize(List<DataRow> rows) {
		return new Summary(getCustomersAmount(rows), 
				getSalesmenAmount(rows), 
				getTheMostExpensiveSaleId(rows), 
				getTheWorstSalesman(rows));
	}
	
	private List<SalesmanDataRow> getSalesmenList(List<DataRow> rows) {
		return rows.stream().filter(x -> x.isClass(SalesmanDataRow.class))
				.map(x -> (SalesmanDataRow) x)
				.collect(Collectors.toList());
	}

	private List<SalesDataRow> getSalesList(List<DataRow> rows) {
		return rows.stream().filter(x -> x.isClass(SalesDataRow.class))
				.map(x -> (SalesDataRow) x)
				.collect(Collectors.toList());
	}

	private Integer getSalesmenAmount(List<DataRow> rows) {
		return rows.stream().filter(x -> x.isClass(SalesmanDataRow.class))
				.collect(Collectors.toList()).size();
	}

	private Integer getCustomersAmount(List<DataRow> rows) {
		return rows.stream().filter(x -> x.isClass(CustomerDataRow.class))
				.collect(Collectors.toList()).size();
	}
	
	private BigDecimal getSalesTotalAmount(List<SalesDataRow> rows) {
		return rows.stream().map((x) -> x.getSaleTotalAmount()).reduce((x, y) -> x.add(y)).get();
	}

	private Long getTheMostExpensiveSaleId(List<DataRow> rows) {
		List<SalesDataRow> sales = getSalesList(rows);
		return Collections.max(sales, Comparator.comparing(SalesDataRow::getSaleTotalAmount)).getId();
	}

	private String getTheWorstSalesman(List<DataRow> rows) {
		List<SalesDataRow> sales = getSalesList(rows);
		List<SalesmanDataRow> salesmen = getSalesmenList(rows);
		
		Map<String, BigDecimal> salesMap = buildSalesMap(sales, salesmen);

		return getTheLeastSalesAmount(salesMap);
	}

	private Map<String, BigDecimal> buildSalesMap(List<SalesDataRow> sales,
			List<SalesmanDataRow> salesmen) {
		Map<String, BigDecimal> salesMap = new HashMap<>();
		for (SalesmanDataRow salesman : salesmen) {
			List<SalesDataRow> salesmenList = sales.stream().
					filter(x -> x.hasSalesmanNamed(salesman.getName()))
					.collect(Collectors.toList());
			
			BigDecimal sumSale = getSalesTotalAmount(salesmenList);
			salesMap.put(salesman.getName(), sumSale);
		}
		return salesMap;
	}
	
	private String getTheLeastSalesAmount(Map<String, BigDecimal> salesMap) {
		Entry<String, BigDecimal> leastAmount = 
				Collections.min(salesMap.entrySet(), Comparator.comparing(Entry::getValue));
		return leastAmount.getKey();
	}
}
