package com.company;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Schedule {
    @XmlElement(name="professor")
    private ArrayList<MarshallSchedule> list = new ArrayList<MarshallSchedule>();


    public  Schedule() {
        super();
    }
    public void setList(ArrayList<MarshallSchedule> list) {
        this.list = list;
    }
    public boolean add(MarshallSchedule mS) {
        return list.add(mS);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "list=" + list +
                '}';
    }
}
