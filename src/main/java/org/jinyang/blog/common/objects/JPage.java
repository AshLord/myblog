package org.jinyang.blog.common.objects;

import java.util.List;

/**
 * Created by ${yaoting.guo} on 2016/12/29.
 */
public class JPage<T> {
    /**
     * 查询出的结果总数
     */
    private long iTotalRecords;
    private long iTotalDisplayRecords;
    private List<T> aaData;

    public long getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(long iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public long getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public List<T> getAaData() {
        return aaData;
    }

    public void setAaData(List<T> aaData) {
        this.aaData = aaData;
    }

    public JPage(long total, List<T> list){
        iTotalRecords=total;
        iTotalDisplayRecords=total;
        aaData=list;
    }
}
