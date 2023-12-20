package kz.fe.aboutUs.service;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.fe.aboutUs.model.Click;
import kz.fe.aboutUs.model.ClickCount;
import kz.fe.aboutUs.model.Value;
import kz.fe.aboutUs.repository.ClickRepository;
import kz.fe.aboutUs.repository.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class MainService {

    @Autowired
    ClickRepository clickRepository;

    @Autowired
    ValueRepository valueRepository;

    public void newClick(String _json) throws JacksonException {
        ObjectMapper objectMapper = new ObjectMapper();
        Value value = objectMapper.readValue(_json, Value.class);
        Click click = new Click();
        click.setDate(LocalDate.now());
        click.setValue(valueRepository.findValueByName(value.getName()));
        clickRepository.save(click);
    }

//    public List<Click> getClicksByDate(LocalDate _localDate){
//       return clickRepository.findClickByDate(_localDate);
//    }

    public List<Click> getClickBetweenDate(LocalDate _localDate1, LocalDate _localDate2){
        return clickRepository.findClickByDateBetween(_localDate1, _localDate2);
    }

    public ClickCount getClickCountByDate(LocalDate _localDate1, LocalDate _localDate2){
        ClickCount clickCount = new ClickCount();
        for (Value value: valueRepository.findAll()){
            Integer count = clickRepository.countByValueAndDateBetween(value, _localDate1, _localDate2);
            switch (value.getName()){
                case "regularCustomer":
                    clickCount.setRegularCustomer(count);
                    break;
                case "wholesale":
                    clickCount.setWholesale(count);
                    break;
                case "recommended":
                    clickCount.setRecommended(count);
                    break;
                case "yandex":
                    clickCount.setYandex(count);
                    break;
                case "google":
                    clickCount.setGoogle(count);
                    break;
                case "instagram":
                    clickCount.setInstagram(count);
                    break;
                case "tikTok":
                    clickCount.setTikTok(count);
                    break;
                case "youtube":
                    clickCount.setYoutube(count);
                    break;
                case "twogis":
                    clickCount.setTwogis(count);
                    break;
            }
        }
    return clickCount;
    }
}
