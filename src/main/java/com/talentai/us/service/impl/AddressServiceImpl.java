package com.talentai.us.service.impl;

import com.talentai.us.entity.Address;
import com.talentai.us.repository.AddressRepository;
import com.talentai.us.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;

    @Override
    public void createOrUpdateAddress(Address address) {
        addressRepository.save(address);
    }

}
