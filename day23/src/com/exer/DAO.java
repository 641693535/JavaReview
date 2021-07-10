package com.exer;

import java.util.*;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-13 18:42
 */
public class DAO<T> {

    Map<String, T> map;

    public DAO() {
        map = new HashMap<String, T>();
    }

    public DAO(Map<String, T> map) {
        this.map = map;
    }

    /**
     * 保存T类型的对象到Map成员变量中；
     * @param id
     * @param entity
     */
    public void save(String id, T entity) {
        map.put(id, entity);
    }

    /**
     * 从Map中获取id对应的对象
     * @param id
     * @return
     */
    public T get(String id) {
        return map.get(id);
    }

    /**
     * 替换map中key为id 的内容，改为entity对象
     * @param id
     * @param entity
     */
    public void update(String id, T entity) {
        if (map.containsKey(id)) {
            map.put(id, entity);
        }
    }

    /**
     * 返回map中存放的所有T对象
     * @return
     */
    public List<T> list(){
        ArrayList<T> arr = new ArrayList<>();
        Collection<T> values = map.values();
        Iterator<T> iterator = values.iterator();
        while (iterator.hasNext()) {
            arr.add((T) iterator.next());
        }
        return arr;
    }

    /**
     * 删除指定id对象
     * @param id
     */
    public void delete(String id) {
        map.remove(id);
    }
}
