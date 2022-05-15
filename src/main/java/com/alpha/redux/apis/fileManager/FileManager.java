package com.alpha.redux.apis.fileManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

enum dynamicTypes{
    INTEGER
}

public class FileManager {

    HashMap containerMap = new HashMap<>();
    String configName = "null";

    public FileManager(HashMap map, String configName) {


        this.containerMap = map;
        this.configName = configName;


    }
    
}
