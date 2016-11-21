package com.github.bingoohuang.spockdemo

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2016/11/14.
 */
class User {
    String firstName // bean field
    String lastName  // bean field

    String getFirstName() {
        "The first name is $firstName"
    }

    void setFirstName(String firstName) {
        this.firstName = "[$firstName]"
    }
}
