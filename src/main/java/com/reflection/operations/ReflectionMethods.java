package com.reflection.operations;

import com.reflection.config.AppConfig;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

/**
 * Created by mesut on 27.07.2016.
 */
public class ReflectionMethods {

    public static void main(String[] args) {
        Class aClass = AppConfig.class;

        Method[] methods = aClass.getDeclaredMethods();
        System.out.println("Methods: ");
        for (Method method : methods) {
            System.out.println(method.getName());
            //Parameters
            Parameter[] parameters = method.getParameters();
            System.out.println("Parameters: ");
            for (Parameter parameter : parameters) {
                    System.out.println(parameter.getName() + " - " + parameter.getType().toString());
            }
            //Return Type
            Type type = method.getReturnType();
            System.out.println("Return Type: " + type.toString());

            //Modifiers
            System.out.println("Modifiers: " + Modifier.toString(method.getModifiers()));
        }


    }
}
