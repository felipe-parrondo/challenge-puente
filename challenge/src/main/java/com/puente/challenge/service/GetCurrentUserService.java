package com.puente.challenge.service;

import com.puente.challenge.model.AuthenticationModel;
import com.puente.challenge.model.UserModel;

import java.util.NoSuchElementException;

public interface GetCurrentUserService {
    UserModel getUser();
}
