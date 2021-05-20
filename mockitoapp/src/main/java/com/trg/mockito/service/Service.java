package com.trg.mockito.service;

import com.trg.mockito.db.DataBase;

public class Service {
	private DataBase database;

    public Service(DataBase database) {
        this.database = database;
    }
    
    public String getName(int eid) {
    	return database.getName(eid);
    }
    
    public int getSalary(int eid) {
    	return database.getSalary(eid);
    }
}
