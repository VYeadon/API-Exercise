package com.qa.util;

import com.google.gson.Gson;

public class JSONToJavaUtility {

	// No statics needs to be injected when its called
	
    private Gson gson = new Gson();;

    public JSONToJavaUtility() {
        this.gson = new Gson();
    }

    public String getJSONFromObject(Object obj) {
        return gson.toJson(obj);
    }

    public <T> T getObjectFromJSON(String jsonString, Class<T> clazz) {
        return gson.fromJson(jsonString, clazz);
    }

}

