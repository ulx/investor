package ru.sberbank.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "instrument_table")
data class InstrumentDb(
    @ColumnInfo(name = "accrued_interest") val accrued_interest: String = "",
    @ColumnInfo(name = "asset_id") val asset_id: String = "",
    @ColumnInfo(name = "bond_type") val bond_type: String = "",
    @ColumnInfo(name = "buyback_date") val buyback_date: String = "",
    @ColumnInfo(name = "buyback_price") val buyback_price: String = "",
    @ColumnInfo(name = "classcode") val classcode: String = "",
    @ColumnInfo(name = "coupon_percent") val coupon_percent: Double,
    @ColumnInfo(name = "coupon_period") val coupon_period: Int = 0,
    @ColumnInfo(name = "coupon_type") val coupon_type: String = "",
    @ColumnInfo(name = "coupon_value") val coupon_value: Double,
    @ColumnInfo(name = "currency") val currency: String = "",
    @ColumnInfo(name = "days_to_redemption") val days_to_redemption: Int = 0,
    @ColumnInfo(name = "early_repayment") val early_repayment: Boolean,
    @ColumnInfo(name = "exchange") val exchange: String = "",
    @ColumnInfo(name = "face_unit") val face_unit: String = "",
    @ColumnInfo(name = "face_value") val face_value: Double = 0.toDouble(),
    @PrimaryKey @ColumnInfo(name = "instrument_id") val id: String = "",
    @ColumnInfo(name = "is_active") val is_active: Boolean,
    @ColumnInfo(name = "is_active_for_trade") val is_active_for_trade: Boolean,
    @ColumnInfo(name = "isin") val isin: String = "",
    @ColumnInfo(name = "issue_date") val issue_date: String = "",
    @ColumnInfo(name = "issuer_id") val issuer_id: String = "",
    @ColumnInfo(name = "lot_size") val lot_size: Int = 0,
    @ColumnInfo(name = "market_code") val market_code: String = "",
    @ColumnInfo(name = "maturity_date") val maturity_date: String = "",
    @ColumnInfo(name = "min_step") val min_step: String = "",
    @ColumnInfo(name = "instrument_name") val name: String = "",
    @ColumnInfo(name = "next_coupon") val next_coupon: String = "",
    @ColumnInfo(name = "offer_date") val offer_date: String = "",
    @ColumnInfo(name = "settlement_type") val settlement_type: String = "",
    @ColumnInfo(name = "tax") val tax: Int = 0,
    @ColumnInfo(name = "ticker") val ticker: String = "",
    @ColumnInfo(name = "type_name") val type_name: String
)