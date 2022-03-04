package org.abhi.tools.overlapper;

import java.lang.reflect.Field;

public class JavaObjectOverlapper {

    public static <T> void overlap(T base, T top, int level) throws IllegalAccessException {
        Class<?> clazz = base.getClass();
        for(Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Class<?> fieldType = field.getType();
            Object baseVal = field.get(base), topVal = field.get(top);
            if(!(fieldType.isPrimitive())) {
                //Only compare for non-primitives, as they already have default value
                if (level != 0 && topVal == null && baseVal != null) {
                    field.set(top, baseVal);
                } else if (topVal != null && baseVal != null) {
                    //If it's our code, then only compare else consider new one only.
                    if (fieldType.getPackageName().startsWith("org.abhi.")) {
                        overlap(baseVal, topVal, level+1);
                    }
                }
            }
        }
    }
}
