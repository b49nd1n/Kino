package ru.sfedu.pKino.repository.interfaces;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;


@Root(name = "List")
public class XmlWrapper {

    @ElementList(inline = true, required = false)
    public List list;

    public XmlWrapper() {
    }

    public <T extends Entity> XmlWrapper(List<T> list) {

        this.list = list;

    }

    public <T extends Entity> List<T> getList() {
        return list;
    }

    public <T extends Entity> void setList(List<T> list) {
        this.list = list;
    }


}



