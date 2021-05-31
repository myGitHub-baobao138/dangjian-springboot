package com.partybuilding.webserver.dto.system.partyInformation;

import java.util.List;

public class SelectSnoAndName {
    String name;
    List<SnoAndId> List;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.util.List<SnoAndId> getList() {
        return List;
    }

    public void setList(java.util.List<SnoAndId> list) {
        List = list;
    }
}

