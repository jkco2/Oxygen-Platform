package com.ethercraft.result;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageResult<T> {

    // 当前页数据
    private List<T> records;

    // 总记录数
    private Long total;

    // 当前页码
    private int page;

    // 每页数量
    private int size;

    // 总页数
    private int pages;

}
