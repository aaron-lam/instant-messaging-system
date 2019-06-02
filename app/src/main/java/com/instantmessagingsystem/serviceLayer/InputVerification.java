package com.instantmessagingsystem.serviceLayer;

public class InputVerification {

    private final int maxLength = 30;

    public boolean validatePassword(String password){
        if(!validLength(password)){
            return false;
        }
        if(!validChars(password)){
            return false;
        }
        return false;
    }

    //Check if username meets requirements
    public boolean validateUsername(String username){
        if(!validLength(username)){
            return false;
        }
        if(!validChars(username)){
            return false;
        }
        return true;
    }

    //Check if all chars are valid
    private boolean validChars(String input){
        for(char current: input.toCharArray()){
            if(isNumber(current)){
            } else if(isLowercase(current)) {
            } else if(isUppercase(current)) {
            } else {
                return false;
            }
        }
        return true;
    }

    //Check if length is valid
    private boolean validLength(String input){
        if(input.length() < maxLength){
            return true;
        }
        return false;
    }

    //Check if char is number
    private boolean isNumber(char input){
        if(input > 47){
            if(input < 58){
                return true;
            }
        }
        return false;
    }

    //Check if char is lowercase
    //Values are hard coded because they will not change.
    private boolean isLowercase(char input){
        if(input > 96){
            if(input < 123){
                return true;
            }
        }
        return false;
    }

    //Check if char is uppercase
    //Values are hard coded because they will not change.
    private boolean isUppercase(char input){
        if(input > 64){
            if(input < 91){
                return true;
            }
        }
        return false;
    }

}
