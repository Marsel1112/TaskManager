package org.taskmanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.taskmanager.model.dto.AccountRegistrationDTO;
import org.taskmanager.model.entity.Account;
import org.taskmanager.repository.AccountRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public void createAccount(AccountRegistrationDTO accountRegistrationDTO){
        accountRepository.save(Account.builder()
                                        .dateCreated(LocalDateTime.now())
                                        .email(accountRegistrationDTO.getEmail())
                                        .password(accountRegistrationDTO.getPassword())
                                        .build());
    }

    public Account getAccount(AccountRegistrationDTO accountRegistrationDTO){
        Account account = accountRepository.getAccountByEmail(accountRegistrationDTO.getEmail());

        if(account.getPassword().equals(accountRegistrationDTO.getPassword())){
            return account;
        }else{
            throw new RuntimeException("Account not found");
        }
    }

    public Account getAccountById(Long id){
        return accountRepository.getReferenceById(id);
    }

    public void updateAccount(Long id, Map<String, String> params){
        Account account = accountRepository.getReferenceById(id);

        if(params.containsKey("email"))
            account.setEmail(params.get("email"));

        if(params.containsKey("firstName"))
            account.setFirstName(params.get("firstName"));

        if(params.containsKey("lastName"))
            account.setLastName(params.get("lastName"));

        if(params.containsKey("patronymic"))
            account.setPatronymic(params.get("patronymic"));

        if(params.containsKey("phone"))
            account.setPhone(params.get("phone"));

        if(params.containsKey("tagName"))
            account.setTagName(params.get("tagName"));

        accountRepository.save(account);

    }

    public void changeAccountStatus(Long id, boolean param){
        Account account = accountRepository.getReferenceById(id);

        account.setActive(param);

        accountRepository.save(account);
    }

    public List<Account> getAccountInList(List<Long> accountIdList){
        return accountRepository.findAllById(accountIdList);
    }
}
