package bukbuk.firstpro.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BukReviewDTO {
    private String review_id;
    private String book_title;
    private double review_rate;
    private String review_title;
    private String review_context;
    private String review_date;
    private int review_num;
}
