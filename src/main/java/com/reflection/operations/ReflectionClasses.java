package com.reflection.operations;

import com.reflection.global.GenericDAOImpl;
import com.reflection.global.GenericService;
import com.reflection.model.Person;
import com.reflection.person.impl.PersonController;
import com.reflection.person.impl.PersonServiceImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by mesut on 27.07.2016.
 */
public class ReflectionClasses {

    public static void main(String[] args) {
        Class aClass = Person.class;

        /*
            Name Part
         */
        String className = aClass.getName();
        String canonicalName = aClass.getCanonicalName();
        String simpleName = aClass.getSimpleName();
        String typeName = aClass.getTypeName();
        System.out.println("Class name: " + className);
        System.out.println("Canonical name: " + canonicalName);
        System.out.println("Simple name: " + simpleName);
        System.out.println("Type name: " + typeName);


        /*
            Modifiers Part
         */
        int modifiers = aClass.getModifiers();
        System.out.println("Modifiers: " + modifiers);
        System.out.println("Modifiers 2: " + GenericDAOImpl.class.getModifiers());

        System.out.println("Modifiers: " + Modifier.toString(aClass.getModifiers()));
        System.out.println("Modifiers 2: " + Modifier.toString(GenericDAOImpl.class.getModifiers()));
        System.out.println("Modifier 3: " + Modifier.toString(GenericService.class.getModifiers()));

        /*
            Package Part
         */
        Package aPackage = aClass.getPackage();
        System.out.println("Package: " + aPackage.getName());


        /*
            SuperClass Part
         */
        Class superClass = aClass.getSuperclass();
        System.out.println("Superclass: " + superClass.getName());

        /*
            Interface Part
         */
        Class[] interfaces = GenericDAOImpl.class.getInterfaces();
        System.out.println("Interfaces: ");
        for (Class i : interfaces) {
            System.out.println(i.getName());
        }

        /*
            Constructor Part
            Constructor Kısmında detaylı incelenecektir.
         */
        Constructor[] constructors = Person.class.getConstructors();

        /*
            Method Part
         */
        Method[] methods = PersonController.class.getDeclaredMethods(); //Show just its own methods none of Super Class
        //Method[] methods = PersonController.class.getMethods(); Show all own and  super class methods
        System.out.println("Methods: ");
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        /*
            Field Part
         */
        //Field[] fields = aClass.getFields(); For public fields
        Field[] fields = aClass.getDeclaredFields(); //For all fields
        System.out.println("Fields: ");
        for (Field field : fields) {
            String fieldName = field.getName();
            System.out.println(fieldName);
        }

        /*
            Annotation Part
         */
        Annotation[] annotations = PersonServiceImpl.class.getAnnotations();
        System.out.println("Annotations: ");
        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
        }

    }
}
