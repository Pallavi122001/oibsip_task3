import java.util.*;
public class Bank{
    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public Bank(String name){
        this.name = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }
    public String getNewUserUUID(){
        String user_id;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique;
        do{
            user_id="";
            for(int i = 0;i<len;i++){
                user_id += ((Integer)rng.nextInt(10)).toString();
            }
                nonUnique = false;
            for(User u:this.users){
                if(user_id.compareTo(u.getUUID())==0){
                    nonUnique = true;
                    break;
                }
            }
        }while(nonUnique);
        return user_id;
    }
    public String getNewAccountUUID(){
      String user_id;
      Random rng = new Random();
      int len = 10;
      boolean nonUnique;
      do{
          user_id="";
          for(int i = 0;i<len;i++){
              user_id += ((Integer)rng.nextInt(10)).toString();
          }
          nonUnique = false;
          for(Account a:this.accounts){
              if(user_id.compareTo(a.getUUID())==0){
                  nonUnique = true;
                  break;
              }
          }
      }while(nonUnique);
      return user_id;  

    }
    public void addAccount(Account anAct){
        this.accounts.add(anAct);
    }

    public User addUser(String firstName,String lastName,String pin){
        User newUser = new User(firstName,lastName,pin,this);
        this.users.add(newUser);
        Account newAccount = new Account("Savings",newUser,this);
         newUser.addAccount(newAccount);
         this.accounts.add(newAccount);

         return newUser;
    }
    public User userLogin(String userID,String pin){
        for(User u:this.users){
            if(u.getUUID().compareTo(userID)==0 && u.validatePin(pin)){
                return u;
            }
        }
        return null;
    }
    public String getName(){
        return this.name;
    }
}