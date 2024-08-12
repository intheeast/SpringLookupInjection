package com.intheeast.springframe.lookupinjection;

public interface Command {
    void setState(Object state);
    Object execute();
}
