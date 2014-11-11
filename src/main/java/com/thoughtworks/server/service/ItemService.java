package com.thoughtworks.server.service;

import com.thoughtworks.server.dao.ItemDao;
import com.thoughtworks.server.model.Item;

public interface ItemService {
    Item getItemById(int i);

    void setItemDaoImpl(ItemDao itemDaoImpl);
}
