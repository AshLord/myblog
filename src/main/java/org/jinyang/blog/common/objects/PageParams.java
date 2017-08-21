package org.jinyang.blog.common.objects;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页参数
 * Created by ${yaoting.guo} on 2016/12/29.
 */
public class PageParams {
    /**
     * 页数
     */
    private int iDisplayLength = 10;
    /**
     * 从哪开始
     */
    private int iDisplayStart = 0;

    private String sort;
    /**
     * 排序参数
     */
    private String order;

    private Map<String, Object> params;

    public int getiDisplayLength() {
        return iDisplayLength;
    }

    public void setiDisplayLength(int iDisplayLength) {
        this.iDisplayLength = iDisplayLength;
    }

    public int getiDisplayStart() {
        return iDisplayStart;
    }

    public void setiDisplayStart(int iDisplayStart) {
        this.iDisplayStart = iDisplayStart;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Map<String, Object> getParams() {
        if (params == null) {
            params = new HashMap<String, Object>();
        }
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Map<String, Object> getQueryParams() {
        if (params == null) {
            params = new HashMap<String, Object>();
        }
        if (params.size() > 0) {
            List<String> invalidKeyList = new ArrayList<String>();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    invalidKeyList.add(key);
                } else {
                    if (value instanceof String && ("".equals(value) || "\"\"".equals(value))) {
                        invalidKeyList.add(key);
                    }
                }
            }
            for (String key : invalidKeyList) {
                params.remove(key);
            }
        }
        params.put("offset", getOffset());
        params.put("limit", getLimit());
        if (!StringUtils.isEmpty(sort)) {
            params.put("sort", sort);
        }
        if (!StringUtils.isEmpty(order)) {
            params.put("order", order);
        }
        return params;
    }

    /**
     * 从哪一行开始
     *
     * @return
     */
    public int getOffset() {
        return iDisplayStart;
    }

    /**
     * 每页显示行数
     *
     * @return
     */
    public int getLimit() {

        return iDisplayLength;
    }

    public String getString(String key, String defaultValue) {
        if (params != null) {
            Object obj = params.get(key);
            if (obj != null && obj instanceof String) {
                return (String) obj;
            }
        }
        return defaultValue;
    }

    public int getInt(String key, int defaultValue) {
        if (params != null) {
            Object obj = params.get(key);
            if (obj != null && obj instanceof String
                    && !"".equals(((String) obj).trim())) {
                return Integer.parseInt((String) obj);
            }
        }

        return defaultValue;
    }

}
