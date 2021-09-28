package com.mongodb.project.common.results;

import java.util.List;

public class SuccessListResponse<T> {

    private List<T> list;
    private Long totalCount;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}