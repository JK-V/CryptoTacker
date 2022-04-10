package com.jkv.cryptotracker.domain.model

import com.jkv.cryptotracker.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val teamMember: List<TeamMember>
    )
