package ru.sberbank.network.entity

data class Instrument(
    val accrued_interest: String = "",
    val asset_id: String = "",
    val bond_type: String = "",
    val buyback_date: Any = Any(),
    val buyback_price: Any = Any(),
    val classcode: String = "",
    val coupon_percent: Double,
    val coupon_period: Int = 0,
    val coupon_type: String = "",
    val coupon_value: Double,
    val currency: String = "",
    val days_to_redemption: Int = 0,
    val early_repayment: Boolean,
    val exchange: String = "",
    val face_unit: String = "",
    val face_value: Double = 0.toDouble(),
    val id: String = "",
    val is_active: Boolean,
    val is_active_for_trade: Boolean,
    val isin: Any = Any(),
    val issue_date: String = "",
    val issuer_id: String = "",
    val lot_size: Int = 0,
    val market_code: String = "",
    val maturity_date: String = "",
    val min_step: String = "",
    val name: String = "",
    val next_coupon: String = "",
    val offer_date: Any = Any(),
    val settlement_type: String = "",
    val tax: Int = 0,
    val ticker: String = "",
    val type_name: String
)