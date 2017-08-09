package com.hwangfantasy.beautify.impl;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStreamReader;

/**
 * Created by hwangfantasy on 2017/8/9.
 */
public class BeautifyJs {
    public BeautifyJs() {
    }

    private static Invocable invocable;

    private static void initialize() {
        if (invocable != null) {
            return;
        }

        try {
            System.out.println("Initialize jsBeautify library");
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
            engine.eval(new InputStreamReader(BeautifyJs.class.getResourceAsStream("/jsBeautify.js")));
            invocable = (Invocable) engine;
        } catch (ScriptException e) {
            System.out.println("Can't load javascript jsBeautify.js" + e.getMessage());
        }
    }

    public static String beautifyJs(String sourceJs) {
        if (sourceJs == null || sourceJs.isEmpty()) {
            return sourceJs;
        }
        initialize();
        try {
            return (String) invocable.invokeFunction("js_beautify", sourceJs);
        } catch (Exception e) {
            System.out.println("Can't execute jsBeautify.js" + e.getMessage());
        }
        return "";
    }
}
