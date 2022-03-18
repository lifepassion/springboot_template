package com.dreamtech.appName.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.List;

public class PageHandler {

    /**
     * 分页函数
     *
     * @param currentPage 当前页数
     * @param pageSize    每一页的数据条数
     * @param list        要进行分页的数据列表
     * @return 当前页要展示的数据
     */
    public static <T> Page<T> getPages(long currentPage, long pageSize, List<T> list) {
        Page<T> page = new Page<>();
        long size = list.size();

        List<T> pageList = new ArrayList<>();

        if (size == 0) {
            page.setTotal(0).setRecords(pageList);
            return page;
        }

        //页面数不不能大于数据总数
        if (pageSize > size) {
            pageSize = size;
        }

        // 求出最大页数，防止currentPage越界
        long maxPage = size % pageSize == 0 ? size / pageSize : size / pageSize + 1;

        if (currentPage > maxPage) {
            currentPage = maxPage;
        }

        // 当前页第一条数据的下标
        long curIdx = currentPage > 1 ? (currentPage - 1) * pageSize : 0;


        // 将当前页的数据放进pageList
        for (int i = 0; i < pageSize && curIdx + i < size; i++) {
            pageList.add(list.get(Math.toIntExact(curIdx + i)));
        }

        page.setCurrent(currentPage).setSize(pageSize).setTotal(list.size()).setRecords(pageList);
        return page;
    }

}
