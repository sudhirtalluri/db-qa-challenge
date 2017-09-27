package com.db.config;

import com.db.am.bauhaus.project.SessionVar;
import net.serenitybdd.core.Serenity;

public class SerenityFacade {
    public static <T> void setData(SessionVar key, T value) {
        Serenity.setSessionVariable(key).to(value);
    }

    public static <T> T getData(SessionVar key) {
        return Serenity.sessionVariableCalled(key);
    }
}
