package com.reflection.operations;

import com.reflection.model.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by mesut on 27.07.2016.
 */
public class ReflectionFields {

    public static void main(String[] args) throws Throwable{
        Person person = new Person(Long.valueOf(25), "name", "surname", 29, "address", "city");
        String str = "";

        Field[] fields = Person.class.getDeclaredFields();
        System.out.println("Declared Fields: ");
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Field[] flds = person.getClass().getDeclaredFields();
        for (Field fld : flds) {
            if ("String".equals(fld.getType().getSimpleName())) {
                Field f = person.getClass().getDeclaredField(fld.getName());
                f.setAccessible(true);
                str += f.get(person) + " - ";
            }


        }

        System.out.println("Fields: " + str);

        //Setting operation
        Field field = person.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(person, "newname");
        System.out.println("Name: " + person.getName());

        //Field Type
        Field field1 = Person.class.getDeclaredField("id");
        System.out.println(field1.getGenericType().toString());

        //Modifiers
        System.out.println("Modifiers: " + Modifier.toString(field1.getModifiers()));

        Annotation[] annotations = field1.getAnnotations();
        System.out.println("Annotations: ");
        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
        }
    }
}
