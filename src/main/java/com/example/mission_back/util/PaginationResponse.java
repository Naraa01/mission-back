package com.example.mission_back.util;

import com.example.mission_back.product.data.ProductResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PaginationResponse {
  @JsonProperty("list")
  private List<ProductResponse> list; // ProductResponse-уудыг агуулсан List

  @JsonProperty("page")
  private int page; // Хуудасны дугаар

  @JsonProperty("total")
  private long total; // Нийт бүтээгдэхүүн

  @JsonProperty("max")
  private int max; // Хуудас бүрт харуулах тоо

  // public PaginationResponse(List<ProductResponse> list, int page, int total, long max) {
  public PaginationResponse(List<ProductResponse> list, int page, long total, int max) {
    this.list = list;
    this.page = page;
    this.total = total;
    this.max = (int) max; // max бол тоо учраас long -> int
  }

  // Getters and Setters
}

// package com.example.mission_back.util;

// import com.fasterxml.jackson.annotation.JsonProperty;
// import java.util.List;

// public class PaginationResponse {

// @JsonProperty("list")
// private List<ProductResponse> list; // ProductResponse-уудыг агуулсан List

// @JsonProperty("page")
// private int page; // Хуудасны дугаар

// @JsonProperty("total")
// private long total; // Нийт бүтээгдэхүүн

// @JsonProperty("max")
// private int max; // Хуудас бүрт харуулах тоо

// // Constructor, Getters, Setters
// public PaginationResponse(List<ProductResponse> list, int page, long total,
// int max) {
// this.list = list;
// this.page = page;
// this.total = total;
// this.max = max;
// }

// // Getters
// public List<ProductResponse> getList() {
// return list;
// }

// public int getPage() {
// return page;
// }

// public long getTotal() {
// return total;
// }

// public int getMax() {
// return max;
// }

// // Setters
// public void setList(List<ProductResponse> list) {
// this.list = list;
// }

// public void setPage(int page) {
// this.page = page;
// }

// public void setTotal(long total) {
// this.total = total;
// }

// public void setMax(int max) {
// this.max = max;
// }
// }
