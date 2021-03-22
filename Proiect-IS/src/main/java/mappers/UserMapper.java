package mappers;
import dto.UserDto;
import entity.User;

public class UserMapper {

    public static UserDto entityToDto(User user)  {

        UserDto userDto = new UserDto();
        userDto.setIdUser(user.getIdUser());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public static User dtoToEntity(UserDto userDto) {
        return null;
    }
}
