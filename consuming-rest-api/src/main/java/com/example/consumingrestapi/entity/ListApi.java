package com.example.consumingrestapi.entity;

import java.util.List;

public class ListApi {
    private int count;

    public ListApi(int count, List<Api> entries) {
        this.count = count;
        this.entries = entries;
    }

    private List<Api> entries;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Api> getEntries() {
        return entries;
    }

    public void setEntries(List<Api> entries) {
        this.entries = entries;
    }
}
