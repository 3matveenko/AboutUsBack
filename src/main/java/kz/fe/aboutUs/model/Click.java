package kz.fe.aboutUs.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;


@Getter
@Setter
@Entity
@Table(name="t_click")
public class Click {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "date")
    LocalDate date;

    @ManyToOne
    private Value value;

}
