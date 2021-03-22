package service;

import dto.AdminDto;
import entity.*;
import exceptions.CustomExceptionMessages;
import exceptions.EntityNotExistsException;
import exceptions.WrongPasswordException;
import mappers.AdminMapper;
import repository.*;

import java.util.UUID;

public class AdminService {
    private UserRepo userRepo;
    private AdminRepo adminRepo;
    private CreditRepo creditRepo;
    private GuaranteeRepo guaranteeRepo;
    private TransactionsRepo transactionsRepo;
    private BankAccountRepo bankAccountRepo;

    public AdminService() {
        this.adminRepo = new AdminRepo();
        this.userRepo = new UserRepo();
        this.guaranteeRepo = new GuaranteeRepo();
        this.creditRepo = new CreditRepo();
        this.transactionsRepo = new TransactionsRepo();
        this.bankAccountRepo = new BankAccountRepo();
    }
    public void addUser(User user) {
       // UserValidator.validateAddNewUserFlow(userDto);
        System.out.println("add User din Admin Service: " + user);
        user.setIdUser(UUID.randomUUID().toString());
        userRepo.insertNewUser(user);

    }

    public void addBankAccount( BankAccount account) {
        account.setIdAccount(UUID.randomUUID().toString());
        bankAccountRepo.insertNewBankAccount(account);
    }

    public void deleteUserServ(User user) {
        // UserValidator.validateAddNewUserFlow(userDto);
        System.out.println("delete User din Admin Service: " + user);
        userRepo.deleteUser(user);
    }

    public void deleteAccServ(BankAccount acc) {
        // UserValidator.validateAddNewUserFlow(userDto);
        System.out.println("delete Acc din Admin Service: " + acc);
        bankAccountRepo.deleteAccount(acc);
    }

    public AdminDto getAdmin(String id, String password) {

        if (id == null || id.equals("")) {
            throw new IllegalArgumentException(CustomExceptionMessages.INVALID_ID_MESSAGE);
        }
        //string 36 de caractere (UUID).
        Admin admin = adminRepo.findAdminById(id);
        System.out.println("Am gasit adminul dupa id:  " + admin);
        if (admin == null) {
            throw new EntityNotExistsException("No user having id " + id + " exists.");
        }
        System.out.println(admin.getPassword());
        if(admin.getPassword().equals(password) == false)
        {
            throw new IllegalArgumentException(WrongPasswordException.WRONG_PASSWORD);
        }
        AdminDto adminDto = AdminMapper.entityToDto(admin);
        return adminDto;
    }

    public void addCredit(Credit credit){
        credit.setIdCredit(UUID.randomUUID().toString());
        creditRepo.insertNewCredit(credit);
    }
    public void addGuarantee(Guarantee g){
        g.setIdGuarantee(UUID.randomUUID().toString());
        guaranteeRepo.insertNewGuarantee(g);
    }

}
