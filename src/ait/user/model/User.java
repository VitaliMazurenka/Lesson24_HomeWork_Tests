package ait.user.model;

public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (emailIsValid(email)) {
            this.email = email;
        } else {
            System.out.println(email + " is not valid.");
        }

    }
    // Проверка email !!
    // email @  - exist and only one,  ==> done.
    //  '.' - min one dot after @ ==> done
    // min two symbols after last dot ==> done
    // alphabetic, digits, '@', '.', ' _ ', '-'. ==> done

    private boolean emailIsValid(String email) {
        int at = email.indexOf('@');
        if (at == -1 || (email.lastIndexOf('@') != at)) {
            return false;

        }
        if (email.indexOf('.', at + 1) == -1) {
            return false;
        }
        if (email.lastIndexOf('.') >= email.length() - 2) {
            return false;
        }
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (!(Character.isDigit(c) || Character.isAlphabetic(c) || c == '@' || c == '.' || c == '_' || c == '-')) {
                return false;
            }

        }

        return true;

    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    /* TODO HomeWork
    1. Min 8 Symbols
    2. min one Symbol in UpperCase
    3. min one Symbol in LowerCase
    4.Min one symbol is Digit
    5.Min one Symbol is a special symbol (!%@*&)
    =================================================================================================================
 */
    private boolean passwordIsValid(String password) {
        if (password.length() >= 7) {
            return true;
        }
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch) && Character.isLowerCase(ch)) {
                return true;
            }
            for (int j = 0; j < password.length(); j++) {
                char ch1 = password.charAt(j);
                if (Character.isDigit(ch1)) ;
                return true;
            }
            for (int k = 0; k < password.length(); k++) {
                char s = password.charAt(k);
                if (k == '!' || k == '%' || k == '@' || k == '*' || k == '&') {
                    return true;
                }

            }
        }
        return false;
    }
    }