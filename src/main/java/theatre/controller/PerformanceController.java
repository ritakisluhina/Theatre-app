package theatre.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import theatre.dto.request.PerformanceRequestDto;
import theatre.dto.response.PerformanceResponseDto;
import theatre.model.Performance;
import theatre.service.PerformanceService;
import theatre.service.mapper.PerformanceMapper;

@RestController
@RequestMapping("/performances")
public class PerformanceController {
    private final PerformanceService performanceService;
    private final PerformanceMapper performanceMapper;
    
    public PerformanceController(PerformanceService performanceService,
            PerformanceMapper performanceMapper) {
        this.performanceService = performanceService;
        this.performanceMapper = performanceMapper;
    }
    
    @PostMapping
    public PerformanceResponseDto add(@RequestBody @Valid PerformanceRequestDto requestDto) {
        Performance performance = performanceService.add(performanceMapper.mapToModel(requestDto));
        return performanceMapper.mapToDto(performance);
    }
    
    @GetMapping
    public List<PerformanceResponseDto> getAll() {
        return performanceService.getAll().stream().map(performanceMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
