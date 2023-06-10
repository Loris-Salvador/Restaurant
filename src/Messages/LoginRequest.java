package Messages;
import Model.*;

import java.io.Serializable;

public class LoginRequest extends Request implements Serializable {
    private String username;
    private String password;
    private Profession profession;


    public LoginRequest()
    {
        username = "none";
        password = "none";
    }

    public LoginRequest(String user, String mdp, Profession pr, TypeRequete type)
    {
        super(type);
        username = user;
        password = mdp;
        profession = pr;
    }

    public Profession getProfession()
    {
        return profession;
    }
    public void setProfession(Profession pr)
    {
        profession = pr;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", profession=" + profession +
                '}';
    }
}
