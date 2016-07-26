package com.reflection.global;

import com.reflection.model.BaseModel;

/**
 * Created by mesut on 27.07.2016.
 */
public interface GenericDAO<T extends BaseModel> {
    Long save(T t);

    T findById(Long id);

    T update(T t);

    T delete(T t);
}
