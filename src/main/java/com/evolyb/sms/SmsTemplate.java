package com.evolyb.sms;

import java.lang.reflect.Field;

public class SmsTemplate {
    public static String welcome = "Hello @User,\nWelcome @User at @Location";
    public static String getSmsResponse(String template, Object data){
        try {
            Class clazz = data.getClass();
            Object smsVariables = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String value = (String) field.get(smsVariables);
                String replaceValue = (String) field.get(data);
                if (replaceValue == null || replaceValue.equals(value)) continue;
                template = template.replace(value, replaceValue);
            }
            return template;
        }
        catch (Exception e){
            return "";
        }
    }
}
