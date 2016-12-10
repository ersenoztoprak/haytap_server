package com.ersen.entity.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserType {
	INDVL, CORP;
	
	private static Map<String, UserType> namesMap = new HashMap<String, UserType>(2);

    static {
        namesMap.put("INDVL", INDVL);
        namesMap.put("CORP", CORP);
    }

    @JsonCreator
    public static UserType forValue(String value) {
        return namesMap.get(StringUtils.upperCase(value));
    }

    @JsonValue
    public String toValue() {
        for (Entry<String, UserType> entry : namesMap.entrySet()) {
            if (entry.getValue() == this)
                return entry.getKey();
        }

        return null; // or fail
    }
}
