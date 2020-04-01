package ru.sberbank.sberinvestor.extenstion

import ru.sberbank.network.entity.Asset
import ru.sberbank.storage.entity.AssetDb

fun Asset.toAssetDb(): AssetDb {
    return AssetDb(currency = currency, id = id, issuer_id = issuer_id, type = type)
}