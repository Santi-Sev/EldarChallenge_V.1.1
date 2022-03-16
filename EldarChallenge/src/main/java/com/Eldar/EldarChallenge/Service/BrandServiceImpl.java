package com.Eldar.EldarChallenge.Service;

import com.Eldar.EldarChallenge.Entity.Brand;
import com.Eldar.EldarChallenge.Repository.BrandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepo brandRepo;

    @Override
    @org.springframework.transaction.annotation.Transactional
    public Brand save(Brand brand) {
        return brandRepo.save(brand);
    }

    @Override
    @Transactional
    public void delete(Brand brand) {
        brandRepo.delete(brand);
    }
}


