package com.d0lbangi.houseutils.service;

import com.d0lbangi.houseutils.exception.ErrorCode;
import com.d0lbangi.houseutils.exception.HouseUtilsException;
import com.d0lbangi.houseutils.repository.ApartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author d0lbangi
 */

@Service
@AllArgsConstructor
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    @Transactional
    public Long getPriceOrThrow(Long apartmentId) {
        return Long.valueOf(apartmentRepository.findById(apartmentId)
                .orElseThrow(()-> new HouseUtilsException(ErrorCode.ENTITY_NOT_FOUND))
                .getPrice());
    }
}
