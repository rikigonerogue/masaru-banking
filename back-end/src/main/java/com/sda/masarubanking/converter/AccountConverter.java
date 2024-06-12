package com.sda.masarubanking.converter;

import com.sda.masarubanking.dto.AccountDTO;
import com.sda.masarubanking.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountConverter {

    public Account convertToEntity(AccountDTO accountDTO) {
        Account account = new Account();
        account.setBalance(accountDTO.getBalance());
        account.setType(accountDTO.getType());
        return account;
    }

    public AccountDTO convertToDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setBalance(account.getBalance());
        accountDTO.setType(account.getType());
        return accountDTO;
    }
}
