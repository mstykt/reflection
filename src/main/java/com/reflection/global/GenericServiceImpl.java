package com.reflection.global;

import com.reflection.model.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by mesut on 27.07.2016.
 */
public abstract class GenericServiceImpl<T extends BaseModel> implements Serializable, GenericService<T> {

    @Autowired
    protected GenericDAO<T> genericDAO;

    @Override
    public Long save(final T t) {
        if (t == null) {
            throw new RuntimeException("Save failed. Object can not be null!");
        }

        return genericDAO.save(t);
    }

    @Override
    public T findById(final Long id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("findById failed. Id can not be null or less then 0!");
        }

        return genericDAO.findById(id);
    }

    @Override
    public T update(final T t) {
        if (t == null) {
            throw new RuntimeException("Update failed. Object Can not be null!");
        }

        return genericDAO.update(t);
    }

    @Override
    public T delete(final T t) {
        if (t == null) {
            throw new RuntimeException("Delete failed. Object can not be null!");
        }

        return genericDAO.delete(t);
    }
}
