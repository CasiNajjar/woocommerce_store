package id.co.next_innovation.store.data.db;


import id.co.next_innovation.store.data.db.model.User;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public interface DbHelper {

    void addUser(User user);
    void removeUser();
    User getUser();

}
