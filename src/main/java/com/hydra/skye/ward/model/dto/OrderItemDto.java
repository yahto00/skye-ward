package com.hydra.skye.ward.model.dto;

/**
 * Created by yahto on 2018/5/6 7:44 PM
 */
public class OrderItemDto {
    private Long cargoId;
    private Integer itemCount;
    private Double itemArea;

    public Long getCargoId() {
        return cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public Double getItemArea() {
        return itemArea;
    }

    public void setItemArea(Double itemArea) {
        this.itemArea = itemArea;
    }
}
