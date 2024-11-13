package ex07;

import java.util.ArrayList;
import java.util.List;

public class AccountDBinMemory implements AccountDAO {
    // this is executed before CTOR (pre-CTOR)
    private List<Account> accountList = new ArrayList<>();

    public AccountDBinMemory() {
        insertAccount(new Account(1, "Smith", 944.0));
        insertAccount(new Account(2, "Miller", 3750.0));
        insertAccount(new Account(3, "Dave", 37.0));
    }

    @Override
    public boolean insertAccount(Account account) {
        Account tmpAccount = getAccountByID( account.getNumber() );
        if (tmpAccount != null) return false;
        accountList.add( account.clone() );
        return true;
    }

    @Override
    public Account getAccountByID(int accountNumber) {
        for (int i=0; i < accountList.size(); i++) {
            if ( accountList.get(i).getNumber() == accountNumber ) {
                return accountList.get(i).clone();
            }
        }
        return null;
    }

    @Override
    public Account getAccountByName(String accountOwner) {
        for (Account account : accountList) {
            if ( account.getOwner().compareToIgnoreCase(accountOwner) == 0 ) {
                return account.clone();
            }
        }
        return null;
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> copyList = new ArrayList<>( accountList.size() );
        //-- this is not the same: copyList.addAll(accountList);
        for (Account account : accountList) {
            copyList.add( account.clone() );
        }
        return copyList;
    }

    @Override
    public boolean changeAccount(int accountNumber, Account account) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeAccount'");
    }

    @Override
    public boolean removeAccount(int accountNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAccount'");
    }

}