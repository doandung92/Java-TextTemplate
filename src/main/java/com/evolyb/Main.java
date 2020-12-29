package com.evolyb;

import com.evolyb.sms.SmsTemplate;
import com.evolyb.sms.welcome.SmsDataSource;

public class Main {
    public static void main(String[] args) {
        SmsDataSource smsDataSource = new SmsDataSource();
        smsDataSource.setUser("Mr A");
        smsDataSource.setLocation("Duy Tan");
        String str = SmsTemplate.getSmsResponse(SmsTemplate.welcome, smsDataSource);
        System.out.println(str);
    }
}
