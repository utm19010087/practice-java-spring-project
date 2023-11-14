package org.utma.ItepTest.model.service;

import java.util.List;

public interface IService <T>
{
    public void save(T t);
    public void deleteById(Long id);
    public T findById(Long id);
    public List<T> findAll();
}
