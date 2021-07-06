package theatre.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import theatre.dao.TheatreStageDao;
import theatre.exception.DataProcessingException;
import theatre.model.TheatreStage;
import theatre.service.TheatreStageService;

@Service
public class TheatreStageServiceImpl implements TheatreStageService {
    private final TheatreStageDao theatreStageDao;

    public TheatreStageServiceImpl(TheatreStageDao theatreStageDao) {
        this.theatreStageDao = theatreStageDao;
    }

    @Override
    public TheatreStage add(TheatreStage theatreStage) {
        return theatreStageDao.add(theatreStage);
    }

    @Override
    public TheatreStage get(Long id) {
        return theatreStageDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get theatre stage by id " + id));
    }

    @Override
    public List<TheatreStage> getAll() {
        return theatreStageDao.getAll();
    }
}
