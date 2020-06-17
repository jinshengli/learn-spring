package com.ljs.entity;

/**
 * create by ljs on 2020/6/16 15:40
 * <p>
 * description:
 */
public class Sale {

    private Integer id;
    private Integer gid;
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", gid=" + gid +
                ", count=" + count +
                '}';
    }
}
