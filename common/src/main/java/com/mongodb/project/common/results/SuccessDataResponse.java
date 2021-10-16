package com.mongodb.project.common.results;

import java.util.List;
import java.util.Optional;

public class SuccessDataResponse<T> {

    private List<T> list;
    private Optional<T> optional;
    private Long totalCount;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Optional<T> getOptional() {
        return optional;
    }

    public void setOptional(Optional<T> optional) {
        this.optional = optional;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}