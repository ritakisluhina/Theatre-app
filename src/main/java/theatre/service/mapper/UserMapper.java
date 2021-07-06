package theatre.service.mapper;

import org.springframework.stereotype.Component;
import theatre.dto.response.UserResponseDto;
import theatre.model.User;

@Component
public class UserMapper implements ResponseDtoMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        return responseDto;
    }
}
