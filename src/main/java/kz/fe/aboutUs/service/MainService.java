package kz.fe.aboutUs.service;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.fe.aboutUs.model.Click;
import kz.fe.aboutUs.model.Value;
import kz.fe.aboutUs.repository.ClickRepository;
import kz.fe.aboutUs.repository.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class MainService {

    @Autowired
    ClickRepository clickRepository;

    @Autowired
    ValueRepository valueRepository;

    public void newClick(String json) throws JacksonException {
        ObjectMapper objectMapper = new ObjectMapper();
        Value value = objectMapper.readValue(json, Value.class);
        Click click = new Click();
        click.setTime(LocalDateTime.now(ZoneId.of("Asia/Almaty")));
        click.setValue(valueRepository.findValueByName(value.getName()));
        clickRepository.save(click);
    }
}
