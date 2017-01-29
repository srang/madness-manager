package com.github.srang.util;

import com.github.javafaker.Faker;
import com.github.srang.datafactory.BaseFieldPopulationStrategy;
import com.github.srang.datafactory.MalformedFilterException;
import com.github.srang.datafactory.ObjectFieldGenerationException;
import com.github.srang.datafactory.util.DateUtil;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

/**
 * Created by srang on 1/28/17.
 */
public class BracketFieldPopulationStrategy extends BaseFieldPopulationStrategy {
    private Map<String, List<String>> fieldMap;
    /**
     * <p>Constructor for BaseFieldPopulationStrategy.</p>
     *
     * @param faker a {@link Faker} object.
     */
    public BracketFieldPopulationStrategy(Faker faker) {
        super(faker);
        this.setIgnoredFields();
        this.setBaseFilters();
    }

    @Override
    public void init() {
        super.init();
        addFilter((fake, field, obj) -> {
            boolean b =  fieldMap.get(obj.getClass().getSimpleName()).contains(field.getName());
            return b;
        });
    }

    private void setBaseFilters() {
        //base string
        this.addFilter(
                (Field field) -> field.getType().equals(String.class),
                () -> faker.lorem().word()
        );

        // base integer
        this.addFilter(
                (Field field) -> field.getType().equals(Integer.class),
                () -> faker.number().numberBetween(0, Integer.MAX_VALUE)
        );

        // base big decimal
        this.addFilter(
                (Field field) -> field.getType().equals(BigDecimal.class),
                () -> new BigDecimal(faker.number().randomDouble(2, 1, 5000))
        );

        // base big decimal
        this.addFilter(
                (Field field) -> field.getType().equals(Long.class),
                () -> new Long(faker.number().numberBetween(Integer.MAX_VALUE, Long.MAX_VALUE))
        );

        // baseDate
        this.addFilter(
                (Field field) -> field.getType().equals(Date.class),
                () -> {
                    Date date;
                    try {
                        date = faker.date().between(DateUtil.getDateOnlyFromString("1901-01-01"), DateUtil.getDateOnlyFromString("2016-01-01"));
                    } catch (ParseException e) {
                        date = new Date();
                    }
                    return date;
                }
        );

        // birthDate
        this.addFilter(
                (Field field) -> field.getType().equals(Date.class) && field.getName().toLowerCase().contains("birthdate"),
                () -> {
                    Date date;
                    try {
                        date = faker.date().between(DateUtil.getDateOnlyFromString("1901-01-01"), DateUtil.getDateOnlyFromString("2006-01-01"));
                    } catch (ParseException e) {
                        date = new Date();
                    }
                    return date;
                }
        );

        // lastName
        this.addFilter(
                (Field field) -> field.getType().equals(String.class) && field.getName().toLowerCase().contains("lastname"),
                () -> faker.name().lastName()
        );

        // firstName
        this.addFilter(
                (Field field) -> field.getType().equals(String.class) && field.getName().toLowerCase().contains("firstname"),
                () -> faker.name().firstName()
        );




        String[] filters = {
                "organization", //
                "teamName",
                "address" //
        };

    }

    private void setIgnoredFields() {
        this.fieldMap = new HashMap<>();
        fieldMap.put("Game", Arrays.asList("bracket"));
        fieldMap.put("Team", Arrays.asList("region"));
        fieldMap.put("User", Arrays.asList("brackets"));
        fieldMap.put("UserRole", Arrays.asList("user"));
    }

    @Override
    public boolean populateField(Object obj, Field field) throws ObjectFieldGenerationException, MalformedFilterException {
        for (Filter filter : filters) {
            if (filter.process(faker, field, obj)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void ignoreField(String fieldName) {
        super.ignoredFields.add(fieldName);
    }

    @Override
    public void addFilter(Filter filter) {
        this.filters.push(filter);
    }
}
