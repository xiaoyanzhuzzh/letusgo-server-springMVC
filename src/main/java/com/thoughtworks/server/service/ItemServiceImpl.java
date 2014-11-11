package com.thoughtworks.server.service;

import com.thoughtworks.server.dao.ItemDao;
import com.thoughtworks.server.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDaoImpl;

    @Override
    public Item getItemById(int id) {
        return itemDaoImpl.getItemById(id);
    }

    @Override
    public void setItemDaoImpl(ItemDao itemDaoImpl) {
        this.itemDaoImpl = itemDaoImpl;
    }
}
