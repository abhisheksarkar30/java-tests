package org.abhi.tools.overlapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDefinedBaseClass {

    private String udbString;
    private int udbInt;
    private Integer udbIntW;
    private boolean udbBool;
    private Boolean udbBoolW;
    private String[] udbStringA;
    private UserDefinedChildClass udbChildObj;
    private UserDefinedChildClass[] udbChildObjA;
}