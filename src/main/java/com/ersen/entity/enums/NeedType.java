package com.ersen.entity.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum NeedType {
	PAYABLE, FREE;
	
	private static Map<String, NeedType> namesMap = new HashMap<String, NeedType>(2);

    static {
        namesMap.put("PAYABLE", PAYABLE);
        namesMap.put("FREE", FREE);
    }

    @JsonCreator
    public static NeedType forValue(String value) {
        return namesMap.get(StringUtils.upperCase(value));
    }

    @JsonValue
    public String toValue() {
        for (Entry<String, NeedType> entry : namesMap.entrySet()) {
            if (entry.getValue() == this)
                return entry.getKey();
        }

        return null; // or fail
    }
}
