package bukbuk.firstpro.repository;

import bukbuk.firstpro.model.BukReviewDTO;

import java.util.List;

public interface ReviewDAO {
    List<BukReviewDTO> list(String book_title);

    int insertReview(BukReviewDTO dto);


}
