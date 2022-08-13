package com.service;

import com.mapper.BannerMapper;
import com.pojo.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;
    @Override
    public List<Banner> getBannerList() {
        return bannerMapper.getBannerList();
    }
}
