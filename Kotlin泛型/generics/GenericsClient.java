package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GenericsClient {

    public static void main(String[] args) {
        testCollections();
//        testGenericsClass();
//        testGenericClass2();
    }

    /**
     * 为什么要引入泛型？运行时的错误在编译时发现
     */
    private static void testCollections(){
        List arrayList = new ArrayList();
        arrayList.add("abc");
        arrayList.add(11);

        int size = arrayList.size();
        for(int i = 0; i < size; i++){
            Object o = arrayList.get(i);
//            println(o.toString());
            println((String)o);
        }
    }

    private static void testCollections2(){
//        List<String> arrayList = new ArrayList();
//        arrayList.add("abc");
//        arrayList.add(11);
//
//        int size = arrayList.size();
//        for(int i = 0; i < size; i++){
//            Object o = arrayList.get(i);
//            println((String)o);
//        }
    }

    private static void testGenericsClass(){
        List<String> stringList = new ArrayList<>();
        stringList.add("test");

        List<Integer> integerList = new ArrayList<>();
        integerList.add(123);

        Class<? extends List> stringListClass = stringList.getClass();
        Class<? extends List> integerListClass = integerList.getClass();

        if(stringListClass.equals(integerListClass)){
            println("类型相同");
        }
    }

    /**
     * 提高了代码表现力
     */
    private static void testGenericClass2(){
        Generic<String> g = new Generic<>("test");
        String key = g.getKey();


        Generic<Integer> g2 = new Generic<>(223);
        Integer g2Key = g2.getKey();
        println("" + g2Key);
    }

    private static void testGenericVersion(Generic<? extends Number> generic){
        Number number = generic.getKey();
        println(""+number);
    }

    private static void testGenericVersionClient(){
        Generic<Integer> generic = new Generic<>(111);
        Generic<Number> generic1 = new Generic<>(222);

        testGenericVersion(generic);
    }

    private <T> T generator(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        T t = tClass.newInstance();
        return t;
    }

    private <E> void testGenericArray(E e){
        List<? extends Apple> list = new ArrayList<RedApple>();
        Apple apple = list.get(0);

        List<? super Apple> list2 = new ArrayList<Fruit>();
        Object object = list2.get(0);
        list2.add(new RedApple());

        testM(new Double(1));
        testM(new Float(1f));
    }

    private void testM(Number number){
        println(number + "");
    }

    private void testExtendWildcard(){
        List<? super Fruit> listSuper = new ArrayList<>();
        listSuper.add(new RedApple());
        listSuper.add(new Fruit());
        Object object = listSuper.get(0);

        List<? extends Fruit> listExtends = new ArrayList<>();
        Fruit fruit = listExtends.get(0);
        testCovariant(new Apple());
    }

    private void test(){
        Number[] array = new Integer[4];
    }

    /**
     * 协变与逆变
     * @param fruit
     */
    private void testCovariant(Fruit fruit){
        List<? super Integer> list = new ArrayList<Number>();
        List<? extends Number> list1 = new ArrayList<Integer>();
    }


    private static void println(String msg){
        System.out.println(msg);
    }

    private static void copyAll(Collection<Object> to, Collection<String> from){
        to.addAll(from);
    }

    /**
     * ？通配符
     */
    private static void testWildcard(){
        List<Object> list = new ArrayList<>();
        list.add("");
        list.add(12);

        List<?> list2 = new ArrayList<>();
        Object o = list2.get(0);

        List<? super Object> list3 = new ArrayList<>();
        list3.add("test");
        list3.add(111);


    }
}
