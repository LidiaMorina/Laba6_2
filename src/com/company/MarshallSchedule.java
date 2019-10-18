package com.company;
import javax.xml.bind.annotation.*;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
/* определение последовательности элементов XMLсв*/
@XmlType(name = "professor", propOrder = {
        "numderOfLessons",
        "numderOfStudents",
        "object"
}) // задание последовательности элементов XML
public class MarshallSchedule {
    @XmlAttribute(required = true)
    private String FIO;
    @XmlElement(required = true)
    private String numderOfLessons;
    @XmlElement(required = true)
    private String numderOfStudents;
    @XmlElement(required = true)
    private Object object = new Object();

    @Override
    public String toString() {
        return "\nFIO: " + FIO +
                "\nnumderOfLessons: " + numderOfLessons +
                "\nnumderOfStudents: " + numderOfStudents +
                object.toString();
    }

    // необходим для маршаллизации/демаршалиизации XML
    public MarshallSchedule(){ }
    public MarshallSchedule(String FIO, String numderOfLessons, String numderOfStudents, Object object){
        this.FIO = FIO;
        this.numderOfLessons = numderOfLessons;
        this.numderOfStudents = numderOfStudents;
        this.object = object;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getNumderOfLessons() {
        return numderOfLessons;
    }

    public void setNumderOfLessons(String numderOfLessons) {
        this.numderOfLessons = numderOfLessons;
    }

    public String getNumderOfStudents() {
        return numderOfStudents;
    }

    public void setNumderOfStudents(String numderOfStudents) {
        this.numderOfStudents = numderOfStudents;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }


    @XmlRootElement
    @XmlType(name = "object ", propOrder = {
            "nameObject",
            "week",
            "cabinet"
    })
    public  static class Object {
        @Override
        public String toString() {
            return "\nnameObject: " + nameObject+"\ncabinet: " + cabinet + "\nweek: " + week ;
        }

        private String nameObject;
        private String week;
        private String cabinet;

        // необходим для маршаллизации/демаршалиизации XML
        public Object() { }
        public Object(String nameObject, String week, String cabinet){
            this.cabinet = cabinet;
            this.nameObject =nameObject;
            this.week = week;
        }

        public String getNameObject() {
            return nameObject;
        }

        public void setNameObject(String nameObject) {
            this.nameObject = nameObject;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getCabinet() {
            return cabinet;
        }

        public void setCabinet(String cabinet) {
            this.cabinet = cabinet;
        }


    }
}
