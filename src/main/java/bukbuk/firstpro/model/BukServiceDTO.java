package bukbuk.firstpro.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BukServiceDTO {
    private int service_category;
    private String service_id;
    private String service_title;
    private String service_context;
    private String service_date;
    private int service_hit;
    private int service_group;
    private int service_step;
    private int service_indent;
}
