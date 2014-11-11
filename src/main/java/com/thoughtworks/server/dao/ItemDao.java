package com.thoughtworks.server.dao;

import com.thoughtworks.server.model.Item;

public interface ItemDao {
    Item getItemById(int id);
}
