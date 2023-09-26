package com.pepsico.retail.helpers;

import java.util.HashMap;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class DataStore {

    private Map<String, Object> scenarioContext = new HashMap<String, Object>();

    public void store(String key, Object value) {

        if (!scenarioContext.containsKey(key.toString())) {

            scenarioContext.put(key.toString(), value);

        }

        else {

            scenarioContext.replace(key.toString(), value);

        }

    }

    public <T> T get(String key) {

        return (T) scenarioContext.get(key);

    }

    public Boolean isContains(String key) {

        return scenarioContext.containsKey(key.toString());

    }

    public void update(String key, Object value) {

        scenarioContext.replace(key.toString(), value);

    }

}
