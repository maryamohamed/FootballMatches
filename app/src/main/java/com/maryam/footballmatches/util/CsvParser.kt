package com.maryam.footballmatches.util

import com.maryam.footballmatches.data.domain.Match

class CsvParser {

    fun parse(line : String) : Match {
        val tokens = line.split(",")

        return Match(
            date = tokens[Constant.ColumnIndex.DATE],
            homeTeamName = tokens[Constant.ColumnIndex.HOME_TEAM_NAME],
            awayTeamName = tokens[Constant.ColumnIndex.AWAY_TEAM_NAME],
            homeTeamFullTimeGoals = tokens[Constant.ColumnIndex.HOME_TEAM_FULL_TIME_GOALS],
            awayTeamFullTimeGoals = tokens[Constant.ColumnIndex.AWAY_TEAM_FULL_TIME_GOALS],
            winnerTeam = tokens[Constant.ColumnIndex.WINNER_TEAM],
            homeTeamHalfTimeGoals = tokens[Constant.ColumnIndex.HOME_TEAM_HALF_TIME_GOALS],
            awayTeamHalfTimeGoals = tokens[Constant.ColumnIndex.AWAY_TEAM_HALF_TIME_GOALS],
            referee = tokens[Constant.ColumnIndex.REFEREE],
            homeTeamShots = tokens[Constant.ColumnIndex.HOME_TEAM_SHOTS],
            awayTeamShots = tokens[Constant.ColumnIndex.AWAY_TEAM_SHOTS],
            homeTeamShotsOnTarget = tokens[Constant.ColumnIndex.HOME_TEAM_SHOTS_ON_TARGET],
            awayTeamShotsOnTarget = tokens[Constant.ColumnIndex.AWAY_TEAM_SHOTS_ON_TARGET],
            homeTeamFouls = tokens[Constant.ColumnIndex.HOME_TEAM_FOULS],
            awayTeamFouls = tokens[Constant.ColumnIndex.AWAY_TEAM_FOULS],
            homeTeamCorners = tokens[Constant.ColumnIndex.HOME_TEAM_CORNERS],
            awayTeamCorners = tokens[Constant.ColumnIndex.AWAY_TEAM_CORNERS],
            homeTeamYellowCards = tokens[Constant.ColumnIndex.HOME_TEAM_YELLOW_CARD],
            awayTeamYellowCards = tokens[Constant.ColumnIndex.AWAY_TEAM_YELLOW_CARD],
            homeTeamRedCards = tokens[Constant.ColumnIndex.HOME_TEAM_RED_CARD],
            awayTeamRedCards = tokens[Constant.ColumnIndex.AWAY_TEAM_RED_CARD],
        )
    }
}