package serviceBD.app.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serviceBD.app.Model.Account;
import serviceBD.app.Model.Person;
import serviceBD.app.Repository.AccountRepository;
import serviceBD.app.Repository.VilleRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository) {
          this.accountRepository = accountRepository;
    }
    public Account saveAccount(Account account){

        return  accountRepository.save(account);
    }
    public Optional<Account> getAccount(String username){
        return  accountRepository.findByUsername(username);
    }
    public List<Account> getAccounts(){
        return  accountRepository.findAll();
    }
	public Account getUserById(Long id) {
		  Optional<Account> account = accountRepository.findById(id);
	        Account a = null;
	        if (account.isPresent()) {
	            a = account.get();

	        } else {
	            throw new RuntimeException("Account doesn't exist for id: " + id);
	        }
	        return a;
	}


}