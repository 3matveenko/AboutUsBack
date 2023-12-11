package kz.fe.aboutUs.repository;

import jakarta.transaction.Transactional;
import kz.fe.aboutUs.model.Click;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface ClickRepository extends JpaRepository<Click, Long> {

}
