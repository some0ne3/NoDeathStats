package me.someone3.nodeathstats;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;
import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class PlayerStatisticIncrementListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onStatisticIncrement(PlayerStatisticIncrementEvent event) {

        if (event.getStatistic() != Statistic.DEATHS) return;

        Player player = event.getPlayer();

        if (player.hasPermission("nodeathstats.bypass")) {
            return;
        }

        if (player.hasPermission("nodeathstats.enable")) {
            event.setCancelled(true);
            ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
            Scoreboard scoreboard = scoreboardManager.getMainScoreboard();
            scoreboard.getObjectivesByCriteria(Criteria.DEATH_COUNT).forEach(objective -> {
                Score score = objective.getScore(player.getName());
                int newScore = score.getScore() - 1;
                if (newScore == 0) {
                    score.resetScore();
                } else {
                    score.setScore(newScore);
                }
            });
        }
    }
}
