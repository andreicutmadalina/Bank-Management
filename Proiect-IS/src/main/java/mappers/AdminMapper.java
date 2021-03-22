package mappers;

import dto.AdminDto;
import entity.Admin;

public class AdminMapper {

    public static AdminDto entityToDto(Admin admin)  {

        AdminDto adminDto = new AdminDto();
        adminDto.setIdAdmin(admin.getIdAdmin());
        adminDto.setEmail(admin.getEmail());
        return adminDto;
    }


}
