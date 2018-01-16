package com.pei.app.annotation;


import java.lang.annotation.Annotation;

@AnnoContainer({@JavaAnno, @JavaAnno})
//@JavaAnno
//@JavaAnno
public class AnnotationTest {

    public static void main(String[] args){
        Annotation[] annotations = SubClass.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}

class SubClass extends AnnotationTest{

}
