package org.srang.madness.manager.model.forms;

import java.util.HashMap;

/**
 * Created by srang on 1/22/17.
 */
public class FormMap<K, V> extends HashMap<K, V> {
    Class valueClazz;

    public FormMap(Class clazz) {
        this.valueClazz = clazz;
    }

    @Override
    public V get(Object key) {
        V value = super.get(key);
        if (value == null) {
            try {
                value = (V)valueClazz.newInstance();
                this.put((K)key, value);
            } catch (InstantiationException|IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return value;
    }
}
