package com.itrug.mobile.service.impl;

import com.itrug.mobile.dao.MobileDao;
import com.itrug.mobile.dao.impl.MobileDaoImpl;
import com.itrug.mobile.model.Mobile;
import com.itrug.mobile.service.MobileService;

import java.util.List;

public class MobileServiceImp implements MobileService {
    MobileDao mobileDao = new MobileDaoImpl();

    @Override
    public Mobile get(Integer id) {
        return null;
    }

    @Override
    public List<Mobile> findAll() {
        return mobileDao.findAll();
    }

    @Override
    public Mobile save(Mobile mobile) {
        return mobileDao.save(mobile);
    }

    @Override
    public Mobile update(Mobile mobile) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        mobileDao.delete(id);
    }
}
