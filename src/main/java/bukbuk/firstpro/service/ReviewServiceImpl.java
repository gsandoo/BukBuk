package bukbuk.firstpro.service;

import bukbuk.firstpro.model.BukReviewDTO;
import bukbuk.firstpro.repository.ReviewDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    ReviewDAOImpl dao;

    @Override
    public List<BukReviewDTO> getReviewList() {
        System.out.println("리뷰서비스호출");

        List<BukReviewDTO> dto = dao.list();

        return dao.list();
    }
}
