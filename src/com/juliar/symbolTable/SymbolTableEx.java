package com.juliar.symbolTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by don on 4/8/17.
 */
public class SymbolTableEx {
    public String levelName;
    public List<SymbolTableEx> scope = new ArrayList<>();
}