package theatre.service;

import java.util.List;
import theatre.model.TheatreStage;

public interface TheatreStageService {
    TheatreStage add(TheatreStage theatreStage);

    TheatreStage get(Long id);

    List<TheatreStage> getAll();
}
