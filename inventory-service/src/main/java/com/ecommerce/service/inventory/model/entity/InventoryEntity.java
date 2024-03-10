package com.ecommerce.service.inventory.model.entity;

import com.ecommerce.service.inventory.model.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inventories")
@EqualsAndHashCode(callSuper = true)
public class InventoryEntity extends BaseEntity<InventoryEntity> {
    private Boolean isStockAvailable;
    private Long stockTotal;
    private Long stockReserved;
    private Long stockSold;

    @OneToMany(mappedBy = "inventory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<InventoryImageEntity> images;
}
