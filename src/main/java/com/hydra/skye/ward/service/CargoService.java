package com.hydra.skye.ward.service;

import com.hydra.skye.ward.model.Cargo;

/**
 * Created by yahto on 21/03/2018
 */
public interface CargoService {
    boolean createCargo(Cargo cargo);

    void stockBack(Long cargoId, Integer backNum, Double backArea, Long opUserId);
}
