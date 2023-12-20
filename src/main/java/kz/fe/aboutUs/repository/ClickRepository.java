package kz.fe.aboutUs.repository;

import jakarta.transaction.Transactional;
import kz.fe.aboutUs.model.Click;
import kz.fe.aboutUs.model.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Repository
public interface ClickRepository extends JpaRepository<Click, Long> {

    Integer countByValueAndDateBetween(Value value, LocalDate date1, LocalDate date2);

    List<Click> findClickByDateBetween(LocalDate date1, LocalDate date2);
}
