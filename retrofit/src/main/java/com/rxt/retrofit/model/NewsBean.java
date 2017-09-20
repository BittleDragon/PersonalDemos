package com.rxt.retrofit.model;

import java.util.ArrayList;
import java.util.List;

public class NewsBean {

    private boolean error;
    private List<NewsResultBean> results = new ArrayList<>();

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<NewsResultBean> getResults() {
        return results;
    }

    public void setResults(List<NewsResultBean> results) {
        this.results = results;
    }

    public static class NewsResultBean {

        private String type;
        private String publishedAt;
        private String desc;
        private String who;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

    }
}