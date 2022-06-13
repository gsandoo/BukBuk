package bukbuk.firstpro.service;

import bukbuk.firstpro.model.BukServiceDTO;
import bukbuk.firstpro.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BukServiceService {
    public List<BukServiceDTO> getServiceList();

}
