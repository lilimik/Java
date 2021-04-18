package ru.itis.springbootsemester.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class SmsServiceSmsRuImpl implements SmsService {

//    Вместо этого подключили аннотацию Slf4j
//    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${sms.ru.url}")
    private String smsUrl;

    @Value("${sms.ru.api}")
    private String apiId;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void sendSms(String phone, String text) {
        StringBuilder url = new StringBuilder();
        url.append(smsUrl);
        url.append("?api_id=");
        url.append(apiId);
        url.append("&to=");
        url.append(phone);
        url.append("&msg=");
        url.append(text);
        url.append("&json=1");

        log.info(url.toString());
        String result = restTemplate.getForObject(url.toString(), String.class);
        log.info(result);
    }
}
