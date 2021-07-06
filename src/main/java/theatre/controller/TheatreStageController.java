package theatre.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import theatre.dto.request.TheatreStageRequestDto;
import theatre.dto.response.TheatreStageResponseDto;
import theatre.model.TheatreStage;
import theatre.service.TheatreStageService;
import theatre.service.mapper.TheatreStageMapper;

@RestController
@RequestMapping("/theatre-stages")
public class TheatreStageController {
    private final TheatreStageService theatreStageService;
    private final TheatreStageMapper theatreStageMapper;
    
    public TheatreStageController(TheatreStageService theatreStageService,
            TheatreStageMapper theatreStageMapper) {
        this.theatreStageService = theatreStageService;
        this.theatreStageMapper = theatreStageMapper;
    }
    
    @PostMapping
    public TheatreStageResponseDto add(@RequestBody @Valid TheatreStageRequestDto requestDto) {
        TheatreStage theatreStage = theatreStageService
                .add(theatreStageMapper.mapToModel(requestDto));
        return theatreStageMapper.mapToDto(theatreStage);
    }
    
    @GetMapping
    public List<TheatreStageResponseDto> getAll() {
        return theatreStageService.getAll()
                .stream()
                .map(theatreStageMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
