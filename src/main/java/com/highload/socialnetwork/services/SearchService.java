package com.highload.socialnetwork.services;

import com.highload.socialnetwork.model.external.SearchExt;
import com.highload.socialnetwork.model.persistense.User;
import com.highload.socialnetwork.services.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private final UserRepository userRepository;

    @Autowired
    public SearchService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> search(SearchExt userFormSearch) {
        String[] fio = userFormSearch.getUsername().split(" ");

        List<User> findedUser = userRepository.findByNameSurname(fio[0], fio[1]);

        return findedUser;
    }
}
