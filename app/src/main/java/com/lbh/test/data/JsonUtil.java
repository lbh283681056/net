package com.lbh.test.data;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


/**
 * Created by linbinghuang
 * Date 2015/10/13
 * json解析
 */
public class JsonUtil {

    //json变成类
    public static Object parsData(String json, Class clazz) {
        try {

            return JSON.parseObject(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }


    //json变成类(含泛型)
    public static Object parsData(String json, TypeReference type) {
        try {
            return JSON.parseObject(json, type.getType());

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
    public static <T> T parseObject(String json, Type type) {
        return JSON.parseObject(json, type);
    }

    //json对象转字符串
    public static String objectToString(Object o) {
        try {

            return JSON.toJSONString(o, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullBooleanAsFalse);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }



    /**
     * json转list 解决解析出来的数据解析出来是LinkTreeMap问题
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> parseToList(String json, Class clazz) {
        try {
            Type type = new ParameterizedTypeImpl(clazz);
            List<T> list = new Gson().fromJson(json, type);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }




    /**
     * HashMap<String,Integer>为例
     */
    private static class ParameterizedTypeImpl implements ParameterizedType {
        Class clazz;

        public ParameterizedTypeImpl(Class clz) {
            clazz = clz;
        }

        /**
         * 返回实际类型组成的数据，即new Type[]{String.class,Integer.class}
         *
         * @return
         */
        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{clazz};
        }

        /**
         * 返回原生类型，即 HashMap
         *
         * @return
         */
        @Override
        public Type getRawType() {
            return List.class;
        }

        /**
         * 返回 Type 对象，表示此类型是其成员之一的类型。
         * 例如，如果此类型为 O<T>.I<S>，则返回 O<T> 的表示形式。 如果此类型为顶层类型，则返回 null。这里就直接返回null就行了。
         *
         * @return
         */
        @Override
        public Type getOwnerType() {
            return null;
        }
    }




}
