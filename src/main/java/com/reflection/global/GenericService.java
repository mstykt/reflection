package com.reflection.global;

import com.reflection.model.BaseModel;

import java.io.Serializable;

/**
 * Created by mesut on 27.07.2016.
 */
public interface GenericService<T extends BaseModel> extends Serializable {
    Long save(T t);

    T findById(Long id);

    T update(T t);

    T delete(T t);
}
