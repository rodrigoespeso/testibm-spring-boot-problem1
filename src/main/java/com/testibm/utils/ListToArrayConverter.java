package com.testibm.utils;

import java.util.List;

public class ListToArrayConverter<T> {
    
    public T[] convert(List<T> list, Class<T> clazz) {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, list.size());
        return list.toArray(array);
    }
}
