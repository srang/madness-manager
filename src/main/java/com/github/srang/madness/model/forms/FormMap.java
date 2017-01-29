package com.github.srang.madness.model.forms;

import java.util.HashMap;
import java.util.function.Supplier;

/**
 * Created by srang on 1/22/17.
 */
public class FormMap<K, V> extends HashMap<K, V> {
    Class valueClazz;
    Supplier<V> instance;

    public FormMap(Class clazz) {
        this.valueClazz = clazz;
    }
    public FormMap(Supplier<V> fn) { this.instance = fn; }

    @Override
    public V get(Object key) {
        V value = super.get(key);
        if (value == null) {
            value = instance();
            this.put((K)key, value);
        }
        return value;
    }
    public V instance() {
        if(instance != null) {
            return instance.get();
        } else {
            try {
                return (V)valueClazz.newInstance();
            } catch (InstantiationException|IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
