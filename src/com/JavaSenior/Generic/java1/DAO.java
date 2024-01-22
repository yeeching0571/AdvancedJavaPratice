package com.JavaSenior.Generic.java1;

import java.util.List;

/**
 * @author Yijing He
 * @version 1.0
 * @description:
 * @date 2023/11/30 21:08
 */
public class DAO<T, E> {
    // 添加一条记录
    public void add(T t){}

    // 删除一条记录
    public boolean remove(){
        return false;
    }

    // 修改一条记录
    public T update(int index, T t){
        return null;
    }

    // 查询一条记录
    public T getIndex(int index){
        return null;
    }

    // 查询多条记录
    public List<T> getForList(int index){
        return null;
    }

    // 泛型方法
    public <E> E getValue(){
        return null;
    }

}
