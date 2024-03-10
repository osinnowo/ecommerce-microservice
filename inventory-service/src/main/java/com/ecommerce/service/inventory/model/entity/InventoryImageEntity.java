package com.ecommerce.service.inventory.model.entity;

import com.ecommerce.service.inventory.model.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inventory_images")
@EqualsAndHashCode(callSuper = true)
public class InventoryImageEntity extends BaseEntity<InventoryImageEntity> {
    private String name;
    private String type;
    private String url;
    private Boolean isThumbnail;
    private Boolean isCover;
    private Boolean isExtra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id", nullable = false)
    private InventoryEntity inventory;
}
