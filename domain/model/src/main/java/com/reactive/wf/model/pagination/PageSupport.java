package com.reactive.wf.model.pagination;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PageSupport<T> {

    public static final String FIRST_PAGE_NUM = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";

    private List<T> content;

    private int pageNumber;
    private int pageSize;
    private long totalElements;

    private long totalPages;
    private boolean first;
    private boolean last;

    public PageSupport(List<T> content, int pageNumber, int pageSize, long totalElements) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        totalPages();
        first();
        last();
    }

    public void totalPages() {
        totalPages = pageSize > 0 ? (totalElements - 1) / pageSize + 1 : 0;
    }

    public void first() {
        first = pageNumber == Integer.parseInt(FIRST_PAGE_NUM);
    }

    public void last() {
        last = (pageNumber + 1) * pageSize >= totalElements;
    }
}
