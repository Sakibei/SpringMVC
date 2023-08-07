package com.benny.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PictrueService {

    @Autowired
    private PictureDao dao;

    // 存圖片服務
    public Picture insert(Picture p) {
        return dao.insert(p);
    }
}
