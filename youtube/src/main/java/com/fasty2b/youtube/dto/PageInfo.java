package com.fasty2b.youtube.dto;

import java.io.Serializable;

public class PageInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long totalResults;
	
	private long resultsPerPage;
	
	public PageInfo() {
		// TODO Auto-generated constructor stub
	}

	public long getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(long totalResults) {
		this.totalResults = totalResults;
	}

	public long getResultsPerPage() {
		return resultsPerPage;
	}

	public void setResultsPerPage(long resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
	}

	@Override
	public String toString() {
		return "PageInfo [totalResults=" + totalResults + ", resultsPerPage=" + resultsPerPage + "]";
	}
	
	

}
