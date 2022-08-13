package com.mapper;

import com.pojo.Banner;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BannerMapper {
    List<Banner> getBannerList();
}
