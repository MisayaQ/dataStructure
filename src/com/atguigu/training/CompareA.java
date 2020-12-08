package com.atguigu.training;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: LiuJiaQi
 * @create: 2020-12-07 21:25
 **/
public class CompareA {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException {
        AAAA aaaa = new AAAA("家岐");
        AAAA bbbb = new AAAA("家岐1");
        List<Map<String, Object>> maps = compareTwoClass(aaaa, bbbb);
        for (Map<String, Object> map : maps) {
            Set<String> set = map.keySet();
            for (String s : set) {
                System.out.println(s + " " + map.get(s));
            }
        }

    }


    public static List<Map<String, Object>> compareTwoClass(Object class1, Object class2) throws ClassNotFoundException, IllegalAccessException {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        //获取对象的class
        Class<?> clazz1 = class1.getClass();
        Class<?> clazz2 = class2.getClass();
        //获取对象的属性列表
        Field[] field1 = clazz1.getDeclaredFields();
        Field[] field2 = clazz2.getDeclaredFields();
        //遍历属性列表field1
        for (int i = 0; i < field1.length; i++) {
            //遍历属性列表field2
            for (int j = 0; j < field2.length; j++) {
                //如果field1[i]属性名与field2[j]属性名内容相同
                if (field1[i].getName().equals(field2[j].getName())) {
                    field1[i].setAccessible(true);
                    field2[j].setAccessible(true);
                    //如果field1[i]属性值与field2[j]属性值内容不相同
                    if (!compareTwo(field1[i].get(class1), field2[j].get(class2))) {
                        Map<String, Object> map2 = new HashMap<String, Object>();
                        System.out.println("属性值不同");
                        map2.put("name", field1[i].getName());
                        map2.put("对象1中属性："+field1[i].getName()+"的值为", field1[i].get(class1));
                        map2.put("对象2中属性："+field1[j].getName()+"的值为", field2[j].get(class2));
                        list.add(map2);
                    } else {
                        System.out.println("属性值相同");
                        break;
                    }

                }
            }
        }

        return list;
    }

    //对比两个数据是否内容相同
    public static boolean compareTwo(Object object1, Object object2) {

        if (object1 == null && object2 == null) {
            return true;
        }
        //以下注掉代码，看具体需求。因有时会出现源数据是没有进行赋值，因此是null；而通过EditText获取值的时候，虽然没有值，但是会变成""，但是本质是没有赋值的。
        //if (object1 == "" && object2 == null) {
        //    return true;
        //}
        //if (object1 == null && object2 == "") {
        //    return true;
        // }
        if (object1 == null && object2 != null) {
            return false;
        }
        if (object1.equals(object2)) {
            return true;
        }
        return false;
    }


}
