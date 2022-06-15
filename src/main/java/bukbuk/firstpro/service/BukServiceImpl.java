package bukbuk.firstpro.service;

import bukbuk.firstpro.model.BukServiceDTO;
import bukbuk.firstpro.repository.ServiceRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BukServiceImpl implements BukServiceService{
    @Autowired
    ServiceRepositoryImpl dao;

    @Override
    public List<BukServiceDTO> getServiceList() {
        System.out.println("service호출");

        List<BukServiceDTO> dto = dao.test();

        return dao.test();
    }
}
