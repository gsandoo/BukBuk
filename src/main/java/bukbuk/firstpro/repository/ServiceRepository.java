package bukbuk.firstpro.repository;

import bukbuk.firstpro.model.BukServiceDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository {
    //저장소에 저장
    BukServiceDTO save(BukServiceDTO dto);

    //찾아옴
    Optional<BukServiceDTO> findById(String service_title);

    //전체출력
    List<BukServiceDTO> findAll();

    List<BukServiceDTO> test();
}
