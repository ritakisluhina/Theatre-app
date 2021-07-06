package theatre.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import theatre.model.PerformanceSession;

public interface PerformanceSessionDao {
    PerformanceSession add(PerformanceSession performanceSession);

    Optional<PerformanceSession> get(Long id);

    List<PerformanceSession> findAvailableSessions(Long performanceId, LocalDate date);

    PerformanceSession update(PerformanceSession performanceSession);

    void delete(Long id);
}
