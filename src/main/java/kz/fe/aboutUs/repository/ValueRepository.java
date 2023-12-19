package kz.fe.aboutUs.repository;

import jakarta.transaction.Transactional;
import kz.fe.aboutUs.model.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface ValueRepository extends JpaRepository<Value, Long> {

    Value findValueByName(String name);

}
