package com.sohaib.e_bankbackend.services;

import com.sohaib.e_bankbackend.dtos.*;
import com.sohaib.e_bankbackend.entities.BankAccount;
import com.sohaib.e_bankbackend.entities.CurrentAccount;
import com.sohaib.e_bankbackend.entities.Customer;
import com.sohaib.e_bankbackend.entities.SavingAccount;
import com.sohaib.e_bankbackend.exceptions.BalanceNotSufficientExeption;
import com.sohaib.e_bankbackend.exceptions.BankAccountNotFoundException;
import com.sohaib.e_bankbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    public CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, Long customerId, double overDraft) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, Long customerId, double interestRate) throws CustomerNotFoundException;
    List<CustomerDTO> liseCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientExeption;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource,String accountIdDestination, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientExeption;

    List<BankAccountDTO> bankAccountList();

    CustomerDTO getcustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getaccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;
}
