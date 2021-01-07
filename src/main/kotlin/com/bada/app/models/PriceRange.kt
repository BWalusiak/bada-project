package com.bada.app.models

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "price_ranges")
class PriceRange(
    @Column(name = "min_quantity", insertable = false, updatable = false)
    val minQuantity: Int,
    var price: Double,

    @ManyToOne
    @MapsId("itemId")
    var item: Item,

    @EmbeddedId
    val id: PriceRangeId = PriceRangeId(item.id, minQuantity)
)

@Embeddable
data class PriceRangeId(
    @Column(name = "item_id")
    var itemId: Long,
    @Column(name = "min_quantity")
    var minQuantity: Int
) : Serializable