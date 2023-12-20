package kz.fe.aboutUs.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClickCount {

    private int regularCustomer;

    private int wholesale;

    private int recommended;

    private int yandex;

    private int google;

    private int instagram;

    private int tikTok;

    private int youtube;

    private int twogis;
}
