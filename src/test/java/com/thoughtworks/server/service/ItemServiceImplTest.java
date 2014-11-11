package com.thoughtworks.server.service;

import com.thoughtworks.server.dao.ItemDao;
import com.thoughtworks.server.dao.ItemDaoImpl;
import com.thoughtworks.server.model.Item;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ItemServiceImplTest {
    ItemDao itemDaoImpl;
    Item item;
    ItemService itemServiceImpl;

    @Before
    public void mock_itemDaoImpl(){
        itemDaoImpl = mock(ItemDaoImpl.class);

        int id = 1;
        item = new Item(1, "葡萄", 6.5, "斤", 2);

        when(itemDaoImpl.getItemById(id)).thenReturn(item);

        itemServiceImpl = new ItemServiceImpl();
        itemServiceImpl.setItemDaoImpl(itemDaoImpl);
    }

    @Test
    public void can_get_item_by_id(){
        assertThat(itemServiceImpl.getItemById(1)).isEqualTo(item);
        verify(itemDaoImpl).getItemById(1);
    }
}
