package com.moneytap.splittest.service;

import com.moneytap.splittest.model.Usr;

public interface UserService {
    public void saveUser(Usr user);
    public boolean isPresent(Usr user);
}
