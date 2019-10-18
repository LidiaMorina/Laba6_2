package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Schedule.class);
            Marshaller m = context.createMarshaller();

            // анонимный класс
            Schedule schedule = new Schedule() {
                {

                    //добавление первый предмет
                    MarshallSchedule.Object obj = new MarshallSchedule.Object("Programming", "Friday", "Г312");
                    MarshallSchedule mS = new MarshallSchedule("Petrov P.P", "12", "30", obj);
                    this.add(mS);

                    //добавление  второй предмет
                    obj = new MarshallSchedule.Object("Database", "Wednesday", "А502");
                    mS = new MarshallSchedule("Ivanov I.I.", "5", "18", obj);
                    this.add(mS);
                     //добавление третий предмет
                    obj = new MarshallSchedule.Object("Math", "Tuesday", "Д202");
                    mS = new MarshallSchedule("Sidirov S.S.", "7", "20", obj);
                    this.add(mS);
                }
            };

            //маршелизация
            m.marshal(schedule, new FileOutputStream("example.xml"));
            System.out.println("XML-файл создан");

             //демаршелизация
            System.out.println("Демаршелизация XML:");
            Unmarshaller u = context.createUnmarshaller();
            FileReader reader = new FileReader("example.xml");
            Schedule  unmarshalSchedule = (Schedule) u.unmarshal(reader) ;
            System.out.println(unmarshalSchedule);

        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не может быть создан: " + e);
        } catch (JAXBException e) {
            System.out.println("JAXB-контекст ошибочен " + e);
        }
    }
}
