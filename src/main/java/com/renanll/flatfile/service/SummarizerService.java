package com.renanll.flatfile.service;

import com.renanll.flatfile.model.DataRow;
import com.renanll.flatfile.model.Summary;

import java.util.List;

public interface SummarizerService {

	Summary summarize(List<DataRow> rows);

}
