package bukbuk.firstpro.service;

import bukbuk.firstpro.model.BukReviewDTO;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    // 책마다 리뷰 출력
    List<BukReviewDTO> getReviewList(String book_title);

    // 리뷰 등록
    int insert(BukReviewDTO dto);
}
