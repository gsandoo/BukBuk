package service;

import bukbuk.firstpro.repository.ServiceRepository;
import bukbuk.firstpro.repository.ServiceRepositoryImpl;
import bukbuk.firstpro.service.BukServiceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class serviceTest {
    @Autowired
    BukServiceService bukServiceService;

    @Autowired
    ServiceRepository serviceRepository;

}
