package com.bite;

import java.util.ArrayList;
import java.util.List;

public class TestOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        // OOM
        List<OOMObject> data = new ArrayList<>();
        while (true) {
            data.add(new OOMObject());
        }
    }
}
